package repositories.protocols;

import model.Team;
import model.Tourney;

import java.util.List;

public interface TourniesRepositoryProtocol {

    List<Tourney> all();

    Tourney find(Integer id);

    List<Team> rankingForATourney(Integer id);
}
