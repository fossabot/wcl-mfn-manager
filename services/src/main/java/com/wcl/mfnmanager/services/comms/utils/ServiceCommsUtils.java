package com.wcl.mfnmanager.services.comms.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonToken;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.jsoup.Jsoup;
import com.wcl.mfnmanager.exceptions.CommunicationsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

public class ServiceCommsUtils {
    public String waitForSearchResultsToComplete(CloseableHttpClient connection, URI loopURI) throws CommunicationsException, IOException {
        var carryon = true;
        String responseText = "";
        final var draftClassResults = new HttpPost(loopURI);
        while(carryon) {
            final var response = connection.execute(draftClassResults);
            responseText = readAndPrintStreamContent(response);
            EntityUtils.consumeQuietly(response.getEntity());
            if (!responseText.contains("Compiling results")) {
                carryon = false;
            }
        }

        return responseText;
    }

    public String readAndPrintStreamContent(CloseableHttpResponse response) throws IOException {

        String line;
        final var builder = new StringBuilder();
        try (var bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to read status event stream", e);
        }
        return builder.toString();
    }

    /*
     * When accessing the draft class page, a redirect is provided as JSON within the body with a 200
     * response; the code needs to manually redirect as a consequence.
     *
     * @param stream
     * @return
     * @throws IOException
     */
    public URI extractRedirectURI(InputStream stream) throws IOException {
        final var jasonFactory = new JsonFactory();
        URI uri = null;
        final var jsonParser = jasonFactory.createParser(stream);
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            //get the current token
            final var fieldname = jsonParser.getCurrentName();
            if ("redirect".equals(fieldname)) {
                //move to next token
                jsonParser.nextToken();
                uri = URI.create(jsonParser.getText());
            }
        }
        return uri;
    }

    /*
     * Returns the Instant Ping URI value.
     *
     * This value is contained within the filtered search response page and represents a URI to scan to
     * retrieve the search results - it contains a progress bar that can be cheecked to see progress.
     *
     * @param responseText
     * @return
     */
    public URI getInstantPingUri(String responseText) {
        final var document = Jsoup.parse(responseText);

        return URI.create(document.getElementsByClass("instant_ping").attr("href"));
    }
}
