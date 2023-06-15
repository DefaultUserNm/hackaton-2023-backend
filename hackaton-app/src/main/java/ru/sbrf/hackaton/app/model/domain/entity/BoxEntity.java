package ru.sbrf.hackaton.app.model.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.sbrf.hackaton.app.model.type.BoxType;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoxEntity {
    @Id
    ObjectId id;

    String title;

    String description;

    BoxType type;

    List<ObjectId> cid;
}
