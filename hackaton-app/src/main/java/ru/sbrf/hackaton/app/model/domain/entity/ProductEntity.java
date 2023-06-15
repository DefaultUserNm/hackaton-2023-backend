package ru.sbrf.hackaton.app.model.domain.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Set;

@Document("product")
@Data
public class ProductEntity {

    @Id
    ObjectId id;
    String name;
    @DocumentReference
    Set<ProductEntity> productEntities;
    @DocumentReference
    Set<ComponentEntity> componentEntities;
    // Set<Team> teams;
}
