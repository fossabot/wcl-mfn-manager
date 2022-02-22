package com.wcl.mfnmanager.ui.guientities.converter;

import com.wcl.mfnmanager.entities.player.Player;
import com.wcl.mfnmanager.entities.player.PlayerPositionSkills;
import com.wcl.mfnmanager.entities.player.Position;
import com.wcl.mfnmanager.entities.player.PotentialType;
import com.wcl.mfnmanager.ui.guientities.players.GuiPlayer;

public final class PlayerConverter {
    private PlayerConverter() {
    }

    public static GuiPlayer convertToGuiPlayer(Player player, String displayedPosition) {
        final var guiPlayer = new GuiPlayer();
        convertPlayerBioDetails(player, guiPlayer);
        convertPlayerOARatings(player, guiPlayer, displayedPosition);
        convertPlayerCoreSkills(player, guiPlayer);
        convertPlayerBlockingSkills(player, guiPlayer);
        convertPlayerCatchingSkills(player, guiPlayer);
        convertPlayerCoverageSkills(player, guiPlayer);
        convertPlayerDefensiveSkills(player, guiPlayer);
        convertPlayerHolderSkills(player, guiPlayer);
        convertPlayerKickingSkills(player, guiPlayer);
        convertPlayerPassingSkills(player, guiPlayer);
        convertPlayerPuntingSkills(player, guiPlayer);
        convertPlayerReturnerSkills(player, guiPlayer);
        convertPlayerRushingSkills(player, guiPlayer);
        convertPlayerSnappingSkills(player, guiPlayer);

        return guiPlayer;
    }


    private static void convertPlayerCoreSkills(Player player, GuiPlayer guiPlayer) {
        guiPlayer.setMaxSpeed(player.getPlayerPositionSkillValue(PlayerPositionSkills.MAX_SPEED, PotentialType.CURRENT));
        guiPlayer.setAcceleration(player.getPlayerPositionSkillValue(PlayerPositionSkills.ACCELERATION, PotentialType.CURRENT));
        guiPlayer.setStrength(player.getPlayerPositionSkillValue(PlayerPositionSkills.STRENGTH, PotentialType.CURRENT));
        guiPlayer.setIntelligence(player.getPlayerPositionSkillValue(PlayerPositionSkills.INTELLIGENCE, PotentialType.CURRENT));
        guiPlayer.setDiscipline(player.getPlayerPositionSkillValue(PlayerPositionSkills.DISCIPLINE, PotentialType.CURRENT));
    }

    private static void convertPlayerOARatings(Player player, GuiPlayer guiPlayer, String displayedPosition) {
        if ("Assigned".equals(displayedPosition)) {
            guiPlayer.setCurrentOA(player.currentOA());
            guiPlayer.setFutureOA(player.maximumOA());
        } else {
            final var position = Position.valueOf(displayedPosition);
            guiPlayer.setCurrentOA(player.getPositionPotentialValue(position, PotentialType.CURRENT));
            guiPlayer.setFutureOA(player.getPositionPotentialValue(position, PotentialType.FUTURE));
        }
    }

    private static void convertPlayerBioDetails(Player player, GuiPlayer guiPlayer) {
        guiPlayer.setId(player.id());
        guiPlayer.setName(player.name());
        guiPlayer.setHeight(player.height());
        guiPlayer.setWeight(player.weight());
        guiPlayer.setAssignedPosition(player.assignedPosition());
        guiPlayer.setVolatility(player.volatility());
    }

    private static void convertPlayerBlockingSkills(Player player, GuiPlayer guiPlayer) {
        guiPlayer.setCurrentRunBlocking(player.getPlayerPositionSkillValue(PlayerPositionSkills.RUN_BLOCKING, PotentialType.CURRENT));
        guiPlayer.setFutureRunBlocking(player.getPlayerPositionSkillValue(PlayerPositionSkills.RUN_BLOCKING, PotentialType.FUTURE));
        guiPlayer.setCurrentPassBlocking(player.getPlayerPositionSkillValue(PlayerPositionSkills.PASS_BLOCKING, PotentialType.CURRENT));
        guiPlayer.setFuturePassBlocking(player.getPlayerPositionSkillValue(PlayerPositionSkills.PASS_BLOCKING, PotentialType.FUTURE));
    }

