package services;

import model.Fixture;
import model.Tourney;
import repositories.TourniesRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

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
    public Tourney find(@PathParam("id") Double id) {
        return this.repository.find(id);
    }

    @GET
    @Path("/{id}/ranking")
    @Produces("application/json")
    public Fixture ranking(@PathParam("id") Double id) {
        return this.repository.rankingForATourney(id);
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
