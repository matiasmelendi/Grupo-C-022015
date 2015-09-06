package exceptions;

public class PositionFull extends Exception {
    public PositionFull() { super("It's not possible to add a player on this position!"); }
}
