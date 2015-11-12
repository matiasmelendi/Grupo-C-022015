package services;

import model.Player;
import repositories.PlayersRepository;
import services.protocols.PlayersServiceProtocol;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.jws.WebService;
import java.util.List;

@Path("/players")
@Produces("application/json")
@WebService(endpointInterface = "services.protocols.PlayersServiceProtocol")
public class PlayersService implements PlayersServiceProtocol {

    private PlayersRepository repository;

    public PlayersService(){
        this.repository = new PlayersRepository();
    }

    @GET
    @Path("/all")
    public List<Player> all() {
        return repository.all();
    }

    public PlayersRepository getRepository() {
        return repository;
    }

    public void setRepository(PlayersRepository repository) {
        this.repository = repository;
    }

}
