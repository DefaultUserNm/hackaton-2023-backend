package it

import common.configuration.TestConfiguration
import common.configuration.bean.DbCleaner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.sbrf.hackaton.app.Application
import ru.sbrf.hackaton.app.model.domain.entity.DocumentEntity
import ru.sbrf.hackaton.app.repository.DocumentRepository
import spock.lang.Specification

import static common.testDataBuilder.DocumentEntityDataBuilder.buildDocumentEntity

@ActiveProfiles("TEST")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [
                Application,
                TestConfiguration
        ]
)
class DocumentRepositoryIT extends Specification {

    @Autowired
    DocumentRepository documentRepository
    @Autowired
    DbCleaner dbCleaner

    def cleanup() {
        dbCleaner.cleanDb()
    }

    def "Test #findById(1). When save documentEntity then must find by id"() {
        given:
        DocumentEntity expected = documentRepository.save(buildDocumentEntity())

        when:
        DocumentEntity actual = documentRepository.findById(expected.getId()).get()

        then:
        actual == expected
    }

    def "Test #findById(1). When save documentEntity then must find by author"() {
        given:
        DocumentEntity expected = documentRepository.save(buildDocumentEntity())

        when:
        DocumentEntity actual = documentRepository.findByAuthor(expected.getAuthor()).get(0)

        then:
        actual == expected
    }
}
