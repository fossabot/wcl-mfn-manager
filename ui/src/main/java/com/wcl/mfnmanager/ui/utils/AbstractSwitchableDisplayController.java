/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcl.mfnmanager.ui.utils;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import com.wcl.mfnmanager.ui.controller.main.StatusBarController;

/**
 *
 * @author martinwarnett
 */
public abstract class AbstractSwitchableDisplayController implements Initializable {

    /** Holder of a switchable display. */
    @FXML
    private StackPane display;

    @FXML
    private StatusBarController statusBarController;


    /**
     * Replaces the vista displayed in the vista holder with a new vista.
     *
     * @param node the vista node to be swapped in.
     */
    public void setDisplay(final Node node) {
        display.getChildren().clear();
        display.getChildren().setAll(node);
    }

     public void setStatus(final String text) {
        statusBarController.setStatus(text);
    }

}
