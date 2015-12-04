package repositories;

import model.Player;
import repositories.protocols.PlayersRepositoryProtocol;


public class PlayersRepository extends GenericRepository<Player> implements PlayersRepositoryProtocol {

    protected Class<Player> getDomainClass() {
        return Player.class;
    }

}
