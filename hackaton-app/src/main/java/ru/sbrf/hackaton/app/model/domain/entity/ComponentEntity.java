package ru.sbrf.hackaton.app.model.domain.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.sbrf.hackaton.app.model.Stack;

import java.util.Set;

@Document("component")
@Data
public class ComponentEntity {

    @Id
    ObjectId id;
    String name;
    String ci;
    String repoLink;
    Set<Enum<Stack>> stack;
}
