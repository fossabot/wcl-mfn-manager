package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;

class GuiPlayerCatchingFields {
    private final SimpleIntegerProperty passCatchingCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty passCatchingFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty passRecCourageCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty passRecCourageFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty bumpAndRunAvoidanceCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty bumpAndRunAvoidanceFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty routeRunningCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty routeRunningFuture = new SimpleIntegerProperty(0);

    public Integer getPassCatchingCurrent() { return passCatchingCurrent.get(); }

    public void setPassCatchingCurrent(int value) {
        passCatchingCurrent.set(value);
    }

    public Integer getPassCatchingFuture() { return passCatchingFuture.get(); }

    public void setPassCatchingFuture(int value) {
        passCatchingFuture.set(value);
    }

    public Integer getPassRecCourageCurrent() { return passRecCourageCurrent.get(); }

    public void setPassRecCourageCurrent(int value) { passRecCourageCurrent.set(value); }

    public Integer getPassRecCourageFuture() { return passRecCourageFuture.get(); }

    public void setPassRecCourageFuture(int value) {
        passRecCourageFuture.set(value);
    }

    public Integer getBumpAndRunAvoidanceCurrent() { return bumpAndRunAvoidanceCurrent.get(); }

    public void setBumpAndRunAvoidanceCurrent(int value) { bumpAndRunAvoidanceCurrent.set(value); }

    public Integer getBumpAndRunAvoidanceFuture() { return bumpAndRunAvoidanceFuture.get(); }

    public void setBumpAndRunAvoidanceFuture(int value) {
        bumpAndRunAvoidanceFuture.set(value);
    }

    public Integer getRouteRunningCurrent() { return routeRunningCurrent.get(); }

    public void setRouteRunningCurrent(int value) { routeRunningCurrent.set(value); }

    public Integer getRouteRunningFuture() { return routeRunningFuture.get(); }

    public void setRouteRunningFuture(int value) {
        routeRunningFuture.set(value);
    }
}
