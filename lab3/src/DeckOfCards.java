import java.util.Collections;
public class DeckOfCards {
    private Card[] deck = new Card[52];
    private String[] buildSuit = {"clubs", "diamonds", "hearts", "spades"};
    private String[] buildRank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};

    public DeckOfCards(){
        // builds the deck and automatically shuffles it.
        // if I feel like adding a lil extra sauce maybe there's a shuffle method that this constructor uses

    }
}
