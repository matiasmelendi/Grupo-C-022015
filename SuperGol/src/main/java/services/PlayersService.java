package services;

import model.Player;
import repositories.PlayersRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/players")
public class PlayersService {

    private PlayersRepository repository;

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Player> all() {
        return repository.all();
    }

}
