package com.wcl.mfnmanager.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;

import java.util.Objects;

public class MfnManagerUIApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() {
        SpringApplication.run(getClass()).getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/main/main.fxml")));
        primaryStage.setTitle("MFN Manager");
        primaryStage.show();
    }
}
