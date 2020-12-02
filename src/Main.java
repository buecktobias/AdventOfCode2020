import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("unchecked")
    private static Aufgabe getTask(int day) {
        Aufgabe task = null;
        try {
            Class<Aufgabe> taskClass = (Class<Aufgabe>) Class.forName("Aufgabe" + day);
            Constructor<Aufgabe> taskConstructor = taskClass.getConstructor();
            task = (Aufgabe) taskConstructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return task;
    }

    private static String getFilename(int day) {
        return "input" + day + ".txt";
    }

    private static Method getSolveFunction(Aufgabe task, int part) {
        Method solveFunction = null;
        try {
            solveFunction = task.getClass().getMethod("solvePart" + part, String.class);
        } catch (NoSuchMethodException | SecurityException ex) {
            ex.printStackTrace();
        }
        return solveFunction;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter day: ");
        int day = scanner.nextInt();

        if (day < 1 || day > 25) {
            scanner.close();
            System.err.println("Enter a day between 1 and 25.");
            return;
        }

        System.out.print("Enter part: ");
        int part = scanner.nextInt();

        if (part < 1 || part > 2) {
            scanner.close();
            System.err.println("Enter a part between 1 and 2.");
            return;
        }

        scanner.close();

        Aufgabe task = getTask(day);
        String filename = getFilename(day);

        Method solveFunction = getSolveFunction(task, part);
        try {
            String solution = (String) solveFunction.invoke(task, filename);
            System.out.println(solution);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}
