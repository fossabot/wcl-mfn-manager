package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;

class GuiPlayerCoreSkillsFields {
    final SimpleIntegerProperty maxSpeed = new SimpleIntegerProperty(0);
    final SimpleIntegerProperty acceleration = new SimpleIntegerProperty(0);
    final SimpleIntegerProperty strength = new SimpleIntegerProperty(0);
    final SimpleIntegerProperty intelligence = new SimpleIntegerProperty(0);
    final SimpleIntegerProperty discipline = new SimpleIntegerProperty(0);

    public Integer getMaxSpeed() {
        return maxSpeed.get();
    }

    public void setMaxSpeed(int value) {
        maxSpeed.set(value);
    }

    public Integer getAcceleration() {
        return acceleration.get();
    }

    public void setAcceleration(int value) {
        acceleration.set(value);
    }

    public Integer getStrength() {
        return strength.get();
    }

    public void setStrength(int value) {
        strength.set(value);
    }

    public Integer getIntelligence() {
        return intelligence.get();
    }

    public void setIntelligence(int value) {
        intelligence.set(value);
    }

    public Integer getDiscipline() {
        return discipline.get();
    }

    public void setDiscipline(int value) {
        discipline.set(value);
    }
}
