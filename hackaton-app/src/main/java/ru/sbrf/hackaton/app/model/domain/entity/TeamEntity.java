package ru.sbrf.hackaton.app.model.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Document("team")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamEntity {

    @Id
    ObjectId id;
    String name;
    @DocumentReference
    List<UserEntity> userEntities;
}
