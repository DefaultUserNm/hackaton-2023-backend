package ru.sbrf.hackaton.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sbrf.hackaton.app.model.domain.entity.ProductEntity;
import ru.sbrf.hackaton.app.model.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "componentDTOs", source = "componentEntities")
    ProductDTO toProductDTO(ProductEntity productEntity);
}
