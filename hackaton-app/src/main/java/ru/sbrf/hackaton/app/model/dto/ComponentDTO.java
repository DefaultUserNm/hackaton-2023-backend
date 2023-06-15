package ru.sbrf.hackaton.app.model.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import ru.sbrf.hackaton.app.model.Stack;

import java.util.Set;

@Data
public class ComponentDTO {

    ObjectId id;
    String name;
    String ci;
    String repoLink;
    Set<Stack> stack;
}
