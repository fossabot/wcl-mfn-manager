/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcl.mfnmanager.ui.utils;

import javafx.fxml.Initializable;
import javafx.scene.Node;

public class LoadedElement<T extends Node, U extends Initializable> {
    private T element;
    private U controller;

    public LoadedElement(T element, U controller) {
        this.element = element;
        this.controller = controller;
    }

    /**
     * @return the element
     */
    public T getElement() {
        return element;
    }

    /**
     * @return the controller
     */
    public U getController() {
        return controller;
    }
}
