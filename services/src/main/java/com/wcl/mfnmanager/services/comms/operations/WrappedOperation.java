package com.wcl.mfnmanager.services.comms.operations;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import com.wcl.mfnmanager.communications.core.MFNHttpClientFactory;
import com.wcl.mfnmanager.exceptions.CommunicationsException;
import com.wcl.mfnmanager.services.comms.operations.login.Login;
import com.wcl.mfnmanager.services.comms.operations.login.Logout;

import java.io.IOException;

public abstract class WrappedOperation<T> {
    public T performOperation(String username, String password) throws CommunicationsException, IOException {
        var connection = MFNHttpClientFactory.buildMFNHttpClient();

        login(connection, username, password);
        final var returnData = perform(connection);
        logout(connection);

        return returnData;
    }

    private void login(CloseableHttpClient connection, String username, String password) throws CommunicationsException, IOException {
        final var loginOp = new Login(username, password);
        loginOp.performOperation(connection);
    }

    protected abstract T perform(CloseableHttpClient connection) throws CommunicationsException;

    private void logout(CloseableHttpClient connection) throws CommunicationsException, IOException {
        final var loginOp = new Logout();
        loginOp.performOperation(connection);
    }
}
