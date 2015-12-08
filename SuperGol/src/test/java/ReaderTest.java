import exceptions.UpdateGoalsFromFileFailure;
import model.Player;
import model.Reader;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ReaderTest {

    private File validCSV = new File("src/test/support/playersScore_OK.csv");
    private File invalidCSV = new File("src/test/support/playersScore_NO_OK.csv");

    @Test
    public void ACorrectCSVShouldBeReadWithoutExceptions() {
        Map<Player, Integer> result = readCSVUpdate(validCSV);
        assertEquals(5, result.size());
    }

    @Test(expected = UpdateGoalsFromFileFailure.class)
    public void exceptionExpectedWhenAnInvalidCSVIsRead() throws UpdateGoalsFromFileFailure {
        Reader.playersGoalsFromLastRound(invalidCSV);
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
