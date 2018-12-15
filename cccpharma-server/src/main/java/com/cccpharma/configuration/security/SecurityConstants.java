package com.cccpharma.configuration.security;

/**
 * Stores the constants used by the security configuration classes.
 *
 * @author Marcus Vinicius
 */
public class SecurityConstants {

    static final String SECRET = "cccpharma";
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING =  "Authorization";
    static final long EXPIRATION_DATE = 864000000L;
}
