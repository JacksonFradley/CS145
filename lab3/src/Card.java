
public class Card{
    String Suit;
    String Rank;
    public Card(String s, String r){
        Suit = s;
        Rank = r;
    }

    public String Read(){
        return(Rank + " of " + Suit);
    }
}