package ru.sbrf.hackaton.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbrf.hackaton.app.mapper.UserMapper;
import ru.sbrf.hackaton.app.model.domain.entity.TeamEntity;
import ru.sbrf.hackaton.app.model.dto.CreateTeamRequest;
import ru.sbrf.hackaton.app.repository.TeamRepository;
import ru.sbrf.hackaton.app.repository.UserRepository;
import ru.sbrf.hackaton.app.service.TeamService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public TeamEntity saveTeam(CreateTeamRequest request) {
        Optional<TeamEntity> team = teamRepository.findByName(request.getName());
        TeamEntity result = team.orElseGet(() -> new TeamEntity()
                .setName(request.getName()));
        setUsers(result, request.getUsers());

        return teamRepository.save(result);
    }

    private void setUsers(TeamEntity team, List<String> users) {
        team.setUsers(new ArrayList<>());
        for (String login : users) {
            userRepository.findByLogin(login)
                    .ifPresent(user -> team.getUsers().add(userMapper.toUser(user)));
        }
    }
}
