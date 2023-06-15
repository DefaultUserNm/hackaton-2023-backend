package ru.sbrf.hackaton.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbrf.hackaton.app.mapper.TeamMapper;
import ru.sbrf.hackaton.app.mapper.UserMapper;
import ru.sbrf.hackaton.app.model.domain.entity.TeamEntity;
import ru.sbrf.hackaton.app.model.domain.entity.UserEntity;
import ru.sbrf.hackaton.app.model.dto.CreateTeamRequest;
import ru.sbrf.hackaton.app.model.dto.TeamDTO;
import ru.sbrf.hackaton.app.repository.TeamRepository;
import ru.sbrf.hackaton.app.repository.UserRepository;
import ru.sbrf.hackaton.app.service.TeamService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final UserMapper userMapper;
    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    @Override
    public TeamEntity saveTeam(CreateTeamRequest request) {
        Optional<TeamEntity> team = teamRepository.findByName(request.getName());
        TeamEntity result = team.orElseGet(() -> new TeamEntity()
                .setName(request.getName()));
        setUsers(result, request.getUsers());

        return teamRepository.save(result);
    }

    @Override
    public void saveAllTeams(Set<TeamDTO> teams) {
        saveTeamUsers(teams);
        teamRepository.saveAll(mapTeamEntities(teams));
    }

    private void setUsers(TeamEntity team, List<String> users) {
        team.setUserEntities(new ArrayList<>());
        for (String login : users) {
            userRepository.findByLogin(login)
                    .ifPresent(user -> team.getUserEntities().add(user));
        }
    }

    private Set<TeamEntity> mapTeamEntities(Set<TeamDTO> teams) {
        return teams.stream()
                .map(teamMapper::toEntity)
                .collect(Collectors.toSet());
    }

    private void saveTeamUsers(Set<TeamDTO> teams) {
        for (TeamDTO team : teams) {
            if (team.getUsers() != null) {
                Set<UserEntity> users = team.getUsers().stream()
                        .map(userMapper::toUserEntity)
                        .collect(Collectors.toSet());
                userRepository.saveAll(users);
            }
        }
    }
}
