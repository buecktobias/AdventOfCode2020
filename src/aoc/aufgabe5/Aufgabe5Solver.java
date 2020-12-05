package aoc.aufgabe5;

import aoc.Input;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Aufgabe5Solver {
    public static class BoardingPass{
        public String Row;
        public String Column;

        public BoardingPass(String row, String column) {
            Row = row;
            Column = column;
        }

        public String rowAsBinary(){
            String newRow = this.Row.replace('B','1');
            return newRow.replace('F', '0');
        }

        public int rowAsDecimal(){
            return Integer.parseInt(this.rowAsBinary(), 2);
        }

        public String columnAsBinary(){
            String newColumn = this.Column.replace('R','1');
            return newColumn.replace('L', '0');
        }

        public int columnAsDecimal(){
            return Integer.parseInt(this.columnAsBinary(), 2);
        }

        public int getId(){
            return this.rowAsDecimal() * 8 + this.columnAsDecimal();
        }

        @Override
        public String toString() {
            return "BoardingPass{" +
                    "Row='" + Row + '\'' +
                    ", RowDecimal='" + this.rowAsDecimal() + '\'' +
                    ", Column='" + Column + '\'' +
                    ", ColumnDecimal='" + this.columnAsDecimal() + '\'' +
                    ", Id='" + this.getId() + '\'' +
                    '}';
        }
    }

    public static List<BoardingPass> getBoardingPasses(String filename){
        String[] stringArray = Input.getInputAsStringArray(filename);
        Pattern pattern = Pattern.compile("([BF]{7})([RL]{3})");
        List<BoardingPass> boardingPasses = new LinkedList<>();
        for(String s: stringArray){
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()){
                boardingPasses.add(new BoardingPass(matcher.group(1), matcher.group(2)));
            }
        }
        return boardingPasses;
    }

    public static int getBoardingPassHighestId(List<BoardingPass> boardingPasses){
        int highest = -100;
        for (BoardingPass boardingPass: boardingPasses){
            if(boardingPass.getId() > highest) {
                highest = boardingPass.getId();
            }
        }
        return highest;
    }

    public static int solvePart1(String filename){
        List<BoardingPass> boardingPasses = getBoardingPasses(filename);
        return getBoardingPassHighestId(boardingPasses);
    }

    public static int getEmptySeat(List<Integer> seats){
        for(int i = 1; i < seats.size(); i++){
            Integer numberBefore = seats.get(i - 1);
            Integer currentNumber = seats.get(i);
            if (numberBefore + 2 == currentNumber){
                return numberBefore + 1;
            }
        }
        return 0;
    }

    public static int solvePart2(String filename){
        List<BoardingPass> boardingPasses = getBoardingPasses(filename);
        List<Integer> ids = (List<Integer>) boardingPasses.stream().map(BoardingPass::getId).collect(Collectors.toList());
        Collections.sort(ids);
        return getEmptySeat(ids);
    }
}
