package common.configuration.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbrf.hackaton.app.repository.ComponentRepository;
import ru.sbrf.hackaton.app.repository.DocumentRepository;
import ru.sbrf.hackaton.app.repository.ProductRepository;
import ru.sbrf.hackaton.app.repository.TeamRepository;

@Component
public class DbCleaner {

    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    ComponentRepository componentRepository;
    @Autowired
    ProductRepository productRepository;

    public void cleanDb() {
        documentRepository.deleteAll();
        teamRepository.deleteAll();
        componentRepository.deleteAll();
        productRepository.deleteAll();
    }
}
