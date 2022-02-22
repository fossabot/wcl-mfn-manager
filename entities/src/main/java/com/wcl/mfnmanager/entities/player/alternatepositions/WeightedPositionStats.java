package com.wcl.mfnmanager.entities.player.alternatepositions;

public record WeightedPositionStats(int overweightPounds,
                                    int currentOA,
                                    int weightAdjustedCurrentOA,
                                    int currentOADifference,
                                    int maximumOA,
                                    int weightAdjustedMaximumOA,
                                    int maximumOADifference) {
}
