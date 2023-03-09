import java.awt.*;
public class Giant extends Critter{
    private int count;
    private int feCount;
    private int currentFe;
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
        String[] feFiFoFu = { "fum", "fee", "fie", "foe",};
        if(count % 6 == 0){
            feCount++;
            currentFe = feCount % 4;
        }
        count++;
        return feFiFoFu[currentFe];
    }


}// end of class
