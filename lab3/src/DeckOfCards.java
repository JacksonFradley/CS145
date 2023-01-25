import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards{
    public ArrayList<Card> deck = new ArrayList<Card>();
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9"
            , "10", "Jack", "Queen", "King", "Ace"};
    //EnumSet.allOf(card.Suit.class).forEach(suit -> System.out.println(suit));

    // Build the deck
    DeckOfCards(){

        for(String rank : ranks){
                for (String suit : suits) {
                    deck.add(new Card(suit, rank));
                }
            }

            // Shuffle the deck
        Collections.shuffle(deck);
    }
}