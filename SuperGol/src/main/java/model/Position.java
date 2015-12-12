package model;

import java.util.HashMap;
import java.util.Map;

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

    private static Map<Integer, Position> map = new HashMap<Integer, Position>();

    static {
        for (Position position : Position.values()) {
            map.put(position.value(), position);
        }
    }

    public static Position valueOf(int value) {
        return map.get(value);
    }
}
