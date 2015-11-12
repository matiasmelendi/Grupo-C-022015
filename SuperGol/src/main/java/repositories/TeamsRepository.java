package repositories;

import model.Team;
import org.hibernate.SessionFactory;
import repositories.protocols.TeamsRepositoryProtocol;

import java.util.List;

public class TeamsRepository implements TeamsRepositoryProtocol {

    public List<Team> all(){
        return null;
    }

    public List<Team> ranking(){
        return null;
    }

    public void update(Integer id){

    }

    public void delete(Integer id){

     }

    public Team find(Integer id){
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
