package com.wcl.mfnmanager.services.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import com.wcl.mfnmanager.entities.league.League;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class EnteredLeaguesParser {
    public List<League> parse(String htmlText) {
        final var document = Jsoup.parse(htmlText);
        final var leagueElements = document.getElementsByTag("li");
        final var enteredLeagues = new ArrayList<League>();

        leagueElements.forEach(element -> enteredLeagues.add(generateEnteredLeague(element)));

        return enteredLeagues;
    }

    private League generateEnteredLeague(Element element) {
        final var childElements = element.children();
        final var uri = URI.create(childElements.get(0).attr("href"));
        final var leagueName = childElements.get(0).text();
        final var fullStageText = childElements.get(1).text();

        final var firstSpaceIndex = fullStageText.indexOf(" ");
        final var year = extractYear(fullStageText);
        final var stageText = fullStageText.substring(firstSpaceIndex);

        return new League(uri, leagueName, year, stageText);
    }

    private int extractYear(String stageText) {
        // ENd of the XXX season
        var index = 0;

        if (stageText.startsWith("End")) {
            index = 3;
        }

        return Integer.parseInt(stageText.split(" ")[index]);
    }
}

