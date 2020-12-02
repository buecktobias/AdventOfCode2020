import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class Aufgabe2 {
    public static class PasswordChecker{
        public static int countAmount(char letter, String password){
            int counter = 0;
            for(char c: password.toCharArray()){
                if (c == letter){
                    counter++;
                }
            }
            return counter;
        }
        public static boolean isPasswordCorrect(Password pwd){
            char letter = pwd.getPolicyLetter();
             int amountLetter = PasswordChecker.countAmount(letter, pwd.getPassword());
             return pwd.getLowerBound() <= amountLetter && amountLetter <= pwd.getUpperBound();
        }
    }

    public static class Password{
        private final char policyLetter;
        private final int lowerBound;
        private final int upperBound;
        private final String password;

        public Password(char policyLetter, int lowerBound, int upperBound, String password) {
            this.policyLetter = policyLetter;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.password = password;
        }

        public char getPolicyLetter() {
            return policyLetter;
        }

        public int getLowerBound() {
            return lowerBound;
        }

        public int getUpperBound() {
            return upperBound;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "Password{" +
                    "policyLetter=" + policyLetter +
                    ", lowerBound=" + lowerBound +
                    ", upperBound=" + upperBound +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
    public static String[] getInputAsStringArray(String fileName){
        Path filePath = Path.of(fileName);
        String actual = null;
        try {
            actual = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arrOfStr = actual.split("\n");
        return arrOfStr;
    }

    public static List<Password> getInput(String filename){
        String[] inputStringArray = getInputAsStringArray(filename);
        List<Password> passwords = new LinkedList<>();
        for (String line : inputStringArray){
            String[] parts = line.split(" ");
            String bounds = parts[0];
            String letterPart = parts[1];
            String password = parts[2];

            int lowerBound = Integer.parseInt(bounds.split("-")[0]);
            int upperBound = Integer.parseInt(bounds.split("-")[1]);
            char letter = letterPart.toCharArray()[0];

            passwords.add(new Password(letter, lowerBound, upperBound, password));
        }
        return passwords;
    }

    public static int solvePart1(String filename){
        List<Password> passwordList = getInput(filename);
        int rightPasswords = 0;

        for(Password pwd: passwordList){
            if(PasswordChecker.isPasswordCorrect(pwd)){
                rightPasswords++;
            }
        }
        return rightPasswords;
    }
}
