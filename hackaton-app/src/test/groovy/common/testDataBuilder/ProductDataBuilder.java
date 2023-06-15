package common.testDataBuilder;

import lombok.experimental.UtilityClass;
import org.bson.types.ObjectId;
import ru.sbrf.hackaton.app.model.domain.entity.ProductEntity;
import ru.sbrf.hackaton.app.model.dto.ComponentDTO;
import ru.sbrf.hackaton.app.model.dto.ProductDTO;
import ru.sbrf.hackaton.app.model.dto.TeamDTO;

import java.util.Collections;
import java.util.Set;

import static common.testDataBuilder.ComponentDataBuilder.buildComponentEntity;

@UtilityClass
public class ProductDataBuilder {

    public static ProductEntity buildProductEntity() {
        return new ProductEntity()
                .setId(new ObjectId())
                .setName("TEST")
                .setComponentEntities(Set.of(buildComponentEntity()))
                .setProductEntities(Collections.emptySet())
                .setTeamEntities(Collections.emptySet());
    }

    public static ProductDTO buildProductDTO(ObjectId productId,
                                             Set<ComponentDTO> components,
                                             Set<ProductDTO> products,
                                             Set<TeamDTO> teams) {
        return new ProductDTO()
                .setId(productId)
                .setName("TEST")
                .setComponents(components)
                .setProducts(products)
                .setTeams(teams);
    }
}
