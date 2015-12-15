package repositories;

import exceptions.CouldNotUpdateAPreviousRound;
import exceptions.FileHasNoHeaderID;
import exceptions.UpdateGoalsFromFileFailure;
import model.PlayerGoalsUpdateFromFile;
import model.Reader;
import model.Tourney;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;
import repositories.protocols.PlayerGoalsUpdateFromFileRepositoryProtocol;

import java.io.File;
import java.util.List;

public class PlayerGoalsUpdateFromFileRepository extends GenericRepository<PlayerGoalsUpdateFromFile> implements PlayerGoalsUpdateFromFileRepositoryProtocol {

    @Transactional
    public void updateRoundFromCSV(Integer tourneyID, File csvFile) throws CouldNotUpdateAPreviousRound, UpdateGoalsFromFileFailure, FileHasNoHeaderID {

        Reader.assignPlayersProvider(this.getHibernateTemplate());
        List<PlayerGoalsUpdateFromFile> results = (List<PlayerGoalsUpdateFromFile>) this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(PlayerGoalsUpdateFromFile.class).addOrder(Order.desc("id")));
        PlayerGoalsUpdateFromFile nextRoundUpdate = null;

        try{

            Tourney tourney = this.getHibernateTemplate().get(Tourney.class, tourneyID);
            PlayerGoalsUpdateFromFile lastUpdate = results.get(0);
            nextRoundUpdate = new PlayerGoalsUpdateFromFile(csvFile, lastUpdate.getRoundToBeUpdated(), lastUpdate.getRoundToBeUpdated()+1, lastUpdate.getHeaderFileIdentifier());
            this.getAGameInstance().updateScoresForByPlayers(tourney, Reader.playersGoalsFromLastRound(csvFile));

        } catch (IndexOutOfBoundsException e){
            nextRoundUpdate = new PlayerGoalsUpdateFromFile(csvFile, -1, 0, -001);
        }finally {
            this.save(nextRoundUpdate);
        }
    }

    protected Class<PlayerGoalsUpdateFromFile> getDomainClass() {
        return PlayerGoalsUpdateFromFile.class;
    }

}
