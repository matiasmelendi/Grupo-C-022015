package model;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Fixture {

    private Integer amountOfRounds;
    private Integer halfTourney;
    private List<Round> rounds;
    private Tourney tourney;

    /**
     * Class' constructor.
     *
     * @param aTourney model.Tourney that contains the information needed to build this up.
     */
    public Fixture(Tourney aTourney) {
        this.tourney = aTourney;
        this.rounds = new ArrayList<Round>();
        this.amountOfRounds = UtilFixtureBuilder.calculateAmountOfRounds(this.tourney);
        this.halfTourney = amountOfRounds / 2;
        this.buildRounds();
    }

    /**
     * Builds the rounds.
     */
    private void buildRounds() {
        UtilFixtureBuilder.addDummyIfNeeded(this.tourney);
        for (int roundId = 0; roundId < this.amountOfRounds; roundId++) {
            Round round = new Round(roundId, this.tourney.teams(), this.halfTourney);
            this.rounds.add(round);
        }
        UtilFixtureBuilder.removeDummyIfNeeded(this.tourney);
    }

    /**
     * Returns the amount of rounds.
     *
     * @return The amount of rounds.
     */
    public List<Round> rounds() {
        return this.rounds;
    }

    @Override
    public boolean equals(Object _anotherFixture){
        Fixture anotherFixture = (Fixture) _anotherFixture;

        return this.getTourney().equals(anotherFixture.getTourney());
    }

    private double id;

    public Fixture(){

    }

    public Integer getAmountOfRounds() {
        return amountOfRounds;
    }

    public void setAmountOfRounds(Integer amountOfRounds) {
        this.amountOfRounds = amountOfRounds;
    }

    public Integer getHalfTourney() {
        return halfTourney;
    }

    public void setHalfTourney(Integer halfTourney) {
        this.halfTourney = halfTourney;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    @JsonIgnore
    public Tourney getTourney() {
        return tourney;
    }

    public void setTourney(Tourney tourney) {
        this.tourney = tourney;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}