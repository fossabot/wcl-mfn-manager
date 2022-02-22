package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;

class GuiPlayerCoverageFields {
    private final SimpleIntegerProperty punishReceiverCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty punishReceiverFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty zoneCoverageCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty zoneCoverageFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty manToManCoverageCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty manToManCoverageFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty bumpAndRunCoverageCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty bumpAndRunCoverageFuture = new SimpleIntegerProperty(0);

    public Integer getPunishReceiverCurrent() {
        return punishReceiverCurrent.get();
    }

    public void setPunishReceiverCurrent(int value) {
        punishReceiverCurrent.set(value);
    }

    public Integer getPunishReceiverFuture() {
        return punishReceiverFuture.get();
    }

    public void setPunishReceiverFuture(int value) { punishReceiverFuture.set(value); }

    public Integer getZoneCoverageCurrent() { return zoneCoverageCurrent.get(); }

    public void setZoneCoverageCurrent(int value) {
        zoneCoverageCurrent.set(value);
    }

    public Integer getZoneCoverageFuture() {
        return zoneCoverageFuture.get();
    }

    public void setZoneCoverageFuture(int value) { zoneCoverageFuture.set(value); }

    public Integer getManToManCoverageCurrent() { return manToManCoverageCurrent.get(); }

    public void setManToManCoverageCurrent(int value) {
        manToManCoverageCurrent.set(value);
    }

    public Integer getManToManCoverageFuture() {
        return manToManCoverageFuture.get();
    }

    public void setManToManCoverageFuture(int value) { manToManCoverageFuture.set(value); }

    public Integer getBumpAndRunCoverageCurrent() { return bumpAndRunCoverageCurrent.get(); }

    public void setBumpAndRunCoverageCurrent(int value) {
        bumpAndRunCoverageCurrent.set(value);
    }

    public Integer getBumpAndRunCoverageFuture() {
        return bumpAndRunCoverageFuture.get();
    }

    public void setBumpAndRunCoverageFuture(int value) { bumpAndRunCoverageFuture.set(value); }
}
