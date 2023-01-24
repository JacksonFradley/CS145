import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Stack;

public class DeckOfCards {
    public static void main(String[] args) {


        ArrayList<String> deck = new ArrayList<String>();
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9"
                , "10", "Jack", "Queen", "King", "Ace"};


        //EnumSet.allOf(card.Suit.class).forEach(suit -> System.out.println(suit));


        // Build the deck
        for (String rank : ranks) {
            for (String suit: suits) {
                deck.add(rank + " of " + suit);
            }
        }

        // Shuffle the deck
        Collections.shuffle(deck);

        // Deal the cards
        Stack<String> pOne = new Stack<String>();
        Stack<String> pTwo = new Stack<String>();
        Stack<String> pThree = new Stack<String>();
        Stack<String> pFour = new Stack<String>();
        for (int i = 0; i < 13; i++) {
        pOne.push(deck.get(i));
        }
        for (int i = 13; i < 26; i++) {
            pTwo.push(deck.get(i));
        }
        for (int i = 26; i < 39; i++) {
            pThree.push(deck.get(i));
        }
        for (int i = 39; i < 52; i++) {
            pFour.push(deck.get(i));
        }


        for (int i = 0; i < 4; i++) {
            System.out.println(deck.get(i));
        }
    }
}
