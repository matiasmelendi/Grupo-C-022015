import exceptions.FullTourney;

import java.util.ArrayList;
import java.util.List;

public class Tourney {

    private String name;
    private Integer minNumberOfTeams;
    private Integer maxNumberOfTeams;
    private List<Team> teams;

    public Tourney(String name, Integer minNumberOfTeams, Integer maxNumberOfTeams){
        this.name = name;
        this.minNumberOfTeams = minNumberOfTeams;
        this.maxNumberOfTeams = maxNumberOfTeams;
        this.teams = new ArrayList<Team>();
    }

    public String name(){
        return this.name;
    }

    public Integer minimumNumberOfTeams(){
        return this.minNumberOfTeams;
    }

    public Integer maximumNumberOfTeams(){
        return this.maxNumberOfTeams;
    }

    public void addTeam(Team aTeam) throws FullTourney {
        if(this.teams.size() == this.maxNumberOfTeams) { throw new FullTourney(); }
        this.teams.add(aTeam);
    }

    public List<Team> teams(){
        return this.teams;
    }

    public Integer amountOfTeams() {
        return this.teams.size();
    }

    public Fixture fixture(){
        return new Fixture(this);
    }

    public List<Round> rounds(){
        return this.fixture().rounds();
    }
}
