package ru.sbrf.hackaton.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/*
 * @created 15.06.2023
 * @author alexander
 */
@SpringBootApplication
@EnableMongoRepositories
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
