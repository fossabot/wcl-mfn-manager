package com.wcl.mfnmanager.entities.draft;

import com.wcl.mfnmanager.entities.league.League;

/**
 * Contains the year and @link League associated with a draft.
 */
public record DraftInfo(int year,
                        League league) {
}