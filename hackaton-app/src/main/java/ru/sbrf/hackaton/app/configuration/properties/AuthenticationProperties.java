package ru.sbrf.hackaton.app.configuration.properties;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Slf4j
@Data
@ConfigurationProperties(prefix = "hackaton.auth")
public class AuthenticationProperties {
    private List<String> filteredPaths = new ArrayList<>();
    private Long expirationTime;

    @PostConstruct
    private void init() {
        log.info("AuthenticationProperties: {}", this);
    }
}