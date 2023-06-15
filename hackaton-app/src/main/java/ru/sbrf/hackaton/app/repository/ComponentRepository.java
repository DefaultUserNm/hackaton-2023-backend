package ru.sbrf.hackaton.app.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sbrf.hackaton.app.model.domain.entity.ComponentEntity;

public interface ComponentRepository extends MongoRepository<ComponentEntity, ObjectId> {
}
