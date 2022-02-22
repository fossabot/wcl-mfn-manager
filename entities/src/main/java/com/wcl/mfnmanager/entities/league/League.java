package com.wcl.mfnmanager.entities.league;

import java.net.URI;

/**
 * Represents an in game League.
 *
 * @param uri - the URI of the League home page.
 * @param name - the name of the League.
 * @param year - the current year of the League.
 * @param stage - the current stage of the League.
 */
public record League(URI uri,
                    String name,
                    int year,
                    String stage){
}
