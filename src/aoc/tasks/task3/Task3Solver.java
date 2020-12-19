package aoc.tasks.task3;
import aoc.helper.Input;

public class Task3Solver {
    public static FieldObject charToFieldObject(char c) throws Exception {
        if(c == '.'){
            return new EmptySpace();
        }else if(c == '#'){
            return new Tree();
        }else{
            throw new Exception("Wrong char!");
        }
    }

    public static FieldObject[] stringToFieldObjects(String s) throws Exception{
        FieldObject[] fieldObjects = new FieldObject[s.length()];
        char[] charArray = s.toCharArray();
        for(int i =0; i < fieldObjects.length; i++){
            fieldObjects[i] = charToFieldObject(charArray[i]);
        }
        return fieldObjects;
    }

    public static FieldObject[][] stringsToFieldObjects(String[] stringArray) throws Exception {
        FieldObject[][] fieldObjects = new FieldObject[stringArray.length][stringArray[0].length()];
        for (int i = 0; i < fieldObjects.length; i++) {
            fieldObjects[i] = stringToFieldObjects(stringArray[i]);
        }
        return fieldObjects;
    }

    public static FieldObject[][] readFieldObjectsFromFile(String filename) throws Exception {
        String[] lines = Input.getInputAsStringArray(filename);
        return stringsToFieldObjects(lines);
    }

    public static int solvePart1(String filename){
        FieldObject[][] fieldObjects;
        try {
            fieldObjects = readFieldObjectsFromFile(filename);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        Pattern pattern = new Pattern(fieldObjects);
        Field field = new Field(pattern);
        Player player = new Player(0,0, 3, 1);
        return player.moveThroughField(field);
    }

    public static long solvePart2(String filename){
        FieldObject[][] fieldObjects;
        try {
            fieldObjects = readFieldObjectsFromFile(filename);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        Pattern pattern = new Pattern(fieldObjects);
        Field field = new Field(pattern);

        Player player1 = new Player(0,0, 1, 1);
        Player player2 = new Player(0,0, 3, 1);
        Player player3 = new Player(0,0, 5, 1);
        Player player4 = new Player(0,0, 7, 1);
        Player player5 = new Player(0,0, 1, 2);

        long trees1 = player1.moveThroughField(field);
        long trees2 = player2.moveThroughField(field);
        long trees3 = player3.moveThroughField(field);
        long trees4 = player4.moveThroughField(field);
        long trees5 = player5.moveThroughField(field);

        return trees1 * trees2 * trees3 * trees4 * trees5;
    }
}
