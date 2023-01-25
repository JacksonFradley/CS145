import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void main(String[] args) {
        String query2;
        boolean speedmode = false;
        //start game? prompt
        System.out.println("Start Game?\n(yes or no)");
        Scanner Play1 = new Scanner(System.in);
        String query = Play1.next().toLowerCase();
        if (query.indexOf("y") != 0) {
            System.exit(0);
        }
        boolean playing = true;
        //split deck between a player array and a cpu array
        DeckOfCards startDeck = new DeckOfCards();
        ArrayList<card> playerDeck = new ArrayList<card>();
        ArrayList<card> cpuDeck = new ArrayList<card>();

        for (int counter = 0; counter < 26; counter++) {
            playerDeck.add(startDeck.deck.get(counter));
        }
        for (int counter = 0; counter < 26; counter++) {
            cpuDeck.add(startDeck.deck.get(counter + 26));
        }

        try {
            //place card? or status
            while (playing == true) {

                int countWAR = 0;
                if (!speedmode) {
                    System.out.println("Enter \"f\" to flip card\nEnter \"s\" to get status of current game\nEnter \"z\" to enter speed mode");
                    Scanner Play2 = new Scanner(System.in);
                    query2 = Play2.next().toLowerCase();
                } else {
                    query2 = "f";
                }
                // if place card:
                if (query2.equals("f")) {
                    //display players top card + display cpu's top card
                    System.out.print("\nplayer: ");
                    Game.wait(speedmode);
                    System.out.print(playerDeck.get(0).toString());
                    Game.wait(speedmode);
                    System.out.print("\ncomputer: ");
                    Game.wait(speedmode);
                    System.out.print(cpuDeck.get(0).toString());
                    Game.wait(speedmode);
                    System.out.println("\n");
                    //if player higher, add cards to players pile
                    if (playerDeck.get(0).getRankInt() > cpuDeck.get(0).getRankInt()) {
                        System.out.println("you won the round");
                        playerDeck.add(cpuDeck.get(0));
                        playerDeck.add(playerDeck.get(0));
                        playerDeck.remove(0);
                        cpuDeck.remove(0);
                    }
                    //if cpu higher, add cards to cpu pile
                    else if (cpuDeck.get(0).getRankInt() > playerDeck.get(0).getRankInt()) {
                        System.out.println("cpu won the round");
                        cpuDeck.add(playerDeck.get(0));
                        cpuDeck.add(cpuDeck.get(0));
                        cpuDeck.remove(0);
                        playerDeck.remove(0);
                    }
                    //if equal, initiate war
                    else {
                        countWAR++;
                        while (countWAR > 0) {
                            System.out.println("cards equal, WAR started\n");
                            Game.wait(speedmode);

                            //W - flip card
                            System.out.print("W");
                            System.out.print("\nplayer: ");
                            System.out.print(playerDeck.get(countWAR).toString());
                            System.out.print("\ncomputer: ");
                            System.out.print(cpuDeck.get(countWAR).toString());
                            System.out.println("\n");
                            Game.wait(speedmode);

                            //A - flip card
                            System.out.print("A");
                            System.out.print("\nplayer: ");
                            System.out.print(playerDeck.get(countWAR + 1).toString());
                            System.out.print("\ncomputer: ");
                            System.out.print(cpuDeck.get(countWAR + 1).toString());
                            System.out.println("\n");
                            Game.wait(speedmode);

                            //R - flip card
                            System.out.print("R");
                            System.out.print("\nplayer: ");
                            System.out.print(playerDeck.get(countWAR + 2).toString());
                            System.out.print("\ncomputer: ");
                            System.out.print(cpuDeck.get(countWAR + 2).toString());
                            System.out.println("\n");
                            Game.wait(speedmode);

                            //WAR - final flip card, whoever is higher takes all cards flipped
                            System.out.println("WAR!");
                            Game.wait(speedmode);

                            System.out.print("\nplayer: ");
                            Game.wait(speedmode);

                            System.out.print(playerDeck.get(countWAR + 3).toString());
                            Game.wait(speedmode);

                            System.out.print("\ncomputer: ");
                            Game.wait(speedmode);

                            System.out.print(cpuDeck.get(countWAR + 3).toString());
                            Game.wait(speedmode);

                            System.out.println("\n");
                            Game.wait(speedmode);

                            if (playerDeck.get(countWAR + 3).getRankInt() > cpuDeck.get(countWAR + 3).getRankInt()) {
                                System.out.println("you won the WAR");
                                for (int c = 0; c < countWAR + 4; c++) {
                                    playerDeck.add(cpuDeck.get(0));
                                    playerDeck.add(playerDeck.get(0));
                                    playerDeck.remove(0);
                                    cpuDeck.remove(0);
                                }
                                countWAR = 0;
                            }
                            //if cpu higher, add cards to cpu pile
                            else if (cpuDeck.get(countWAR + 3).getRankInt() > playerDeck.get(countWAR + 3).getRankInt()) {
                                System.out.println("cpu won the WAR");
                                for (int c = 0; c < countWAR + 4; c++) {
                                    cpuDeck.add(playerDeck.get(0));
                                    cpuDeck.add(cpuDeck.get(0));
                                    cpuDeck.remove(0);
                                    playerDeck.remove(0);
                                }
                                countWAR = 0;
                            } else {
                                countWAR = countWAR + 4;
                            }
                        }
                    }
                }
                //if status
                else if (query2.equals("s")) {

                    //display how many cards are left to play in deck, how many cards in cpu pile and player pile
                    System.out.println("You have " + playerDeck.size() + " cards");
                    System.out.println("the computer has " + cpuDeck.size() + " cards");
                } else if (query2.equals("z")) {
                    speedmode = true;
                } else {
                    System.out.println("please try again");
                }

            }
        } catch(IndexOutOfBoundsException e) {
            if(playerDeck.size() > cpuDeck.size()) {
                System.out.println("\n\n\n\n\nYou Won!");
            }
            else if(cpuDeck.size() > playerDeck.size()) {
                System.out.println("\n\n\n\n\nYou Lost!");
            }
            else {
                System.out.println("\n\n\n\n\nyou are really lucky");
            }
        }
    }
    public static void wait( boolean s){
        if (!s) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("got interrupted!");
            }
        }
    }

}
