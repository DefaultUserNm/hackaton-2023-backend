package ru.sbrf.hackaton.app.service;

import ru.sbrf.hackaton.app.model.domain.entity.TeamEntity;
import ru.sbrf.hackaton.app.model.dto.CreateTeamRequest;

/*
 * @created 15.06.2023
 * @author alexander
 */
public interface TeamService {
    TeamEntity saveTeam(CreateTeamRequest request);
}