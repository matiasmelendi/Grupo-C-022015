import java.util.*;

public class SuperGol {

    private List<User> users;
    //private List<ScoringRule> scoringRules;

    public SuperGol(){
        this.users = new ArrayList<User>();
    }

    public List<User> users(){
        return this.users;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public List<Team> rankingFor(Tourney aTourney){

        return ascendingSortByScore(createScoresMapFromUsers(aTourney));
    }

    public void updateScoresFor(Tourney tourney, Map<Team, Integer> scoresForTeams){
        for(User user : this.users()){
            user.updateScoreFor(tourney, scoresForTeams.get(user.team()));
        }
    }

    private List<Team> ascendingSortByScore(Map<Team, Integer> teamScores){

        return new ArrayList<Team>(MapUtils.sortByAscendingValue(teamScores).keySet());
    }

    private Map<Team, Integer> createScoresMapFromUsers(Tourney aTourney){
        Map result = new HashMap<Team, Integer>();

        for(User user : this.users()){
            result.put(user.team(), user.scoreFor(aTourney));
        }

        return result;
    }
}
