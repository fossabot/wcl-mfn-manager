package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;

class GuiPlayerKickingFields {
    private final SimpleIntegerProperty kickStrengthCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty kickStrengthFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty kickAccuracyCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty kickAccuracyFuture = new SimpleIntegerProperty(0);

    public Integer getKickStrengthCurrent() { return kickStrengthCurrent.get(); }

    public void setKickStrengthCurrent(int value) { kickStrengthCurrent.set(value); }

    public Integer getKickStrengthFuture() { return kickStrengthFuture.get(); }

    public void setKickStrengthFuture(Integer value) { kickStrengthFuture.set(value); }

    public Integer getKickAccuracyCurrent() { return kickAccuracyCurrent.get(); }

    public void setKickAccuracyCurrent(int value) { kickAccuracyCurrent.set(value); }

    public Integer getKickAccuracyFuture() { return kickAccuracyFuture.get(); }

    public void setKickAccuracyFuture(Integer value) { kickAccuracyFuture.set(value); }}
