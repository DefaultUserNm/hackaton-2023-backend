package ru.sbrf.hackaton.app.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.sbrf.hackaton.app.model.domain.entity.UserEntity;

import java.util.Optional;

/*
 * @created 15.06.2023
 * @author alexander
 */
public interface UserRepository extends MongoRepository<UserEntity, ObjectId> {
    @Query("{'sessions._id': ?0, 'sessions.expireDate': {$gt: ?1}}")
    Optional<UserEntity> findBySessionId(String sessionId, Long expireDate);

    Optional<UserEntity> findByLogin(String login);
}