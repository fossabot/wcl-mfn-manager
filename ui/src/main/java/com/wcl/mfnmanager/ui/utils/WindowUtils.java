/*
 * This project is licensed under the Apache 2.0  license.
 *
 *  For details see the LICENSE file which can be found at the base of this project archive.
 */

package com.wcl.mfnmanager.ui.utils;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Window;

/**
 * Provides common utility functions for JavaFX windows.
 */
public final class WindowUtils {
    private WindowUtils(){}

    /**
     * Returns the parent window for a provided {@link ActionEvent} instance.
     *
     * Many cases exist where GUI functionality requires knowledge of the parent window, for example providing the
     * parent window for Dialog boxes to be attached to.  Where this requirement is triggered from a GUI action, the
     * parent Window can be retrieved from the {@link Node} that is the target of the {@link ActionEvent}.
     *
     * Example :-
     * <code>
     *     @FXML
     *     public button triggerEvent;
     *     ...
     *     private DirectoryChooser directoryChooser;
     *     private File selectedDirectory;
     *
     *     @FXML
     *     public void handleTriggeredEvent(final ActionEvent event) {
     *         var directoryChooser = new DirectoryChooser();
     *         selectedDirectory = directoryChooser.showDialog(<b>WindowUtils.getParentSceneForEvent(event)</.); /
    *     }
     * </code>
     *
     *
     *
     * @param event the provided ActionEvent instance.
     * @return the parent {@link Window} associated with the target of the {@link ActionEvent} instance.
     */
    public static Window getParentSceneForEvent(final ActionEvent event) {
        return ((Node)event.getTarget()).getScene().getWindow();
    }
}
