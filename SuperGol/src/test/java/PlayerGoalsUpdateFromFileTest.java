import exceptions.CouldNotUpdateAPreviousRound;
import exceptions.FileHasNoHeaderID;
import exceptions.UpdateGoalsFromFileFailure;
import model.PlayerGoalsUpdateFromFile;
import model.Reader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class PlayerGoalsUpdateFromFileTest {

    private File invalidFile = new File("src/test/support/playersScore_NO_OK.csv");
    private File validFile = new File("src/test/support/playersScore_OK.csv");
    private File emptyFile = new File("src/test/support/playersScore_empty.csv");

    @Before
    public void setUp(){
        Reader.assignPlayersProvider(new PlayersProviderForTest());
    }


    @Test(expected = UpdateGoalsFromFileFailure.class)
    public void couldNotUpdateARoundWithAFileThatWasUsedPreviously() throws UpdateGoalsFromFileFailure, CouldNotUpdateAPreviousRound, FileHasNoHeaderID {
        new PlayerGoalsUpdateFromFile(validFile, 0, 1, 001);
    }

    @Test(expected = FileHasNoHeaderID.class)
    public void couldNotUpdateARoundWithAFileThatHasNoHeaderID() throws UpdateGoalsFromFileFailure, CouldNotUpdateAPreviousRound, FileHasNoHeaderID {
        new PlayerGoalsUpdateFromFile(emptyFile, 0, 1, 000);
    }

    @Test(expected = UpdateGoalsFromFileFailure.class)
    public void shouldFailWhenTryingToUpdateAValidRoundWithAnInvalidFile() throws UpdateGoalsFromFileFailure, CouldNotUpdateAPreviousRound, FileHasNoHeaderID {
        new PlayerGoalsUpdateFromFile(invalidFile, 0, 1, 000);
    }

    @Test(expected = CouldNotUpdateAPreviousRound.class)
    public void shouldFailWhenTryingToUpdateAPreviousRound() throws UpdateGoalsFromFileFailure, CouldNotUpdateAPreviousRound, FileHasNoHeaderID {
        new PlayerGoalsUpdateFromFile(validFile, 1, 0, 000);
    }

    @Test(expected = CouldNotUpdateAPreviousRound.class)
    public void aRoundCouldNotBeUpdatedTwice() throws UpdateGoalsFromFileFailure, CouldNotUpdateAPreviousRound, FileHasNoHeaderID {
        new PlayerGoalsUpdateFromFile(validFile, 1, 1, 000);
    }

    @Test
    public void shouldNotFailWhenTryingToUpdateAValidRoundWithAValidFile() throws UpdateGoalsFromFileFailure, CouldNotUpdateAPreviousRound, FileHasNoHeaderID {
        new PlayerGoalsUpdateFromFile(validFile, 0, 1, 000);
    }
}
