//programmer: William Morton
//Class: CS141 Hybrid
//Date: 11/1/2021
//Assignment: Lab 4 (Guessing game)
//Purpose: Create a program that creates a random number and has the user input integers until they guess the integer

import java.util.Scanner; //import the scanning library for java
import java.util.*; // random number generator


public class WMguessingGame
{ //Main Method -Execute this program

    public static void main(String[] args)
    {
//Define Variables
        int range = 100; //range of random number
//*****removed a couple variables that either were redundant or could be local variables -Fradley

// introduction method         
        introduction();


        int a = game(0,range);//set the return value of game to an integer, so it can be used for statistics of game
        Stats(a);//after each game, there is a statistics method that gets used
        //while loop to test if the user wants to play the game again
        while(true){
            System.out.println("Would you like to play again?\n(Yes or No)\n");
            Scanner Play1  = new Scanner(System.in);
            String YN1 = Play1.next();
//***** changed the query to accept Yes or no as answers instead of 1 (yes) or 2 (no) -Fradley
//***** Removed a redundant while loop and made it just an if-else -Fradley
            if (YN1.toLowerCase().indexOf("y") == 0){
                a = game(0,range);
                Stats(a);
            }
            else{
                System.out.println("Thank you for playing!");//goodbye section
                break;
            }//end of else
        }//end of while
    }//end of main

    // Introduction method
    public static void introduction(){
        Scanner Play2  = new Scanner(System.in);
        System.out.print("Would you like to partake in \"THE GUESSING GAME\"? \n(Yes or No)\n");
//***** simplified print to use one line instead of 3 - Fradley
        String YN2 = Play2.next();
//***** changed the query to accept Yes or no as answers instead of 1 (yes) or 2 (no) -Fradley
        if( YN2.toLowerCase().indexOf("y") == 0 ) {
            System.out.print("Great!\nWhat is your name?\n");
            Scanner adj = new Scanner(System.in);  //creates a scanner to read string input
            String Name = adj.nextLine();   //reads string before the space
            System.out.printf("Glad to have you with us %s! \n\n", Name);
            System.out.print("\tI think it's probably a good idea to start out with a quick introduction. ");
            System.out.print("My name is Gary the Guesser\nand I'm the lovechild of parental figures Gary (Phalic) and Guesser (Yonic). ");
            System.out.println("However it may have\nhappened, you seemed to have stumbled upon my numbers guessing game.");
        }
        else{
            System.out.println(":{");
            System.exit(0);
        }//end of else
        //end of while
    }//end of method


    //game method
    public static int game (int attempts, int range){
//***** changed Guess to be a local variable -Fradley
        int Guess = 0;
        Random rand = new Random();
        int randomNumber = rand.nextInt(range)+1; // random number generation
        System.out.printf("\n\tI have randomly selected a number between 1 and " + range + ". You may have as many guesses as you need, with each\nguess prompting a response of \"Higher\" or \"Lower\". ");
//***** made this game text change if the range changes -Fradley
        //while loop for guessing game
        while(Guess != randomNumber){
            System.out.println("\nWhat is your Guess?");
            Scanner GuessIn  = new Scanner(System.in);
            Guess = GuessIn.nextInt();
            if (Guess>randomNumber){
                System.out.println("Lower");
            }//end of if
            else if (Guess<randomNumber){
                System.out.println("Higher");
            }//end of else if
            else{
                System.out.print("Congratulations!\n");
            }//end of else
//***** Attempts was originally inside each seperate if-elseif-else. moved it outside of the loop. -Fradley
            attempts= attempts + 1;
        }//end of while loop
        System.out.printf("You got the answer in %d attempt(s)\n", attempts);//give user total attempts
        return attempts;//return value for method
    }//end of guessing method
    //statistics method
    public static void Stats (int a){
        double guessperc = (100.0/a);
        System.out.printf("you had a guessing rate of %.2f percent\n", guessperc);
    }//end of method
}//end of class