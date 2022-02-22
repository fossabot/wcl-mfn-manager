/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcl.mfnmanager.ui.controller.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.controlsfx.control.StatusBar;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Martin Warnett, Marlyn Consulting Ltd
 */
public final class StatusBarController implements Initializable {

    @FXML
    private StatusBar statusBar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // No initialization code required.
    }

    public void setStatus(final String text) {
        if (text != null
                && !text.equals(statusBar.getText())) {
            statusBar.setText(text);
        }
    }
}