    private static void convertPlayerCatchingSkills(Player player, GuiPlayer guiPlayer) {
        guiPlayer.setCurrentPassCatching(player.getPlayerPositionSkillValue(PlayerPositionSkills.PASS_CATCHING, PotentialType.CURRENT));
        guiPlayer.setFuturePassCatching(player.getPlayerPositionSkillValue(PlayerPositionSkills.PASS_CATCHING, PotentialType.FUTURE));
        guiPlayer.setCurrentPassReceptionCourage(player.getPlayerPositionSkillValue(PlayerPositionSkills.PASS_RECEPTION_COURAGE, PotentialType.CURRENT));
        guiPlayer.setFuturePassReceptionCourage(player.getPlayerPositionSkillValue(PlayerPositionSkills.PASS_RECEPTION_COURAGE, PotentialType.FUTURE));
        guiPlayer.setCurrentBumpAndRunAvoidance(player.getPlayerPositionSkillValue(PlayerPositionSkills.BUMP_AND_RUN_AVOIDANCE, PotentialType.CURRENT));
        guiPlayer.setFutureBumpAndRunAvoidance(player.getPlayerPositionSkillValue(PlayerPositionSkills.BUMP_AND_RUN_AVOIDANCE, PotentialType.FUTURE));
        guiPlayer.setCurrentRouteRunning(player.getPlayerPositionSkillValue(PlayerPositionSkills.ROUTE_RUNNING, PotentialType.CURRENT));
        guiPlayer.setFutureRouteRunning(player.getPlayerPositionSkillValue(PlayerPositionSkills.ROUTE_RUNNING, PotentialType.FUTURE));
    }

    private static void convertPlayerCoverageSkills(Player player, GuiPlayer guiPlayer) {
        guiPlayer.setCurrentPunishReceiver(player.getPlayerPositionSkillValue(PlayerPositionSkills.PUNISH_RECEIVER, PotentialType.CURRENT));
        guiPlayer.setFuturePunishReceiver(player.getPlayerPositionSkillValue(PlayerPositionSkills.PUNISH_RECEIVER, PotentialType.FUTURE));
        guiPlayer.setCurrentZoneCoverage(player.getPlayerPositionSkillValue(PlayerPositionSkills.ZONE_DEFENCE, PotentialType.CURRENT));
        guiPlayer.setFutureZoneCoverage(player.getPlayerPositionSkillValue(PlayerPositionSkills.ZONE_DEFENCE, PotentialType.FUTURE));
        guiPlayer.setCurrentManToManCoverage(player.getPlayerPositionSkillValue(PlayerPositionSkills.MAN_TO_MAN_COVERAGE, PotentialType.CURRENT));
        guiPlayer.setFutureManToManCoverage(player.getPlayerPositionSkillValue(PlayerPositionSkills.MAN_TO_MAN_COVERAGE, PotentialType.FUTURE));
        guiPlayer.setCurrentBumpAndRunCoverage(player.getPlayerPositionSkillValue(PlayerPositionSkills.BUMP_AND_RUN_COVERAGE, PotentialType.CURRENT));
        guiPlayer.setFutureBumpAndRunCoverage(player.getPlayerPositionSkillValue(PlayerPositionSkills.BUMP_AND_RUN_COVERAGE, PotentialType.FUTURE));
   }

