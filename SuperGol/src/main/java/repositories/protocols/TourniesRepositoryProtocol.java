package repositories.protocols;

import model.Fixture;
import model.Tourney;

import java.util.List;

public interface TourniesRepositoryProtocol {

    List<Tourney> all();

    Tourney find(Double id);

    Fixture rankingForATourney(Double id);
}
