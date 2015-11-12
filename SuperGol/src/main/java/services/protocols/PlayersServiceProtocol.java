package services.protocols;

import model.Player;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface PlayersServiceProtocol {

    List<Player> all();

}
