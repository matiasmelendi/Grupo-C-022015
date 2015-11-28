package repositories;

import fixtures.PlayersFixture;
import model.Player;
import org.hibernate.SessionFactory;
import repositories.protocols.PlayersRepositoryProtocol;

import java.util.List;

public class PlayersRepository implements PlayersRepositoryProtocol {

    private List<Player> players;

    public PlayersRepository(){
        this.players = PlayersFixture.createPlayers();
    }

    public List<Player> all(){
        return this.players;
    }

    public void delete(Integer id){
        for(Player player : this.players){
            if(player.getId() == id)
                this.players.remove(player);
        }
    }

    public Player find(Integer id){
        for(Player player : this.players){
            if(player.getId() == id)
                return player;
        }

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
