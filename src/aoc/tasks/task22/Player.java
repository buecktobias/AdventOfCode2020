package aoc.tasks.task22;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Player {
    private Queue<Integer> cards;

    public Player(Collection<Integer> cards) {
        this.cards = new LinkedList<>();
        this.cards.addAll(cards);
    }

    public int getFirstCard(){
        return this.cards.remove();
    }
    public boolean hasCard(){
        return !this.cards.isEmpty();
    }

    public void addCards(Collection<Integer> cards){
        this.cards.addAll(cards);
    }

    public int getScore(){
        int amountCards = this.cards.size();
        int score = 0;
        int i = 0;
        while(this.hasCard()){
            score += this.getFirstCard() * (amountCards - i);
            i ++;
        }
        return score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "cards=" + cards +
                '}';
    }
}
