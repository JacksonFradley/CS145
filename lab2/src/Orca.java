import java.awt.*;

import java.lang.reflect.*;

public class Orca extends Critter{

    private static enum Swing {
        Left,
        Right
    }
    Swing dir = Swing.Right;


    public Critter.Action getMove(CritterInfo info) {
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
        if(info.getRight() == Critter.Neighbor.SAME || info.getFront() == Critter.Neighbor.WALL){
            nearby++;
        }
        if(info.getBack() == Critter.Neighbor.SAME || info.getFront() == Critter.Neighbor.WALL){
            nearby++;
        }
        if(info.getLeft() == Critter.Neighbor.SAME || info.getFront() == Critter.Neighbor.WALL){
            nearby++;
        }

        switch(nearby) {


            //if 4, spin
            case 4:
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
        return Color.MAGENTA;
    }
    public String toString() {
        return "B";


    }



}