    private static void convertPlayerDefensiveSkills(Player player, GuiPlayer guiPlayer) {
        guiPlayer.setCurrentStripBall(player.getPlayerPositionSkillValue(PlayerPositionSkills.STRIP_BALL, PotentialType.CURRENT));
        guiPlayer.setFutureStripBall(player.getPlayerPositionSkillValue(PlayerPositionSkills.STRIP_BALL, PotentialType.FUTURE));
        guiPlayer.setCurrentPassRush(player.getPlayerPositionSkillValue(PlayerPositionSkills.PASS_RUSH, PotentialType.CURRENT));
        guiPlayer.setFuturePassRush(player.getPlayerPositionSkillValue(PlayerPositionSkills.PASS_RUSH, PotentialType.FUTURE));
        guiPlayer.setCurrentRunDefence(player.getPlayerPositionSkillValue(PlayerPositionSkills.RUN_DEFENCE, PotentialType.CURRENT));
        guiPlayer.setFutureRunDefence(player.getPlayerPositionSkillValue(PlayerPositionSkills.RUN_DEFENCE, PotentialType.FUTURE));
        guiPlayer.setCurrentTackleAbility(player.getPlayerPositionSkillValue(PlayerPositionSkills.TACKLE_ABILITY, PotentialType.CURRENT));
        guiPlayer.setFutureTackleAbility(player.getPlayerPositionSkillValue(PlayerPositionSkills.TACKLE_ABILITY, PotentialType.FUTURE));
    }

    private static void convertPlayerHolderSkills(Player player, GuiPlayer guiPlayer) {
        guiPlayer.setCurrentKickHolding(player.getPlayerPositionSkillValue(PlayerPositionSkills.HOLDING, PotentialType.CURRENT));
        guiPlayer.setFutureKickHolding(player.getPlayerPositionSkillValue(PlayerPositionSkills.HOLDING, PotentialType.FUTURE));
    }

    private static void convertPlayerKickingSkills(Player player, GuiPlayer guiPlayer) {
        guiPlayer.setCurrentKickStrength(player.getPlayerPositionSkillValue(PlayerPositionSkills.KICK_STRENGTH, PotentialType.CURRENT));
        guiPlayer.setFutureKickStrength(player.getPlayerPositionSkillValue(PlayerPositionSkills.KICK_STRENGTH, PotentialType.FUTURE));
        guiPlayer.setCurrentKickAccuracy(player.getPlayerPositionSkillValue(PlayerPositionSkills.KICK_ACCURACY, PotentialType.CURRENT));
        guiPlayer.setFutureKickAccuracy(player.getPlayerPositionSkillValue(PlayerPositionSkills.KICK_ACCURACY, PotentialType.FUTURE));
    }

    private static void convertPlayerPassingSkills(Player player, GuiPlayer guiPlayer) {
        guiPlayer.setCurrentPassAccuracy(player.getPlayerPositionSkillValue(PlayerPositionSkills.PASS_ACCURACY, PotentialType.CURRENT));
        guiPlayer.setFuturePassAccuracy(player.getPlayerPositionSkillValue(PlayerPositionSkills.PASS_ACCURACY, PotentialType.FUTURE));
        guiPlayer.setCurrentHardCount(player.getPlayerPositionSkillValue(PlayerPositionSkills.HARD_COUNT, PotentialType.CURRENT));
        guiPlayer.setFutureHardCount(player.getPlayerPositionSkillValue(PlayerPositionSkills.HARD_COUNT, PotentialType.FUTURE));
        guiPlayer.setCurrentArmStrength(player.getPlayerPositionSkillValue(PlayerPositionSkills.ARM_STRENGTH, PotentialType.CURRENT));
        guiPlayer.setFutureArmStrength(player.getPlayerPositionSkillValue(PlayerPositionSkills.ARM_STRENGTH, PotentialType.FUTURE));
        guiPlayer.setCurrentPassRelease(player.getPlayerPositionSkillValue(PlayerPositionSkills.PASSING_RELEASE, PotentialType.CURRENT));
        guiPlayer.setFuturePassRelease(player.getPlayerPositionSkillValue(PlayerPositionSkills.PASSING_RELEASE, PotentialType.FUTURE));
        guiPlayer.setCurrentLookOffDefence(player.getPlayerPositionSkillValue(PlayerPositionSkills.LOOK_OFF_DEFENCE, PotentialType.CURRENT));
        guiPlayer.setFutureLookOffDefence(player.getPlayerPositionSkillValue(PlayerPositionSkills.LOOK_OFF_DEFENCE, PotentialType.FUTURE));
        guiPlayer.setCurrentScramblingSkill(player.getPlayerPositionSkillValue(PlayerPositionSkills.SCRAMBLING, PotentialType.CURRENT));
        guiPlayer.setFutureScramblingSkill(player.getPlayerPositionSkillValue(PlayerPositionSkills.SCRAMBLING, PotentialType.FUTURE));
        guiPlayer.setCurrentFieldOfVision(player.getPlayerPositionSkillValue(PlayerPositionSkills.FIELD_OF_VISION, PotentialType.CURRENT));
        guiPlayer.setFutureFieldOfVision(player.getPlayerPositionSkillValue(PlayerPositionSkills.FIELD_OF_VISION, PotentialType.FUTURE));
    }

