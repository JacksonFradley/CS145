//programmer: William Morton
//Class: CS141 Hybrid
//Date: 11/1/2021
//Assignment: Lab 4 (Guessing game)
//Purpose: Create a program that creates a random number and has the user input integers until they guess the integer

import java.util.Scanner; //import the scanning library for java
import java.util.*; // random number generator

class WMguessingGame
                        { //Main Method -Execute this program 

   public static void main(String[] args)
                                             {
//Define Variables
    int range = 100; //range of random number
    int games = 0; //total number of games
    int Guess = 0;//user guess
    int attempts = 0;
    int YN1 = 0;
    int YN2 = 0;
    int randomNumber = 0;
 

// introduction method         
        introduction(0);
        System.out.print("\tI think it's probably a good idea to start out with a quick introduction. ");
        System.out.print("My name is Gary the Guesser\nand I'm the lovechild of parental figures Gary (Phalic) and Guesser (Yonic). ");
        System.out.println("However it may have\nhappened, you seemed to have stumbled upon my numbers guessing game.");

        int a = game(randomNumber,0,0,range);//set the return value of game to an integer so it can be used for statistics of game
        Stats(a);//after each game, there is a statistics method that gets used
   //while loop to test if the user wants to play the game again
        while(true){
         System.out.println("Would you like to play again?");
         System.out.print("(Yes = 1)\n");
         System.out.print("(No  = 2)\n");
         Scanner Play1  = new Scanner(System.in);
         YN1 = Play1.nextInt();
         if (YN1 == 1){
         a = game(randomNumber,0,0,range);
         Stats(a);
         }
            else{
            System.out.println("Thank you for playing!");//goodbye section
            break;
            }//end of else
               }//end of while
                  }//end of main 
                  
// Introduction method
       public static void introduction(int YN2){
        Scanner Play2  = new Scanner(System.in);
        System.out.print("Would you like to partake in \"THE GUESSING GAME?\" \n");
        System.out.print("(Yes = 1)\n");
        System.out.print("(No  = 2)\n");
        YN2 = Play2.nextInt();
        while((YN2 != 1)|(YN2 != 2)){
         if (YN2 == 1){
         System.out.print("Great!\n");
         System.out.print("What is your name?\n");
         Scanner adj= new Scanner(System.in);  //creates a scanner to read string input  
         String Name= adj.nextLine();   //reads string before the space  
         System.out.printf("Glad to have you with us %s! \n\n", Name);
         break;
         }
           else{
           System.out.println(":{");
           System.exit(0);
           }//end of else
             }//end of while
                }//end of method
       
                                   
//game method              
       public static int game (int randomNumber, int Guess, int attempts, int range){
       Random rand = new Random();
       randomNumber = rand.nextInt(range)+1; // random number generation
       System.out.print("\n\tI have randomly selected a number between 1 and 100. ");
       System.out.println("You may have as many guesses as you need, with each\nguess prompting a response of \"Higher\" or \"Lower\". ");
   //while loop for guessing game
       while(Guess != randomNumber){
         System.out.println("What is your Guess?");
         Scanner GuessIn  = new Scanner(System.in);
         Guess = GuessIn.nextInt(); 
            if (Guess>randomNumber){
                 System.out.println("Lower");
                 attempts= attempts + 1;
            }//end of if
               else if (Guess<randomNumber){
                    System.out.println("Higher");
                    attempts= attempts + 1;
                  }//end of else if  
                  else{
                       System.out.printf("Congradulations!\n");
                       attempts= attempts + 1;
                  }//end of else
                     }//end of while loop
 System.out.printf("You got the answer in %d attempt\n", attempts);//give user total attempts
         return attempts;//return value for method
                        }//end of guessing method
//statistics method                       
        public static void Stats (int a){
        double guessperc = 0;
        guessperc = (100/a);
        System.out.printf("you had a guessing rate of %.2f percent\n", guessperc);
        }//end of method
            }//end of class