package services.protocols;

import model.Team;
import java.util.List;
import javax.jws.WebService;

@WebService
public interface TeamsServiceProtocol {

    List<Team> all();

    List<Team> ranking();

}
