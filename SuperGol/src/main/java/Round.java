import java.util.ArrayList;
import java.util.List;

public class Round {

    private Integer number;
    private List<Match> matches;
    private List<Team> teams;
    private Integer halfTourney;

    /**
     * Class' constructor.
     *
     * @param number      Number of the Round.
     * @param teams       Teams that the round will build the matches with.
     * @param halfTourney Number that represents the half of the Tourney.
     */
    public Round(Integer number, List<Team> teams, Integer halfTourney) {
        this.number = number;
        this.matches = new ArrayList<Match>();
        this.teams = teams;
        this.halfTourney = halfTourney;
        this.build();
    }

    /**
     * Builds this round with Matches, following this:
     * <p/>
     * Given a N amount of teams, it keeps the first team fixed,
     * and rotates the rest (clockwise) of the teams, until N - 1.
     * If N is odd, a Dummy Team needs to be added, and the Team that is
     * matched against the Dummy Team, doesn't play this round.
     */
    private void build() {
        Integer matchesToBuild = teams.size() / 2;
        List<Team> teamsCopy = UtilFixtureBuilder.copyWithoutFirst(teams);
        Integer teamsSize = teamsCopy.size();
        int teamNumber = number % teamsSize;
        this.addMatch(teamsCopy.get(teamNumber), teams.get(0));
        for (int match = 1; match < matchesToBuild; match++) {
            int firstTeam = (number + match) % teamsSize;
            int secondTeam = (number + teamsSize - match) % teamsSize;
            Team home = teamsCopy.get(firstTeam);
            Team away = teamsCopy.get(secondTeam);
            this.addMatch(home, away);
        }
    }

    /**
     * Adds a Match to this round, checking that none of the teams is Dummy.
     * Also, check if the round is before or after the half of the tourney
     * to see if it should be "A vs B", or "B vs A".
     *
     * @param teamA Team to be added.
     * @param teamB Team to be added.
     */
    private void addMatch(Team teamA, Team teamB) {
        Boolean firstTeamIsDummy = UtilFixtureBuilder.aTeamIsDummy(teamA);
        Boolean secondTeamIsDummy = UtilFixtureBuilder.aTeamIsDummy(teamB);
        Boolean oneOfTheTeamsIsDummy = firstTeamIsDummy || secondTeamIsDummy;
        if (!oneOfTheTeamsIsDummy) {
            if (number < halfTourney)
                this.matches.add(new Match(teamA, teamB));
            else
                this.matches.add(new Match(teamB, teamA));
        }
    }

    /**
     * Returns the matches of this round.
     *
     * @return The matches of this round.
     */
    public List<Match> matches() {
        return this.matches;
    }

}
