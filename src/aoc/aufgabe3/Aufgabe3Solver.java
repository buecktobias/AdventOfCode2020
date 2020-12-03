package aoc.aufgabe3;
import aoc.Input;

public class Aufgabe3Solver {
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
        int treeCounter = 0;
        while(field.isIn(player)){
            if(field.getObjectAt(player.getX(), player.getY()).isTree()){
                treeCounter++;
            }
            player.move();
        }

        return treeCounter;
    }
}
