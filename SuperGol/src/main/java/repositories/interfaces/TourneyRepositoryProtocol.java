package repositories.interfaces;

import model.Tourney;

import java.util.List;

public interface TourneyRepositoryProtocol {

    List<Tourney> all();

    Tourney getById(Integer id);
}
