package it

import common.configuration.TestConfiguration
import common.configuration.bean.DbCleaner
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.sbrf.hackaton.app.Application
import ru.sbrf.hackaton.app.model.domain.entity.TeamEntity
import ru.sbrf.hackaton.app.model.domain.entity.UserEntity
import ru.sbrf.hackaton.app.repository.TeamRepository
import ru.sbrf.hackaton.app.repository.UserRepository
import spock.lang.Ignore
import spock.lang.Specification

@ActiveProfiles("TEST")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [
                Application,
                TestConfiguration
        ]
)
@Ignore
class TeamRepositoryIT extends Specification {

    @Autowired
    UserRepository userRepository
    @Autowired
    TeamRepository teamRepository
    @Autowired
    DbCleaner dbCleaner

    def cleanup() {
        dbCleaner.cleanDb()
    }

    def "Test #findById(1). When save teamEntity then must find by id"() {
        given:
        TeamEntity expected = teamRepository.save(buildTeamEntity())

        when:
        TeamEntity actual = teamRepository.findById(expected.getId()).get()

        then:
        actual == expected
    }

    def "FindByName"() {
        given:
        TeamEntity te = buildTeamEntity()
        userRepository.saveAll(te.userEntities)
        TeamEntity expected = teamRepository.save(te)

        when:
        TeamEntity actual = teamRepository.findByName(expected.getName()).get()

        then:
        actual == expected
    }

    private TeamEntity buildTeamEntity(){
        TeamEntity team = new TeamEntity()

        team.setId(new ObjectId())
        team.setName("UOV")
        team.setUserEntities(List.of(new UserEntity().setId(new ObjectId())))

        team
    }

}
