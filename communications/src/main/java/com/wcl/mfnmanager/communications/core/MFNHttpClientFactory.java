package com.wcl.mfnmanager.communications.core;

import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.impl.DefaultRedirectStrategy;
import org.apache.hc.client5.http.impl.classic.*;
import org.apache.hc.client5.http.impl.io.*;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import org.apache.hc.core5.http.ssl.TLS;
import org.apache.hc.core5.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import com.wcl.mfnmanager.exceptions.CommunicationsException;
/**
 * Factory class to build a {@link CloseableHttpClient} instance.
 *
 * The {@link CloseableHttpClient} instance is built with a {@link BasicCookieStore}, a {@link DefaultRedirectStrategy}
 * and a {@link PoolingHttpClientConnectionManager} setup to run on TLS v1.2 with a {@link SSLContext} accepting
 * all certificates.
 *
 * Whilst the above would be risky in a public facing API, as this is currently encased within this application only
 * then the risk is minimal.
 */
public final class MFNHttpClientFactory {
    private MFNHttpClientFactory() {}

    /**
     * Builds and returns a {@link CloseableHttpClient} instance, containing  {@link BasicCookieStore},
     * {@link DefaultRedirectStrategy} and {@link SSLContext} accepting all certificates via TLS 1.2.
     *
     * @return generated {@link CloseableHttpClient}
     * @throws CommunicationsException thrown on error creating {@link CloseableHttpClient}
     */
    public static CloseableHttpClient buildMFNHttpClient() throws CommunicationsException {
        return HttpClients.custom()
                .setDefaultCookieStore(new BasicCookieStore())
                .setConnectionManager(createConnectionManager())
                .setRedirectStrategy(new DefaultRedirectStrategy())
                .build();
    }

    /**
     * Creates a {@link PoolingHttpClientConnectionManager} instance with a {@link SSLContext} designed to accept
     * all certificates using TLS 1.2.
     *
     * @return created {@link PoolingHttpClientConnectionManager}
     * @throws CommunicationsException thrown on error setting up the {@link SSLContext}
     */
    private static PoolingHttpClientConnectionManager createConnectionManager() throws CommunicationsException {
        // Trust all CA
        SSLContext sslcontext;
        try {
            sslcontext = SSLContexts.custom()
                    .loadTrustMaterial((chain, authTye) -> true)
                    .build();
        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
            throw new CommunicationsException("Error creating SSLContext", e);
        }
        // Allow TLSv1.2 protocol only
        final var sslSocketFactory = SSLConnectionSocketFactoryBuilder.create()
                .setSslContext(sslcontext)
                .setTlsVersions(TLS.V_1_2)
                .build();
        return PoolingHttpClientConnectionManagerBuilder.create()
                .setSSLSocketFactory(sslSocketFactory)
                .build();
    }

}
