package ru.sbrf.hackaton.app.service;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import ru.sbrf.hackaton.app.configuration.properties.AuthenticationProperties;
import ru.sbrf.hackaton.app.exception.AuthenticationException;
import ru.sbrf.hackaton.app.mapper.UserMapper;
import ru.sbrf.hackaton.app.model.Session;
import ru.sbrf.hackaton.app.model.User;
import ru.sbrf.hackaton.app.model.domain.entity.UserEntity;
import ru.sbrf.hackaton.app.model.dto.AuthenticationPayload;
import ru.sbrf.hackaton.app.model.dto.CreateUserRequest;
import ru.sbrf.hackaton.app.repository.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationProperties authenticationProperties;

    @Override
    public Optional<User> findBySession(String id) {
        Long now = System.currentTimeMillis();
        return userRepository.findBySessionId(id, now)
                        .map(userMapper::toUser);
    }

    @Override
    public Session authenticate(AuthenticationPayload authenticationPayload) {
        UserEntity user = userRepository.findByLogin(authenticationPayload.getLogin())
                .orElseThrow();
        if (checkPassword(user, authenticationPayload.getPassword())) {
            Session session = generateSession();
            user.getSessions().add(session);
            userRepository.save(user);
            return session;
        }
        throw new AuthenticationException("Invalid password");
    }

    @Override
    public User save(CreateUserRequest request) {
        Optional<UserEntity> user = userRepository.findByLogin(request.getLogin());
        UserEntity result;
        if (user.isPresent()) {
            result = user.get();
            result.setPasswordHash(request.getPassword());
        } else {
            result = new UserEntity()
                    .setLogin(request.getLogin())
                    .setPasswordHash(request.getPassword())
                    .setSessions(new ArrayList<>());
        }

        return userMapper.toUser(
                userRepository.save(result)
        );
    }

    private boolean checkPassword(UserEntity user, String password) {
        return user.getPasswordHash().equals(password);
    }

    private Session generateSession() {
        Long now = System.currentTimeMillis();
        return new Session()
                .setId(new ObjectId())
                .setCreateDate(now)
                .setExpireDate(now + authenticationProperties.getExpirationTime());
    }
}
