package ru.sbrf.hackaton.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sbrf.hackaton.app.model.domain.entity.ProductEntity;
import ru.sbrf.hackaton.app.model.dto.ProductDTO;

@Mapper(uses = {
        ComponentMapper.class,
        TeamMapper.class
})
public interface ProductMapper {

    @Mapping(target = "components", source = "productEntity.componentEntities")
    @Mapping(target = "products", source = "productEntity.productEntities")
    @Mapping(target = "teams", source = "productEntity.teamEntities")
    ProductDTO toProductDTO(ProductEntity productEntity);

    @Mapping(target = "componentEntities", source = "productDTO.components")
    @Mapping(target = "productEntities", source = "productDTO.products")
    @Mapping(target = "teamEntities", source = "productDTO.teams")
    ProductEntity toProductEntity(ProductDTO productDTO);
}
