package exceptions;

public class UpdateGoalsFromFileFailure extends Exception {

    public UpdateGoalsFromFileFailure() {
        super("Reading the CSV File to Update the scores failed during the process.");
    }

}
