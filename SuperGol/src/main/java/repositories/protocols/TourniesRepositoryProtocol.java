package repositories.protocols;

import model.Tourney;

import java.util.List;

public interface TourniesRepositoryProtocol {

    List<Tourney> all();

    Tourney getById(Integer id);
}
