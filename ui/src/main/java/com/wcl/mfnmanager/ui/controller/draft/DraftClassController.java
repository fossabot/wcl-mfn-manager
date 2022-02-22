/*
 * This project is licensed under the Apache 2.0  license.
 *
 *  For details see the LICENSE file which can be found at the base of this project archive.
 */
package com.wcl.mfnmanager.ui.controller.draft;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import com.wcl.mfnmanager.entities.player.Player;
import com.wcl.mfnmanager.entities.player.Position;
import com.wcl.mfnmanager.ui.guientities.converter.PlayerConverter;
import com.wcl.mfnmanager.ui.guientities.players.GuiPlayer;
import com.wcl.mfnmanager.ui.utils.AbstractSwitchableDisplayController;
import com.wcl.mfnmanager.ui.utils.WindowUtils;
import com.wcl.mfnmanager.services.DraftClassLoaderService;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Handles User interactions for the DraftClass screen.
 * <p>
 * An instance of this controller class is bound to the draft-class.fxml file.
 * <p>
 * The class processes the screen interactions with regards to the User selecting the draft directory.
 */
public final class DraftClassController extends AbstractSwitchableDisplayController {
    /**
     * Label indicating the draft class directory.
     */
    @FXML
    private Label draftClassInfo;

    /**
     * Button used to invoke the {@link DirectoryChooser} dialog.
     */
    @FXML
    private Button chooseDirectory;

    @FXML
    private ChoiceBox<String> draftClassChoiceBox;

    @FXML
    private TableView<GuiPlayer> playerTable;

    @FXML
    private TableColumn<GuiPlayer, Integer> id;
    @FXML
    private TableColumn<GuiPlayer, String> name;
    @FXML
    private TableColumn<GuiPlayer, Integer> height;
    @FXML
    private TableColumn<GuiPlayer, Integer> weight;
    @FXML
    private TableColumn<GuiPlayer, Position> assignedPosition;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentOA;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureOA;
    @FXML
    private TableColumn<GuiPlayer, Integer> volatility;
    @FXML
    private TableColumn<GuiPlayer, Integer> maxSpeed;
    @FXML
    private TableColumn<GuiPlayer, Integer> acceleration;
    @FXML
    private TableColumn<GuiPlayer, Integer> strength;
    @FXML
    private TableColumn<GuiPlayer, Integer> intelligence;
    @FXML
    private TableColumn<GuiPlayer, Integer> discipline;

    @FXML
    private TableColumn<GuiPlayer, Integer> currentPassAccuracy;
    @FXML
    private TableColumn<GuiPlayer, Integer> futurePassAccuracy;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentHardCount;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureHardCount;
    @FXML

    private TableColumn<GuiPlayer, Integer> currentArmStrength;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureArmStrength;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentPassRelease;
    @FXML
    private TableColumn<GuiPlayer, Integer> futurePassRelease;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentLookOffDefence;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureLookOffDefence;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentScramblingSkill;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureScramblingSkill;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentFieldOfVision;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureFieldOfVision;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentPassCatching;
    @FXML
    private TableColumn<GuiPlayer, Integer> futurePassCatching;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentBumpAndRunAvoidance;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureBumpAndRunAvoidance;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentRouteRunning;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureRouteRunning;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentPassReceptionCourage;
    @FXML
    private TableColumn<GuiPlayer, Integer> futurePassReceptionCourage;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentTackleAbility;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureTackleAbility;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentStripBall;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureStripBall;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentPassRush;
    @FXML
    private TableColumn<GuiPlayer, Integer> futurePassRush;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentRunDefence;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureRunDefence;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentBreakTackle;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureBreakTackle;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentBallCarrying;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureBallCarrying;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentAvoidFumble;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureAvoidFumble;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentRunBlocking;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureRunBlocking;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentPassBlocking;
    @FXML
    private TableColumn<GuiPlayer, Integer> futurePassBlocking;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentShortSnapping;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureShortSnapping;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentLongSnapping;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureLongSnapping;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentPuntStrength;
    @FXML
    private TableColumn<GuiPlayer, Integer> futurePuntStrength;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentPuntAccuracy;
    @FXML
    private TableColumn<GuiPlayer, Integer> futurePuntAccuracy;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentPuntTiming;
    @FXML
    private TableColumn<GuiPlayer, Integer> futurePuntTiming;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentKickStrength;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureKickStrength;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentKickAccuracy;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureKickAccuracy;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentKickHolding;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureKickHolding;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentKickCatching;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureKickCatching;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentPunishReceiver;
    @FXML
    private TableColumn<GuiPlayer, Integer> futurePunishReceiver;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentZoneCoverage;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureZoneCoverage;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentManToManCoverage;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureManToManCoverage;
    @FXML
    private TableColumn<GuiPlayer, Integer> currentBumpAndRunCoverage;
    @FXML
    private TableColumn<GuiPlayer, Integer> futureBumpAndRunCoverage;

