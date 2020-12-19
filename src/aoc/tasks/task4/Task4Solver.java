package aoc.tasks.task4;

import aoc.helper.Input;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Task4Solver {

    public static Passport createPassport(String passport){
        String REGEX = "([\\w]{3}):([\\w#]*)";
        String INPUT = passport;
        Pattern pattern = Pattern.compile(REGEX);

        // get a matcher object
        Matcher matcher = pattern.matcher(INPUT);

        HashMap<String, String> hashMap = new HashMap<>();
        while(matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            hashMap.put(key, value);

        }
        Passport passport1 = new Passport(hashMap);
        return passport1;
    }
    public static List<Passport> getInput(String filename){
        String input= null;
        try {
            input = Input.readFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] passports= input.split("\n\n");
        List<Passport> passports1 = new LinkedList<>();
        for(String s: passports){
            passports1.add(createPassport(s));
        }
        return passports1;
    }

    public static int solvePart1(String filename){
        List<Passport> passports = getInput(filename);
        int counter = 0;
        for(Passport passport: passports){
            if(PassportChecker.isValid(passport)){
                counter++;
                System.out.println(passport);
            }
        }
        return counter;
    }
    public static int solvePart2(String filename){
        List<Passport> passports = getInput(filename);
        int counter = 0;
        for(Passport passport: passports){
            if(PassportChecker.isValidPart2(passport)){
                counter++;
            }
        }
        return counter;
    }
}
