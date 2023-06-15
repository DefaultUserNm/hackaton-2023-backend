import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.sbrf.hackaton.app.Application
import spock.lang.Specification

/*
 * @created 15.06.2023
 * @author alexander
 */

@ActiveProfiles("TEST")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [
                Application
        ]
)
class ApplicationIT extends Specification {

    def "verify context starts"() {
        expect:
        true
    }
}
