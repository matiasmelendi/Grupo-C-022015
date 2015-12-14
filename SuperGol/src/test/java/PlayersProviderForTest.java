import model.Player;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.io.Serializable;

public class PlayersProviderForTest extends HibernateTemplate {

    @Override
    public Player get(Class entityClass, Serializable id) throws DataAccessException {
        return new Player(id.toString(), null, null);
    }

}
