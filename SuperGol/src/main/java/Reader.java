import com.opencsv.CSVReader;
import exceptions.UpdateGoalsFromFileFailure;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Reader {

    public static Map<Player, Integer> playersGoalsFromLastRound(File file) throws UpdateGoalsFromFileFailure {
        Map<Player, Integer> result = new HashMap<Player, Integer>();
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            Integer updateID = headerID(reader);
            addPlayerScore(result, reader);
        } catch (Exception exception) {
            throw new UpdateGoalsFromFileFailure();
        }
        return result;
    }

    private static void addPlayerScore(Map<Player, Integer> result, CSVReader reader) throws IOException {
        for (String[] currentLine : reader.readAll()) {
            result.put(playerById(playerIdFrom(currentLine)), goals(currentLine));
        }
    }

    private static Integer playerIdFrom(String[] line) {
        return Integer.valueOf(line[0]);
    }

    private static String position(String[] line) {
        return line[1];
    }

    private static Integer goals(String[] line) {
        return Integer.valueOf(line[2]);
    }

    private static Player playerById(Integer id) {
        // TODO: To implement with DAO Services.
        return new Player(id.toString(), null, null);
    }

    private static Integer headerID(CSVReader reader) throws IOException {
        String[] header = reader.readNext();
        return Integer.valueOf(header[0]);
    }

}
