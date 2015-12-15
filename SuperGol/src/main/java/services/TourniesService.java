package services;

import model.Player;
import model.Team;
import model.Tourney;
import repositories.TourniesRepository;

import javax.ws.rs.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/tournies")
public class TourniesService {

    private TourniesRepository repository;

    public TourniesService() {
        this.repository = new TourniesRepository();
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Tourney> all() {
        return this.repository.all();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Tourney find(@PathParam("id") Integer id) {
        return this.repository.find(id);
    }

    @GET
    @Path("/{id}/ranking")
    @Produces("application/json")
    public List<Team> ranking(@PathParam("id") Integer id) {
        return this.repository.rankingForATourney(id);
    }

    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/x-www-form-urlencoded")
    public void create(Tourney tourney) {
        this.repository.save(tourney);
    }

    @PUT
    @Path("/")
    @Consumes("application/json")
    @Produces("application/x-www-form-urlencoded")
    public void update(Tourney tourney) {
        this.repository.update(tourney);
    }

    @POST
    @Path("/{id}/update-from-list")
    @Consumes("application/json")
    public void updateFromList(@PathParam("id") Integer id, Map<Player, Integer> scores){

        this.repository.updateFromList(id, scores);
    }

    //*******************************************************
    //           Only used by spring only
    //*******************************************************

    public TourniesRepository getRepository() {
        return repository;
    }

    public void setRepository(TourniesRepository repository) {
        this.repository = repository;
    }

}
