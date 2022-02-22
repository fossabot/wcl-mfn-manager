package com.wcl.mfnmanager.services.help;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.util.concurrent.CountDownLatch;

// @TODO  Move this service into the GUI domain.
public class HelpService {
    public void displayManual() {
        final var manualFile = prepareManual();
        final var service = new Service<Void>() {

            @Override
            protected Task<Void> createTask() {
                //Background work
                final var latch = new CountDownLatch(1);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            try {
                                Desktop.getDesktop().browse(URI.create("file://" + manualFile.getCanonicalPath()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } finally{
                            latch.countDown();
                        }
                    }
                });
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Keep with the background work
                return null;
            }
        };

        service.start();
    }

    public File prepareManual() {
        File file = null;
        final var input = getClass().getResourceAsStream("/manual/MFN Manager Manual.pdf");
        try {
            file = File.createTempFile("manual",".pdf");
            file.deleteOnExit();
            FileUtils.copyInputStreamToFile(input, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    public void removeTempManualFile(File file) {
        try {
            Files.delete(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
