public class Aufgabe1 {
    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean sumIs(int a, int b, int sum){
        if(add(a,b) == sum){
            return true;
        } else{
            return false;
        }
    }

    public static int multiply(int a, int b){
        return a * b;
    }

}
