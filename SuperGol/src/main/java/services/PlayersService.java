package services;

import model.Player;
import repositories.PlayersRepository;

import javax.ws.rs.*;
import java.util.List;

@Path("/players")
public class PlayersService {

    private PlayersRepository repository;

    public PlayersService(){
        this.repository = new PlayersRepository();
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Player> all() {
        return this.repository.all();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Player find(@PathParam("id") Integer id) {
        return this.repository.find(id);
    }

    //*******************************************************
    //           Only used by spring only
    //*******************************************************

    public PlayersRepository getRepository() {
        return repository;
    }

    public void setRepository(PlayersRepository repository) {
        this.repository = repository;
    }

}
