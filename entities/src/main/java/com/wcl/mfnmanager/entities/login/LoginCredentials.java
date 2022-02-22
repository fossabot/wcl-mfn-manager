package com.wcl.mfnmanager.entities.login;

/**
 * Models login credentials.
 *
 * @param username - the name of the user.
 * @param password - the password of the user.
 */
public record LoginCredentials(String username,
                               String password) {}
