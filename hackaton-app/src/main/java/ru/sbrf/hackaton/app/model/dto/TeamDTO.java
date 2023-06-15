package ru.sbrf.hackaton.app.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.sbrf.hackaton.app.model.User;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamDTO {
    String name;

    List<User> users;
}
