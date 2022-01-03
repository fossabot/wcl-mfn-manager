package com.wcl.mfnmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class MfnManagerJavaFXApplication extends Application {

    public static void main(String[] args) {
        Application.launch();
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
