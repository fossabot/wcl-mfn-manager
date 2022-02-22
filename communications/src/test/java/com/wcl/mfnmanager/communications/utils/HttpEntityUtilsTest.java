package com.wcl.mfnmanager.communications.utils;

import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.BasicHttpEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

/**
 * Contains tests for the {@link HttpEntityUtils} class.
 */
@ExtendWith(MockitoExtension.class)
public class HttpEntityUtilsTest {
    /** Mock {@link HttpEntity} instance. */
    @Mock
    private HttpEntity mockEntity;

    /**
     * Checks that an string is correctly returned matching the content.
     */
    @Test
    public void checkThatContentCorrectlyReturnedAsString() {
        try {
            final var contentText = "Test Text" + System.lineSeparator() + "Second line";
            when(mockEntity.getContent()).thenReturn(new ByteArrayInputStream(contentText.getBytes()));

            final var extractedText = HttpEntityUtils.extractEntityContentAsString(mockEntity);
            assertEquals(contentText + System.lineSeparator(), extractedText, "Content not returned correctly");
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Checks that an empty string is returned when the content is empty.
     */
    @Test
    public void checkThatBlankContentCorrectlyReturnedAsEmptyString() {
        try {
            final var contentText = "";
            when(mockEntity.getContent()).thenReturn(new ByteArrayInputStream(contentText.getBytes()));

            final var extractedText = HttpEntityUtils.extractEntityContentAsString(mockEntity);
            assertEquals(contentText, extractedText, "Content returned was not an empty string");
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Checks that {@link HttpEntity} content is retrieved and written to a file and is the same as the content.
     * @param tempDir temporary directory to use.
     */
    @Test
    public void checkThatContentCorrectlyWrittenToFile(@TempDir final File tempDir) {
        final var contentText = new StringBuilder(20);
        contentText.append("a,b,c,d,e").append(System.lineSeparator()).append("f,g,h,i,j");

        try {
            final var entity = new BasicHttpEntity(new ByteArrayInputStream(contentText.toString().getBytes()), ContentType.DEFAULT_BINARY);

            final var dirPath = Files.createDirectories(Paths.get(tempDir.getAbsolutePath()));

            HttpEntityUtils.storeEntityContentAsFile(entity, dirPath, "TEST.CSV");

            final var path = Paths.get(dirPath.toAbsolutePath()+"/"+"TEST.CSV");

            final var lines = Files.readAllLines(path);
            assertEquals(contentText.toString(), String.join(System.lineSeparator(), lines), "Content in file not as expected");

        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Checks that empty file is written when the content is blank.
     * @param tempDir temporary directory to use.
     */
    @Test
    public void checkThatEmptyFileCreatedWhenContentIEmpty(@TempDir final File tempDir) {

        try {
            final var entity = new BasicHttpEntity(new ByteArrayInputStream("".getBytes()), ContentType.DEFAULT_BINARY);

            final var dirPath = Files.createDirectories(Paths.get(tempDir.getAbsolutePath()));

            HttpEntityUtils.storeEntityContentAsFile(entity, dirPath, "TEST.CSV");

            final var path = Paths.get(dirPath.toAbsolutePath()+"/"+"TEST.CSV");

            final var lines = Files.readAllLines(path);
            assertEquals("", String.join(System.lineSeparator(), lines), "Created file was not emoty");

        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}
