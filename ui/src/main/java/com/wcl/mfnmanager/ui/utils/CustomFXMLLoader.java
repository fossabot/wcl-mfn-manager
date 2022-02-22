package com.wcl.mfnmanager.ui.utils;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CustomFXMLLoader<T extends Node, U extends Initializable> {
    public LoadedElement<T,U> loadFXML(final String fxmlFileName) {
                 final URL url = getClass().getResource(fxmlFileName);
        final var fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(url);

        T element = null;
        try {
            element = fxmlLoader.load(url.openStream());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(-1);
            Logger.getLogger(CustomFXMLLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new LoadedElement<>(element, fxmlLoader.<U>getController());
    }
}
