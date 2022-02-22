package com.wcl.mfnmanager.services.draft.loader;

import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.wcl.mfnmanager.entities.player.*;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DraftPlayerFileLoader {
    public Map<Integer, Player> loadPlayerFileData(final File draftClassDataDirectory, final String filename) {
        final var rowProcessor = new BeanListProcessor<>(DraftClassPlayer.class);

        final var parserSettings = new CsvParserSettings();
        parserSettings.setLineSeparatorDetectionEnabled(true);
        parserSettings.setSkipEmptyLines(true);
        parserSettings.setProcessor(rowProcessor);

        new CsvParser(parserSettings).parse(Path.of(draftClassDataDirectory.getAbsolutePath() + "/DRAFT_" + filename).toFile());

        return convertImportedDraftPlayers(rowProcessor.getBeans());
    }

    private Map<Integer, Player> convertImportedDraftPlayers(final List<DraftClassPlayer> importedDraftClassPlayers) {
        return importedDraftClassPlayers.stream().collect(Collectors.toMap(
                dp -> dp.playerID, this::convertImportedDraftPlayer));
    }

    private Player convertImportedDraftPlayer(DraftClassPlayer dcp) {
        final var positionSkills = convertPositionSkills(dcp);
        return new Player(dcp.playerID,
                dcp.firstName + " " + dcp.lastName,
                extractPosition(dcp),
                dcp.volatility,
                dcp.height,
                dcp.weight,
                dcp.positionCur,
                dcp.positionMax,
                positionSkills,
                new HashMap<Position, Potential>());
    }

    public Map<PlayerPositionSkills, Potential> convertPositionSkills(DraftClassPlayer dcp) {
        final var playerPositionSkills = new HashMap<PlayerPositionSkills, Potential>();
        playerPositionSkills.put(PlayerPositionSkills.MAX_SPEED,
                                 new Potential(dcp.maxSpeedCur, dcp.maxSpeedMax));
        playerPositionSkills.put(PlayerPositionSkills.ACCELERATION,
                new Potential(dcp.accelerationCur, dcp.accelerationMax));
        playerPositionSkills.put(PlayerPositionSkills.STRENGTH,
                new Potential(dcp.strengthCur, dcp.strengthMax));
        playerPositionSkills.put(PlayerPositionSkills.INTELLIGENCE,
                new Potential(dcp.intelligenceCur, dcp.intelligenceMax));
        playerPositionSkills.put(PlayerPositionSkills.DISCIPLINE,
                new Potential(dcp.disciplineCur, dcp.disciplineMax));
        playerPositionSkills.put(PlayerPositionSkills.RUN_BLOCKING,
                new Potential(dcp.runBlockingCur, dcp.runBlockingMax));
        playerPositionSkills.put(PlayerPositionSkills.PASS_BLOCKING,
                new Potential(dcp.passBlockingCur, dcp.passBlockingMax));
        playerPositionSkills.put(PlayerPositionSkills.PASS_CATCHING,
                new Potential(dcp.passCatchingCur, dcp.passCatchingMax));
        playerPositionSkills.put(PlayerPositionSkills.BUMP_AND_RUN_AVOIDANCE,
                new Potential(dcp.bandrAvoidanceCur, dcp.bandrAvoidanceMax));
        playerPositionSkills.put(PlayerPositionSkills.ROUTE_RUNNING,
                new Potential(dcp.routeRunningCur, dcp.routeRunningMax));
        playerPositionSkills.put(PlayerPositionSkills.PASS_RECEPTION_COURAGE,
                new Potential(dcp.passRecCourageCur, dcp.passRecCourageMax));
        playerPositionSkills.put(PlayerPositionSkills.PUNISH_RECEIVER,
                new Potential(dcp.punishReceiverCur, dcp.punishReceiverMax));
        playerPositionSkills.put(PlayerPositionSkills.ZONE_DEFENCE,
                new Potential(dcp.zoneCoverageCur, dcp.zoneCoverageMax));
        playerPositionSkills.put(PlayerPositionSkills.MAN_TO_MAN_COVERAGE,
                new Potential(dcp.manToManCoverageCur, dcp.manToManCoverageMax));
        playerPositionSkills.put(PlayerPositionSkills.BUMP_AND_RUN_COVERAGE,
                new Potential(dcp.bandrCoverageCur, dcp.bandrCoverageMax));
        playerPositionSkills.put(PlayerPositionSkills.STRIP_BALL,
                new Potential(dcp.stripBallCur, dcp.stripBallMax));
        playerPositionSkills.put(PlayerPositionSkills.PASS_RUSH,
                new Potential(dcp.passRushCur, dcp.passRushMax));
        playerPositionSkills.put(PlayerPositionSkills.RUN_DEFENCE,
                new Potential(dcp.runDefenceCur, dcp.runDefenceMax));
        playerPositionSkills.put(PlayerPositionSkills.TACKLE_ABILITY,
                new Potential(dcp.tackleAbilityCur, dcp.tackleAbilityMax));
        playerPositionSkills.put(PlayerPositionSkills.HOLDING,
                new Potential(dcp.kickHoldingCur, dcp.kickHoldingMax));
        playerPositionSkills.put(PlayerPositionSkills.KICK_STRENGTH,
                new Potential(dcp.kickStrengthCur, dcp.kickStrengthMax));
        playerPositionSkills.put(PlayerPositionSkills.KICK_ACCURACY,
                new Potential(dcp.kickAccuracyCur, dcp.kickAccuracyMax));
        playerPositionSkills.put(PlayerPositionSkills.PASS_ACCURACY,
                new Potential(dcp.passAccuracyCur, dcp.passAccuracyMax));
        playerPositionSkills.put(PlayerPositionSkills.HARD_COUNT,
                new Potential(dcp.hardCountCur, dcp.hardCountMax));
        playerPositionSkills.put(PlayerPositionSkills.ARM_STRENGTH,
                new Potential(dcp.armStrengthCur, dcp.armStrengthMax));
        playerPositionSkills.put(PlayerPositionSkills.PASSING_RELEASE,
                new Potential(dcp.passingReleaseCur, dcp.passingReleaseMax));
        playerPositionSkills.put(PlayerPositionSkills.LOOK_OFF_DEFENCE,
                new Potential(dcp.lookOffDefCur, dcp.lookOffDefMax));
        playerPositionSkills.put(PlayerPositionSkills.SCRAMBLING,
                new Potential(dcp.scramblingSkillCur, dcp.scramblingSkillMax));
        playerPositionSkills.put(PlayerPositionSkills.FIELD_OF_VISION,
                new Potential(dcp.fieldOfVisionCur, dcp.fieldOfVisionMax));
        playerPositionSkills.put(PlayerPositionSkills.PUNT_STRENGTH,
                new Potential(dcp.puntStrengthCur, dcp.puntStrengthMax));
        playerPositionSkills.put(PlayerPositionSkills.PUNT_ACCURACY,
                new Potential(dcp.puntAccuracyCur, dcp.puntAccuracyMax));
        playerPositionSkills.put(PlayerPositionSkills.PUNT_TIMING,
                new Potential(dcp.puntTimingCur, dcp.puntTimingMax));
        playerPositionSkills.put(PlayerPositionSkills.KICK_CATCHING,
                new Potential(dcp.kickCatchingCur, dcp.kickCatchingMax));
        playerPositionSkills.put(PlayerPositionSkills.BREAK_TACKLE,
                new Potential(dcp.breakTackleCur, dcp.breakTackleMax));
        playerPositionSkills.put(PlayerPositionSkills.BALL_CARRYING,
                new Potential(dcp.ballCarryingCur, dcp.ballCarryingMax));
        playerPositionSkills.put(PlayerPositionSkills.AVOID_FUMBLE,
                new Potential(dcp.avoidFumbleCur, dcp.avoidFumbleMax));
        playerPositionSkills.put(PlayerPositionSkills.SHORT_SNAPPING,
                new Potential(dcp.shortSnappingCur, dcp.shortSnappingMax));
        playerPositionSkills.put(PlayerPositionSkills.LONG_SNAPPING,
                new Potential(dcp.longSnappingCur, dcp.longSnappingMax));

        return playerPositionSkills;
    }
    /*
     * Returns the Position for the DraftClassPlayer.
     *
     * For the ALL.csv file, the position text is straightforward - eg "QB".  For other position related files such as
     * RB.csv, the position is listed as the position of the file with the original assigned position in brackets, eg
     * "RB (QB)" where QB is the original position.
     *
     * This method processes the text of the postion value on the DraftClassPlayer object to accurately obtain the
     * original assigned position.
     */
    private Position extractPosition(DraftClassPlayer draftClassPlayer) {
        var newPositionName = draftClassPlayer.position;
        final var index = newPositionName.indexOf(" (");
        if (index > 0) {
            newPositionName = newPositionName.substring(0, index);
        }
        newPositionName = switch (newPositionName) {
            case "Kickoffs", "Field Goal Kicker" -> "K";
            case "Gunner" -> "GUNNER";
            case "Kick Holder" -> "KH";
            case "Kick Returner" -> "KR";
            case "Long Snapper" -> "LS";
            case "Punt Returner" -> "PR";
            case "ST Blocker" -> "STBLK";
            case "ST Rusher" -> "STRUSH";
            default -> newPositionName;
        };

        return Position.valueOf(newPositionName);
    }

    static class DraftClassPlayer {
        @Parsed(field = "PlayerID")
        public int playerID;
        @Parsed(field = "FirstName")
        public String firstName;
        @Parsed(field = "LastName")
        public String lastName;
        @Parsed(field = "Pos")
        public String position;
        @Parsed(field = "Exp")
        public String experience;
        @Parsed(field = "Height")
        public int height;
        @Parsed(field = "Weight")
        public int weight;
        @Parsed(field = "Cur")
        public int positionCur;
        @Parsed(field = "Max")
        public int positionMax;
        @Parsed(field = "College")
        public String college;
        @Parsed(field = "Team")
        public String team;
        @Parsed(field = "Health")
        public int health;
        @Parsed(field = "Volatility")
        public int volatility;
        @Parsed(field = "MaxSpeedCur")
        public int maxSpeedCur;
        @Parsed(field = "MaxSpeedMax")
        public int maxSpeedMax;
        @Parsed(field = "AccelerationCur")
        public int accelerationCur;
        @Parsed(field = "AccelerationMax")
        public int accelerationMax;
        @Parsed(field = "StrengthCur")
        public int strengthCur;
        @Parsed(field = "StrengthMax")
        public int strengthMax;
        @Parsed(field = "IntelligenceCur")
        public int intelligenceCur;
        @Parsed(field = "IntelligenceMax")
        public int intelligenceMax;
        @Parsed(field = "DisciplineCur")
        public int disciplineCur;
        @Parsed(field = "DisciplineMax")
        public int disciplineMax;
        @Parsed(field = "PassAccuracyCur")
        public int passAccuracyCur;
        @Parsed(field = "PassAccuracyMax")
        public int passAccuracyMax;
        @Parsed(field = "HardCountCur")
        public int hardCountCur;
        @Parsed(field = "HardCountMax")
        public int hardCountMax;
        @Parsed(field = "ArmStrengthCur")
        public int armStrengthCur;
        @Parsed(field = "ArmStrengthMax")
        public int armStrengthMax;
        @Parsed(field = "PassingReleaseCur")
        public int passingReleaseCur;
        @Parsed(field = "PassingReleaseMax")
        public int passingReleaseMax;
        @Parsed(field = "LookOffDefCur")
        public int lookOffDefCur;
        @Parsed(field = "LookOffDefMax")
        public int lookOffDefMax;
        @Parsed(field = "ScramblingSkillCur")
        public int scramblingSkillCur;
        @Parsed(field = "ScramblingSkillMax")
        public int scramblingSkillMax;
        @Parsed(field = "FieldOfVisionCur")
        public int fieldOfVisionCur;
        @Parsed(field = "FieldOfVisionMax")
        public int fieldOfVisionMax;
        @Parsed(field = "PassCatchingCur")
        public int passCatchingCur;
        @Parsed(field = "PassCatchingMax")
        public int passCatchingMax;
        @Parsed(field = "B&RAvoidanceCur")
        public int bandrAvoidanceCur;
        @Parsed(field = "B&RAvoidanceMax")
        public int bandrAvoidanceMax;
        @Parsed(field = "RouteRunningCur")
        public int routeRunningCur;
        @Parsed(field = "RouteRunningMax")
        public int routeRunningMax;
        @Parsed(field = "PassRecCourageCur")
        public int passRecCourageCur;
        @Parsed(field = "PassRecCourageMax")
        public int passRecCourageMax;
        @Parsed(field = "TackleAbilityCur")
        public int tackleAbilityCur;
        @Parsed(field = "TackleAbilityMax")
        public int tackleAbilityMax;
        @Parsed(field = "StripBallCur")
        public int stripBallCur;
        @Parsed(field = "StripBallMax")
        public int stripBallMax;
        @Parsed(field = "BreakTackleCur")
        public int breakTackleCur;
        @Parsed(field = "BreakTackleMax")
        public int breakTackleMax;
        @Parsed(field = "BallCarryingCur")
        public int ballCarryingCur;
        @Parsed(field = "BallCarryingMax")
        public int ballCarryingMax;
        @Parsed(field = "AvoidFumbleCur")
        public int avoidFumbleCur;
        @Parsed(field = "AvoidFumbleMax")
        public int avoidFumbleMax;
        @Parsed(field = "RunBlockingCur")
        public int runBlockingCur;
        @Parsed(field = "RunBlockingMax")
        public int runBlockingMax;
        @Parsed(field = "PassBLockingCur")
        public int passBlockingCur;
        @Parsed(field = "PassBlockingMax")
        public int passBlockingMax;
        @Parsed(field = "ShortSnappingCur")
        public int shortSnappingCur;
        @Parsed(field = "ShortSnappingMax")
        public int shortSnappingMax;
        @Parsed(field = "LongSnappingCur")
        public int longSnappingCur;
        @Parsed(field = "LongSnappingMax")
        public int longSnappingMax;
        @Parsed(field = "PassRushCur")
        public int passRushCur;
        @Parsed(field = "PassRushMax")
        public int passRushMax;
        @Parsed(field = "RunDefenseCur")
        public int runDefenceCur;
        @Parsed(field = "RunDefenseMax")
        public int runDefenceMax;
        @Parsed(field = "PuntStrengthCur")
        public int puntStrengthCur;
        @Parsed(field = "PuntStrengthMax")
        public int puntStrengthMax;
        @Parsed(field = "PuntAccuracyCur")
        public int puntAccuracyCur;
        @Parsed(field = "PuntAccuracyMax")
        public int puntAccuracyMax;
        @Parsed(field = "KickStrengthCur")
        public int kickStrengthCur;
        @Parsed(field = "KickStrengthMax")
        public int kickStrengthMax;
        @Parsed(field = "KickAccuracyCur")
        public int kickAccuracyCur;
        @Parsed(field = "KickAccuracyMax")
        public int kickAccuracyMax;
        @Parsed(field = "KickHoldingCur")
        public int kickHoldingCur;
        @Parsed(field = "KickHoldingMax")
        public int kickHoldingMax;
        @Parsed(field = "PuntTimingCur")
        public int puntTimingCur;
        @Parsed(field = "PuntTimingMax")
        public int puntTimingMax;
        @Parsed(field = "KickCatchingCur")
        public int kickCatchingCur;
        @Parsed(field = "KickCatchingMax")
        public int kickCatchingMax;
        @Parsed(field = "PunishReceiverCur")
        public int punishReceiverCur;
        @Parsed(field = "PunishReceiverMax")
        public int punishReceiverMax;
        @Parsed(field = "ZoneCoverageCur")
        public int zoneCoverageCur;
        @Parsed(field = "ZoneCoverageMax")
        public int zoneCoverageMax;
        @Parsed(field = "M2MCoverageCur")
        public int manToManCoverageCur;
        @Parsed(field = "M2MCoverageMax")
        public int manToManCoverageMax;
        @Parsed(field = "B&RCoverageCur")
        public int bandrCoverageCur;
        @Parsed(field = "B&RCoverageMax")
        public int bandrCoverageMax;
    }
}
