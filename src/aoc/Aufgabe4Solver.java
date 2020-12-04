package aoc;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aufgabe4Solver {

    public static Passport createPassport(String passport){
        String REGEX = "([\\w]{3}):";
        String INPUT = passport;
        Pattern pattern = Pattern.compile(REGEX);

        // get a matcher object
        Matcher matcher = pattern.matcher(INPUT);

        List<String> keys = new LinkedList<>();
        while(matcher.find()) {
            keys.add(matcher.group(1));
        }
        Passport passport1 = new Passport(keys);
        return passport1;
    }
    public static List<Passport> getInput(String filename){
        String input= null;
        try {
            input = Input.readFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] passports=input.split("\n\n");
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
}
