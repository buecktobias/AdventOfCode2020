package aoc.aufgabe13;

public class Bus {
    private int id;

    public Bus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isComing(int time){
        return time % this.id == 0;
    }
}
