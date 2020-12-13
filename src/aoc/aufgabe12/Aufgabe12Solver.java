package aoc.aufgabe12;

import aoc.helper.Input;

import java.util.LinkedList;
import java.util.List;

public class Aufgabe12Solver {

    public static List<Instruction> getInput(String filename){
        String[] instructions = Input.getInputAsStringArray(filename);
        List<Instruction> instructionList = new LinkedList<>();
        for (String instruction : instructions) {
             char instructionType = instruction.charAt(0);
             int parameter = Integer.parseInt(instruction.substring(1));
             InstructionType instructionType1;
             switch(instructionType){
                 case 'F':
                     instructionType1 = InstructionType.FORWARD;
                     break;
                 case 'N':
                     instructionType1 = InstructionType.NORTH;
                     break;
                 case 'E':
                     instructionType1 = InstructionType.EAST;
                     break;
                 case 'W':
                     instructionType1 = InstructionType.WEST;
                     break;
                 case 'S':
                     instructionType1 = InstructionType.SOUTH;
                     break;
                 case 'R':
                     instructionType1 = InstructionType.RIGHT;
                     break;
                 case 'L':
                     instructionType1 = InstructionType.LEFT;
                     break;

                 default:
                     throw new IllegalStateException("Unexpected value: " + instructionType);
             }
             instructionList.add(new Instruction(instructionType1, parameter));
        }
        return instructionList;
    }
}
