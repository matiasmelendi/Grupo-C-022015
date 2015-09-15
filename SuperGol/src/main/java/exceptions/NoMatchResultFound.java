package exceptions;

public class NoMatchResultFound extends Exception {

    public NoMatchResultFound(){
        super("No result found for this match!");
    }
}
