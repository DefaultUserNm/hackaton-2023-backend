package common.configuration.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbrf.hackaton.app.repository.DocumentRepository;

@Component
public class DbCleaner {

    @Autowired
    DocumentRepository documentRepository;

    public void cleanDb() {
        documentRepository.deleteAll();
    }
}
