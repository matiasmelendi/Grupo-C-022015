package persistence;

import model.Player;
import model.Position;
import model.Team;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import repositories.PlayersRepository;
import repositories.TeamsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test/test-spring-persistence-context.xml" })
public class PlayersPersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTransactionManager transactionManager;

    @Autowired
    private PlayersRepository playersRepository;

    @Autowired
    private TeamsRepository teamsRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Team dummyTeam;

    @Before
    public void setUp(){
        dummyTeam = new Team("Dummy Team");
        teamsRepository.save(dummyTeam);
    }

    @Test
    @Transactional
    public void testAPlayerCouldBeSaved() {
        Player player = new Player("Player test", Position.DEFENDER);

        playersRepository.save(player);

        sessionFactory.getCurrentSession().flush();

        assertEquals(1, playersOnDatabase().size());
        assertTrue(playersOnDatabase().contains(player));
    }

    @Test
    @Transactional
    public void testAPlayerCouldBeRemoved() {
        Player player = new Player("Player test", Position.DEFENDER);
        playersRepository.save(player);

        playersRepository.delete(player.getId());

        sessionFactory.getCurrentSession().flush();

        assertEquals(0, playersOnDatabase().size());
        assertFalse(playersOnDatabase().contains(player));
    }

    @Test
    @Transactional
    public void testAPlayerCouldBeFound() {
        Player player = new Player("Player test", Position.DEFENDER);
        playersRepository.save(player);
        sessionFactory.getCurrentSession().flush();

        Player storedPlayer = playersRepository.find(player.getId());

        assertEquals(player, storedPlayer);
    }

    @Test
    @Transactional
    public void testAPlayerCouldBeUpdated() {
        Player player = new Player("Player test", Position.DEFENDER);
        playersRepository.save(player);

        player.setName("Another player name");
        playersRepository.update(player);

        sessionFactory.getCurrentSession().flush();
        Player storedPlayer = playersRepository.find(player.getId());

        assertEquals("Another player name", storedPlayer.name());
    }

    private List<Player> playersOnDatabase(){

        String query = "SELECT * FROM players";

        List<Player> players = new ArrayList<Player>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map row : rows) {
            Player player = new Player();
            player.setId((Integer)(row.get("ID")));
            player.setName((String) row.get("NAME"));
            player.setPosition(Position.valueOf((Integer)row.get("POSITION")));
            player.setCaptain((Boolean) row.get("CAPTAIN"));

            players.add(player);
        }

        return players;
    }


}
