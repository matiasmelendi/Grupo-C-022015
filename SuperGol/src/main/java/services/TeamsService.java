package services;

import model.Team;
import repositories.TeamsRepository;
import services.protocols.TeamsServiceProtocol;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.jws.WebService;
import java.util.List;

@Path("/teams")
@Produces("application/json")
@WebService(endpointInterface = "services.protocols.TeamsServiceProtocol")
public class TeamsService implements TeamsServiceProtocol {

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

    public TeamsRepository getRepository() {
        return repository;
    }

    public void setRepository(TeamsRepository repository) {
        this.repository = repository;
    }

}
