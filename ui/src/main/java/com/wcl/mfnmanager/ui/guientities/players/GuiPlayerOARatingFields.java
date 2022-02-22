package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;

class GuiPlayerOARatingFields {
    final SimpleIntegerProperty currentOA = new SimpleIntegerProperty(0);
    final SimpleIntegerProperty futureOA = new SimpleIntegerProperty(0);

    public Integer getCurrentOA() {
        return currentOA.get();
    }

    public void setCurrentOA(int value) {
        currentOA.set(value);
    }

    public Integer getFutureOA() {
        return futureOA.get();
    }

    public void setFutureOA(int value) {
        futureOA.set(value);
    }
}
