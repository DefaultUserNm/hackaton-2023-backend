package ru.sbrf.hackaton.app.mapper;

import org.mapstruct.Mapper;
import ru.sbrf.hackaton.app.model.User;
import ru.sbrf.hackaton.app.model.domain.entity.UserEntity;
import ru.sbrf.hackaton.app.model.dto.UserDto;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Mapper
public interface UserMapper {
    User toUser(UserEntity entity);

    User toUser(UserDto userDto);

    UserEntity toEntity(User user);

    UserDto toDto(User user);
}