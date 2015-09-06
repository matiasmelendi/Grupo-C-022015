package exceptions;

public class FullTourney extends Exception {
    public FullTourney(){ super("This tourney is full and it's not possible to add new teams!"); }
}
