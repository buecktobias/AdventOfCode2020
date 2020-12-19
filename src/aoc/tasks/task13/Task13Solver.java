package aoc.tasks.task13;

import aoc.helper.Input;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task13Solver {

    public static List<Bus> getInput(String filename){
        String[] stringArr = Input.getInputAsStringArray(filename);
        String busses = stringArr[1];
        Pattern regex = Pattern.compile("\\d+");
        Matcher matcher = regex.matcher(busses);
        List<Bus> busList = new LinkedList<>();
        while(matcher.find()){
            int busId = Integer.parseInt(matcher.group());
            busList.add(new Bus(busId));
        }
        return busList;
    }

    public static int getStartTime(String filename){
        String[] stringArr = Input.getInputAsStringArray(filename);
        String busses = stringArr[0];
        return Integer.parseInt(busses);
    }

    public static Optional<Integer> getBusIdComing(List<Bus> busses, int time){
        for (Bus bus : busses) {
            if(bus.isComing(time)){
                return Optional.of(bus.getId());
            }
        }
        return Optional.empty();
    }

    public static int solvePart1(String filename){
        int startTime = getStartTime(filename);
        List<Bus> busses = getInput(filename);
        for (int i = startTime; i < startTime * 2; i++) {
            Optional<Integer> possibleId = getBusIdComing(busses, i);
            if(possibleId.isPresent()){
                return possibleId.get() * (i - startTime);
            }
        }
        return -1;
    }

}
