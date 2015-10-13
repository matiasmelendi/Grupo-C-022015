package repositories.interfaces;

import model.Team;

import java.util.List;

public interface TeamsRepositoryProtocol {

    List<Team> all();

    List<Team> ranking();

    void update(Integer id);

    void delete(Integer id);

    Team find(Integer id);
}
