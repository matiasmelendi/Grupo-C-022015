package services;

import model.Tourney;
import repositories.TourneyRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/tournies")
@Produces("application/json")
public class TourniesService {

    private TourneyRepository repository;

    public TourniesService(){
        this.repository = new TourneyRepository();
    }

    @GET
    @Path("/all")
    public List<Tourney> all(){
        return this.repository.all();
    }

    @GET
    @Path("/{id}")
    public Tourney getById(@PathParam("id") final Integer id){
        return this.repository.getById(id);
    }
}
