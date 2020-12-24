package aoc.tasks.task22;

import aoc.helper.Input;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task22Solver {
    public static Game getInput(String filename) {
        String s = "";
        try {
            s = Input.readFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        s = s.replace("Player 1:\n", "");
        s = s.replace("Player 2:\n", "");
        String[] cards = s.split("\n\n");
        String player1Cards = cards[0];
        String player2Cards = cards[1];
        String[] player1CardList = player1Cards.split("\n");
        String[] player2CardList = player2Cards.split("\n");
        List<Integer> cards1IntList = Arrays.stream(player1CardList).map(card -> Integer.valueOf(card)).collect(Collectors.toList());
        List<Integer> cards2IntList = Arrays.stream(player2CardList).map(card -> Integer.valueOf(card)).collect(Collectors.toList());
        Player player1 = new Player(cards1IntList);
        Player player2 = new Player(cards2IntList);
        return new Game(player1, player2);
    }

    public static int solvePart1(String filename){
        Game game = getInput(filename);
        try {
            return game.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
