package ru.sbrf.hackaton.app.exception;

import lombok.Getter;

/*
 * @created 15.06.2023
 * @author alexander
 */
public class HackatonBaseException extends RuntimeException {

    @Getter
    private final String code;

    public HackatonBaseException(String code) {
        super();
        this.code = code;
    }

    public HackatonBaseException(String message, String code) {
        super(message);
        this.code = code;
    }

    public HackatonBaseException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }
}