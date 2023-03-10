import java.awt.*;

public class IGOR extends Critter{
    private boolean core = false;
    private int currentC;

    private static enum Swing {
        Left,
        Right
    }
    Swing dir = Swing.Right;


    public Critter.Action getMove(CritterInfo info) {
        core = false;
        //initialize variables
        int nearby = 0;

        // priority one is always to infect
        if(info.getFront() == Critter.Neighbor.OTHER){
            return Critter.Action.INFECT;
        }

        //how many "allys" nearby
        if(info.getFront() == Critter.Neighbor.SAME || info.getFront() == Critter.Neighbor.WALL){
            nearby++;
        }
        if(info.getRight() == Critter.Neighbor.SAME || info.getRight() == Critter.Neighbor.WALL){
            nearby++;
        }
        if(info.getBack() == Critter.Neighbor.SAME || info.getBack() == Critter.Neighbor.WALL){
            nearby++;
        }
        if(info.getLeft() == Critter.Neighbor.SAME || info.getLeft() == Critter.Neighbor.WALL){
            nearby++;
        }

        switch(nearby) {


            //if 4, spin
            case 4:
                core = true;
                return Action.RIGHT;

            //if 0, fly south
            case 0:
                if (info.getDirection() == Critter.Direction.SOUTH) {
                    return Action.HOP;
                } else if (info.getDirection() == Critter.Direction.WEST) {
                    return Action.LEFT;
                } else {
                    return Action.RIGHT;
                }

            case 1:
            case 2:
                //ingore this for now



//                if(info.getDeclaredMethod("get" + dir.name(), null) == Critter.Neighbor.WALL || info.getDeclaredMethod("get" + dir.name(), null) == Critter.Neighbor.SAME) {
//                    return Action.getDeclaredMethod(dir.name().toUpperCase(), null);
 //               }
 //               else
 //           }

                var neighborSideOfInterest = dir == Swing.Right ? info.getRight() : info.getLeft();

                if ( ShouldChangeDirection(neighborSideOfInterest) ) {
                    // Change direction of dir
                    dir = dir == Swing.Right ? Swing.Left : Swing.Right;

                    // If this was a boolean, you could do
                    // dir = !dir;
                }

                return (dir == Swing.Right) ? Action.RIGHT : Action.LEFT;

            case 3:
                 if(info.getFront() == Critter.Neighbor.EMPTY){
                     return Action.INFECT;
                }
                 else{
                     if(info.getLeft() == Critter.Neighbor.EMPTY){
                         return Action.LEFT;
                     }
                     else{
                         return Action.RIGHT;
                     }
                 }
        }
        return Action.RIGHT;
    }

    private boolean ShouldChangeDirection(Critter.Neighbor side) {
        if (side == Critter.Neighbor.WALL || side == Critter.Neighbor.SAME) {
            return true;
        }
        return false;
    }

    public Color getColor() {
        if(core) {
            Color[] colors = {Color.cyan, Color.MAGENTA, Color.BLUE};
            currentC = (int) (Math.random() * 3);
            return colors[currentC];
        }
        else{
            return Color.BLACK;
        }
    }

    public String toString() {
        if(core) {
            return "??????";
        }
        else{
            return "??????";
        }

    }



}
