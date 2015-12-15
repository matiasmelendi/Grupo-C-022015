package repositories;

import model.*;
import repositories.protocols.TourniesRepositoryProtocol;

import java.util.List;

public class TourniesRepository extends GenericRepository<Tourney> implements TourniesRepositoryProtocol {

    public List<Team> rankingForATourney(Integer id){

        return this.getAGameInstance().rankingFor(this.find(id));
    }

    protected Class<Tourney> getDomainClass() {
        return Tourney.class;
    }
}
