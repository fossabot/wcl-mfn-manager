package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;

class GuiPlayerDefenceFields {
    private final SimpleIntegerProperty stripBallCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty stripBallFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty passRushCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty passRushFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty runDefenceCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty runDefenceFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty tackleAbilityCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty tackleAbilityFuture = new SimpleIntegerProperty(0);

    public Integer getStripBallCurrent() {
        return stripBallCurrent.get();
    }

    public void setStripBallCurrent(int value) {
        stripBallCurrent.set(value);
    }

    public Integer getStripBallFuture() {
        return stripBallFuture.get();
    }

    public void setStripBallFuture(int value) { stripBallFuture.set(value); }

    public Integer getPassRushCurrent() {
        return passRushCurrent.get();
    }

    public void setPassRushCurrent(int value) {
        passRushCurrent.set(value);
    }

    public Integer getPassRushFuture() {
        return passRushFuture.get();
    }

    public void setPassRushFuture(int value) { passRushFuture.set(value); }

    public Integer getRunDefenceCurrent() {
        return runDefenceCurrent.get();
    }

    public void setRunDefenceCurrent(int value) {
        runDefenceCurrent.set(value);
    }

    public Integer getRunDefenceFuture() {
        return runDefenceFuture.get();
    }

    public void setRunDefenceFuture(int value) { runDefenceFuture.set(value); }

    public Integer getTackleAbilityCurrent() {
        return tackleAbilityCurrent.get();
    }

    public void setTackleAbilityCurrent(int value) {
        tackleAbilityCurrent.set(value);
    }

    public Integer getTackleAbilityFuture() {
        return tackleAbilityFuture.get();
    }

    public void setTackleAbilityFuture(int value) { tackleAbilityFuture.set(value); }
}
