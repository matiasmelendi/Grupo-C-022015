package repositories;

import model.Fixture;
import model.Tourney;
import repositories.protocols.TourniesRepositoryProtocol;

public class TourniesRepository extends GenericRepository<Tourney> implements TourniesRepositoryProtocol {

    public Fixture rankingForATourney(Double id){
        return this.find(id).fixture();
    }

    protected Class<Tourney> getDomainClass() {
        return Tourney.class;
    }
}
