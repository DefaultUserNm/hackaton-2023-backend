package ru.sbrf.hackaton.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @created 15.06.2023
 * @author alexander
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class AuthenticationException extends HackatonBaseException {

    public static final String CODE = "AUTH_ERROR";

    public AuthenticationException() {
        super(CODE);
    }

    public AuthenticationException(String message) {
        super(message, CODE);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause, CODE);
    }
}