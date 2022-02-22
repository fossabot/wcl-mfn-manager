package com.wcl.mfnmanager.services.comms.operations.draft;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import com.wcl.mfnmanager.entities.draft.DraftInfo;
import com.wcl.mfnmanager.exceptions.CommunicationsException;
import com.wcl.mfnmanager.services.comms.operations.WrappedOperation;
import com.wcl.mfnmanager.services.draft.downloader.PositionFilter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class DownloadDraftClassesOperation extends WrappedOperation<Void> {
    private List<DraftInfo> leaguesWithDrafts;
    private String username;
    private String password;

    public DownloadDraftClassesOperation(final List<DraftInfo> leaguesWithDrafts, String username, String password) {
        this.leaguesWithDrafts = new ArrayList<>();
        this.leaguesWithDrafts.addAll(leaguesWithDrafts);
        this.username = username;
        this.password = password;
    }

    @Override
    public Void perform(CloseableHttpClient connection) throws CommunicationsException {
        // Create League directories
        if (!leaguesWithDrafts.isEmpty()) {
            final var executor = Executors.newFixedThreadPool(leaguesWithDrafts.size());
            try {
                executor.invokeAll(getTasksToLoadLeagueFiles(leaguesWithDrafts, connection, username, password));
                executor.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    private List<Callable<Void>> getTasksToLoadLeagueFiles(final List<DraftInfo> leagues, CloseableHttpClient connection, String username, String password) {
        final var tasks = new ArrayList<Callable<Void>>();
        leagues.forEach(league -> tasks.add(new LeagueDownloadTask(league, connection, username, password)));

        return tasks;
    }
}

class LeagueDownloadTask implements Callable<Void> {
    private static final String DRAFT_DOWNLOAD_DIRECTORY = "%s/mfn-manager/downloads/to-process/draft/%s-%s";
    private final DraftInfo league;
    private String username;
    private String password;

    LeagueDownloadTask(DraftInfo league, CloseableHttpClient connection, String username, String password) {
        this.league = league;
        this.username = username;
        this.password = password;
    }

    @Override
    public Void call() throws Exception {
        downloadDraftClass(league, username, password);

        return null;
    }





    private void downloadDraftClass(DraftInfo league, String username, String password) {
        // Create download directory
        System.out.println("Downloading draft class for " + league);
        final String directoryName = String.format(DRAFT_DOWNLOAD_DIRECTORY,
                System.getProperty("user.home"),
                league.year(), league.league().name());
        try {
            Files.createDirectories(Paths.get(directoryName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Download for each position
        final var executor = Executors.newFixedThreadPool(31);

        try {
            executor.invokeAll(getTasksToLoadDataFiles(Paths.get(directoryName), league, username, password));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    private List<Callable<Void>> getTasksToLoadDataFiles(final Path directory, final DraftInfo league, String username, String password) {
        final var tasks = new ArrayList<Callable<Void>>();
        Arrays.asList(PositionFilter.values()).forEach(positionFilter ->
                tasks.add(() ->
                        new DraftDownloaderOperation(positionFilter, directory, league).performOperation(username, password)
                ));
        return tasks;
    }
}