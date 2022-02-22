package com.wcl.mfnmanager.communications.utils;

import org.apache.hc.core5.http.HttpEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Provides static helper methods pertaining to the {@link HttpEntity} class.
 */
public final class HttpEntityUtils {
    private HttpEntityUtils() {
    }

    /**
     * Reads the content of a {@link HttpEntity} and returns as a String.
     *
     * @param entity the {@link HttpEntity} to read the content of
     * @return String the content of the {@link HttpEntity}
     * @throws IOException thrown on error reading the {@link HttpEntity} content
     */
    public static String extractEntityContentAsString(final HttpEntity entity) throws IOException {
        final var builder = new StringBuilder();
        try (var bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

    /**
     * Writes the content of a {@link HttpEntity} to an external file.
     *
     * WHere the content is empty, then a blank file is written.
     *
     * @param entity  the {@link HttpEntity} class to read from
     * @param directoryPath the {@link Path} of the directoryPath to write t0
     * @param fileName the name of the file to write to
     * @throws IOException thrown on error writing to file
     */
    public static void storeEntityContentAsFile(final HttpEntity entity,
                                                final Path directoryPath,
                                                final String fileName) throws IOException {
        Files.createDirectories(directoryPath);

        final var path = Paths.get(String.format("%s/%s", directoryPath, fileName));
        try (final var outstream = Files.newOutputStream(Paths.get(path.toString()))) {
            entity.writeTo(outstream);
        }
    }
}
