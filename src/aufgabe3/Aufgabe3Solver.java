package aufgabe3;

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
    public static FieldObject[] StringToFieldObjects(String s) throws Exception{
        FieldObject[] fieldObjects = new FieldObject[s.length()];
        char[] charArray = s.toCharArray();
        for(int i =0; i < fieldObjects.length; i++){
            fieldObjects[i] = charToFieldObject(charArray[i]);
        }
        return fieldObjects;
    }

    public static int solvePart1(){
        return 0;
    }
}
