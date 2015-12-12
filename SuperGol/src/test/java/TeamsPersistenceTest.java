import model.Team;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import repositories.TeamsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test/test-spring-persistence-context.xml" })
public class TeamsPersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTransactionManager transactionManager;

    @Autowired
    private TeamsRepository teamsRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Transactional
    public void testATeamCouldBeSaved() {
        Team team = new Team("Team test");

        teamsRepository.save(team);

        sessionFactory.getCurrentSession().flush();

        assertEquals(1, teamsOnDatabase().size());
        assertTrue(teamsOnDatabase().contains(team));
    }

    @Test
    @Transactional
    public void testATeamCouldBeRemoved() {
        Team team = new Team("Team test");
        teamsRepository.save(team);

        teamsRepository.delete(team.getId());

        sessionFactory.getCurrentSession().flush();

        assertEquals(0, teamsOnDatabase().size());
        assertFalse(teamsOnDatabase().contains(team));
    }

    @Test
    @Transactional
    public void testATeamCouldBeFound() {
        Team team = new Team("Team test");
        teamsRepository.save(team);
        sessionFactory.getCurrentSession().flush();

        Team storedTeam = teamsRepository.find(team.getId());

        assertEquals(team, storedTeam);
    }

    @Test
    @Transactional
    public void testATeamCouldBeUpdated() {
        Team team = new Team("Team test");
        teamsRepository.save(team);

        team.setName("Another team name");
        teamsRepository.update(team);

        sessionFactory.getCurrentSession().flush();
        Team storedTeam = teamsRepository.find(team.getId());

        assertEquals("Another team name", storedTeam.name());
    }

    private List<Team> teamsOnDatabase(){

        String query = "SELECT * FROM teams";

        List<Team> teams = new ArrayList<Team>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map row : rows) {
            Team team = new Team();
            team.setId((Double)(row.get("ID")));
            team.setName((String) row.get("NAME"));
            teams.add(team);
        }

        return teams;
    }
}
