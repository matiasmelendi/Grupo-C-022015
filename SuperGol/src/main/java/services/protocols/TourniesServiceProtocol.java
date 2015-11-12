package services.protocols;

import model.Tourney;

import javax.jws.WebService;
import javax.ws.rs.PathParam;
import java.util.List;

@WebService
public interface TourniesServiceProtocol {

    List<Tourney> all();

    Tourney getById(@PathParam("id") final Integer id);

}
