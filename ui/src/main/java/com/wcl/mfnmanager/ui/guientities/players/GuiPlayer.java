/*
 * This project is licensed under the Apache 2.0  license.
 *
 *  For details see the LICENSE file which can be found at the base of this project archive.
 */

package com.wcl.mfnmanager.ui.guientities.players;

import com.wcl.mfnmanager.entities.player.Position;

public class GuiPlayer {
    private final GuiPlayerCommonFields guiPlayerCommonFields = new GuiPlayerCommonFields();
    private final GuiPlayerOARatingFields guiPlayerOARatings = new GuiPlayerOARatingFields();
    private final GuiPlayerCoreSkillsFields guiPlayerCoreSkills = new GuiPlayerCoreSkillsFields();
    private final GuiPlayerBlockingFields guiPlayerBlockingSkills = new GuiPlayerBlockingFields();
    private final GuiPlayerCatchingFields guiPlayerCatchingSkills = new GuiPlayerCatchingFields();
    private final GuiPlayerCoverageFields guiPlayerCoverageSkills = new GuiPlayerCoverageFields();
    private final GuiPlayerDefenceFields guiPlayerDefensiveSkills = new GuiPlayerDefenceFields();
    private final GuiPlayerHolderFields guiPlayerHolderSkills = new GuiPlayerHolderFields();
    private final GuiPlayerKickingFields guiPlayerKickingSkills = new GuiPlayerKickingFields();
    private final GuiPlayerPassingFields guiPlayerPassingSkills = new GuiPlayerPassingFields();
    private final GuiPlayerPuntingFields guiPlayerPuntingSkills = new GuiPlayerPuntingFields();
    private final GuiPlayerReturnerFields guiPlayerReturnerSkills = new GuiPlayerReturnerFields();
    private final GuiPlayerRushingFields guiPlayerRushingSkills = new GuiPlayerRushingFields();
    private final GuiPlayerSnappingFields guiPlayerSnappingSkills = new GuiPlayerSnappingFields();

    // COMMON FIELDS
    public Integer getId() {
        return guiPlayerCommonFields.getId();
    }

    public void setId(int value) {
        guiPlayerCommonFields.setId(value);
    }

    public String getName() {
        return guiPlayerCommonFields.getName();
    }

    public void setName(String value) {
        guiPlayerCommonFields.setName(value);
    }

    public Integer getHeight() {
        return guiPlayerCommonFields.getHeight();
    }

    public void setHeight(int value) {
        guiPlayerCommonFields.setHeight(value);
    }

    public Integer getWeight() {
        return guiPlayerCommonFields.getWeight();
    }

    public void setWeight(int value) {
        guiPlayerCommonFields.setWeight(value);
    }

    public Position getAssignedPosition() {
        return guiPlayerCommonFields.getAssignedPosition();
    }

    public void setAssignedPosition(Position value) {
        guiPlayerCommonFields.setAssignedPosition(value);
    }

    public Integer getVolatility() {
        return guiPlayerCommonFields.getVolatility();
    }

    public void setVolatility(int value) {
        guiPlayerCommonFields.setVolatility(value);
    }

    // OA Ratings
    public Integer getCurrentOA() {
        return guiPlayerOARatings.getCurrentOA();
    }

    public void setCurrentOA(int value) {
        guiPlayerOARatings.setCurrentOA(value);
    }

    public Integer getFutureOA() {
        return guiPlayerOARatings.getFutureOA();
    }

    public void setFutureOA(int value) {
        guiPlayerOARatings.setFutureOA(value);
    }

    // Core Skills
    public Integer getMaxSpeed() {
        return guiPlayerCoreSkills.getMaxSpeed();
    }

    public void setMaxSpeed(int value) {
        guiPlayerCoreSkills.setMaxSpeed(value);
    }

    public Integer getAcceleration() {
        return guiPlayerCoreSkills.getAcceleration();
    }

    public void setAcceleration(int value) {
        guiPlayerCoreSkills.setAcceleration(value);
    }

    public Integer getStrength() {
        return guiPlayerCoreSkills.getStrength();
    }

    public void setStrength(int value) {
        guiPlayerCoreSkills.setStrength(value);
    }

    public Integer getIntelligence() {
        return guiPlayerCoreSkills.getIntelligence();
    }

