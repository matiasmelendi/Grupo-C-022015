package fixtures;

import model.Player;
import model.Position;
import model.Team;

import java.util.ArrayList;
import java.util.List;

public class PlayersFixture {

    public static List<Player> createPlayers() {
        List<Player> players = new ArrayList<Player>();
        Team pepeTeam = new Team("Pepe's Team");

        players.add(new Player("Pepe", Position.GOALKEEPER, pepeTeam));
        players.add(new Player("Pepe", Position.DEFENDER, pepeTeam));
        players.add(new Player("Pepe", Position.DEFENDER, pepeTeam));
        players.add(new Player("Pepe", Position.DEFENDER, pepeTeam));
        players.add(new Player("Pepe", Position.DEFENDER, pepeTeam));
        players.add(new Player("Pepe", Position.MIDFIELDER, pepeTeam));
        players.add(new Player("Pepe", Position.MIDFIELDER, pepeTeam));
        players.add(new Player("Pepe", Position.MIDFIELDER, pepeTeam));
        players.add(new Player("Pepe", Position.MIDFIELDER, pepeTeam));
        players.add(new Player("Pepe", Position.FORWARD, pepeTeam));
        players.add(new Player("Pepe", Position.FORWARD, pepeTeam));

        return players;
    }
}
