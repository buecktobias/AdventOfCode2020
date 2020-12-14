package aoc.tasks.task4;

import java.util.HashMap;

public class Passport {
    private HashMap<String, String> hashMap;
    /*
    byr (Birth Year) - four digits; at least 1920 and at most 2002.
    iyr (Issue Year) - four digits; at least 2010 and at most 2020.
    eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
    hgt (Height) - a number followed by either cm or in:
    If cm, the number must be at least 150 and at most 193.
    If in, the number must be at least 59 and at most 76.
    hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    pid (Passport ID) - a nine-digit number, including leading zeroes.
    cid (Country ID) - ignored, missing or not.

     */
    public Passport(HashMap<String,String> hashMap){
        this.hashMap = hashMap;
    }

    public HashMap<String, String> getHashMap() {
        return hashMap;
    }

    public String getBirthYear(){
        return this.hashMap.get("byr");
    }

    public String getIyr(){
        return this.hashMap.get("iyr");
    }

    public String getEyr(){
        return this.hashMap.get("eyr");
    }

    public String getHgt(){
        return this.hashMap.get("hgt");
    }

    public String getHcl(){
        return this.hashMap.get("hcl");
    }

    public String getEcl(){
        return this.hashMap.get("ecl");
    }

    public String getPid(){
        return this.hashMap.get("pid");
    }

    public String getCid(){
        return this.hashMap.get("cid");
    }


    @Override
    public String toString() {
        return "Passport{" +
                "hashMap=" + hashMap +
                '}';
    }
}
