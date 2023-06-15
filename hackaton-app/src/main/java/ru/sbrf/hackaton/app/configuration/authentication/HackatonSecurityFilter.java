package ru.sbrf.hackaton.app.configuration.authentication;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.GenericFilterBean;
import ru.sbrf.hackaton.app.configuration.properties.AuthenticationProperties;
import ru.sbrf.hackaton.app.exception.AuthenticationException;
import ru.sbrf.hackaton.app.model.User;
import ru.sbrf.hackaton.app.service.UserService;

import java.io.IOException;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Slf4j
@RequiredArgsConstructor
public class HackatonSecurityFilter extends GenericFilterBean {

    public static final String AUTH_COOKIE_NAME = "SESSION-ID";

    private final UserService userService;
    private final AuthenticationProperties properties;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (shouldAuthenticate(request)) {
            log.debug("Authentication request to {}", request.getRequestURI());
            try {
                User user = getUser(request);
                log.debug("Authenticated user: {}", user);
            } catch (Exception ex) {
                log.error("Failed to authenticate user: {}", getStackTrace(ex));
                ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }

            // TODO add user into context
        }
        chain.doFilter(servletRequest, servletResponse);
    }

    private boolean shouldAuthenticate(HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        return properties.getFilteredPaths()
                .stream()
                .anyMatch(requestUri::matches);
    }

    private User getUser(HttpServletRequest request) {
        String sessionId = getToken(request);
        return userService.findBySession(sessionId)
                .orElseThrow(() -> new AuthenticationException("Invalid sessionId [" + sessionId + "]"));
    }

    private String getToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (AUTH_COOKIE_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        throw new AuthenticationException("Authentication cookie [" + AUTH_COOKIE_NAME + "] was not present");
    }
}