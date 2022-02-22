package com.wcl.mfnmanager.ui.controller.main.help.pdf;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

public class PDFModel {

    private PDDocument document;
    private PDFRenderer renderer;

    public PDFModel(File file) {
        try {
            document = PDDocument.load(file);
            renderer = new PDFRenderer(document);
        } catch (IOException ex) {
            throw new UncheckedIOException("PDDocument thorws IOException file=" + file.getAbsolutePath(), ex);
        }
    }

    public int numPages() {
        return document.getPages().getCount();
    }

    public Image getImage(int pageNumber) {
        BufferedImage pageImage;
        try {
            pageImage = renderer.renderImage(pageNumber);
        } catch (IOException ex) {
            throw new UncheckedIOException("PDFRenderer throws IOException", ex);
        }
        return SwingFXUtils.toFXImage(pageImage, null);
    }
}

