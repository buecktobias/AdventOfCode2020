package aoc;

import java.util.List;

public class Passport {
    private List<String> keys;

    public Passport(List<String> keys){
        this.keys = keys;
    }

    public List<String> getKeys() {
        return keys;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "keys=" + keys +
                '}';
    }
}
