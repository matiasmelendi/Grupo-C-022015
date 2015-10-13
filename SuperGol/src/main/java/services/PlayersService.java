package services;

import model.Player;
import repositories.PlayersRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/players")
@Produces("application/json")
public class PlayersService {

    private PlayersRepository repository;

    public PlayersService(){
        this.repository = new PlayersRepository();
    }

    @GET
    @Path("/all")
    public List<Player> all() {
        return repository.all();
    }

}
