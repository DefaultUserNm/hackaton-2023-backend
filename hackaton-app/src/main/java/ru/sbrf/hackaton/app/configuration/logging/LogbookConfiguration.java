package ru.sbrf.hackaton.app.configuration.logging;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.HttpLogWriter;

/*
 * @created 21.04.2023
 * @author alexander
 */
@Configuration
@ConditionalOnProperty(
        value = "logging.logbook.autoconfigure",
        havingValue = "true",
        matchIfMissing = true
)
public class LogbookConfiguration {

    @Bean
    public HttpLogWriter httpLogWriter() {
        return new InfoHttpLogWriter();
    }
}
