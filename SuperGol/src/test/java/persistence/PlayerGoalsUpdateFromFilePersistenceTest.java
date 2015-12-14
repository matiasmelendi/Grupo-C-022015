package persistence;

import exceptions.CouldNotUpdateAPreviousRound;
import exceptions.FileHasNoHeaderID;
import exceptions.UpdateGoalsFromFileFailure;
import model.PlayerGoalsUpdateFromFile;
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
import repositories.PlayerGoalsUpdateFromFileRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test/test-spring-persistence-context.xml" })
public class PlayerGoalsUpdateFromFilePersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTransactionManager transactionManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlayerGoalsUpdateFromFileRepository playerGoalsUpdateFromFileRepository;

    @Test
    @Transactional
    public void testATourneyCouldBeUpdatedFromAFile() throws CouldNotUpdateAPreviousRound, UpdateGoalsFromFileFailure, FileHasNoHeaderID {
        this.updateARound();

        assertEquals(1, roundUpdatesOnDatabase().size());
    }

    @Test
    @Transactional
    public void testATourneyCouldBeUpdatedFromAFileWhenHavingPreviousUpdates() throws CouldNotUpdateAPreviousRound, UpdateGoalsFromFileFailure, FileHasNoHeaderID {
        File anotherValidCSVFile = new File("src/test/support/anotherPlayersScore_OK.csv");
        File anotherValidCSVFile2 = new File("src/test/support/anotherPlayersScore_OK_2.csv");

        playerGoalsUpdateFromFileRepository.updateRoundFromCSV(anotherValidCSVFile);
        playerGoalsUpdateFromFileRepository.updateRoundFromCSV(anotherValidCSVFile2);

        assertEquals(2, roundUpdatesOnDatabase().size());
    }


    private List<PlayerGoalsUpdateFromFile> roundUpdatesOnDatabase(){
        String query = "SELECT * FROM player_goals_update_from_file";

        List<PlayerGoalsUpdateFromFile> roundUpdates = new ArrayList<PlayerGoalsUpdateFromFile>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map row : rows) {
            PlayerGoalsUpdateFromFile roundUpdate = new PlayerGoalsUpdateFromFile();
            roundUpdate.setId((Integer)(row.get("ID")));
            roundUpdate.setHeaderFileIdentifier((Integer) (row.get("headerFileIdentifier")));
            roundUpdate.setLastUpdatedRound((Integer) (row.get("lastUpdatedRound")));
            roundUpdate.setRoundToBeUpdated((Integer) (row.get("roundToBeUpdated")));
            roundUpdates.add(roundUpdate);
        }

        return roundUpdates;
    }

    private void updateARound() throws CouldNotUpdateAPreviousRound, UpdateGoalsFromFileFailure, FileHasNoHeaderID {
        File validCSVFile = new File("src/test/support/playersScore_OK.csv");
        playerGoalsUpdateFromFileRepository.updateRoundFromCSV(validCSVFile);
    }

}
