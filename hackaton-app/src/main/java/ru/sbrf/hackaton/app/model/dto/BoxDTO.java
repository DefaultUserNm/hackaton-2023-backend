package ru.sbrf.hackaton.app.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.sbrf.hackaton.app.model.type.BoxType;

import java.util.List;
import org.bson.types.ObjectId;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoxDTO {
    ObjectId id;
    String title;

    String description;

    BoxType type;

    List<ObjectId> cid;
}
