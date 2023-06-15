package ru.sbrf.hackaton.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.hackaton.app.mapper.TeamMapper;
import ru.sbrf.hackaton.app.model.dto.CreateTeamRequest;
import ru.sbrf.hackaton.app.model.dto.TeamDTO;
import ru.sbrf.hackaton.app.service.TeamService;

/*
 * @created 15.06.2023
 * @author alexander
 */
@RestController
@RequestMapping("/api/v1/teams")
@RequiredArgsConstructor
public class TeamEndpoint {
    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @PutMapping
    public TeamDTO saveTeam(@RequestBody CreateTeamRequest request) {
        return teamMapper.toDto(
                teamService.saveTeam(request)
        );
    }
}