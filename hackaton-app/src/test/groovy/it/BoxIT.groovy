package it

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.sbrf.hackaton.app.Application
import ru.sbrf.hackaton.app.model.domain.entity.BoxEntity
import ru.sbrf.hackaton.app.model.type.BoxType
import ru.sbrf.hackaton.app.repository.BoxRepository
import spock.lang.Specification

@ActiveProfiles("TEST")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [Application]
)
class BoxIT extends Specification {
    @Autowired
    BoxRepository boxRepository

    def"Test #findByTitle(1). When save boxEntity then must find by title"(){
        given:
        BoxEntity expected = boxRepository.save(buildBoxEntity())

        when:
        BoxEntity actual = boxRepository.findBoxByTitle(expected.getTitle())

        then:
        actual == expected
    }

    private BoxEntity buildBoxEntity(){
        BoxEntity box1 = new BoxEntity()
        box1.setType(BoxType.CUSTOM)
        box1.setTitle("title of the box")
        box1.setDescription("some description")

        return box1
    }

}
