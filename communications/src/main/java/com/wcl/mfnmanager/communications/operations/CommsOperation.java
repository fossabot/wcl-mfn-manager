package com.wcl.mfnmanager.communications.operations;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import com.wcl.mfnmanager.exceptions.CommunicationsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface CommsOperation {
    default String performOperation(CloseableHttpClient connection) throws CommunicationsException, IOException {
        var request = generateRequest();
        var response = connection.execute(request);

        String responseText;
        try {
            responseText = consumeResponse(response);
        } catch (IOException e) {
            throw new CommunicationsException("Failed to process response", e);
        }
        return responseText;
    }

    private String consumeResponse(CloseableHttpResponse response) throws IOException {
        StringBuilder builder;
        try (var bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
            var line = "";
            builder = new StringBuilder();
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line);
                    builder.append(System.lineSeparator());
                }
            } catch (IOException e) {
                throw new RuntimeException("Unable to read status event stream", e);
            }
        }
        EntityUtils.consume(response.getEntity());
        return builder.toString();
    }

    ClassicHttpRequest generateRequest();
}
