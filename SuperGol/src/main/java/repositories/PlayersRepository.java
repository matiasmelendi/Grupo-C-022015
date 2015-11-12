package repositories;

import model.Player;
import org.hibernate.SessionFactory;
import repositories.protocols.PlayersRepositoryProtocol;

import java.util.List;

public class PlayersRepository implements PlayersRepositoryProtocol {

    public List<Player> all(){
        return null;
    }

    public void delete(Integer id){

    }

    public Player find(Integer id){
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
