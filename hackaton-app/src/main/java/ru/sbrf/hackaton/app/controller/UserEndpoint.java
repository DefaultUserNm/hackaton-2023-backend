package ru.sbrf.hackaton.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.hackaton.app.mapper.UserMapper;
import ru.sbrf.hackaton.app.model.dto.CreateUserRequest;
import ru.sbrf.hackaton.app.model.dto.UserDto;
import ru.sbrf.hackaton.app.service.UserService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/*
 * @created 15.06.2023
 * @author alexander
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserService userService;
    private final UserMapper userMapper;

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserDto saveUser(@RequestBody CreateUserRequest request) {
        return userMapper.toDto(
                userService.save(request)
        );
    }
}