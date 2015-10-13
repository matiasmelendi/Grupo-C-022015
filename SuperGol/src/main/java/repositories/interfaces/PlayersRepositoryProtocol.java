package repositories.interfaces;

import model.Player;

import java.util.List;

public interface PlayersRepositoryProtocol {

    List<Player> all();

    void delete(Integer id);

    Player find(Integer id);

}
