package services;

import model.Team;
import repositories.TeamsRepository;

import javax.ws.rs.*;
import java.util.List;

@Path("/teams")
public class TeamsService {

    private TeamsRepository repository;

    public TeamsService(){
        this.repository = new TeamsRepository();
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Team> all(){
        return this.repository.all();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Team find(@PathParam("id") Double id){
        return this.repository.find(id);
    }

    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/x-www-form-urlencoded")
    public void create(Team team) {
        this.repository.save(team);
    }

    @PUT
    @Path("/")
    @Consumes("application/json")
    @Produces("application/x-www-form-urlencoded")
    public void update(Team team) {
        this.repository.update(team);
    }


    //*******************************************************
    //           Only used by spring only
    //*******************************************************

    public TeamsRepository getRepository() {
        return repository;
    }

    public void setRepository(TeamsRepository repository) {
        this.repository = repository;
    }

}
