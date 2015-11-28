package repositories;

import model.Fixture;
import model.Tourney;
import org.hibernate.SessionFactory;
import repositories.protocols.TourniesRepositoryProtocol;

import java.util.List;

public class TourniesRepository implements TourniesRepositoryProtocol {

    public List<Tourney> all(){
        return null;
    }

    public Tourney find(Integer id) {
        return null;
    }

    public Fixture rankingForATourney(Integer id){
        return this.find(id).fixture();
    }

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
