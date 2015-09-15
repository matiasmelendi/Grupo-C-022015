import exceptions.MatchIsDraw;
import exceptions.NoMatchResultFound;

public class WinnerOfTheMatch extends ScoringRule {

    //TODO: Review compiler version to allow us to use exception multi-catch
    @Override
    public Boolean appliesTo(Team team, Match match) {
        try {
            return match.theWinnerIs(team);
        } catch (MatchIsDraw e){
            return false;
        }catch (NoMatchResultFound e){
            return false;
        }
    }

    @Override
    public Integer points() {
        return 3;
    }
}