    public void setIntelligence(int value) {
        guiPlayerCoreSkills.setIntelligence(value);
    }

    public Integer getDiscipline() {
        return guiPlayerCoreSkills.getDiscipline();
    }

    public void setDiscipline(int value) {
        guiPlayerCoreSkills.setDiscipline(value);
    }

    // Blocking Skills
    public Integer getCurrentRunBlocking() {
        return guiPlayerBlockingSkills.getRunBlockingCurrent();
    }

    public void setCurrentRunBlocking(int value) {
        guiPlayerBlockingSkills.setRunBlockingCurrent(value);
    }

    public Integer getFutureRunBlocking() {
        return guiPlayerBlockingSkills.getRunBlockingFuture();
    }

    public void setFutureRunBlocking(Integer value) {
        guiPlayerBlockingSkills.setRunBlockingFuture(value);
    }

    public Integer getCurrentPassBlocking() {
        return guiPlayerBlockingSkills.getPassBlockingCurrent();
    }

    public void setCurrentPassBlocking(int value) {
        guiPlayerBlockingSkills.setPassBlockingCurrent(value);
    }

    public Integer getFuturePassBlocking() {
        return guiPlayerBlockingSkills.getPassBlockingFuture();
    }

    public void setFuturePassBlocking(int value) {
        guiPlayerBlockingSkills.setPassBlockingFuture(value);
    }

    // Catching Skills
    public Integer getCurrentPassCatching() { return guiPlayerCatchingSkills.getPassCatchingCurrent(); }

    public void setCurrentPassCatching(int value) { guiPlayerCatchingSkills.setPassCatchingCurrent(value); }

    public Integer getFuturePassCatching() { return guiPlayerCatchingSkills.getPassCatchingFuture(); }

    public void setFuturePassCatching(int value) { guiPlayerCatchingSkills.setPassCatchingFuture(value); }

    public Integer getCurrentPassReceptionCourage() { return guiPlayerCatchingSkills.getPassRecCourageCurrent(); }

    public void setCurrentPassReceptionCourage(int value) { guiPlayerCatchingSkills.setPassRecCourageCurrent(value); }

    public Integer getFuturePassReceptionCourage() { return guiPlayerCatchingSkills.getPassRecCourageFuture(); }

    public void setFuturePassReceptionCourage(int value) { guiPlayerCatchingSkills.setPassRecCourageFuture(value); }

    public Integer getCurrentBumpAndRunAvoidance() { return guiPlayerCatchingSkills.getBumpAndRunAvoidanceCurrent(); }

    public void setCurrentBumpAndRunAvoidance(int value) { guiPlayerCatchingSkills.setBumpAndRunAvoidanceCurrent(value); }

    public Integer getFutureBumpAndRunAvoidance() { return guiPlayerCatchingSkills.getBumpAndRunAvoidanceFuture(); }

    public void setFutureBumpAndRunAvoidance(int value) { guiPlayerCatchingSkills.setBumpAndRunAvoidanceFuture(value); }

    public Integer getCurrentRouteRunning() { return guiPlayerCatchingSkills.getRouteRunningCurrent(); }

    public void setCurrentRouteRunning(int value) { guiPlayerCatchingSkills.setRouteRunningCurrent(value); }

    public Integer getFutureRouteRunning() { return guiPlayerCatchingSkills.getRouteRunningFuture(); }

    public void setFutureRouteRunning(int value) { guiPlayerCatchingSkills.setRouteRunningFuture(value); }

    // Coverage Skills
    public Integer getCurrentPunishReceiver() { return guiPlayerCoverageSkills.getPunishReceiverCurrent(); }

    public void setCurrentPunishReceiver(int value) {
        guiPlayerCoverageSkills.setPunishReceiverCurrent(value);
    }

    public Integer getFuturePunishReceiver() {
        return guiPlayerCoverageSkills.getPunishReceiverFuture();
    }

    public void setFuturePunishReceiver(int value) { guiPlayerCoverageSkills.setPunishReceiverFuture(value); }

    public Integer getCurrentZoneCoverage() { return guiPlayerCoverageSkills.getZoneCoverageCurrent(); }

    public void setCurrentZoneCoverage(int value) {
        guiPlayerCoverageSkills.setZoneCoverageCurrent(value);
    }

