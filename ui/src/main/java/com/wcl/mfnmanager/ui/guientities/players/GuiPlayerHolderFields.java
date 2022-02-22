package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;

class GuiPlayerHolderFields {
    private final SimpleIntegerProperty kickHoldingCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty kickHoldingFuture = new SimpleIntegerProperty(0);

    public Integer getKickHoldingCurrent() {
        return kickHoldingCurrent.get();
    }

    public void setKickHoldingCurrent(int value) {
        kickHoldingCurrent.set(value);
    }

    public Integer getKickHoldingFuture() {
        return kickHoldingFuture.get();
    }

    public void setKickHoldingFuture(Integer value) {
        kickHoldingFuture.set(value);
    }
}
