package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;

class GuiPlayerPassingFields {
    private final SimpleIntegerProperty passAccuracyCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty passAccuracyFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty hardCountCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty hardCountFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty armStrengthCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty armStrengthFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty passReleaseCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty passReleaseFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty lookOffDefenceCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty lookOffDefenceFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty scramblingSkillCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty scramblingSkillFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty fieldOfVisionCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty fieldOfVisionFuture = new SimpleIntegerProperty(0);

    public Integer getPassAccuracyCurrent() {
        return passAccuracyCurrent.get();
    }

    public void setPassAccuracyCurrent(int value) {
        passAccuracyCurrent.set(value);
    }

    public Integer getPassAccuracyFuture() {
        return passAccuracyFuture.get();
    }

    public void setPassAccuracyFuture(Integer value) {
        passAccuracyFuture.set(value);
    }

    public Integer getHardCountCurrent() {
        return hardCountCurrent.get();
    }

    public void setHardCountCurrent(int value) {
        hardCountCurrent.set(value);
    }

    public Integer getHardCountFuture() {
        return hardCountFuture.get();
    }

    public void setHardCountFuture(Integer value) {
        hardCountFuture.set(value);
    }

    public Integer getArmStrengthCurrent() {
        return armStrengthCurrent.get();
    }

    public void setArmStrengthCurrent(int value) {
        armStrengthCurrent.set(value);
    }

    public Integer getArmStrengthFuture() {
        return armStrengthFuture.get();
    }

    public void setArmStrengthFuture(Integer value) { armStrengthFuture.set(value); }

    public Integer getPassReleaseCurrent() {
        return passReleaseCurrent.get();
    }

    public void setPassReleaseCurrent(int value) {
        passReleaseCurrent.set(value);
    }

    public Integer getPassReleaseFuture() {
        return passReleaseFuture.get();
    }

    public void setPassReleaseFuture(Integer value) { passReleaseFuture.set(value); }

    public Integer getLookOffDefenceCurrent() {
        return lookOffDefenceCurrent.get();
    }

    public void setLookOffDefenceCurrent(int value) {
        lookOffDefenceCurrent.set(value);
    }

    public Integer getLookOffDefenceFuture() {
        return lookOffDefenceFuture.get();
    }

    public void setLookOffDefenceFuture(Integer value) { lookOffDefenceFuture.set(value); }

    public Integer getScramblingSkillCurrent() {
        return scramblingSkillCurrent.get();
    }

    public void setScramblingSkillCurrent(int value) {
        scramblingSkillCurrent.set(value);
    }

    public Integer getScramblingSkillFuture() {
        return scramblingSkillFuture.get();
    }

    public void setScramblingSkillFuture(Integer value) { scramblingSkillFuture.set(value); }

    public Integer getFieldOfVisionCurrent() {
        return fieldOfVisionCurrent.get();
    }

    public void setFieldOfVisionCurrent(int value) {
        fieldOfVisionCurrent.set(value);
    }

    public Integer getFieldOfVisionFuture() {
        return fieldOfVisionFuture.get();
    }

    public void setFieldOfVisionFuture(Integer value) { fieldOfVisionFuture.set(value); }
}
