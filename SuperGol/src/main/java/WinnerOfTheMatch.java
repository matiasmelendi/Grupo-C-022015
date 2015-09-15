import exceptions.MatchIsDraw;

public class WinnerOfTheMatch extends ScoringRule {


    @Override
    public Boolean appliesTo(Team team, Match match) {
        try {
            return match.theWinnerIs(team);
        } catch (MatchIsDraw e){
            return false;
        }
    }

    @Override
    public Integer points() {
        return 3;
    }
}
