package ru.sbrf.hackaton.app.configuration.authentication;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;
import ru.sbrf.hackaton.app.configuration.properties.AuthenticationProperties;
import ru.sbrf.hackaton.app.service.UserInfoManager;
import ru.sbrf.hackaton.app.service.UserService;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Configuration
@ConditionalOnProperty(
        value = "hackaton.auth.enabled",
        havingValue = "true",
        matchIfMissing = true
)
public class HackatonSecurityFilterConfiguration {

    @Bean
    public GenericFilterBean hackatonSecurityFilter(
            UserService userService, AuthenticationProperties properties, UserInfoManager manager) {
        return new HackatonSecurityFilter(userService, properties, manager);
    }
}