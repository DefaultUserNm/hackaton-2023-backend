package it

import common.configuration.TestConfiguration
import common.configuration.bean.DbCleaner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.sbrf.hackaton.app.Application
import ru.sbrf.hackaton.app.mapper.ComponentMapper
import ru.sbrf.hackaton.app.mapper.ProductMapper
import ru.sbrf.hackaton.app.model.domain.entity.DocumentEntity
import ru.sbrf.hackaton.app.model.domain.entity.ProductEntity
import ru.sbrf.hackaton.app.model.dto.ComponentDTO
import ru.sbrf.hackaton.app.model.dto.ProductDTO
import ru.sbrf.hackaton.app.repository.ComponentRepository
import ru.sbrf.hackaton.app.repository.DocumentRepository
import ru.sbrf.hackaton.app.repository.ProductRepository
import ru.sbrf.hackaton.app.service.ProductService
import ru.sbrf.hackaton.app.service.impl.ProductServiceImpl
import spock.lang.Specification

import static common.testDataBuilder.DocumentEntityDataBuilder.buildComponentDTO
import static common.testDataBuilder.DocumentEntityDataBuilder.buildDocumentEntity
import static common.testDataBuilder.DocumentEntityDataBuilder.buildProductDTO
import static common.testDataBuilder.DocumentEntityDataBuilder.buildProductEntity

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
    ComponentRepository componentRepository
    @Autowired
    ProductRepository productRepository
    @Autowired
    ProductServiceImpl productServiceImpl
    @Autowired
    ProductMapper productMapper
    @Autowired
    ComponentMapper componentMapper
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

    def "Test getProduct (1) "() {
        given:
        ProductEntity productEntity = buildProductEntity()
        componentRepository.saveAll(productEntity.componentEntities)
        productRepository.save(productEntity)

        when:
        ProductDTO actual = productServiceImpl.getProduct(productEntity.id)

        then:
        actual == productMapper.toProductDTO(productEntity)
    }
}
