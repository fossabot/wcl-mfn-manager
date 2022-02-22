package com.wcl.mfnmanager.ui.guientities.converter;

import org.junit.jupiter.api.*;
import com.wcl.mfnmanager.entities.player.*;
import com.wcl.mfnmanager.ui.guientities.players.GuiPlayer;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerConverterTest {
    private GuiPlayer testPlayer;

    private Player player;

    @BeforeEach
    public void setup() {
        testPlayer = PlayerConverter.convertToGuiPlayer(buildTestDraftPlayer(), "Assigned");
    }

    @Test
    public void checkThatPlayerCoreSkillsCorrectlyConverted() {
        assertEquals(1, testPlayer.getMaxSpeed());
        assertEquals(2, testPlayer.getAcceleration());
        assertEquals(3, testPlayer.getStrength());
        assertEquals(4, testPlayer.getIntelligence());
        assertEquals(5, testPlayer.getDiscipline());
    }

    @Test
    public void checkThatPlayerBlockingSkillsCorrectlyConverted() {
        assertEquals(11, testPlayer.getCurrentRunBlocking());
        assertEquals(12, testPlayer.getFutureRunBlocking());
        assertEquals(13, testPlayer.getCurrentPassBlocking());
        assertEquals(14, testPlayer.getFuturePassBlocking());
    }

    @Test
    public void checkThatPlayerCatchingSkillsCorrectlyConverted() {
        assertEquals(15, testPlayer.getCurrentPassCatching());
        assertEquals(16, testPlayer.getFuturePassCatching());
        assertEquals(17, testPlayer.getCurrentPassReceptionCourage());
        assertEquals(18, testPlayer.getFuturePassReceptionCourage());
        assertEquals(19, testPlayer.getCurrentBumpAndRunAvoidance());
        assertEquals(20, testPlayer.getFutureBumpAndRunAvoidance());
        assertEquals(21, testPlayer.getCurrentRouteRunning());
        assertEquals(22, testPlayer.getFutureRouteRunning());
    }

    @Test
    public void checkThatPlayerCoverageSkillsCorrectlyConverted() {
        assertEquals(23, testPlayer.getCurrentPunishReceiver());
        assertEquals(24, testPlayer.getFuturePunishReceiver());
        assertEquals(25, testPlayer.getCurrentZoneCoverage());
        assertEquals(26, testPlayer.getFutureZoneCoverage());
        assertEquals(27, testPlayer.getCurrentManToManCoverage());
        assertEquals(28, testPlayer.getFutureManToManCoverage());
        assertEquals(29, testPlayer.getCurrentBumpAndRunCoverage());
        assertEquals(30, testPlayer.getFutureBumpAndRunCoverage());
    }

    @Test
    public void checkThatPlayerGeneralDefenceSkillsCorrectlyConverted() {
        assertEquals(31, testPlayer.getCurrentStripBall());
        assertEquals(32, testPlayer.getFutureStripBall());
        assertEquals(33, testPlayer.getCurrentPassRush());
        assertEquals(34, testPlayer.getFuturePassRush());
        assertEquals(35, testPlayer.getCurrentRunDefence());
        assertEquals(36, testPlayer.getFutureRunDefence());
        assertEquals(37, testPlayer.getCurrentTackleAbility());
        assertEquals(38, testPlayer.getFutureTackleAbility());
    }

    @Test
    public void checkThatPlayerHolderSkillsCorrectlyConverted() {
        assertEquals(39, testPlayer.getCurrentKickHolding());
        assertEquals(40, testPlayer.getFutureKickHolding());
    }

    @Test
    public void checkThatPlayerKickingSkillsCorrectlyConverted() {
        assertEquals(41, testPlayer.getCurrentKickStrength());
        assertEquals(42, testPlayer.getFutureKickStrength());
        assertEquals(43, testPlayer.getCurrentKickAccuracy());
        assertEquals(44, testPlayer.getFutureKickAccuracy());
    }

    @Test
    public void checkThatPlayerPassingSkillsCorrectlyConverted() {
        assertEquals(45, testPlayer.getCurrentPassAccuracy());
        assertEquals(46, testPlayer.getFuturePassAccuracy());
        assertEquals(47, testPlayer.getCurrentHardCount());
        assertEquals(48, testPlayer.getFutureHardCount());
        assertEquals(49, testPlayer.getCurrentArmStrength());
        assertEquals(50, testPlayer.getFutureArmStrength());
        assertEquals(51, testPlayer.getCurrentPassRelease());
        assertEquals(52, testPlayer.getFuturePassRelease());
        assertEquals(53, testPlayer.getCurrentLookOffDefence());
        assertEquals(54, testPlayer.getFutureLookOffDefence());
        assertEquals(55, testPlayer.getCurrentScramblingSkill());
        assertEquals(56, testPlayer.getFutureScramblingSkill());
        assertEquals(57, testPlayer.getCurrentFieldOfVision());
        assertEquals(58, testPlayer.getFutureFieldOfVision());
    }

    @Test
    public void checkThatPlayerPuntingSkillsCorrectlyConverted() {
        assertEquals(59, testPlayer.getCurrentPuntStrength());
        assertEquals(60, testPlayer.getFuturePuntStrength());
        assertEquals(61, testPlayer.getCurrentPuntAccuracy());
        assertEquals(62, testPlayer.getFuturePuntAccuracy());
        assertEquals(63, testPlayer.getCurrentPuntTiming());
        assertEquals(64, testPlayer.getFuturePuntTiming());
    }

    @Test
    public void checkThatPlayerReturnSkillsCorrectlyConverted() {
        assertEquals(65, testPlayer.getCurrentKickCatching());
        assertEquals(66, testPlayer.getFutureKickCatching());
    }

    @Test
    public void checkThatPlayerRushingSkillsCorrectlyConverted() {
        assertEquals(67, testPlayer.getCurrentBreakTackle());
        assertEquals(68, testPlayer.getFutureBreakTackle());
        assertEquals(69, testPlayer.getCurrentAvoidFumble());
        assertEquals(70, testPlayer.getFutureAvoidFumble());
        assertEquals(71, testPlayer.getCurrentBallCarrying());
        assertEquals(72, testPlayer.getFutureBallCarrying());
    }

    @Test
    public void checkThatPlayerSnappingSkillsCorrectlyConverted() {
        assertEquals(73, testPlayer.getCurrentShortSnapping());
        assertEquals(74, testPlayer.getFutureShortSnapping());
        assertEquals(75, testPlayer.getCurrentLongSnapping());
        assertEquals(76, testPlayer.getFutureLongSnapping());
    }

    @Test
    public void checkBaseDataCorrectlyConverted() {
        assertEquals(63745, testPlayer.getId(), "ID not correctly converted");
        assertEquals("Wibble Wobble", testPlayer.getName(), "Name not correctly converted");
        assertEquals(Position.FS, testPlayer.getAssignedPosition(), "Assigned position not correctly converted");
        assertEquals(76, testPlayer.getHeight(), "Height not correctly converted");
        assertEquals(195, testPlayer.getWeight(), "Weight not correctly converted");
        assertEquals(55, testPlayer.getVolatility(), "Volatility not correctly converted");
        assertEquals(1, testPlayer.getMaxSpeed(), "Max Speed not correctly converted");
        assertEquals(2, testPlayer.getAcceleration(), "Acceleration not correctly converted");
        assertEquals(3, testPlayer.getStrength(), "Strength not correctly converted");
        assertEquals(4, testPlayer.getIntelligence(), "Intelligence not correctly converted");
        assertEquals(5, testPlayer.getDiscipline(), "Discipline not correctly converted");
    }

    private Player buildTestDraftPlayer() {
        final var positionRatings = new HashMap<Position, Potential>();
        positionRatings.put(Position.CB, new Potential(34, 67));
        positionRatings.put(Position.DT, new Potential(35, 68));
        positionRatings.put(Position.FS, new Potential(36, 69));
        positionRatings.put(Position.LDE, new Potential(37, 70));
        positionRatings.put(Position.RDE, new Potential(38, 71));
        positionRatings.put(Position.MLB, new Potential(39, 72));
        positionRatings.put(Position.SLB, new Potential(40, 73));
        positionRatings.put(Position.SS, new Potential(41, 74));
        positionRatings.put(Position.WLB, new Potential(42, 75));
        positionRatings.put(Position.QB, new Potential(43, 76));
        positionRatings.put(Position.RB, new Potential(44, 77));
        positionRatings.put(Position.FB, new Potential(45, 78));
        positionRatings.put(Position.C, new Potential(46, 79));
        positionRatings.put(Position.LG, new Potential(47, 80));
        positionRatings.put(Position.LT, new Potential(48, 81));
        positionRatings.put(Position.RG, new Potential(49, 82));
        positionRatings.put(Position.RT, new Potential(50, 83));
        positionRatings.put(Position.TE, new Potential(51, 84));
        positionRatings.put(Position.WR, new Potential(52, 85));
        final var player = new Player(
                63745,
                "Wibble Wobble",
                Position.FS,
                55,
                76,
                195,
                23,
                85,
                generatePlayerSkills(),
                positionRatings);
        return player;
    }

    private Map<PlayerPositionSkills, Potential> generatePlayerSkills() {
        var playerSkills = new HashMap<PlayerPositionSkills, Potential>();
        generateCoreSKills(playerSkills);
        generateBlockingSkills(playerSkills);
        generateCatchingSkills(playerSkills);
        generateCoverageSkills(playerSkills);
        generateGeneralDefenceSkills(playerSkills);
        generateHolderSkills(playerSkills);
        generateKickingSkills(playerSkills);
        generatePassingSkills(playerSkills);
        generatePuntingSkills(playerSkills);
        generateReturnSkills(playerSkills);
        generateRushingSkills(playerSkills);
        generateSnappingSkills(playerSkills);

        return playerSkills;
    }

    private void generateCoreSKills(Map<PlayerPositionSkills, Potential> playerSkills) {
        playerSkills.put(PlayerPositionSkills.MAX_SPEED, new Potential(1, 1));
        playerSkills.put(PlayerPositionSkills.ACCELERATION, new Potential(2, 2));
        playerSkills.put(PlayerPositionSkills.STRENGTH, new Potential(3, 3));
        playerSkills.put(PlayerPositionSkills.INTELLIGENCE, new Potential(4, 4));
        playerSkills.put(PlayerPositionSkills.DISCIPLINE, new Potential(5, 5));
    }

    private void generateBlockingSkills(Map<PlayerPositionSkills, Potential> playerSkills) {
        playerSkills.put(PlayerPositionSkills.RUN_BLOCKING, new Potential(11, 12));
        playerSkills.put(PlayerPositionSkills.PASS_BLOCKING, new Potential(13, 14));
    }

    private void generateCatchingSkills(Map<PlayerPositionSkills, Potential> playerSkills) {
        playerSkills.put(PlayerPositionSkills.PASS_CATCHING, new Potential(15, 16));
        playerSkills.put(PlayerPositionSkills.PASS_RECEPTION_COURAGE, new Potential(17, 18));
        playerSkills.put(PlayerPositionSkills.BUMP_AND_RUN_AVOIDANCE, new Potential(19, 20));
        playerSkills.put(PlayerPositionSkills.ROUTE_RUNNING, new Potential(21, 22));
    }

    private void generateCoverageSkills(Map<PlayerPositionSkills, Potential> playerSkills) {
        playerSkills.put(PlayerPositionSkills.PUNISH_RECEIVER, new Potential(23, 24));
        playerSkills.put(PlayerPositionSkills.ZONE_DEFENCE, new Potential(25, 26));
        playerSkills.put(PlayerPositionSkills.MAN_TO_MAN_COVERAGE, new Potential(27, 28));
        playerSkills.put(PlayerPositionSkills.BUMP_AND_RUN_COVERAGE, new Potential(29, 30));
    }

    private void generateGeneralDefenceSkills(Map<PlayerPositionSkills, Potential> playerSkills) {
        playerSkills.put(PlayerPositionSkills.STRIP_BALL, new Potential(31,32));
        playerSkills.put(PlayerPositionSkills.PASS_RUSH, new Potential(33,34));
        playerSkills.put(PlayerPositionSkills.RUN_DEFENCE, new Potential(35,36));
        playerSkills.put(PlayerPositionSkills.TACKLE_ABILITY, new Potential(37,38));
    }

    private void generateHolderSkills(Map<PlayerPositionSkills, Potential> playerSkills) {
        playerSkills.put(PlayerPositionSkills.HOLDING, new Potential(39,40));
    }

    private void generateKickingSkills(Map<PlayerPositionSkills, Potential> playerSkills) {
        playerSkills.put(PlayerPositionSkills.KICK_STRENGTH, new Potential(41,42));
        playerSkills.put(PlayerPositionSkills.KICK_ACCURACY, new Potential(43,44));
    }

    private void generatePassingSkills(Map<PlayerPositionSkills, Potential> playerSkills) {
        playerSkills.put(PlayerPositionSkills.PASS_ACCURACY, new Potential(45,46));
        playerSkills.put(PlayerPositionSkills.HARD_COUNT, new Potential(47,48));
        playerSkills.put(PlayerPositionSkills.ARM_STRENGTH, new Potential(49,50));
        playerSkills.put(PlayerPositionSkills.PASSING_RELEASE, new Potential(51,52));
        playerSkills.put(PlayerPositionSkills.LOOK_OFF_DEFENCE, new Potential(53,54));
        playerSkills.put(PlayerPositionSkills.SCRAMBLING, new Potential(55,56));
        playerSkills.put(PlayerPositionSkills.FIELD_OF_VISION, new Potential(57,58));
    }

    private void generatePuntingSkills(Map<PlayerPositionSkills, Potential> playerSkills) {
        playerSkills.put(PlayerPositionSkills.PUNT_STRENGTH, new Potential(59,60));
        playerSkills.put(PlayerPositionSkills.PUNT_ACCURACY, new Potential(61,62));
        playerSkills.put(PlayerPositionSkills.PUNT_TIMING, new Potential(63,64));
    }

    private void generateReturnSkills(Map<PlayerPositionSkills, Potential> playerSkills) {
        playerSkills.put(PlayerPositionSkills.KICK_CATCHING, new Potential(65,66));
    }

    private void generateRushingSkills(Map<PlayerPositionSkills, Potential> playerSkills) {
        playerSkills.put(PlayerPositionSkills.BREAK_TACKLE, new Potential(67,68));
        playerSkills.put(PlayerPositionSkills.AVOID_FUMBLE, new Potential(69,70));
        playerSkills.put(PlayerPositionSkills.BALL_CARRYING, new Potential(71,72));
    }

    private void generateSnappingSkills(Map<PlayerPositionSkills, Potential> playerSkills) {
        playerSkills.put(PlayerPositionSkills.SHORT_SNAPPING, new Potential(73,74));
        playerSkills.put(PlayerPositionSkills.LONG_SNAPPING, new Potential(75,76));
    }

}
