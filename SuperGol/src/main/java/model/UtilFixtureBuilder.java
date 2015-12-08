package model;

import java.util.ArrayList;
import java.util.List;

public class UtilFixtureBuilder {

    private static Team dummyTeam = new Team("Dummy");

    /**
     * Given a model.Tourney, it returns the amount of Rounds for that model.Tourney.
     *
     * @param aTourney model.Tourney from where the amount of teams is taken.
     * @return Amount of Rounds for a model.Tourney.
     */
    public static Integer calculateAmountOfRounds(Tourney aTourney) {
        Integer amountOfRounds;
        if (tourneyHasEvenAmountOfTeams(aTourney)) {
            amountOfRounds = (aTourney.amountOfTeams() - 1) * 2;
        } else {
            amountOfRounds = aTourney.amountOfTeams() * 2;
        }
        return amountOfRounds;
    }

    /**
     * Adds a Dummy model.Team to a model.Tourney in case it has an odd amount of Teams.
     *
     * @param aTourney model.Tourney to check.
     */
    public static void addDummyIfNeeded(Tourney aTourney) {
        if (!tourneyHasEvenAmountOfTeams(aTourney)) {
            aTourney.teams().add(dummyTeam);
        }
    }

    /**
     * Removes a Dummy model.Team in case a model.Tourney has one.
     *
     * @param aTourney model.Tourney to check.
     */
    public static void removeDummyIfNeeded(Tourney aTourney) {
        for (int i = 0; i < aTourney.amountOfTeams(); i++) {
            Team team = aTourney.teams().get(i);
            if (team.name().equals("Dummy"))
                aTourney.teams().remove(i);
        }
    }

    /**
     * Returns if the given team is Dummy.
     *
     * @param team model.Team to check.
     * @return If a given team is Dummy.
     */
    public static Boolean aTeamIsDummy(Team team) {
        return team.name().equals("Dummy");
    }

    /**
     * Returns if the model.Tourney has an even amount of teams.
     *
     * @param aTourney model.Tourney to be checked.
     * @return If a model.Tourney has an even amount of teams.
     */
    private static Boolean tourneyHasEvenAmountOfTeams(Tourney aTourney) {
        return aTourney.amountOfTeams() % 2 == 0;
    }

    /**
     * Returns a new list that contains the same teams as the first one, without the first element.
     *
     * @param teams List to copy the teams from.
     * @return New list with the same teams as the parameter list but without the first.
     */
    public static List<Team> copyWithoutFirst(List<Team> teams) {
        List<Team> teamsCopy = new ArrayList<Team>();
        teamsCopy.addAll(teams);
        teamsCopy.remove(0);
        return teamsCopy;
    }

}
