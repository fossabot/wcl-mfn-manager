/*
 * This project is licensed under the Apache 2.0  license.
 *
 *  For details see the LICENSE file which can be found at the base of this project archive.
 */

package com.wcl.mfnmanager.ui.controller.main.help;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import com.wcl.mfnmanager.ui.controller.main.help.pdf.PDFModel;
import com.wcl.mfnmanager.services.help.HelpService;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ManualController implements Initializable {
    @FXML
    private Pagination pagination;

    private HelpService helpService;
    private File manualFile;

    private PDFModel pdfModel;

    public void handleCloseManualDialog(ActionEvent event) {
        helpService.removeTempManualFile(manualFile);

        final var source = (Node) event.getSource();
        final var stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        helpService = new HelpService();
        manualFile = helpService.prepareManual();

        pdfModel = new PDFModel(manualFile);
        pagination.setPageCount(pdfModel.numPages());
        pagination.setPageFactory(index -> new ImageView(pdfModel.getImage(index)));
    }

}
