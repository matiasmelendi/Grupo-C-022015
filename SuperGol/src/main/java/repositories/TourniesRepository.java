package repositories;

import model.*;
import repositories.protocols.TourniesRepositoryProtocol;

import java.util.List;

public class TourniesRepository extends GenericRepository<Tourney> implements TourniesRepositoryProtocol {

    public List<Team> rankingForATourney(Integer id){
        SuperGol game = new SuperGol();
        game.setUsers(this.getHibernateTemplate().findByExample(new User()));

        return game.rankingFor(this.find(id));
    }

    protected Class<Tourney> getDomainClass() {
        return Tourney.class;
    }
}
