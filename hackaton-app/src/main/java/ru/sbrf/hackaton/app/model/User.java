package ru.sbrf.hackaton.app.model;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Data
public class User {
    private ObjectId id;
    private String login;
    private String passwordHash;
    private String lastName;
    private String firstName;
    private String middleName;
    private String phone;
    private String email;
    private List<Session> sessions;
}
