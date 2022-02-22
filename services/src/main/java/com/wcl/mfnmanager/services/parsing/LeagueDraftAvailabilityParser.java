package com.wcl.mfnmanager.services.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import com.wcl.mfnmanager.entities.draft.DraftInfo;
import com.wcl.mfnmanager.entities.league.League;

import java.util.Optional;

public final class LeagueDraftAvailabilityParser {


    public Optional<DraftInfo> parse(String htmlText, int year, League league) {
        final var document = Jsoup.parse(htmlText);

        DraftInfo draftInfo = null;
        if (nextSeasonDraftClassPresent(document, year)) {
            draftInfo = new DraftInfo(year + 1, league);
        } else if (currentSeasonDraftClassPresent(document)) {
            draftInfo = new DraftInfo(year, league);
        }

        return Optional.ofNullable(draftInfo);
    }

    private boolean nextSeasonDraftClassPresent(final Document document, int year) {
        return null != document.selectFirst("a:containsOwn(" + (year + 1) + " Draft Class)");
    }

    private boolean currentSeasonDraftClassPresent(final Document document) {
        return null != document.selectFirst("a:containsOwn(Draft Class)");
    }

}

