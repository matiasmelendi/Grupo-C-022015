package persistence;

import model.SuperGol;
import model.Team;
import model.Tourney;
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
import repositories.TourniesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test/test-spring-persistence-context.xml" })
public class TourniesPersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTransactionManager transactionManager;

    @Autowired
    private TourniesRepository tourniesRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    @Transactional
    public void testATourneyCouldBeSaved() {
        Tourney tourney = new Tourney("Tourney test", 0, 4);

        tourniesRepository.save(tourney);

        sessionFactory.getCurrentSession().flush();

        assertEquals(1, tourniesOnDatabase().size());
        assertTrue(tourniesOnDatabase().contains(tourney));
    }

    @Test
    @Transactional
    public void testATourneyCouldBeRemoved() {
        Tourney tourney = new Tourney("Tourney test", 0, 4);
        tourniesRepository.save(tourney);

        tourniesRepository.delete(tourney.getId());

        sessionFactory.getCurrentSession().flush();

        assertEquals(0, tourniesOnDatabase().size());
        assertFalse(tourniesOnDatabase().contains(tourney));
    }

    @Test
    @Transactional
    public void testATourneyCouldBeFound() {
        Tourney tourney = new Tourney("Tourney test", 0, 4);
        tourniesRepository.save(tourney);
        sessionFactory.getCurrentSession().flush();

        Tourney storedTourney = tourniesRepository.find(tourney.getId());

        assertEquals(tourney, storedTourney);
    }

    @Test
    @Transactional
    public void testATourneyCouldBeUpdated() {
        Tourney tourney = new Tourney("Tourney test", 0, 4);
        tourniesRepository.save(tourney);

        tourney.setName("Another tourney name");
        tourniesRepository.update(tourney);

        sessionFactory.getCurrentSession().flush();
        Tourney storedTourney = tourniesRepository.find(tourney.getId());

        assertEquals("Another tourney name", storedTourney.name());
    }

    @Test
    @Transactional
    public void testATourneyCouldReturnYourFixture() {
        SuperGol game = new SuperGol();
        Tourney tourney = new Tourney("Tourney test", 0, 4);
        tourniesRepository.save(tourney);

        List<Team> generatedRankingFromDB = tourniesRepository.rankingForATourney(tourney.getId());

        sessionFactory.getCurrentSession().flush();

        assertEquals(game.rankingFor(tourney), generatedRankingFromDB);
    }

    private List<Tourney> tourniesOnDatabase(){

        String query = "SELECT * FROM tournies";

        List<Tourney> tournies = new ArrayList<Tourney>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map row : rows) {
            Tourney tourney = new Tourney();
            tourney.setId((Integer)(row.get("ID")));
            tourney.setName((String) row.get("NAME"));
            tourney.setMinNumberOfTeams((Integer) row.get("minNumberOfTeams"));
            tourney.setMaxNumberOfTeams((Integer) row.get("maxNumberOfTeams"));

            tournies.add(tourney);
        }

        return tournies;
    }

}