    // Group Columns
    @FXML
    private TableColumn passingColumn;
    @FXML
    private TableColumn catchingColumn;
    @FXML
    private TableColumn defenceColumn;
    @FXML
    private TableColumn rushingColumn;
    @FXML
    private TableColumn blockingColumn;
    @FXML
    private TableColumn snappingColumn;
    @FXML
    private TableColumn puntingColumn;
    @FXML
    private TableColumn kickingColumn;
    @FXML
    private TableColumn holderColumn;
    @FXML
    private TableColumn returnerColumn;
    @FXML
    private TableColumn coverageColumn;

    /**
     * The imported and converted {@link Player} collection.
     */
    private List<Player> importedPlayers;

    private List<GuiPlayer> convertedPlayers;

    private ObservableList<GuiPlayer> observablePlayers;

    private ObservableList<String> draftClassOptions;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        importedPlayers = new ArrayList<>();
        convertedPlayers = new ArrayList<>();
        observablePlayers = FXCollections.observableArrayList(convertedPlayers);

        draftClassChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
                refreshData();
            }
        });

        setupPlayerCoreSkillsColumns();
        setupPlayerPassingSkillsColumns();
        setupPlayerCatchingSkillsColumns();
        setupPlayerGeneralDefenceSkillsColumns();
        setupPlayerRushingSkills();
        setupPlayerBlockingSkills();
        setupPlayerSnappingSkills();
        setupPlayerPuntingSkills();
        setupPlayerKickingSkills();
        setupPlayerKickHoldingSkills();
        setupPlayerCoverageSkills();
        setupPlayerReturnSkills();

        final var positions = new ArrayList<String>(31);
        positions.add("Assigned");
        positions.add("QB");
        positions.add("RB");
        positions.add("FB");
        positions.add("TE");
        positions.add("WR");
        positions.add("LT");
        positions.add("LG");
        positions.add("C");
        positions.add("RG");
        positions.add("RT");
        positions.add("P");
        positions.add("K");
        positions.add("LDE");
        positions.add("DT");
        positions.add("RDE");
        positions.add("SLB");
        positions.add("MLB");
        positions.add("WLB");
        positions.add("CB");
        positions.add("SS");
        positions.add("FS");
        positions.add("GUNNER");
        positions.add("KH");
        positions.add("LS");
        positions.add("KR");
        positions.add("PR");
        positions.add("STBLK");
        positions.add("STRUSH");

        draftClassOptions = FXCollections.observableArrayList(positions);

        draftClassChoiceBox.setItems(draftClassOptions);
        draftClassChoiceBox.setValue("Assigned");

        playerTable.setItems(observablePlayers);
    }

    private void setupPlayerCoverageSkills() {
        currentPunishReceiver.setCellValueFactory(new PropertyValueFactory<>("currentPunishReceiver"));
        futurePunishReceiver.setCellValueFactory(new PropertyValueFactory<>("futurePunishReceiver"));
        currentZoneCoverage.setCellValueFactory(new PropertyValueFactory<>("currentZoneCoverage"));
        futureZoneCoverage.setCellValueFactory(new PropertyValueFactory<>("futureZoneCoverage"));
        currentManToManCoverage.setCellValueFactory(new PropertyValueFactory<>("currentManToManCoverage"));
        futureManToManCoverage.setCellValueFactory(new PropertyValueFactory<>("futureManToManCoverage"));
        currentBumpAndRunCoverage.setCellValueFactory(new PropertyValueFactory<>("currentBumpAndRunCoverage"));
        futureBumpAndRunCoverage.setCellValueFactory(new PropertyValueFactory<>("futureBumpAndRunCoverage"));
    }

    private void setupPlayerKickHoldingSkills() {
        currentKickHolding.setCellValueFactory(new PropertyValueFactory<>("currentKickHolding"));
        futureKickHolding.setCellValueFactory(new PropertyValueFactory<>("futureKickHolding"));
    }

    private void setupPlayerReturnSkills() {
        currentKickCatching.setCellValueFactory(new PropertyValueFactory<>("currentKickCatching"));
        futureKickCatching.setCellValueFactory(new PropertyValueFactory<>("futureKickCatching"));
    }

    private void setupPlayerKickingSkills() {
        currentKickStrength.setCellValueFactory(new PropertyValueFactory<>("currentKickStrength"));
        futureKickStrength.setCellValueFactory(new PropertyValueFactory<>("futureKickStrength"));
        currentKickAccuracy.setCellValueFactory(new PropertyValueFactory<>("currentKickAccuracy"));
        futureKickAccuracy.setCellValueFactory(new PropertyValueFactory<>("futureKickAccuracy"));
    }

    private void setupPlayerPuntingSkills() {
        currentPuntStrength.setCellValueFactory(new PropertyValueFactory<>("currentPuntStrength"));
        futurePuntStrength.setCellValueFactory(new PropertyValueFactory<>("futurePuntStrength"));
        currentPuntAccuracy.setCellValueFactory(new PropertyValueFactory<>("currentPuntAccuracy"));
        futurePuntAccuracy.setCellValueFactory(new PropertyValueFactory<>("futurePuntAccuracy"));
        currentPuntTiming.setCellValueFactory(new PropertyValueFactory<>("currentPuntTiming"));
        futurePuntTiming.setCellValueFactory(new PropertyValueFactory<>("futurePuntTiming"));
    }

    private void setupPlayerSnappingSkills() {
        currentShortSnapping.setCellValueFactory(new PropertyValueFactory<>("currentShortSnapping"));
        futureShortSnapping.setCellValueFactory(new PropertyValueFactory<>("futureShortSnapping"));
        currentLongSnapping.setCellValueFactory(new PropertyValueFactory<>("currentLongSnapping"));
        futureLongSnapping.setCellValueFactory(new PropertyValueFactory<>("futureLongSnapping"));
    }

    private void setupPlayerBlockingSkills() {
        currentRunBlocking.setCellValueFactory(new PropertyValueFactory<>("currentRunBlocking"));
        futureRunBlocking.setCellValueFactory(new PropertyValueFactory<>("futureRunBlocking"));
        currentPassBlocking.setCellValueFactory(new PropertyValueFactory<>("currentPassBlocking"));
        futurePassBlocking.setCellValueFactory(new PropertyValueFactory<>("futurePassBlocking"));
    }

    private void setupPlayerRushingSkills() {
        currentBreakTackle.setCellValueFactory(new PropertyValueFactory<>("currentBreakTackle"));
        futureBreakTackle.setCellValueFactory(new PropertyValueFactory<>("futureBreakTackle"));
        currentBallCarrying.setCellValueFactory(new PropertyValueFactory<>("currentBallCarrying"));
        futureBallCarrying.setCellValueFactory(new PropertyValueFactory<>("futureBallCarrying"));
        currentAvoidFumble.setCellValueFactory(new PropertyValueFactory<>("currentAvoidFumble"));
        futureAvoidFumble.setCellValueFactory(new PropertyValueFactory<>("futureAvoidFumble"));
    }

    private void setupPlayerGeneralDefenceSkillsColumns() {
        currentTackleAbility.setCellValueFactory(new PropertyValueFactory<>("currentTackleAbility"));
        futureTackleAbility.setCellValueFactory(new PropertyValueFactory<>("futureTackleAbility"));
        currentStripBall.setCellValueFactory(new PropertyValueFactory<>("currentStripBall"));
        futureStripBall.setCellValueFactory(new PropertyValueFactory<>("futureStripBall"));
        currentPassRush.setCellValueFactory(new PropertyValueFactory<>("currentPassRush"));
        futurePassRush.setCellValueFactory(new PropertyValueFactory<>("futurePassRush"));
        currentRunDefence.setCellValueFactory(new PropertyValueFactory<>("currentRunDefence"));
        futureRunDefence.setCellValueFactory(new PropertyValueFactory<>("futureRunDefence"));
    }

    private void setupPlayerCatchingSkillsColumns() {
        currentPassCatching.setCellValueFactory(new PropertyValueFactory<>("currentPassCatching"));
        futurePassCatching.setCellValueFactory(new PropertyValueFactory<>("futurePassCatching"));
        currentBumpAndRunAvoidance.setCellValueFactory(new PropertyValueFactory<>("currentBumpAndRunAvoidance"));
        futureBumpAndRunAvoidance.setCellValueFactory(new PropertyValueFactory<>("futureBumpAndRunAvoidance"));
        currentRouteRunning.setCellValueFactory(new PropertyValueFactory<>("currentRouteRunning"));
        futureRouteRunning.setCellValueFactory(new PropertyValueFactory<>("futureRouteRunning"));
        currentPassReceptionCourage.setCellValueFactory(new PropertyValueFactory<>("currentPassReceptionCourage"));
        futurePassReceptionCourage.setCellValueFactory(new PropertyValueFactory<>("futurePassReceptionCourage"));
    }

    private void setupPlayerPassingSkillsColumns() {
        currentPassAccuracy.setCellValueFactory(new PropertyValueFactory<>("currentPassAccuracy"));
        futurePassAccuracy.setCellValueFactory(new PropertyValueFactory<>("futurePassAccuracy"));
        currentHardCount.setCellValueFactory(new PropertyValueFactory<>("currentHardCount"));
        futureHardCount.setCellValueFactory(new PropertyValueFactory<>("futureHardCount"));
        currentArmStrength.setCellValueFactory(new PropertyValueFactory<>("currentArmStrength"));
        futureArmStrength.setCellValueFactory(new PropertyValueFactory<>("futureArmStrength"));
        currentPassRelease.setCellValueFactory(new PropertyValueFactory<>("currentPassRelease"));
        futurePassRelease.setCellValueFactory(new PropertyValueFactory<>("futurePassRelease"));
        currentLookOffDefence.setCellValueFactory(new PropertyValueFactory<>("currentLookOffDefence"));
        futureLookOffDefence.setCellValueFactory(new PropertyValueFactory<>("futureLookOffDefence"));
        currentScramblingSkill.setCellValueFactory(new PropertyValueFactory<>("currentScramblingSkill"));
        futureScramblingSkill.setCellValueFactory(new PropertyValueFactory<>("futureScramblingSkill"));
        currentFieldOfVision.setCellValueFactory(new PropertyValueFactory<>("currentFieldOfVision"));
        futureFieldOfVision.setCellValueFactory(new PropertyValueFactory<>("futureFieldOfVision"));
    }

    private void setupPlayerCoreSkillsColumns() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        height.setCellValueFactory(new PropertyValueFactory<>("height"));
        weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        assignedPosition.setCellValueFactory(new PropertyValueFactory<>("assignedPosition"));
        currentOA.setCellValueFactory(new PropertyValueFactory<>("currentOA"));
        futureOA.setCellValueFactory(new PropertyValueFactory<>("futureOA"));
        volatility.setCellValueFactory(new PropertyValueFactory<>("volatility"));
        acceleration.setCellValueFactory(new PropertyValueFactory<>("acceleration"));
        maxSpeed.setCellValueFactory(new PropertyValueFactory<>("maxSpeed"));
        strength.setCellValueFactory(new PropertyValueFactory<>("strength"));
        intelligence.setCellValueFactory(new PropertyValueFactory<>("intelligence"));
        discipline.setCellValueFactory(new PropertyValueFactory<>("discipline"));
    }

    /**
     * Presents the User with a {@link DirectoryChooser} dialog from which the User can select the directory containing
     * Draft class files to load and process.
     *
     * @param event the {@link ActionEvent} triggering invocation of this method.
     */
    @FXML
    public void handleDraftFileDirectory(final ActionEvent event) {
        final var directoryChooser = new DirectoryChooser();
        final var selectedDirectory = Optional.ofNullable(directoryChooser.showDialog(WindowUtils.getParentSceneForEvent(event)));
        selectedDirectory.ifPresent(this::loadDraftPlayerData);
    }

    /*
     * Loads Draft player data and updates the directory label.
     */
    private void loadDraftPlayerData(File draftPlayerDataDirectory) {
        final var loader = new DraftClassLoaderService();
        importedPlayers.clear();
        importedPlayers.addAll(loader.importDraftCLassData(draftPlayerDataDirectory));

        refreshData();

        draftClassInfo.setText("Draft class for " + draftPlayerDataDirectory.getName() + "; " + observablePlayers.size() + " players loaded");
    }

    private void refreshData() {
        observablePlayers.clear();

        final var position = draftClassChoiceBox.getValue();

        convertedPlayers = importedPlayers.stream()
                .map((player) -> PlayerConverter.convertToGuiPlayer(player, draftClassChoiceBox.getValue()))
                .sorted(Comparator.comparing(GuiPlayer::getFutureOA).reversed())
                .collect(Collectors.toList());

        observablePlayers.addAll(convertedPlayers);

        // Need to display only visible fields...
        switch (position) {
            case "Assigned" -> {
                passingColumn.setVisible(true);
                catchingColumn.setVisible(true);
                defenceColumn.setVisible(true);
                rushingColumn.setVisible(true);
                blockingColumn.setVisible(true);
                snappingColumn.setVisible(true);
                puntingColumn.setVisible(true);
                kickingColumn.setVisible(true);
                holderColumn.setVisible(true);
                returnerColumn.setVisible(true);
                coverageColumn.setVisible(true);
            }
            case "QB" -> {
                passingColumn.setVisible(true);
                catchingColumn.setVisible(false);
                defenceColumn.setVisible(false);
                rushingColumn.setVisible(false);
                blockingColumn.setVisible(false);
                snappingColumn.setVisible(false);
                puntingColumn.setVisible(false);
                kickingColumn.setVisible(false);
                holderColumn.setVisible(false);
                returnerColumn.setVisible(false);
                coverageColumn.setVisible(false);
            }
            case "RB" -> {
                passingColumn.setVisible(false);
                catchingColumn.setVisible(true);
                defenceColumn.setVisible(false);
                rushingColumn.setVisible(true);
                blockingColumn.setVisible(false);
                snappingColumn.setVisible(false);
                puntingColumn.setVisible(false);
                kickingColumn.setVisible(false);
                holderColumn.setVisible(false);
                returnerColumn.setVisible(false);
                coverageColumn.setVisible(false);
            }
            case "FB", "TE", "WR" -> {
                passingColumn.setVisible(false);
                catchingColumn.setVisible(true);
                defenceColumn.setVisible(false);
                rushingColumn.setVisible(true);
                blockingColumn.setVisible(true);
                snappingColumn.setVisible(false);
                puntingColumn.setVisible(false);
                kickingColumn.setVisible(false);
                holderColumn.setVisible(false);
                returnerColumn.setVisible(false);
                coverageColumn.setVisible(false);
            }
            case "LT", "LG", "RG", "RT", "STBLK" -> {
                passingColumn.setVisible(false);
                catchingColumn.setVisible(false);
                defenceColumn.setVisible(false);
                rushingColumn.setVisible(false);
                blockingColumn.setVisible(true);
                snappingColumn.setVisible(false);
                puntingColumn.setVisible(false);
                kickingColumn.setVisible(false);
                holderColumn.setVisible(false);
                returnerColumn.setVisible(false);
                coverageColumn.setVisible(false);
            }
            case "C" -> {
                passingColumn.setVisible(false);
                catchingColumn.setVisible(false);
                defenceColumn.setVisible(false);
                rushingColumn.setVisible(false);
                blockingColumn.setVisible(true);
                snappingColumn.setVisible(true);
                puntingColumn.setVisible(false);
                kickingColumn.setVisible(false);
                holderColumn.setVisible(false);
                returnerColumn.setVisible(false);
                coverageColumn.setVisible(false);
            }
            case "LDE", "DT", "RDE", "STRUSH" -> {
                passingColumn.setVisible(false);
                catchingColumn.setVisible(false);
                defenceColumn.setVisible(true);
                rushingColumn.setVisible(false);
                blockingColumn.setVisible(false);
                snappingColumn.setVisible(false);
                puntingColumn.setVisible(false);
                kickingColumn.setVisible(false);
                holderColumn.setVisible(false);
                returnerColumn.setVisible(false);
                coverageColumn.setVisible(false);
            }
            case "SLB", "MLB", "WLB", "CB", "FS", "SS" -> {
                passingColumn.setVisible(false);
                catchingColumn.setVisible(false);
                defenceColumn.setVisible(true);
                rushingColumn.setVisible(false);
                blockingColumn.setVisible(false);
                snappingColumn.setVisible(false);
                puntingColumn.setVisible(false);
                kickingColumn.setVisible(false);
                holderColumn.setVisible(false);
                returnerColumn.setVisible(false);
                coverageColumn.setVisible(true);
            }
            case "GUNNER" -> {
                passingColumn.setVisible(false);
                catchingColumn.setVisible(false);
                defenceColumn.setVisible(true);
                rushingColumn.setVisible(false);
                blockingColumn.setVisible(false);
                snappingColumn.setVisible(false);
                puntingColumn.setVisible(false);
                kickingColumn.setVisible(false);
                holderColumn.setVisible(false);
                returnerColumn.setVisible(false);
                coverageColumn.setVisible(false);
            }
            case "KH" -> {
                passingColumn.setVisible(false);
                catchingColumn.setVisible(false);
                defenceColumn.setVisible(false);
                rushingColumn.setVisible(false);
                blockingColumn.setVisible(false);
                snappingColumn.setVisible(false);
                puntingColumn.setVisible(false);
                kickingColumn.setVisible(false);

                holderColumn.setVisible(true);
                returnerColumn.setVisible(false);
                coverageColumn.setVisible(false);
            }
            case "LS" -> {
                passingColumn.setVisible(false);
                catchingColumn.setVisible(false);
                defenceColumn.setVisible(false);
                rushingColumn.setVisible(false);
                blockingColumn.setVisible(false);
                snappingColumn.setVisible(true);
                puntingColumn.setVisible(false);

                kickingColumn.setVisible(false);
                holderColumn.setVisible(false);
                returnerColumn.setVisible(false);
                coverageColumn.setVisible(false);
            }
            case "KR", "PR" -> {
                passingColumn.setVisible(false);
                catchingColumn.setVisible(false);
                defenceColumn.setVisible(false);
                rushingColumn.setVisible(false);
                blockingColumn.setVisible(false);
                snappingColumn.setVisible(false);
                puntingColumn.setVisible(false);
                kickingColumn.setVisible(false);
                holderColumn.setVisible(false);
                returnerColumn.setVisible(true);
                coverageColumn.setVisible(false);
            }
            default -> {}
        }

    }
}
