package com.wcl.mfnmanager.ui.controller.draft;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import com.wcl.mfnmanager.entities.draft.DraftInfo;
import com.wcl.mfnmanager.entities.login.LoginCredentials;
import com.wcl.mfnmanager.exceptions.CommunicationsException;
import com.wcl.mfnmanager.ui.utils.AbstractSwitchableDisplayController;
import com.wcl.mfnmanager.services.DraftClassDownloaderService;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class DraftDownloadController extends AbstractSwitchableDisplayController {
    private static final String AVAILABLE_DRAFT_TEXT = "Draft available to download for League %s, Season %d - %s";

    @FXML
    private Button checkForDraftClasses;

    @FXML
    private TextArea downloadStatus;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // No initialization code required.
    }

    public void handleCheckForDraftClasses(ActionEvent event) {
        downloadStatus.clear();
        checkForDraftClasses.setDisable(true);
        final var downloadService = new DraftClassDownloaderService();

        // Display Login popup to get Username and Password ( avoids hard coding )
        // Pass Username and password into Service.
        final var loginCredentials = getLoginCredentials();
        loginCredentials.ifPresent(credentials -> {
            final var username = loginCredentials.get().username();
            final var password =  loginCredentials.get().password();
            try {
                final var leagues = downloadService.checkForAvailableDraftClasses(username, password);
                if (leagues.isEmpty()) {
                    downloadStatus.appendText("No entered leagues have available draft classes to load");
                } else {
                    downloadStatus.appendText("Leagues with Draft Classes available");
                    downloadStatus.appendText(System.lineSeparator());
                    leagues.forEach(a -> {
                        downloadStatus.appendText(formatAvailableDraftText(a));
                        downloadStatus.appendText(System.lineSeparator());
                    });
                    downloadService.downloadAvailableDraftClasses(leagues, username, password);
                }
                checkForDraftClasses.setDisable(false);
            } catch (IOException | CommunicationsException e) {
                e.printStackTrace();
            }
        });
    }

    private String formatAvailableDraftText(DraftInfo a) {
        return String.format(AVAILABLE_DRAFT_TEXT, a.league().name(), a.year(),
                a.league().uri());
    }

    public Optional<LoginCredentials> getLoginCredentials() {
        final var dialog = new Dialog<Pair<String, String>>();

        dialog.setTitle("Provide Login credentials");
        dialog.setHeaderText("Login to MFN");

        final var loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);

        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        final var grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        final var usernameField = new TextField();
        final var passwordField = new PasswordField();

        grid.add(new Label("Username:"), 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(passwordField, 1, 1);

        dialog.getDialogPane().setContent(grid);

        Platform.runLater(usernameField::requestFocus);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<String, String>(usernameField.getText(), passwordField.getText());
            }
            return null;
        });


        final var result = dialog.showAndWait();


        AtomicReference<LoginCredentials> loginCredentials = new AtomicReference<>();
        result.ifPresent(credentials ->
                {
                    loginCredentials.set(new LoginCredentials(credentials.getKey(),
                            credentials.getValue()));
                }
        );

        return Optional.ofNullable(loginCredentials.get());
    }
}
