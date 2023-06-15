package ru.sbrf.hackaton.app.model.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("document")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocumentEntity {

    @Id
    ObjectId id;

    String title;
    String text;
    String attach;
    String author;
    Long dataTime;
}
