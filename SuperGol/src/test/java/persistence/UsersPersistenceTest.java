package persistence;

import model.Team;
import model.User;
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
import repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test/test-spring-persistence-context.xml" })
public class UsersPersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTransactionManager transactionManager;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TeamsRepository teamsRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Transactional
    public void testAUserCouldBeSaved() {
        User user = new User("User test", "1234", new Team("Test team"));

        usersRepository.save(user);

        sessionFactory.getCurrentSession().flush();

        assertEquals(1, usersOnDatabase().size());
        assertTrue(usersOnDatabase().contains(user));
    }

    @Test
    @Transactional
    public void testAUserCouldBeRemoved() {
        User user = new User("User test", "1234", new Team("Test team"));
        usersRepository.save(user);

        usersRepository.delete(user.getId());

        sessionFactory.getCurrentSession().flush();

        assertEquals(0, usersOnDatabase().size());
        assertFalse(usersOnDatabase().contains(user));
    }

    @Test
    @Transactional
    public void testAUserCouldBeFound() {
        User user = new User("User test", "1234", new Team("Test team"));
        usersRepository.save(user);
        sessionFactory.getCurrentSession().flush();

        User storedUser = usersRepository.find(user.getId());

        assertEquals(user, storedUser);
    }

    @Test
    @Transactional
    public void testAUserCouldBeUpdated() {
        User user = new User("User test", "1234", new Team("Test team"));
        usersRepository.save(user);

        user.setUsername("Another username");
        usersRepository.update(user);

        sessionFactory.getCurrentSession().flush();
        User storedUser = usersRepository.find(user.getId());

        assertEquals("Another username", storedUser.username());
    }

    @Test(expected=org.springframework.dao.DuplicateKeyException.class)
    @Transactional
    public void testUsernameIsUnique(){
        User user1 = new User("User test", "1234", new Team("Test team"));
        User user2 = new User("User test", "1234", new Team("Test team"));

        usersRepository.save(user1);
        usersRepository.save(user2);
        sessionFactory.getCurrentSession().flush();
    }

    private List<User> usersOnDatabase(){

        String query = "SELECT * FROM users";

        List<User> users = new ArrayList<User>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map row : rows) {
            User user = new User();
            user.setId((Double)(row.get("ID")));
            user.setUsername((String) row.get("USERNAME"));
            user.setTeam(teamsRepository.find((Double) row.get("TEAM")));
            users.add(user);
        }

        return users;
    }
}