    public Integer getFutureZoneCoverage() {
        return guiPlayerCoverageSkills.getZoneCoverageFuture();
    }

    public void setFutureZoneCoverage(int value) { guiPlayerCoverageSkills.setZoneCoverageFuture(value); }

    public Integer getCurrentManToManCoverage() { return guiPlayerCoverageSkills.getManToManCoverageCurrent(); }

    public void setCurrentManToManCoverage(int value) {
        guiPlayerCoverageSkills.setManToManCoverageCurrent(value);
    }

    public Integer getFutureManToManCoverage() {
        return guiPlayerCoverageSkills.getManToManCoverageFuture();
    }

    public void setFutureManToManCoverage(int value) { guiPlayerCoverageSkills.setManToManCoverageFuture(value); }

    public Integer getCurrentBumpAndRunCoverage() { return guiPlayerCoverageSkills.getBumpAndRunCoverageCurrent(); }

    public void setCurrentBumpAndRunCoverage(int value) {
        guiPlayerCoverageSkills.setBumpAndRunCoverageCurrent(value);
    }

    public Integer getFutureBumpAndRunCoverage() {
        return guiPlayerCoverageSkills.getBumpAndRunCoverageFuture();
    }

    public void setFutureBumpAndRunCoverage(int value) { guiPlayerCoverageSkills.setBumpAndRunCoverageFuture(value); }

    // General Defensive skills
    public Integer getCurrentStripBall() { return guiPlayerDefensiveSkills.getStripBallCurrent(); }

    public void setCurrentStripBall(int value) {
        guiPlayerDefensiveSkills.setStripBallCurrent(value);
    }

    public Integer getFutureStripBall() { return guiPlayerDefensiveSkills.getStripBallFuture(); }

    public void setFutureStripBall(int value) {
        guiPlayerDefensiveSkills.setStripBallFuture(value);
    }

    public Integer getCurrentPassRush() { return guiPlayerDefensiveSkills.getPassRushCurrent(); }

    public void setCurrentPassRush(int value) {
        guiPlayerDefensiveSkills.setPassRushCurrent(value);
    }

    public Integer getFuturePassRush() { return guiPlayerDefensiveSkills.getPassRushFuture(); }

    public void setFuturePassRush(int value) {
        guiPlayerDefensiveSkills.setPassRushFuture(value);
    }

    public Integer getCurrentRunDefence() { return guiPlayerDefensiveSkills.getRunDefenceCurrent(); }

    public void setCurrentRunDefence(int value) {
        guiPlayerDefensiveSkills.setRunDefenceCurrent(value);
    }

    public Integer getFutureRunDefence() { return guiPlayerDefensiveSkills.getRunDefenceFuture(); }

    public void setFutureRunDefence(int value) { guiPlayerDefensiveSkills.setRunDefenceFuture(value); }

    public Integer getCurrentTackleAbility  () { return guiPlayerDefensiveSkills.getTackleAbilityCurrent(); }

    public void setCurrentTackleAbility(int value) {
        guiPlayerDefensiveSkills.setTackleAbilityCurrent(value);
    }

    public Integer getFutureTackleAbility() { return guiPlayerDefensiveSkills.getTackleAbilityFuture(); }

    public void setFutureTackleAbility(int value) { guiPlayerDefensiveSkills.setTackleAbilityFuture(value); }

    // Holder Skills
    public Integer getCurrentKickHolding() { return guiPlayerHolderSkills.getKickHoldingCurrent(); }

    public void setCurrentKickHolding(int value) { guiPlayerHolderSkills.setKickHoldingCurrent(value); }

    public Integer getFutureKickHolding() { return guiPlayerHolderSkills.getKickHoldingFuture(); }

    public void setFutureKickHolding(int value) { guiPlayerHolderSkills.setKickHoldingFuture(value); }

    // Kicking Skills
    public Integer getCurrentKickStrength() { return guiPlayerKickingSkills.getKickStrengthCurrent(); }

    public void setCurrentKickStrength(int value) {
        guiPlayerKickingSkills.setKickStrengthCurrent(value);
    }

    public Integer getFutureKickStrength() { return guiPlayerKickingSkills.getKickStrengthFuture(); }

