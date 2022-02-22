package com.wcl.mfnmanager.services.comms.operations.login;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import com.wcl.mfnmanager.communications.operations.CommsOperation;

/**
 * Represents a Logout operation on MyFootballNow, providing the {@link ClassicHttpRequest} required.
 *
 * The heavy lifting is performed by the {@link wcl.mfnmanager.communications.operations.CommsOperation} class.
 */
public final class Logout implements CommsOperation {
    /** The URI to Logout from MyFootballNow. */
    private static final String LOGOUT_URI = "https://www.myfootballnow.com/log-out";

    @Override
    public ClassicHttpRequest generateRequest() {
        return ClassicRequestBuilder.get(LOGOUT_URI).build();
    }
}
