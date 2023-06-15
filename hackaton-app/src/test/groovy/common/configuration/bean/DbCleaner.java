package common.configuration.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbrf.hackaton.app.repository.DocumentRepository;
import ru.sbrf.hackaton.app.repository.TeamRepository;

@Component
public class DbCleaner {

    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    TeamRepository teamRepository;

    public void cleanDb() {
        documentRepository.deleteAll();
        teamRepository.deleteAll();
    }
}
