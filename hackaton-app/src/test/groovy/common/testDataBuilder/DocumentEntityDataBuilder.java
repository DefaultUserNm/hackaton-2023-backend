package common.testDataBuilder;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.bson.types.ObjectId;
import ru.sbrf.hackaton.app.model.Stack;
import ru.sbrf.hackaton.app.model.domain.entity.ComponentEntity;
import ru.sbrf.hackaton.app.model.domain.entity.DocumentEntity;
import ru.sbrf.hackaton.app.model.domain.entity.ProductEntity;
import ru.sbrf.hackaton.app.model.dto.ComponentDTO;
import ru.sbrf.hackaton.app.model.dto.ProductDTO;

import java.util.Collections;
import java.util.Set;

@UtilityClass
public class DocumentEntityDataBuilder {

    public static DocumentEntity buildDocumentEntity() {
        return new DocumentEntity()
                .setTitle("big title")
                .setText("big text")
                .setAttach(RandomStringUtils.random(1000))
                .setAuthor("User 1")
                .setDataTime(System.currentTimeMillis());
    }

    public static ComponentEntity buildComponentEntity() {
        return new ComponentEntity()
                .setCi("CI19191919")
                .setId(new ObjectId())
                .setName("TEST")
                .setRepoLink("REPO")
                .setStack(Set.of(Stack.GIT, Stack.BASH));
    }

    public static ComponentDTO buildComponentDTO(ObjectId id) {
        return new ComponentDTO()
                .setId(id)
                .setCi("CI19191919")
                .setName("TEST")
                .setRepoLink("REPO")
                .setStack(Set.of(Stack.GIT, Stack.BASH));
    }

    public static ProductEntity buildProductEntity() {
        return new ProductEntity()
                .setId(new ObjectId())
                .setName("TEST")
                .setComponentEntities(Set.of(buildComponentEntity()))
                .setProductEntities(Collections.emptySet());
    }

    public static ProductDTO buildProductDTO(ObjectId productId,
                                             Set<ComponentDTO> components,
                                             Set<ProductDTO> products) {
        return new ProductDTO()
                .setId(productId)
                .setName("TEST")
                .setComponents(components)
                .setProducts(products);
    }
}
