package aoc.tasks.task14;

import aoc.helper.Input;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aufgabe14Solver {

    public static List<MemoryCommand> getInput(String filename)throws Exception{
        String[] lines = Input.getInputAsStringArray(filename);
        List<MemoryCommand> memoryCommands = new LinkedList<>();
        for (String line : lines) {
            if (line.contains("mem")){
                String regexMem = "(\\d+)] = (\\d+)";
                Pattern pattern = Pattern.compile(regexMem);
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()){
                    memoryCommands.add(new ChangeMemoryCommand(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(1))));
                }else{
                    throw new Exception("Regex does not Match! Line is Invalid: " + line);
                }
            }else if(line.contains("mask")){
                String regexMask = "= ([\\dX]+)";
                Pattern pattern = Pattern.compile(regexMask);
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()){
                    memoryCommands.add(new ChangeBitMapCommand(new BitMask(matcher.group(1))));
                }else{
                    throw new Exception("Regex does not Match! Line is Invalid: " + line);
                }
            }else{
                throw new Exception("Invalid Input Line :" + line );
            }
        }
        return memoryCommands;
    }
    public static long getSum(Collection<Long> collection){
        long sum = 0;
        for (Long integer : collection) {
            sum += integer;
        }
        return sum;
    }

    public static long solvePart(String filename){
        List<MemoryCommand> commandList = new LinkedList<>();
        try {
            commandList = Aufgabe14Solver.getInput(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Memory mem = new Memory();
        mem.executeCommands(commandList);
       Collection<Long> collection =  mem.getMemory().values();
       return getSum(collection);
    }
}
