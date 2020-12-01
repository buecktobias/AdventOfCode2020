import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Aufgabe1 {
    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean sumIs(int a, int b, int sum){
        return add(a,b) == sum;
    }

    public static int multiply(int a, int b){
        return a * b;
    }

    public static boolean isSum2020(int a, int b){
        return sumIs(a,b,2020);
    }

    public static boolean hasSum (List<Integer> list){
        int element1;
        int element2;

        for(int i = 0; i < list.size()-1; i++) {
            for(int k = i+1; k < list.size(); k++){
                element1 = list.get(i);
                element2 = list.get(k);
                if(isSum2020(element1, element2)){
                    return true;
                }
            }
        }
        return false;
    }

    public static int multiplyElements(List<Integer> list){
        int element1;
        int element2;

        for(int i = 0; i < list.size()-1; i++) {
            for(int k = i+1; k < list.size(); k++){
                element1 = list.get(i);
                element2 = list.get(k);
                if(isSum2020(element1, element2)){
                    return multiply(element1, element2);
                }
            }
        }
        return -1;
    }
/*
 */
}
