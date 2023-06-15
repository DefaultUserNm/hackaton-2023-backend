package ru.sbrf.hackaton.app.service;

import ru.sbrf.hackaton.app.model.Session;
import ru.sbrf.hackaton.app.model.User;
import ru.sbrf.hackaton.app.model.dto.AuthenticationPayload;
import ru.sbrf.hackaton.app.model.dto.CreateUserRequest;

import java.util.Optional;

/*
 * @created 15.06.2023
 * @author alexander
 */
public interface UserService {
    User save(CreateUserRequest request);

    Optional<User> findBySession(String id);

    Session authenticate(AuthenticationPayload authenticationPayload);
}