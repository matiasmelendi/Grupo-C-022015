package services;

import exceptions.CouldNotUpdateAPreviousRound;
import exceptions.FileHasNoHeaderID;
import exceptions.UpdateGoalsFromFileFailure;
import repositories.PlayerGoalsUpdateFromFileRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.File;

@Path("/rounds")
public class PlayerGoalsUpdateFromFileService {

    private PlayerGoalsUpdateFromFileRepository repository;

    @PUT
    @Path("/update-from-csv")
    @Consumes("multipart/form-data")
    @Produces("application/x-www-form-urlencoded")
    public void updateFromCsv(File csvFile) throws UpdateGoalsFromFileFailure, CouldNotUpdateAPreviousRound, FileHasNoHeaderID {
        this.repository.updateRoundFromCSV(csvFile);
    }

    //*******************************************************
    //           Only used by spring
    //*******************************************************


    public PlayerGoalsUpdateFromFileRepository getRepository() {
        return repository;
    }

    public void setRepository(PlayerGoalsUpdateFromFileRepository repository) {
        this.repository = repository;
    }

}
