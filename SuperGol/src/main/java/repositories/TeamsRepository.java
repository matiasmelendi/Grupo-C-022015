package repositories;

import model.Team;
import repositories.protocols.TeamsRepositoryProtocol;

import java.util.List;

public class TeamsRepository extends GenericRepository<Team> implements TeamsRepositoryProtocol {

    protected Class<Team> getDomainClass() {
        return Team.class;
    }

}
