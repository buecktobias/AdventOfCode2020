package aoc.aufgabe3;

public class Field {
    private Pattern pattern;

    public Field(Pattern pattern) {
        this.pattern = pattern;
    }

    public FieldObject getObjectAt(int x, int y){
        int newX = x % this.pattern.getWidth();
        return this.pattern.getObjectAt(newX, y);
    }

    public boolean isIn(Player player){
        return player.getY() < this.pattern.getheight();
    }
}
