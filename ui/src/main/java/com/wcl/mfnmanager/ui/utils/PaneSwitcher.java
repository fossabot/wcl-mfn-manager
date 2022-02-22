package com.wcl.mfnmanager.ui.utils;

import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;

public class PaneSwitcher<T, U extends Pane> {
    private final Map<T, U> mapping;
    private final Pane pane;

    public PaneSwitcher(final Pane pane) {
        mapping = new HashMap<>();
        this.pane = pane;
    }

    public void addMapping(T key, U value) {
        mapping.put(key, value);
    }

    public void removeMapping(T key) {
        mapping.remove(key);
    }

    public void activate(T key) {
        pane.getChildren().clear();
        pane.getChildren().add(mapping.get(key));
    }
}
