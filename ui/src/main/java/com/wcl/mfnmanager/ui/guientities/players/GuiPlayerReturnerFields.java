package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;

class GuiPlayerReturnerFields {
    private final SimpleIntegerProperty kickCatchingCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty kickCatchingFuture = new SimpleIntegerProperty(0);

    public Integer getKickCatchingCurrent() { return kickCatchingCurrent.get();  }

    public void setKickCatchingCurrent(int value) { kickCatchingCurrent.set(value); }

    public Integer getKickCatchingFuture() { return kickCatchingFuture.get(); }

    public void setKickCatchingFuture(Integer value) { kickCatchingFuture.set(value); }
}
