package repositories.protocols;

import model.Team;

import java.util.List;

public interface TeamsRepositoryProtocol {

    List<Team> all();

    void update(Team team);

    void delete(Double id);

    Team find(Double id);
}