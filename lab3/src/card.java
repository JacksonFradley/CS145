
public class card {

    private String suit;
    private String rank;
    //constructor
    public card(String suit, String rank){
        this.rank = rank;
        this.suit = suit;
    }


    enum Suit{
        DIAMONDS,
        SPADES,
        CLUBS,
        HEARTS
    }
    enum Rank{
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }
} // end of class