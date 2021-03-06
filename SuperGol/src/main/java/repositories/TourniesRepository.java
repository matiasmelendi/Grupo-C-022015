package repositories;

import model.*;
import repositories.protocols.TourniesRepositoryProtocol;

import java.util.List;
import java.util.Map;

public class TourniesRepository extends GenericRepository<Tourney> implements TourniesRepositoryProtocol {

    public List<Team> rankingForATourney(Integer id){

        return this.getAGameInstance().rankingFor(this.find(id));
    }

    public void updateFromList(Integer id, Map<Player, Integer> scores){
        this.getAGameInstance().updateScoresForByPlayers(this.find(id), scores);
    }

    protected Class<Tourney> getDomainClass() {
        return Tourney.class;
    }
}
