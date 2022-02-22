package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;

class GuiPlayerRushingFields {
    private final SimpleIntegerProperty breakTackleCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty breakTackleFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty ballCarryingCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty ballCarryingFuture = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty avoidFumbleCurrent = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty avoidFumbleFuture = new SimpleIntegerProperty(0);

    public Integer getBreakTackleCurrent() { return breakTackleCurrent.get();  }

    public void setBreakTackleCurrent(int value) { breakTackleCurrent.set(value); }

    public Integer getBreakTackleFuture() { return breakTackleFuture.get(); }

    public void setBreakTackleFuture(Integer value) { breakTackleFuture.set(value); }

    public Integer getBallCarryingCurrent() { return ballCarryingCurrent.get();  }

    public void setBallCarryingCurrent(int value) { ballCarryingCurrent.set(value); }

    public Integer getBallCarryingFuture() { return ballCarryingFuture.get(); }

    public void setBallCarryingFuture(Integer value) { ballCarryingFuture.set(value); }

    public Integer getAvoidFumbleCurrent() { return avoidFumbleCurrent.get();  }

    public void setAvoidFumbleCurrent(int value) { avoidFumbleCurrent.set(value); }

    public Integer getAvoidFumbleFuture() { return avoidFumbleFuture.get(); }

    public void setAvoidFumbleFuture(Integer value) { avoidFumbleFuture.set(value); }
}
