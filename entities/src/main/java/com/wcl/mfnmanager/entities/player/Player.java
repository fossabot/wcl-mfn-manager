package com.wcl.mfnmanager.entities.player;

import java.util.Map;

public record Player(int id,
                     String name,
                     Position assignedPosition,
                     int volatility,
                     int height,
                     int weight,
                     int currentOA,
                     int maximumOA,
                     Map<PlayerPositionSkills, Potential> playerSkills,
                     Map<Position, Potential> positionPotentialRatings) {

    public Integer getPositionPotentialValue(final Position position, final PotentialType potentialType) {
        if (PotentialType.CURRENT == potentialType)
            return positionPotentialRatings.get(position).current();

        return positionPotentialRatings.get(position).future();
    }

    public Integer getPlayerPositionSkillValue(final PlayerPositionSkills positionSkill, final PotentialType potentialType) {
        if (PotentialType.CURRENT == potentialType)
            return playerSkills.get(positionSkill).current();

        return playerSkills.get(positionSkill).future();
    }
}
