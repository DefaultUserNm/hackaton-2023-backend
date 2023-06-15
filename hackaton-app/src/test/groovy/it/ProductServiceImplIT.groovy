package it

import common.configuration.TestConfiguration
import common.configuration.bean.DbCleaner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.sbrf.hackaton.app.Application
import ru.sbrf.hackaton.app.mapper.ComponentMapper
import ru.sbrf.hackaton.app.mapper.ProductMapper
import ru.sbrf.hackaton.app.model.domain.entity.ProductEntity
import ru.sbrf.hackaton.app.model.dto.ProductDTO
import ru.sbrf.hackaton.app.repository.ComponentRepository
import ru.sbrf.hackaton.app.repository.ProductRepository
import ru.sbrf.hackaton.app.service.impl.ProductServiceImpl
import spock.lang.Specification

import static common.testDataBuilder.ProductDataBuilder.buildProductEntity

@ActiveProfiles("TEST")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [
                Application,
                TestConfiguration
        ]
)
class ProductServiceImplIT extends Specification {

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

    def "Test getProduct productId (1). When try to get product by id then expect product dto "() {
        given:
        ProductEntity expectedProductEntity = buildProductEntity()
        componentRepository.saveAll(expectedProductEntity.componentEntities)
        productRepository.save(expectedProductEntity)

        when:
        ProductDTO actualProductDTO = productServiceImpl.getProduct(expectedProductEntity.id)

        then:
        actualProductDTO == productMapper.toProductDTO(expectedProductEntity)
    }

    def "Test saveProduct productDTO (1). When try to get product by id then expect product dto "() {
        given:
        ProductEntity embeddedProductEntity = buildProductEntity()
        ProductDTO expectedProductDTO = productMapper.toProductDTO(
                buildProductEntity().setProductEntities(Set.of(embeddedProductEntity))
        )

        when:
        productServiceImpl.saveProduct(expectedProductDTO)

        and:
        ProductDTO actualProductDTO = productServiceImpl.getProduct(expectedProductDTO.id)

        then:
        actualProductDTO == expectedProductDTO
    }
}
