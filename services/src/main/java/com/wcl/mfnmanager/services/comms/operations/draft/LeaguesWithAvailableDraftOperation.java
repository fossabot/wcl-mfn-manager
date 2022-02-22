package com.wcl.mfnmanager.services.comms.operations.draft;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import com.wcl.mfnmanager.entities.draft.DraftInfo;
import com.wcl.mfnmanager.entities.league.League;
import com.wcl.mfnmanager.exceptions.CommunicationsException;
import com.wcl.mfnmanager.services.comms.operations.WrappedOperation;
import com.wcl.mfnmanager.services.parsing.EnteredLeaguesParser;
import com.wcl.mfnmanager.services.parsing.LeagueDraftAvailabilityParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LeaguesWithAvailableDraftOperation extends WrappedOperation<List<DraftInfo>> {
    @Override
    protected List<DraftInfo> perform(CloseableHttpClient connection) throws CommunicationsException {
        final var leagues = getEnteredLeagues(connection);

        final var leaguesWithDrafts = new ArrayList<DraftInfo>();

        leagues.forEach(a -> {
            try {
                final var leagueOptional = getLeaguesWithAvailableDrafts(connection, a);
                leagueOptional.ifPresent(leaguesWithDrafts::add);
            } catch (CommunicationsException e1) {
                e1.printStackTrace();
            }

        });
        return leaguesWithDrafts;
    }

    private List<League> getEnteredLeagues(CloseableHttpClient connection) throws CommunicationsException {
        final var myLeagues = new HttpGet("https://www.myfootballnow.com/account/my-leagues");
        final var parser = new EnteredLeaguesParser();

        try (final CloseableHttpResponse response = connection.execute(myLeagues)) {

            try (var br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
                String line;
                final var builder = new StringBuilder();
                try {
                    while ((line = br.readLine()) != null) {
                        builder.append(line);
                    }
                } catch (IOException e) {
                    throw new CommunicationsException("Unable to read status event stream", e);
                }
                return parser.parse(builder.toString());
            }
        } catch (IOException e) {
            throw new CommunicationsException("Error during operation", e);
        }
    }

    private Optional<DraftInfo> getLeaguesWithAvailableDrafts(CloseableHttpClient connection, League league) throws CommunicationsException {
        final var get = new HttpGet(league.uri());
        final var parser = new LeagueDraftAvailabilityParser();
        try (final CloseableHttpResponse response = connection.execute(get)) {

            try (var br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
                String line;
                final var builder = new StringBuilder();
                try {
                    while ((line = br.readLine()) != null) {
                        builder.append(line);
                        builder.append(System.lineSeparator());
                    }
                } catch (IOException e) {
                    throw new CommunicationsException("Unable to read status event stream", e);
                }

                return parser.parse(builder.toString(), league.year(), league);
            } catch (IOException e) {
                throw new CommunicationsException("Error during operation", e);
            }
        } catch (IOException e) {
            throw new CommunicationsException("Error during operation", e);
        }
    }
}
