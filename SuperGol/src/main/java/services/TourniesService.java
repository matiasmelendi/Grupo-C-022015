package services;

import model.Player;
import model.Position;
import model.Team;
import model.Tourney;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.*;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.TypeReference;
import repositories.TourniesRepository;

import javax.ws.rs.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

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
    public void updateFromList(@PathParam("id") Integer id, List<List<Object>> requestBody){
        Map<Player, Integer> scores = new HashMap<Player, Integer>();

        for(List<Object> score : requestBody){
            scores.put(playerFrom((LinkedHashMap) score.get(0)), (Integer)score.get(1));
        }

        this.repository.updateFromList(id, scores);
    }

    private Player playerFrom(LinkedHashMap<String, Object> playerJson){
        Player player = new Player();
        player.setId((Integer)playerJson.get("id"));
        player.setName((String) playerJson.get("name"));
        player.setPosition(Position.valueOf((String)playerJson.get("position")));
        player.setCaptain((Boolean)playerJson.get("captain"));

        return player;
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
