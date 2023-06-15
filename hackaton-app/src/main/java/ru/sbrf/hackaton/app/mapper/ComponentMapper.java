package ru.sbrf.hackaton.app.mapper;

import org.mapstruct.Mapper;
import ru.sbrf.hackaton.app.model.domain.entity.ComponentEntity;
import ru.sbrf.hackaton.app.model.dto.ComponentDTO;

@Mapper
public interface ComponentMapper {

    ComponentDTO toComponentDTO(ComponentEntity componentEntity);
    ComponentEntity toComponentEntity(ComponentDTO componentDTO);
}
