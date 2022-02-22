package com.wcl.mfnmanager.services.comms.operations.draft;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import com.wcl.mfnmanager.communications.utils.HttpEntityUtils;
import com.wcl.mfnmanager.entities.draft.DraftInfo;
import com.wcl.mfnmanager.exceptions.CommunicationsException;
import com.wcl.mfnmanager.services.comms.operations.WrappedOperation;
import com.wcl.mfnmanager.services.comms.utils.ServiceCommsUtils;
import com.wcl.mfnmanager.services.draft.downloader.PositionFilter;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;

public class DraftDownloaderOperation extends WrappedOperation<Void> {
    private static final String DRAFT_FILE_NAME_TEMPLATE = "DRAFT_%s.csv";
    private static final String DRAFT_SAVE_FILTER_URI = "%s/draft-class/save-filter";
    private final ServiceCommsUtils utils;

    private final DraftInfo leagueDraftInfo;
    private final PositionFilter filter;
    private final Path directory;

    public DraftDownloaderOperation(PositionFilter filter, Path directory, DraftInfo draftInfo) {
        this.filter = filter;
        this.leagueDraftInfo = draftInfo;
        this.directory = directory;
        utils = new ServiceCommsUtils();
    }


    @Override
    public Void perform(CloseableHttpClient connection) throws CommunicationsException {
        try {
            final var redirectedURI = setPositionFilter(connection);
            final var instantPingURI = extractInstantPingURI(connection, redirectedURI);
            final var downloadURI = extractDownloadURI(connection, instantPingURI);
            downloadFile(connection, downloadURI);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    private void downloadFile(CloseableHttpClient connection, URI downloadURI) throws CommunicationsException, IOException {
        final var downloader = new HttpGet(downloadURI);
        final var response = connection.execute(downloader);
        HttpEntityUtils.storeEntityContentAsFile(response.getEntity(), directory,
                String.format(DRAFT_FILE_NAME_TEMPLATE, filter));
    }

    private URI extractDownloadURI(CloseableHttpClient connection, URI instantPingURI) throws IOException, CommunicationsException {
        final var responseText = utils.waitForSearchResultsToComplete(connection, instantPingURI);
        final var document = Jsoup.parse(responseText);
        return URI.create(document.getElementsByTag("a").attr("href")
                .replaceAll("\\\\\"", "").replaceAll("\\\\", ""));
    }

    private URI setPositionFilter(CloseableHttpClient connection) throws IOException, CommunicationsException {
        final var setPositionFilter = new HttpPost(String.format(DRAFT_SAVE_FILTER_URI, leagueDraftInfo.league().uri()));
        final var parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("position_id", filter.getPosition()));
        parameters.add(new BasicNameValuePair("show_all", "1"));
        setPositionFilter.setEntity(new UrlEncodedFormEntity(parameters));

        final var response = connection.execute(setPositionFilter);

        return utils.extractRedirectURI(response.getEntity().getContent());
    }

    private URI extractInstantPingURI(CloseableHttpClient connection, URI redirectURI) throws CommunicationsException {
        final var temp = new HttpGet(redirectURI);
        try {
            final var response = connection.execute(temp);
            return utils.getInstantPingUri(utils.readAndPrintStreamContent(response));
        } catch (IOException e) {
            throw new CommunicationsException("Cannot extract redirect URI", e);
        }
    }

}