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
import repositories.TourniesRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test/test-spring-persistence-context.xml"})
public class PlayerGoalsUpdateFromFilePersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTransactionManager transactionManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlayerGoalsUpdateFromFileRepository playerGoalsUpdateFromFileRepository;

    @Autowired
    private TourniesRepository tourneyRepository;

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
        createDummyTeamWithPlayersForDummyTourney();

        playerGoalsUpdateFromFileRepository.updateRoundFromCSV(1, anotherValidCSVFile);
        playerGoalsUpdateFromFileRepository.updateRoundFromCSV(1, anotherValidCSVFile2);

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
        this.createDummyTourney();
        File validCSVFile = new File("src/test/support/playersScore_OK.csv");
        playerGoalsUpdateFromFileRepository.updateRoundFromCSV(1, validCSVFile);
    }

    private void createDummyTourney(){
        jdbcTemplate.execute("INSERT INTO tournies(ID, name, minNumberOfTeams, maxNumberOfTeams) VALUES (1, 'Champions League', 2, 16)");
    }

    private void createDummyTeamWithPlayersForDummyTourney(){
        this.createDummyTourney();
        jdbcTemplate.execute("INSERT INTO formations(ID) VALUES (1)\n" +
                "INSERT INTO teams(ID, name, formation) VALUES (1, 'Pepes Team 1', 1)\n" +
                "INSERT INTO teams(ID, name, formation) VALUES (2, 'Pepes Team 2', 1)\n" +
                "INSERT INTO tourney_teams(tourney_id, index, team_id) VALUES (1, 0, 1)\n" +
                "INSERT INTO tourney_teams(tourney_id, index, team_id) VALUES (1, 1, 2)\n" +
                "INSERT INTO players(ID, name, captain, position, team) VALUES (1, 'Pepe 1', false, 1, 1)\n" +
                "INSERT INTO players(ID, name, captain, position, team) VALUES (2, 'Pepe 2', false, 2, 1)\n" +
                "INSERT INTO players(ID, name, captain, position, team) VALUES (3, 'Pepe 3', false, 2, 1)\n" +
                "INSERT INTO players(ID, name, captain, position, team) VALUES (4, 'Pepe 4', false, 2, 1)\n" +
                "INSERT INTO players(ID, name, captain, position, team) VALUES (5, 'Pepe 5', false, 3, 1)\n" +
                "INSERT INTO players(ID, name, captain, position, team) VALUES (6, 'Pepe 6', false, 3, 1)\n" +
                "INSERT INTO players(ID, name, captain, position, team) VALUES (7, 'Pepe 7', true, 3, 1)\n" +
                "INSERT INTO players(ID, name, captain, position, team) VALUES (14, 'Pepe 14', true, 3, 2)\n" +
                "INSERT INTO formation_players(formation_id, index, player_id) VALUES (1, 0, 1)\n" +
                "INSERT INTO formation_players(formation_id, index, player_id) VALUES (1, 1, 2)\n" +
                "INSERT INTO allowed_players(formation_id, position, number_of_allowed_players_by_position) VALUES (1, 0, 1)\n" +
                "INSERT INTO allowed_players(formation_id, position, number_of_allowed_players_by_position) VALUES (1, 1, 4)\n" +
                "INSERT INTO allowed_players(formation_id, position, number_of_allowed_players_by_position) VALUES (1, 2, 3)\n" +
                "INSERT INTO allowed_players(formation_id, position, number_of_allowed_players_by_position) VALUES (1, 3, 3)\n" +
                "INSERT INTO matches(ID, matchResultSet) VALUES (1, true)\n" +
                "INSERT INTO match_results(ID, localPoints, awayPoints, match_id, team_id) VALUES (1, 0, 0, 1, 1)\n" +
                "INSERT INTO match_results(ID, localPoints, awayPoints, match_id, team_id) VALUES (2, 0, 0, 1, 2)\n" +
                "INSERT INTO local_scorers(match_result_id, index, player_id) VALUES (1, 0, 1)\n" +
                "INSERT INTO away_scorers(match_result_id, index, player_id) VALUES (1, 0, 2)\n" +
                "INSERT INTO rounds(ID, number, halfTourney) VALUES (1, 0, 0)\n" +
                "INSERT INTO round_matches(round_id, index, match_id) VALUES (1, 0, 1)\n" +
                "INSERT INTO round_teams(round_id, index, team_id) VALUES (1, 0, 1)\n" +
                "INSERT INTO round_teams(round_id, index, team_id) VALUES (1, 1, 2)\n" +
                "INSERT INTO users(ID, username, password, team) VALUES (1, 'Pepito 1', '1234', 1)\n" +
                "INSERT INTO users(ID, username, password, team) VALUES (2, 'Pepito 2', '1234', 2)\n" +
                "INSERT INTO tourney_scores(user_id, tourney_id, points) VALUES (1, 1, 0)\n" +
                "INSERT INTO tourney_scores(user_id, tourney_id, points) VALUES (2, 1, 0)\n");
    }

}
