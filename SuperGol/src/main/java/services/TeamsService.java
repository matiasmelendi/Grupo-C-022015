package services;

import model.Team;
import repositories.TeamsRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/teams")
@Produces("application/json")
public class TeamsService {

    private TeamsRepository repository;

    public TeamsService(){
        this.repository = new TeamsRepository();
    }

    @GET
    @Path("/all")
    public List<Team> all(){
        return this.repository.all();
    }

    @GET
    @Path("/ranking")
    public List<Team> ranking() {
        return this.repository.ranking();
    }
}
