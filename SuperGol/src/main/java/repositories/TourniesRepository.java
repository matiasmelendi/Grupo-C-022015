package repositories;

import model.Tourney;
import org.hibernate.SessionFactory;
import repositories.interfaces.TourniesRepositoryProtocol;

import java.util.List;

public class TourniesRepository implements TourniesRepositoryProtocol {

    public List<Tourney> all(){
        return null;
    }

    public Tourney getById(Integer id) {
        return null;
    }

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
