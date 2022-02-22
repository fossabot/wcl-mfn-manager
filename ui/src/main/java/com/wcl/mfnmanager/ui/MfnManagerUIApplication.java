package com.wcl.mfnmanager.ui;

import com.wcl.mfnmanager.ui.controller.main.MainController;
import com.wcl.mfnmanager.ui.utils.AbstractSwitchableDisplayController;
import com.wcl.mfnmanager.ui.utils.CustomFXMLLoader;
import com.wcl.mfnmanager.ui.utils.DisplaySwitcher;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;

//@TODO Push a lot of this class to UI module
public class MfnManagerUIApplication extends Application {

    /** Represents the main application screen FXML file location */
    private static final String MAIN_FXML_FILE = "/fxml/main/main.fxml";
    /** Represents the blank display panel FXML file location */
    private static final String BLANK_FXML_FILE = "/fxml/main/blank.fxml";
    /** Represents the Draft display panel FXML file location */
    private static final String DRAFT_FXML_FILE = "/fxml/draft/draft-class.fxml";
    /** Represents the Draft display panel FXML file location */
    private static final String DOWNLOAD_DRAFT_CLASSES_FXML_FILE = "/fxml/draft/draft-downloader.fxml";
    /** Represents the Contract Calculator panel FXML file location */
    private static final String CONTRACT_CALCULATOR_FXML_FILE = "/fxml/contract/contract-calculator.fxml";
    /** Represents the default application height */
    private static final Integer APP_HEIGHT = 1000;
    /** Represents the default application width */
    private static final Integer APP_WIDTH = 1600;
    /** Represents the application title */
    private static final String APP_TITLE = "MFN Manager - MyFootballNow Management and Analysis Software";
    /** Represents the application started message */
    private static final String APP_STARTED_MESSAGE = "Application Started";

    private DisplaySwitcher<Screen, AbstractSwitchableDisplayController> displaySwitcher;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() {
        SpringApplication.run(getClass()).getAutowireCapableBeanFactory().autowireBean(this);
    }

    /**
     * Instantiates the application and configures the main controller and DisplaySwitcher
     * objects.
     *
     * @param stage the Stage for the GUI.
     */
    @Override
    public void start(final Stage stage) {
        loadMainScreen(stage);
    }

    /*
     * Loads the main controller and main screen for the application.
     *
     * @param primaryStage the primary Stage used by the application
     */
    private void loadMainScreen(final Stage primaryStage) {
        displaySwitcher = createDisplaySwitcher();
        final var loader = new CustomFXMLLoader<>();
        final var element = loader.loadFXML(MAIN_FXML_FILE);
        final Scene scene = new Scene((Parent) element.getElement(), APP_WIDTH, APP_HEIGHT);
        primaryStage.setTitle(APP_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();

        final var mainController = (MainController)element.getController();
        mainController.setDisplaySwitcher(createDisplaySwitcher());
        mainController.setStatus(APP_STARTED_MESSAGE);
    }

    private DisplaySwitcher<Screen, AbstractSwitchableDisplayController> createDisplaySwitcher() {
        final var displaySwitcher = new DisplaySwitcher<Screen, AbstractSwitchableDisplayController>();

        displaySwitcher.addScreenMapping(Screen.BLANK, BLANK_FXML_FILE);
        displaySwitcher.addScreenMapping(Screen.CONTRACT_CALCULATOR, CONTRACT_CALCULATOR_FXML_FILE);
        displaySwitcher.addScreenMapping(Screen.VIEW_DRAFT_CLASS, DRAFT_FXML_FILE);
        displaySwitcher.addScreenMapping(Screen.DOWNLOAD_DRAFT_CLASSES, DOWNLOAD_DRAFT_CLASSES_FXML_FILE);
        return displaySwitcher;
    }
}


