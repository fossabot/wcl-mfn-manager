package com.wcl.mfnmanager.exceptions;

/**
 * Used to wrap exceptions occurring within the Communications module.
 *
 * As numerous errors can occur in the process of connecting and intereacting with web pages, wrapping into a
 * single Exception prevents clint code having to handle numerous checked exceptions, instead only daling with
 * this wrapper exception.
 */
public class CommunicationsException extends Exception {
    public CommunicationsException(String message) {
        super(message);
    }

    public CommunicationsException(String message, Throwable cause) {
        super(message, cause);
    }
}
