package common.testDataBuilder;

import lombok.experimental.UtilityClass;
import org.bson.types.ObjectId;
import ru.sbrf.hackaton.app.model.Stack;
import ru.sbrf.hackaton.app.model.domain.entity.ComponentEntity;
import ru.sbrf.hackaton.app.model.dto.ComponentDTO;

import java.util.Set;

@UtilityClass
public class ComponentDataBuilder {

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
}
