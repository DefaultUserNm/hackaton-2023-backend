package ru.sbrf.hackaton.app.mapper;

import org.mapstruct.Mapper;
import ru.sbrf.hackaton.app.model.domain.entity.TeamEntity;
import ru.sbrf.hackaton.app.model.dto.TeamDTO;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Mapper
public interface TeamMapper {
    TeamDTO toDto(TeamEntity entity);
}