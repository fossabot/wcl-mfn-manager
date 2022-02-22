package com.wcl.mfnmanager.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommunicationsExceptionTest {
    @Test
    public void checkThatSingleParameterConstructorWorksCorrectly() {
        final var testMessage = "Test Message";
        final var testException = new CommunicationsException(testMessage);
        assertEquals(testMessage, testException.getMessage(), "Exception had incorrect message");
        assertNull(testException.getCause(), "Exception cause should be null");
    }

    @Test
    public void checkThatDoubleParameterConstructorWorksCorrectly() {
        final var testMessage = "Test Message";
        final var testCause = new NullPointerException("Test Message 2");
        final var testException = new CommunicationsException(testMessage, testCause);
        assertEquals(testMessage, testException.getMessage(), "Exception had incorrect message");
        assertSame(testCause, testException.getCause(), "Exception had incorrect cause");
    }
}

