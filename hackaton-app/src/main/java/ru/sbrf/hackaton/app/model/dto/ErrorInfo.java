package ru.sbrf.hackaton.app.model.dto;

import lombok.Data;

import java.util.Date;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Data
public class ErrorInfo {
    private Date timestamp;
    private int status;
    private Object error;
    private String path;
    private String code;
}