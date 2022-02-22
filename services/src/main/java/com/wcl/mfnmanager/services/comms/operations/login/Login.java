package com.wcl.mfnmanager.services.comms.operations.login;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import com.wcl.mfnmanager.communications.operations.CommsOperation;

import java.net.URI;

/**
 * Represents a Login operation on MyFootballNow, providing the {@link ClassicHttpRequest} required.
 *
 * The heavy lifting is performed by the {@link CommsOperation} class.
 */
public class Login implements CommsOperation {
    /** The URI to Login to MyFootballNow. */
    private static final String LOGIN_URI = "https://www.myfootballnow.com/guest/sign-in";

    /** The name of the username parameter. */
    private static final String USERNAME_PARAMETER = "username";
    /** The name of the password parameter. */
    private static final String PASSWORD_PARAMETER = "password";

    /** Login username. */
    private final String username;
    /** Login password. */
    private final String password;

    /**
     * Sets the username and password parameters to login to myfootballnow.
     * @param username the username for login
     * @param password the password for login
     */
    public Login(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public ClassicHttpRequest generateRequest() {
        return ClassicRequestBuilder.post()
                .setUri(URI.create(LOGIN_URI))
                .addParameter(USERNAME_PARAMETER, username)
                .addParameter(PASSWORD_PARAMETER, password)
                .build();
    }
}
