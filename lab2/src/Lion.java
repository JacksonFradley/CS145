import java.awt.*;
import java.util.*;
public class Lion extends Critter{
    private int count;

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
        count++;
        if (count >= 4){
            count = 0;
        }
        Random rand = new Random();
        int randomNumber = rand.nextInt(3);

        if (randomNumber == 1) {
            return Color.RED;
        }
        else if (randomNumber == 2) {
            return Color.GREEN;
        }
        else {
                return Color.BLUE;
        }

        }

    public String toString() {
            return "L";
    }

}
