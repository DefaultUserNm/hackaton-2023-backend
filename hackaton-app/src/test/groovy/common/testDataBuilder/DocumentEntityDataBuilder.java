package common.testDataBuilder;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;
import ru.sbrf.hackaton.app.model.domain.entity.DocumentEntity;

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
}
