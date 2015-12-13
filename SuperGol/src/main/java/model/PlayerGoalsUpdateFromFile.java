package model;

import exceptions.CouldNotUpdateAPreviousRound;
import exceptions.FileHasNoHeaderID;
import exceptions.UpdateGoalsFromFileFailure;

import java.io.File;
import java.io.IOException;

public class PlayerGoalsUpdateFromFile {

    private Integer roundToBeUpdated;
    private Integer lastUpdatedRound;
    private Integer headerFileID;

    public PlayerGoalsUpdateFromFile(File file, Integer lastUpdatedRound, Integer roundToBeUpdated, Integer lastHeaderID) throws UpdateGoalsFromFileFailure, CouldNotUpdateAPreviousRound, FileHasNoHeaderID {
        this.roundToBeUpdated = roundToBeUpdated;
        this.lastUpdatedRound = lastUpdatedRound;
        this.setHeaderIDAndValidateIfValid(file, lastHeaderID);
        this.verifyIfTryingToUpdateAValidRound();
        Reader.playersGoalsFromLastRound(file);
    }

    private void verifyIfTryingToUpdateAValidRound() throws CouldNotUpdateAPreviousRound {
        if(this.lastUpdatedRound >= this.roundToBeUpdated){
            throw new CouldNotUpdateAPreviousRound();
        }
    }

    private void setHeaderIDAndValidateIfValid(File file, Integer lastHeaderID) throws UpdateGoalsFromFileFailure, FileHasNoHeaderID {
        try {
            this.headerFileID = Reader.getHeaderID(file);
            if(this.headerFileID <= lastHeaderID){
                throw new UpdateGoalsFromFileFailure();
            }
        } catch (IOException e) {
            throw new UpdateGoalsFromFileFailure();

        } catch (NullPointerException e) {

            throw new UpdateGoalsFromFileFailure();
        }
    }

}
