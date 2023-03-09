import java.awt.*;
import java.util.*;
public class Lion extends Critter{
    private int count;
    private int currentC;

    public Action getMove(CritterInfo info) {
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }
        else if (info.getFront() == Neighbor.WALL){
            return Action.LEFT;
        }
        else if (info.getFront() == Neighbor.SAME){
            return Action.RIGHT;
        }
        else {
            return Action.HOP;
        }
    }



    public Color getColor() {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
        if (count % 3 == 0){
            currentC = (int)(Math.random() * 3);
        }
        count++;
        return colors[currentC];
    }

    public String toString() {
            return "L";
    }

}