    private static void convertPlayerPuntingSkills(Player player, GuiPlayer guiPlayer) {
        guiPlayer.setCurrentPuntStrength(player.getPlayerPositionSkillValue(PlayerPositionSkills.PUNT_STRENGTH, PotentialType.CURRENT));
        guiPlayer.setFuturePuntStrength(player.getPlayerPositionSkillValue(PlayerPositionSkills.PUNT_STRENGTH, PotentialType.FUTURE));
        guiPlayer.setCurrentPuntAccuracy(player.getPlayerPositionSkillValue(PlayerPositionSkills.PUNT_ACCURACY, PotentialType.CURRENT));
        guiPlayer.setFuturePuntAccuracy(player.getPlayerPositionSkillValue(PlayerPositionSkills.PUNT_ACCURACY, PotentialType.FUTURE));
        guiPlayer.setCurrentPuntTiming(player.getPlayerPositionSkillValue(PlayerPositionSkills.PUNT_TIMING, PotentialType.CURRENT));
        guiPlayer.setFuturePuntTiming(player.getPlayerPositionSkillValue(PlayerPositionSkills.PUNT_TIMING, PotentialType.FUTURE));
    }

    private static void convertPlayerReturnerSkills(Player player, GuiPlayer guiPlayer) {
        guiPlayer.setCurrentKickCatching(player.getPlayerPositionSkillValue(PlayerPositionSkills.KICK_CATCHING, PotentialType.CURRENT));
        guiPlayer.setFutureKickCatching(player.getPlayerPositionSkillValue(PlayerPositionSkills.KICK_CATCHING, PotentialType.FUTURE));
    }

    private static void convertPlayerRushingSkills(Player player, GuiPlayer guiPlayer) {
        guiPlayer.setCurrentBreakTackle(player.getPlayerPositionSkillValue(PlayerPositionSkills.BREAK_TACKLE, PotentialType.CURRENT));
        guiPlayer.setFutureBreakTackle(player.getPlayerPositionSkillValue(PlayerPositionSkills.BREAK_TACKLE, PotentialType.FUTURE));
        guiPlayer.setCurrentBallCarrying(player.getPlayerPositionSkillValue(PlayerPositionSkills.BALL_CARRYING, PotentialType.CURRENT));
        guiPlayer.setFutureBallCarrying(player.getPlayerPositionSkillValue(PlayerPositionSkills.BALL_CARRYING, PotentialType.FUTURE));
        guiPlayer.setCurrentAvoidFumble(player.getPlayerPositionSkillValue(PlayerPositionSkills.AVOID_FUMBLE, PotentialType.CURRENT));
        guiPlayer.setFutureAvoidFumble(player.getPlayerPositionSkillValue(PlayerPositionSkills.AVOID_FUMBLE, PotentialType.FUTURE));
    }

    private static void convertPlayerSnappingSkills(Player player, GuiPlayer guiPlayer) {
        guiPlayer.setCurrentShortSnapping(player.getPlayerPositionSkillValue(PlayerPositionSkills.SHORT_SNAPPING, PotentialType.CURRENT));
        guiPlayer.setFutureShortSnapping(player.getPlayerPositionSkillValue(PlayerPositionSkills.SHORT_SNAPPING, PotentialType.FUTURE));
        guiPlayer.setCurrentLongSnapping(player.getPlayerPositionSkillValue(PlayerPositionSkills.LONG_SNAPPING, PotentialType.CURRENT));
        guiPlayer.setFutureLongSnapping(player.getPlayerPositionSkillValue(PlayerPositionSkills.LONG_SNAPPING, PotentialType.FUTURE));
    }
}
