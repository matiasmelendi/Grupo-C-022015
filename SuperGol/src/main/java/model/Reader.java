package model;

import com.opencsv.CSVReader;
import exceptions.FileHasNoHeaderID;
import exceptions.UpdateGoalsFromFileFailure;
import org.springframework.orm.hibernate3.HibernateTemplate;
import repositories.PlayersRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Reader {

    private static HibernateTemplate playersProvider;

    public static void assignPlayersProvider(HibernateTemplate provider){
        playersProvider = provider;
    }

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

    public static Integer getHeaderID(File file) throws IOException, FileHasNoHeaderID {
        CSVReader reader = new CSVReader(new FileReader(file));
        try{

            String[] header = reader.readNext();
            return Integer.valueOf(header[0]);

        } catch (NullPointerException e){
            throw new FileHasNoHeaderID();
        }
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

        return playersProvider.get(Player.class, id);
    }

    private static Integer headerID(CSVReader reader) throws IOException {
        String[] header = reader.readNext();
        return Integer.valueOf(header[0]);
    }

}
