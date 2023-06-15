package ru.sbrf.hackaton.app.model.dto;

import lombok.Data;

import java.util.List;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Data
public class CreateTeamRequest {

    private String name;
    private List<String> users;
}
