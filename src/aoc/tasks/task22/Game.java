package aoc.tasks.task22;

import java.util.Arrays;

public class Game {
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playOneRound() throws Exception{
        int card1 = player1.getFirstCard();
        int card2 = player2.getFirstCard();
        if (card1 > card2){
            player1.addCards(Arrays.asList(card1, card2));
        }else if (card2 > card1){
            player2.addCards(Arrays.asList(card2, card1));
        }else{
            throw new Exception("Same cards !!");
        }
    }

    public int play() throws Exception {
        while(player1.hasCard() && player2.hasCard()){
            this.playOneRound();
        }
        System.out.println(player1);
        System.out.println(player2);
        if (player1.hasCard()){
            return player1.getScore();
        }else{
            return player2.getScore();
        }
    }
}
