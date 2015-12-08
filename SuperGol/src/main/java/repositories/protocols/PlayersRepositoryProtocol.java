package repositories.protocols;

import model.Player;

import java.util.List;

public interface PlayersRepositoryProtocol {

    List<Player> all();

    void delete(Double id);

    Player find(Double id);

}
