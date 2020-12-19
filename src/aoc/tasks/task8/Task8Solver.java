package aoc.tasks.task8;

import aoc.helper.Input;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8Solver {

    public static Program getInput(String filename) {
        Program program = new Program();
        String file = "";
        try {
            file = Input.readFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String regex = "(\\w+) ([\\+-]\\d*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(file);
        while (matcher.find()) {
            String commandName = matcher.group(1);
            int argument = Integer.parseInt(matcher.group(2));
            Command newCommand = Command.getCommand(commandName, argument);
            program.addCommand(newCommand);
        }
        return program;
    }

    public static int solvePart1(String filename) {
        Program program;
        program = getInput(filename);
        program.run();

        return program.getAccumulator();
    }

    public static int solvePart2(String filename) {
        Program program;
        int i = 0;
        do {
            program = getInput(filename);
            Command cmd = program.getCommands().get(i);
            if (cmd instanceof JumpCommand) {
                program.changeCommandAt(i, new NoOperation(cmd.getArgument()));
            } else if (cmd instanceof NoOperation) {
                program.changeCommandAt(i, new JumpCommand(cmd.getArgument()));
            }
            program.run();
            i++;
        } while (!program.hasTerminated());
        return program.getAccumulator();
    }
}
