package com.wcl.mfnmanager.services;

import com.wcl.mfnmanager.communications.core.MFNHttpClientFactory;
import com.wcl.mfnmanager.entities.draft.DraftInfo;
import com.wcl.mfnmanager.exceptions.CommunicationsException;
import com.wcl.mfnmanager.services.comms.operations.draft.DownloadDraftClassesOperation;
import com.wcl.mfnmanager.services.comms.operations.draft.LeaguesWithAvailableDraftOperation;

import java.io.IOException;
import java.util.List;

public final class DraftClassDownloaderService {
    public List<DraftInfo> checkForAvailableDraftClasses(String username, String password) throws CommunicationsException, IOException {
        return new LeaguesWithAvailableDraftOperation().performOperation(username, password);
    }


    public void downloadAvailableDraftClasses(final List<DraftInfo> leagues, String username, String password) throws CommunicationsException, IOException {
        final var downloader = new DownloadDraftClassesOperation(leagues, username, password);
        downloader.perform(MFNHttpClientFactory.buildMFNHttpClient());

    }


}
