package services;

import exceptions.CouldNotUpdateAPreviousRound;
import exceptions.FileHasNoHeaderID;
import exceptions.UpdateGoalsFromFileFailure;
import repositories.PlayerGoalsUpdateFromFileRepository;

import javax.ws.rs.*;
import java.io.File;

@Path("/rounds")
public class PlayerGoalsUpdateFromFileService {

    private PlayerGoalsUpdateFromFileRepository repository;

    @PUT
    @Path("/{id}/update-from-csv")
    @Consumes("multipart/form-data")
    @Produces("application/x-www-form-urlencoded")
    public void updateFromCsv(@PathParam("id") Integer tourneyID,File csvFile) throws UpdateGoalsFromFileFailure, CouldNotUpdateAPreviousRound, FileHasNoHeaderID {
        this.repository.updateRoundFromCSV(tourneyID, csvFile);
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
