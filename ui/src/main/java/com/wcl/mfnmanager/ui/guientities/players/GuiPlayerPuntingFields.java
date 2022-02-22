package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;

class GuiPlayerPuntingFields {
    private final SimpleIntegerProperty puntStrengthCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty puntStrengthFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty puntAccuracyCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty puntAccuracyFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty puntTimingCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty puntTimingFuture = new SimpleIntegerProperty(0);

    public Integer getPuntStrengthCurrent() { return puntStrengthCurrent.get(); }

    public void setPuntStrengthCurrent(int value) { puntStrengthCurrent.set(value); }

    public Integer getPuntStrengthFuture() {  return puntStrengthFuture.get();  }

    public void setPuntStrengthFuture(Integer value) {  puntStrengthFuture.set(value); }

    public Integer getPuntAccuracyCurrent() { return puntAccuracyCurrent.get(); }

    public void setPuntAccuracyCurrent(int value) { puntAccuracyCurrent.set(value); }

    public Integer getPuntAccuracyFuture() {  return puntAccuracyFuture.get();  }

    public void setPuntAccuracyFuture(Integer value) {  puntAccuracyFuture.set(value); }

    public Integer getPuntTimingCurrent() { return puntTimingCurrent.get(); }

    public void setPuntTimingCurrent(int value) { puntTimingCurrent.set(value); }

    public Integer getPuntTimingFuture() {  return puntTimingFuture.get();  }

    public void setPuntTimingFuture(Integer value) {  puntTimingFuture.set(value); }
}
