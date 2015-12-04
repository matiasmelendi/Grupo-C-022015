package repositories;

import model.Team;
import repositories.protocols.TeamsRepositoryProtocol;

import java.util.List;

public class TeamsRepository extends GenericRepository<Team> implements TeamsRepositoryProtocol {

    public List<Team> ranking(){
        return null;
    }

    protected Class<Team> getDomainClass() {
        return Team.class;
    }

}
