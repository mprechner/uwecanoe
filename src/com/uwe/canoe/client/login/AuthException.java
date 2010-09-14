package com.uwe.canoe.client.login;

import java.io.Serializable;

public class AuthException extends Exception implements Serializable {

    public AuthException() {
        super();
    }
    
    public AuthException(String message) {
        super(message);
    }
}

