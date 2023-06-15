package ru.sbrf.hackaton.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.hackaton.app.model.dto.ComponentDTO;
import ru.sbrf.hackaton.app.model.dto.CreateUserRequest;
import ru.sbrf.hackaton.app.model.dto.UserDto;
import ru.sbrf.hackaton.app.service.ComponentService;
import ru.sbrf.hackaton.app.service.UserService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/components")
@RequiredArgsConstructor
public class ComponentEndpoint {

    private final ComponentService componentService;

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ComponentDTO saveComponent(@RequestBody ComponentDTO componentDTO) {
        return componentService.saveComponent(componentDTO);
    }
}
