package aoc.tasks.task16;

import aoc.helper.Input;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task16Solver {
    public static List<TicketField> getTicketFields(String filename){
        List<TicketField> ticketFields = new LinkedList<>();
        String s = "";
        try {
           s =  Input.readFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern pattern = Pattern.compile(": ([\\d]+)-([\\d]+) or (\\d+)-(\\d+)");
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            int from1 = Integer.parseInt(matcher.group(1));
            int to1 = Integer.parseInt(matcher.group(2));
            int from2 = Integer.parseInt(matcher.group(3));
            int to2 = Integer.parseInt(matcher.group(4));
            Range range1 = new Range(from1, to1);
            Range range2 = new Range(from2, to2);
            TicketField ticketField = new TicketField(range1, range2);
            ticketFields.add(ticketField);
        }
        return ticketFields;
    }
    public static List<Integer> getAllTicketValues(String filename){
        String s = "";
        try {
            s = Input.readFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String nearbyTickets = s.split("nearby tickets:\n")[1];
        List<Integer> integerList = new LinkedList<>();
        String[] ticketValues = nearbyTickets.split("[,\n]");
        for (String ticketValue : ticketValues) {
            integerList.add(Integer.parseInt(ticketValue.replace("\n", "")));
        }
        return integerList;
    }

    public static Set<Integer> getAllCorrectValues(List<TicketField> ticketFieldList){
        Set<Integer> integerSet = new HashSet<>();
        List<Set<Integer>> allSets = ticketFieldList.stream().map(TicketField::getCorrectValues).collect(Collectors.toList());
        for(Set<Integer> set :allSets){
            integerSet.addAll(set);
        }
        return integerSet;
    }

    public static int solve(String filename){
        List<TicketField> ticketFields = Task16Solver.getTicketFields(filename);
        List<Integer> allIntegers = getAllTicketValues(filename);
        Set<Integer> correct = getAllCorrectValues(ticketFields);
        int scanningError = 0;
        for (Integer allInteger : allIntegers) {
            if(!correct.contains(allInteger)){
                scanningError+= allInteger;
            }
        }
        return scanningError;
    }
}