    public void setFutureKickStrength(int value) {
        guiPlayerKickingSkills.setKickStrengthFuture(value);
    }

    public Integer getCurrentKickAccuracy() { return guiPlayerKickingSkills.getKickAccuracyCurrent(); }

    public void setCurrentKickAccuracy(int value) {
        guiPlayerKickingSkills.setKickAccuracyCurrent(value);
    }

    public Integer getFutureKickAccuracy() { return guiPlayerKickingSkills.getKickAccuracyFuture(); }

    public void setFutureKickAccuracy(int value) {
        guiPlayerKickingSkills.setKickAccuracyFuture(value);
    }

    // Passing Skills
    public Integer getCurrentPassAccuracy() { return guiPlayerPassingSkills.getPassAccuracyCurrent(); }

    public void setCurrentPassAccuracy(int value) {
        guiPlayerPassingSkills.setPassAccuracyCurrent(value);
    }

    public Integer getFuturePassAccuracy() { return guiPlayerPassingSkills.getPassAccuracyFuture(); }

    public void setFuturePassAccuracy(int value) {
        guiPlayerPassingSkills.setPassAccuracyFuture(value);
    }

    public Integer getCurrentHardCount() { return guiPlayerPassingSkills.getHardCountCurrent(); }

    public void setCurrentHardCount(int value) {
        guiPlayerPassingSkills.setHardCountCurrent(value);
    }

    public Integer getFutureHardCount() { return guiPlayerPassingSkills.getHardCountFuture(); }

    public void setFutureHardCount(int value) {
        guiPlayerPassingSkills.setHardCountFuture(value);
    }

    public Integer getCurrentArmStrength() { return guiPlayerPassingSkills.getArmStrengthCurrent(); }

    public void setCurrentArmStrength(int value) {
        guiPlayerPassingSkills.setArmStrengthCurrent(value);
    }

    public Integer getFutureArmStrength() { return guiPlayerPassingSkills.getArmStrengthFuture(); }

    public void setFutureArmStrength(int value) { guiPlayerPassingSkills.setArmStrengthFuture(value); }

    public Integer getCurrentPassRelease() { return guiPlayerPassingSkills.getPassReleaseCurrent(); }

    public void setCurrentPassRelease(int value) {
        guiPlayerPassingSkills.setPassReleaseCurrent(value);
    }

    public Integer getFuturePassRelease() { return guiPlayerPassingSkills.getPassReleaseFuture(); }

    public void setFuturePassRelease(int value) {
        guiPlayerPassingSkills.setPassReleaseFuture(value);
    }

    public Integer getCurrentLookOffDefence() { return guiPlayerPassingSkills.getLookOffDefenceCurrent(); }

    public void setCurrentLookOffDefence(int value) { guiPlayerPassingSkills.setLookOffDefenceCurrent(value); }

    public Integer getFutureLookOffDefence() { return guiPlayerPassingSkills.getLookOffDefenceFuture(); }

    public void setFutureLookOffDefence(int value) { guiPlayerPassingSkills.setLookOffDefenceFuture(value); }

    public Integer getCurrentScramblingSkill() { return guiPlayerPassingSkills.getScramblingSkillCurrent(); }

    public void setCurrentScramblingSkill(int value) {
        guiPlayerPassingSkills.setScramblingSkillCurrent(value);
    }

    public Integer getFutureScramblingSkill() { return guiPlayerPassingSkills.getScramblingSkillFuture(); }

    public void setFutureScramblingSkill(int value) { guiPlayerPassingSkills.setScramblingSkillFuture(value); }

    public Integer getCurrentFieldOfVision() { return guiPlayerPassingSkills.getFieldOfVisionCurrent(); }

    public void setCurrentFieldOfVision(int value) {
        guiPlayerPassingSkills.setFieldOfVisionCurrent(value);
    }

    public Integer getFutureFieldOfVision() { return guiPlayerPassingSkills.getFieldOfVisionFuture(); }

    public void setFutureFieldOfVision(int value) { guiPlayerPassingSkills.setFieldOfVisionFuture(value); }

    // Punting Skills
    public Integer getCurrentPuntStrength() { return guiPlayerPuntingSkills.getPuntStrengthCurrent(); }

    public void setCurrentPuntStrength(int value) { guiPlayerPuntingSkills.setPuntStrengthCurrent(value); }

