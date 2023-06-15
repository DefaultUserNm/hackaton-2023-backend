package it

import common.configuration.TestConfiguration
import common.configuration.bean.DbCleaner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.sbrf.hackaton.app.Application
import ru.sbrf.hackaton.app.model.User
import ru.sbrf.hackaton.app.model.domain.entity.TeamEntity
import ru.sbrf.hackaton.app.repository.TeamRepository
import spock.lang.Specification

@ActiveProfiles("TEST")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [
                Application,
                TestConfiguration
        ]
)
class TeamRepositoryTest extends Specification {
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
        TeamEntity expected = teamRepository.save(buildTeamEntity())

        when:
        TeamEntity actual = teamRepository.findByName(expected.getName()).get()

        then:
        actual == expected
    }

    private TeamEntity buildTeamEntity(){
        TeamEntity team = new TeamEntity()

        team.setName("UOV")
        team.setUsers(List.of(new User().setFirstName("NameHere")))

        team
    }

}
