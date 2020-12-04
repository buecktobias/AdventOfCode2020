package aoc;

public class PassportChecker {
    public static boolean isValid(Passport passport){
        return passport.getKeys().size() == 8 || (! passport.getKeys().contains("cid") && passport.getKeys().size() == 7);
    }
}
