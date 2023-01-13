import java.awt.*;
public class Giant extends Critter{
    private int count;
    public Action getMove(CritterInfo info) {
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }
        else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }
        else {
            return Action.RIGHT;
        }
    }



    public Color getColor() {
            return Color.GRAY;
    }
    public String toString() {
        count= count+1;
        if (count >= 24){
            count = 0;
        }
        if (count <= 5) {
            return "FEE";
        } else if (count >= 6 && count <= 11) {
            return "FIE";
        } else if (count >= 12 && count <= 17) {
            return "FOE";
        } else {
            return "FUM";
        }
    }


}// end of class
