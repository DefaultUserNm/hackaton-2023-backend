package ru.sbrf.hackaton.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sbrf.hackaton.app.model.domain.entity.TeamEntity;
import ru.sbrf.hackaton.app.model.dto.TeamDTO;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Mapper
public interface TeamMapper {

    @Mapping(target = "users", source = "entity.userEntities")
    TeamDTO toDto(TeamEntity entity);

    @Mapping(target = "userEntities", source = "dto.users")
    TeamEntity toEntity(TeamDTO dto);
}