    public Integer getFuturePuntStrength() { return guiPlayerPuntingSkills.getPuntStrengthFuture(); }

    public void setFuturePuntStrength(int value) { guiPlayerPuntingSkills.setPuntStrengthFuture(value); }

    public Integer getCurrentPuntAccuracy() { return guiPlayerPuntingSkills.getPuntAccuracyCurrent(); }

    public void setCurrentPuntAccuracy(int value) {
        guiPlayerPuntingSkills.setPuntAccuracyCurrent(value);
    }

    public Integer getFuturePuntAccuracy() { return guiPlayerPuntingSkills.getPuntAccuracyFuture(); }

    public void setFuturePuntAccuracy(int value) {
        guiPlayerPuntingSkills.setPuntAccuracyFuture(value);
    }

    public Integer getCurrentPuntTiming() { return guiPlayerPuntingSkills.getPuntTimingCurrent(); }

    public void setCurrentPuntTiming(int value) {
        guiPlayerPuntingSkills.setPuntTimingCurrent(value);
    }

    public Integer getFuturePuntTiming() { return guiPlayerPuntingSkills.getPuntTimingFuture(); }

    public void setFuturePuntTiming(int value) {
        guiPlayerPuntingSkills.setPuntTimingFuture(value);
    }

    // Returner Skills
    public Integer getCurrentKickCatching() { return guiPlayerReturnerSkills.getKickCatchingCurrent(); }

    public void setCurrentKickCatching(int value) { guiPlayerReturnerSkills.setKickCatchingCurrent(value); }

    public Integer getFutureKickCatching() { return guiPlayerReturnerSkills.getKickCatchingFuture(); }

    public void setFutureKickCatching(int value) { guiPlayerReturnerSkills.setKickCatchingFuture(value); }

    // Rushing Skills
    public Integer getCurrentBreakTackle() { return guiPlayerRushingSkills.getBreakTackleCurrent(); }

    public void setCurrentBreakTackle(int value) { guiPlayerRushingSkills.setBreakTackleCurrent(value); }

    public Integer getFutureBreakTackle() { return guiPlayerRushingSkills.getBreakTackleFuture(); }

    public void setFutureBreakTackle(int value) { guiPlayerRushingSkills.setBreakTackleFuture(value); }

    public Integer getCurrentBallCarrying() { return guiPlayerRushingSkills.getBallCarryingCurrent(); }

    public void setCurrentBallCarrying(int value) { guiPlayerRushingSkills.setBallCarryingCurrent(value); }

    public Integer getFutureBallCarrying() { return guiPlayerRushingSkills.getBallCarryingFuture(); }

    public void setFutureBallCarrying(int value) { guiPlayerRushingSkills.setBallCarryingFuture(value); }

    public Integer getCurrentAvoidFumble() { return guiPlayerRushingSkills.getAvoidFumbleCurrent(); }

    public void setCurrentAvoidFumble(int value) { guiPlayerRushingSkills.setAvoidFumbleCurrent(value); }

    public Integer getFutureAvoidFumble() { return guiPlayerRushingSkills.getAvoidFumbleFuture(); }

    public void setFutureAvoidFumble(int value) { guiPlayerRushingSkills.setAvoidFumbleFuture(value); }

    // Snapping Skills
    public Integer getCurrentShortSnapping() { return guiPlayerSnappingSkills.getShortSnappingCurrent(); }

    public void setCurrentShortSnapping(int value) { guiPlayerSnappingSkills.setShortSnappingCurrent(value); }

    public Integer getFutureShortSnapping() { return guiPlayerSnappingSkills.getShortSnappingFuture(); }

    public void setFutureShortSnapping(int value) { guiPlayerSnappingSkills.setShortSnappingFuture(value); }

    public Integer getCurrentLongSnapping() { return guiPlayerSnappingSkills.getLongSnappingCurrent(); }

    public void setCurrentLongSnapping(int value) { guiPlayerSnappingSkills.setLongSnappingCurrent(value); }

    public Integer getFutureLongSnapping() { return guiPlayerSnappingSkills.getLongSnappingFuture(); }

    public void setFutureLongSnapping(int value) { guiPlayerSnappingSkills.setLongSnappingFuture(value); }
}
