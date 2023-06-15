package ru.sbrf.hackaton.app.model.domain.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.sbrf.hackaton.app.model.Session;

import java.util.List;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Data
@Document("user")
public class UserEntity {

    @Id
    private ObjectId id;

    @Indexed(name = "ix_user_login", unique = true)
    private String login;

    private String passwordHash;

    private List<Session> sessions;
}