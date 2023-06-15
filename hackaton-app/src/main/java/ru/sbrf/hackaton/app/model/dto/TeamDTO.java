package ru.sbrf.hackaton.app.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamDTO {
    String name;

    List<UserDto> users;
}
