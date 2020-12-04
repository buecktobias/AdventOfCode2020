package aoc.aufgabe4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportChecker {
    public static boolean isValid(Passport passport){
        return passport.getHashMap().size() == 8 || (! passport.getHashMap().containsKey("cid") && passport.getHashMap().size() == 7);
    }
    public static boolean isValidPart2(Passport passport){
        if(isValid(passport)){
            return hasCorrectBirthYear(passport) &&
                    hasCorrectExpiration(passport) &&
                    hasCorrectEyeColor(passport) &&
                    hasCorrectHairColor(passport) &&
                    hasCorrectHeight(passport) &&
                    hasCorrectIssueYear(passport) &&
                    hasCorrectPassportId(passport)
                    ;
        }else{
            return false;
        }
    }

    public static boolean hasCorrectBirthYear(Passport passport){
        String birthYear = passport.getBirthYear();
        Integer birthYearInteger = Integer.valueOf(birthYear);
        return birthYearInteger <= 2002 &&  birthYearInteger >= 1920;
    }

    public static boolean hasCorrectIssueYear(Passport passport){
        String issueYear = passport.getIyr();
        Integer issueYearInteger = Integer.valueOf(issueYear);
        return issueYearInteger <= 2020 &&  issueYearInteger >= 2010;
    }

    public static boolean hasCorrectExpiration(Passport passport){
        String expirationYear = passport.getEyr();
        Integer expirationYearInteger = Integer.valueOf(expirationYear);
        return expirationYearInteger <= 2030 &&  expirationYearInteger >= 2010;
    }

    public static boolean hasCorrectHeight(Passport passport){
        String height = passport.getHgt();
        String REGEX = "(\\d*)(in|cm)";
        Pattern pattern = Pattern.compile(REGEX);

        // get a matcher object
        Matcher matcher = pattern.matcher(height);
        String unit = "";
        Integer number = 0;
        if(matcher.find()){
            number = Integer.valueOf(matcher.group(1));
            unit = matcher.group(2);
        }
        return (unit.equals("in") && number >= 59 && number <= 76) || (unit.equals("cm") && number >= 150 && number <= 193);
    }
    
    public static boolean hasCorrectHairColor(Passport passport){
        String color = passport.getHcl();
        if (color.length() == 7) {
            String REGEX = "#([0-9a-f]{6})";
            Pattern pattern = Pattern.compile(REGEX);

            // get a matcher object
            Matcher matcher = pattern.matcher(color);
            return matcher.find();
        }
        return false;
    }

    public static boolean hasCorrectEyeColor(Passport passport){
        String eye = passport.getEcl();
        String REGEX = "amb|blu|brn|gry|grn|hzl|oth";
        Pattern pattern = Pattern.compile(REGEX);
        // get a matcher object
        Matcher matcher = pattern.matcher(eye);
        return matcher.find();
    }

    public static boolean hasCorrectPassportId(Passport passport){
        String pid = passport.getPid();
        String REGEX = "[0-9]{9}";
        if(pid.length() == 9){
            Pattern pattern = Pattern.compile(REGEX);
            // get a matcher object
            Matcher matcher = pattern.matcher(pid);
            return matcher.find();
        }else{
            return false;
        }
    }

}
