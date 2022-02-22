package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;

class GuiPlayerBlockingFields {
    private final SimpleIntegerProperty runBlockingCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty runBlockingFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty passBlockingCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty passBlockingFuture = new SimpleIntegerProperty(0);

    public Integer getRunBlockingCurrent() {
        return runBlockingCurrent.get();
    }

    public void setRunBlockingCurrent(int value) {
        runBlockingCurrent.set(value);
    }

    public Integer getRunBlockingFuture() {
        return runBlockingFuture.get();
    }

    public void setRunBlockingFuture(Integer value) {
        runBlockingFuture.set(value);
    }

    public Integer getPassBlockingCurrent() {
        return passBlockingCurrent.get();
    }

    public void setPassBlockingCurrent(int value) {
        passBlockingCurrent.set(value);
    }

    public Integer getPassBlockingFuture() {
        return passBlockingFuture.get();
    }

    public void setPassBlockingFuture(int value) {
        passBlockingFuture.set(value);
    }
}
