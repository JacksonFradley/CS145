
public class Card{
    String Suit;
    String Rank;
    public Card(String s, String r){
        Suit = s;
        Rank = r;
    }

    public String toString(){
        return(Rank + " of " + Suit);
    }

    public int getRankInt(){
        switch(Rank){
            case "2":
                return(2);
            case "3":
                return(3);
            case "4":
                return(4);
            case "5":
                return(5);
            case "6":
                return(6);
            case "7":
                return(7);
            case "8":
                return(8);
            case "9":
                return(9);
            case "10":
                return(10);
            case "Jack":
                return(11);
            case "Queen":
                return(12);
            case "King":
                return(13);
            case "Ace":
                return(14);
        }
        return(0);
    }
}