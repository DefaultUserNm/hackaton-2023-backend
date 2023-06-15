package ru.sbrf.hackaton.app.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamDTO {

    ObjectId id;
    String name;
    List<UserDto> users;
}
