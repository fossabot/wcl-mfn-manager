package com.wcl.mfnmanager.communications.core;

import org.junit.jupiter.api.Test;
import com.wcl.mfnmanager.exceptions.CommunicationsException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Provides tests for the {@link MFNHttpClientFactory} class.
 *
 * The returned {@link org.apache.hc.client5.http.impl.classic.CloseableHttpClient} instance does not allow
 * interrogation of the setup, so cookie store, SSLContext etc cannot currently be queried.
 */
public final class MFNHttpClientFactoryTest {

    /**
     * Checks that the {@see MFNHttpClientFactory} class uilds and returns a {@link org.apache.hc.client5.http.impl.classic.CloseableHttpClient}
     * instance.
     */
    @Test
    public void checkHttpClientGenerated() {
        try {
            assertNotNull(MFNHttpClientFactory.buildMFNHttpClient(), "Provided client was null");
        } catch (CommunicationsException e) {
            fail("Unable to build built HttpClient", e.getCause());
        }
    }

}
