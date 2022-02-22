package com.wcl.mfnmanager.ui.utils;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class DisplaySwitcher<Screen, U extends AbstractSwitchableDisplayController> {
   
    public Map<Screen, String> screenMappings = new ConcurrentHashMap<>();
    
    /** The main application layout controller. */
   private U mainController;

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param mainController the main application layout controller.
     */
    public void setMainController(final U mainController) {
        this.mainController = mainController;
    }
    
    public void addScreenMapping(final Screen key, final String fxmlFileName) {
        screenMappings.put(key, fxmlFileName);
    }

    /**
     * Loads the vista specified by the fxml file into the
     * vistaHolder pane of the main application layout.
     *
     * Previously loaded vista for the same fxml file are not cached.
     * The fxml is loaded anew and a new vista node hierarchy generated
     * every time this method is invoked.
     *
     * A more sophisticated load function could potentially add some
     * enhancements or optimizations, for example:
     *   cache FXMLLoaders
     *   cache loaded vista nodes, so they can be recalled or reused
     *   allow a user to specify vista node reuse or new creation
     *   allow back and forward history like a browser
     *
     * @param key the fxml file to be loaded.
     */
    public void loadDisplay(final Screen key) {
        try {
            mainController.setDisplay(FXMLLoader.load(
                    getClass().getResource(
                        screenMappings.get(key)
                    )
                )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}