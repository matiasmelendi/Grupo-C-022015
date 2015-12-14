package repositories;

import exceptions.CouldNotUpdateAPreviousRound;
import exceptions.FileHasNoHeaderID;
import exceptions.UpdateGoalsFromFileFailure;
import model.PlayerGoalsUpdateFromFile;
import model.Reader;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;
import repositories.protocols.PlayerGoalsUpdateFromFileRepositoryProtocol;

import java.io.File;
import java.util.List;

public class PlayerGoalsUpdateFromFileRepository extends GenericRepository<PlayerGoalsUpdateFromFile> implements PlayerGoalsUpdateFromFileRepositoryProtocol {

    @Transactional
    public void updateRoundFromCSV(File csvFile) throws CouldNotUpdateAPreviousRound, UpdateGoalsFromFileFailure, FileHasNoHeaderID {

        Reader.assignPlayersProvider(this.getHibernateTemplate());
        List<PlayerGoalsUpdateFromFile> results = (List<PlayerGoalsUpdateFromFile>) this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(PlayerGoalsUpdateFromFile.class).addOrder(Order.desc("id")));
        PlayerGoalsUpdateFromFile nextRoundUpdate = null;

        try{
            PlayerGoalsUpdateFromFile lastUpdate = results.get(0);
            nextRoundUpdate = new PlayerGoalsUpdateFromFile(csvFile, lastUpdate.getRoundToBeUpdated(), lastUpdate.getRoundToBeUpdated()+1, lastUpdate.getHeaderFileIdentifier());

        } catch (IndexOutOfBoundsException e){
            nextRoundUpdate = new PlayerGoalsUpdateFromFile(csvFile, 0, 1, 000);
        }finally {
            this.save(nextRoundUpdate);
        }
    }

    protected Class<PlayerGoalsUpdateFromFile> getDomainClass() {
        return PlayerGoalsUpdateFromFile.class;
    }

}
