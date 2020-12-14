package aoc.tasks.task12;

import aoc.helper.Vector2D;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    EAST(Direction.EAST_ROTATION, new Vector2D(1, 0)),
    SOUTH(Direction.SOUTH_ROTATION, new Vector2D(0, 1)),
    WEST(Direction.WEST_ROTATION, new Vector2D(-1, 0)),
    NORTH(Direction.NORTH_ROTATION, new Vector2D(0, -1));

    private static final int EAST_ROTATION = 0;
    private static final int SOUTH_ROTATION = 90;
    private static final int WEST_ROTATION = 180;
    private static final int NORTH_ROTATION = 270;

    private static final Map<Integer, Direction> getValues() {

        return new HashMap<>()

    {
        {
            put(Direction.EAST_ROTATION, Direction.EAST);
            put(Direction.SOUTH_ROTATION, Direction.SOUTH);
            put(Direction.WEST_ROTATION, Direction.WEST);
            put(Direction.NORTH_ROTATION, Direction.NORTH);
        }
    }

    ;
}
    private final int rotation;
    private final Vector2D directionVector;
    Direction(int rotation, Vector2D directionVector){
        this.rotation = rotation;
        this.directionVector = directionVector;
    }

    public Direction changeRotation(int increaseBy) throws Exception{
        int newRotation = this.rotation + increaseBy;
        return Direction.getDirection(newRotation);
    }

    public static Direction getDirection(int rotation) throws Exception{
        if(rotation < 0){
            return getDirection(rotation + 360);
        }
        rotation = rotation % 360;

        if(Direction.getValues().containsKey(rotation)){
            return Direction.getValues().get(rotation);
        }else{
            throw new Exception("The value " + rotation + " is not a valid rotation");
        }
    }

    public Vector2D getDirectionVector() {
        return directionVector;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "rotation=" + rotation +
                ", directionVector=" + directionVector +
                '}';
    }
}