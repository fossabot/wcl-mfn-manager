package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;

class GuiPlayerSnappingFields {
    private final SimpleIntegerProperty shortSnappingCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty shortSnappingFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty longSnappingCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty longSnappingFuture = new SimpleIntegerProperty(0);

    public Integer getShortSnappingCurrent() { return shortSnappingCurrent.get();  }

    public void setShortSnappingCurrent(int value) { shortSnappingCurrent.set(value); }

    public Integer getShortSnappingFuture() { return shortSnappingFuture.get(); }

    public void setShortSnappingFuture(Integer value) { shortSnappingFuture.set(value); }

    public Integer getLongSnappingCurrent() { return longSnappingCurrent.get();  }

    public void setLongSnappingCurrent(int value) { longSnappingCurrent.set(value); }

    public Integer getLongSnappingFuture() { return longSnappingFuture.get(); }

    public void setLongSnappingFuture(Integer value) { longSnappingFuture.set(value); }}
