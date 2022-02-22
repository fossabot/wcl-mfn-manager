package com.wcl.mfnmanager.ui.guientities.players;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import com.wcl.mfnmanager.entities.player.Position;

class GuiPlayerCommonFields {
    final SimpleIntegerProperty id = new SimpleIntegerProperty(0);
    final SimpleStringProperty name = new SimpleStringProperty("");
    final SimpleIntegerProperty height = new SimpleIntegerProperty(0);
    final SimpleIntegerProperty weight = new SimpleIntegerProperty(0);
    final SimpleObjectProperty<Position> assignedPosition = new SimpleObjectProperty<Position>(null);
    final SimpleIntegerProperty volatility = new SimpleIntegerProperty(0);

    public Integer getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public Integer getHeight() {
        return height.get();
    }

    public void setHeight(int value) {
        height.set(value);
    }

    public Integer getWeight() {
        return weight.get();
    }

    public void setWeight(int value) {
        weight.set(value);
    }

    public Position getAssignedPosition() {
        return assignedPosition.get();
    }

    public void setAssignedPosition(Position value) {
        assignedPosition.set(value);
    }

    public Integer getVolatility() {
        return volatility.get();
    }

    public void setVolatility(int value) {
        volatility.set(value);
    }
}
