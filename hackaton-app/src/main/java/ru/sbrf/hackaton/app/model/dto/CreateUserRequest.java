package ru.sbrf.hackaton.app.model.dto;

import lombok.Data;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Data
public class CreateUserRequest {
    private String login;
    private String password;
}