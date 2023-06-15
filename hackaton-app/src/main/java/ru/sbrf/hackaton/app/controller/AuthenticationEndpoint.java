package ru.sbrf.hackaton.app.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.hackaton.app.model.Session;
import ru.sbrf.hackaton.app.model.dto.AuthenticationPayload;
import ru.sbrf.hackaton.app.service.UserService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.sbrf.hackaton.app.configuration.authentication.HackatonSecurityFilter.AUTH_COOKIE_NAME;

/*
 * @created 15.06.2023
 * @author alexander
 */
@RestController
@RequestMapping("/api/v1/login")
@RequiredArgsConstructor
public class AuthenticationEndpoint {

    private final UserService userService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void authenticate(@RequestBody AuthenticationPayload payload, HttpServletResponse response) {
        Session session = userService.authenticate(payload);
        setCookie(session, response);
    }

    private void setCookie(Session session, HttpServletResponse response) {
        Cookie cookie = new Cookie(AUTH_COOKIE_NAME, session.getId().toHexString());
        cookie.setPath("/");
        cookie.setSecure(true);

        response.addCookie(cookie);
    }
}