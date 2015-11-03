package model;

public enum Position {
    GOALKEEPER(0),
    DEFENDER(1),
    MIDFIELDER(2),
    FORWARD(3);


    private final int value;
    private Position(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
