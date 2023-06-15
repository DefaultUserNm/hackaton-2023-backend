package common.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"common.configuration.bean"})
public class TestConfiguration {
}
