package model;

import exceptions.CouldNotUpdateAPreviousRound;
import exceptions.FileHasNoHeaderID;
import exceptions.UpdateGoalsFromFileFailure;

import java.io.File;
import java.io.IOException;

public class PlayerGoalsUpdateFromFile {

    private Integer roundToBeUpdated;
    private Integer lastUpdatedRound;
    private Integer headerFileIdentifier;

    public PlayerGoalsUpdateFromFile(File file, Integer lastUpdatedRound, Integer roundToBeUpdated, Integer lastHeaderID) throws UpdateGoalsFromFileFailure, CouldNotUpdateAPreviousRound, FileHasNoHeaderID {
        this.roundToBeUpdated = roundToBeUpdated;
        this.lastUpdatedRound = lastUpdatedRound;
        this.setHeaderIDAndValidateIfValid(file, lastHeaderID);
        this.verifyIfTryingToUpdateAValidRound();
        Reader.playersGoalsFromLastRound(file);
    }

    @Override
    public boolean equals(Object _anotherPlayerGoalsUpdateFromFile){
        PlayerGoalsUpdateFromFile anotherPlayerGoalsUpdateFromFile = (PlayerGoalsUpdateFromFile) _anotherPlayerGoalsUpdateFromFile;

        return this.getHeaderFileIdentifier().equals(anotherPlayerGoalsUpdateFromFile.getHeaderFileIdentifier()) &&
               this.getLastUpdatedRound().equals(anotherPlayerGoalsUpdateFromFile.getLastUpdatedRound()) &&
               this.getRoundToBeUpdated().equals(anotherPlayerGoalsUpdateFromFile.getRoundToBeUpdated());
    }

    private void verifyIfTryingToUpdateAValidRound() throws CouldNotUpdateAPreviousRound {
        if(this.lastUpdatedRound >= this.roundToBeUpdated){
            throw new CouldNotUpdateAPreviousRound();
        }
    }

    private void setHeaderIDAndValidateIfValid(File file, Integer lastHeaderID) throws UpdateGoalsFromFileFailure, FileHasNoHeaderID {
        try {
            this.headerFileIdentifier = Reader.getHeaderID(file);
            if(this.headerFileIdentifier <= lastHeaderID){
                throw new UpdateGoalsFromFileFailure();
            }
        } catch (IOException e) {
            throw new UpdateGoalsFromFileFailure();

        } catch (NullPointerException e) {

            throw new UpdateGoalsFromFileFailure();
        }
    }

    private int id;

    public PlayerGoalsUpdateFromFile(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRoundToBeUpdated() {
        return roundToBeUpdated;
    }

    public void setRoundToBeUpdated(Integer roundToBeUpdated) {
        this.roundToBeUpdated = roundToBeUpdated;
    }

    public Integer getLastUpdatedRound() {
        return lastUpdatedRound;
    }

    public void setLastUpdatedRound(Integer lastUpdatedRound) {
        this.lastUpdatedRound = lastUpdatedRound;
    }

    public Integer getHeaderFileIdentifier() {
        return headerFileIdentifier;
    }

    public void setHeaderFileIdentifier(Integer headerFileIdentifier) {
        this.headerFileIdentifier = headerFileIdentifier;
    }
}
