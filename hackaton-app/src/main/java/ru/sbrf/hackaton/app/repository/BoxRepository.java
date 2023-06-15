package ru.sbrf.hackaton.app.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.sbrf.hackaton.app.model.domain.entity.BoxEntity;

public interface BoxRepository extends MongoRepository<BoxEntity, String> {

    @Query("{id: '?0'}")
    BoxEntity findBoxEntitiesById(ObjectId id);

    @Query("{title:'?0'}")
    BoxEntity findBoxByTitle(String title);
}
