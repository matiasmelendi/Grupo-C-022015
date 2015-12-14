import exceptions.FileHasNoHeaderID;
import exceptions.UpdateGoalsFromFileFailure;
import model.Player;
import model.Reader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ReaderTest {

    private File validCSV = new File("src/test/support/playersScore_OK.csv");
    private File invalidCSV = new File("src/test/support/playersScore_NO_OK.csv");
    private File emptyCSV = new File("src/test/support/playersScore_empty.csv");

    @Before
    public void setUp(){
        Reader.assignPlayersProvider(new PlayersProviderForTest());
    }

    @Test
    public void ACorrectCSVShouldBeReadWithoutExceptions() {
        Map<Player, Integer> result = readCSVUpdate(validCSV);
        assertEquals(5, result.size());
    }

    @Test(expected = UpdateGoalsFromFileFailure.class)
    public void exceptionExpectedWhenAnInvalidCSVIsRead() throws UpdateGoalsFromFileFailure {
        Reader.playersGoalsFromLastRound(invalidCSV);
    }

    @Test
    public void couldReturnTheHeaderIDOfAFile() throws IOException, FileHasNoHeaderID {
        assertEquals(Integer.valueOf(001), Reader.getHeaderID(validCSV));
    }

    @Test(expected = FileHasNoHeaderID.class)
    public void shouldFailWhenFileHasNoHeaderID() throws IOException, FileHasNoHeaderID {
        Reader.getHeaderID(emptyCSV);
    }

    private Map<Player, Integer> readCSVUpdate(File file) {
        Map<Player, Integer> result = new HashMap<Player, Integer>();
        try {
            result = Reader.playersGoalsFromLastRound(file);
        } catch (UpdateGoalsFromFileFailure exception) {
            fail();
        }
        return result;
    }

}
