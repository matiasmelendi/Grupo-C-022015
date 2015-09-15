import java.util.*;

public class SuperGol {

    private List<User> users;
    private List<ScoringRule> scoringRules;

    public SuperGol(){
        this.users = new ArrayList<User>();
        this.scoringRules = this.scoringRules();
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

    public void calculateScoresForTourneyInARound(Tourney tourney, Round round){
        this.updateScoresFor(tourney, this.scoresFor(round));
    }

    private Map<Team, Integer> scoresFor(Round round){
        Map<Team, Integer> scores = new HashMap<Team, Integer>();

        for(Match match : round.matches()){
            scores.put(match.localTeam(), this.applyScoringRulesForTeamInAMatch(match, match.localTeam()));
            scores.put(match.awayTeam(), this.applyScoringRulesForTeamInAMatch(match, match.awayTeam()));
        }

        return scores;
    }

    private Integer applyScoringRulesForTeamInAMatch(Match match, Team team){

        return this.pointsReceivedForMatch(this.appliedRulesForTeamInAMatch(team, match));
    }

    private List<ScoringRule> appliedRulesForTeamInAMatch(Team team, Match match){
        List<ScoringRule> appliedRules = new ArrayList<ScoringRule>();

        for (ScoringRule rule : this.scoringRules()){
            if(rule.appliesTo(team, match)) { appliedRules.add(rule); }
        }

        return appliedRules;
    }

    private Integer pointsReceivedForMatch(List<ScoringRule> appliedRules){
        Integer points = 0;

        for(ScoringRule rule : appliedRules){ points += rule.points(); }

        return points;
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

    private List<ScoringRule> scoringRules(){
        return Arrays.asList(   new MidfielderForwardScored(), new DefenderScored(), new NoGoals(),
                                new DrawMatch(), new WinnerOfTheMatch());
    }
}
