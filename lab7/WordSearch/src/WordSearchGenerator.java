import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
// is the size predefined or should it be fluid? if fluid, How?
// randomly choose if it's going to be Horizontal, Vertical, Diagonal-up, or Diagonal-down
// evaluate all available locations - identifed by the location of the first letter. (include all possible intersections???)
// randomly choose one of the available locations
// branching off of this /\. maybe have a method that will run every time you generate a new word.
// this method would be specific to the randomly chosen direction and the defined length of the word.
// this method running every time a word is generated would allow it to have the option to be placed
// in locations specific to that word based off of intersections.
// maybe it prioritizes intersections because they make for a more interesting word search?
// if there aren't any available locations, add +1 to each dimention of the square.
// then, only evaluate locations that are touched by those new squares.
// what does that mean? /\ if a location on the right side now has an additional
// space to work with based off of the direction and length of the word,
// that space should be reevaluated. but any location that isn't changed, should not.

public class WordSearchGenerator {
    ArrayList<ArrayList<Character>> wordSearch = new ArrayList<>();
    enum Directions {HORIZONTAL
        ,VERTICAL
        //,DIAGONAL_UP
        //,DIAGONAL_DOWN
        }

    int wordLength;
    Directions currentDirection;
    boolean triedH = false;
    boolean triedV = false;


    public void generate(String newWord){
        newWord = newWord.toUpperCase();
        wordLength = newWord.length();

        if(wordSearch.isEmpty()) {
            ArrayList<ArrayList<Character>> temp = new ArrayList<>(wordLength);
            boolean halfwaypoint = false;
            for (int i = 0; i < wordLength; i++) {
                if(!halfwaypoint && i >= wordLength/2){
                    ArrayList<Character> thisArr = new ArrayList<>();
                    for(int ii = 0; ii < wordLength; ii++){
                        thisArr.add(newWord.charAt(ii));
                    }
                    temp.add(thisArr);
                    halfwaypoint = true;
                }
                else{
                    ArrayList<Character> thisArr = new ArrayList<>();
                    for(int ii = 0; ii < wordLength; ii++){
                        thisArr.add((char)32);
                    }
                    temp.add(thisArr);
                }
            }

            wordSearch = temp;
        }
        else{
            this.setRandomDirection();
            if(wordLength > wordSearch.size()){
                this.increaseSize(wordLength - wordSearch.size());
            }
            triedH = false;
            triedV = false;
            this.place(this.scan(newWord), currentDirection, newWord);

        }
    }

    public String toString(){
        String temp = "";
        for(ArrayList<Character> arr : wordSearch){
            for(Character chr : arr){
                if(chr == (char)32){
                    temp += "X ";
                }
                else{
                    temp += chr.toString() + " ";
                }
            }
            temp += "\n";
        }
        return temp;
    }

    public void increaseSize(int amount) {
        ArrayList<ArrayList<Character>> nextWordSearch = new ArrayList<>();

        // Make even it amount is odd
        if (amount % 2 != 0) {
            amount += 1;
        }


        for (int i = 0; i < amount/2; i++) {
            ArrayList<Character> bumperArr = new ArrayList<>();
            for (int j = 0; j < wordSearch.size() + amount; j++) {
                bumperArr.add((char) 32);
            }
            nextWordSearch.add(bumperArr);
        }

        for (ArrayList<Character> arr : wordSearch) {
            ArrayList<Character> tempArr = new ArrayList<>();

            for (int i = 0; i < amount/2; i++) {
                tempArr.add((char) 32);
            }
            for (Character chr : arr) {
                tempArr.add(chr);
            }

            for (int i = 0; i < amount/2; i++) {
                tempArr.add((char) 32);
            }

            nextWordSearch.add(tempArr);
        }

        for (int i = 0; i < amount/2; i++) {
            ArrayList<Character> bumperArr = new ArrayList<>();
            for (int j = 0; j < wordSearch.size() + amount; j++) {
                bumperArr.add((char) 32);
            }
            nextWordSearch.add(bumperArr);
        }

        wordSearch = nextWordSearch;
    }

    public int[] scan(String word){
        boolean canPlace;
        int[] temp = new int[2];


        switch(currentDirection){
            case HORIZONTAL:
                triedH = true;
                System.out.println("started H scan");
                for(int i = 0; i < wordSearch.size(); i++){
                    System.out.println("Scanning array " + i);
                    for(int ii = 0; ii <= wordSearch.size() - wordLength; ii++){
                        System.out.println("Scanning char " + ii);
                        canPlace = true;
                        for(int letter = 0; letter < wordLength; letter++){
                            if(!(wordSearch.get(i).get(ii + letter) == (char)32 || wordSearch.get(i).get(ii + letter) == word.charAt(letter))){
                                System.out.println("Can't place at [" + ii + ", " + i + "]");
                                canPlace = false;
                            }
                        }
                        if(canPlace){
                            System.out.println("Can Place H");
                            temp[0] = i;
                            temp[1] = ii ;
                            return temp;
                        }
                    }
                }
                if(!triedV){
                    currentDirection = Directions.VERTICAL;
                    return this.scan(word);
                }
                break;
            case VERTICAL:
                triedV = true;
                System.out.println("Started V scan");
                for(int i = 0; i <= wordSearch.size() - wordLength; i++){
                    for(int ii = 0; ii < wordSearch.size(); ii++){
                        canPlace = true;
                        for(int letter = 0; letter < wordLength; letter++){
                            if(!(wordSearch.get(i+letter).get(ii) == (char)32 || wordSearch.get(i + letter).get(ii) == word.charAt(letter))){
                                System.out.println("Can't place at [" + ii + ", " + i + "]");
                                canPlace = false;
                            }
                        }
                        if(canPlace){
                            System.out.println("Can Place V");
                            temp[0] = i;
                            temp[1] = ii ;
                            return temp;
                        }
                    }
                }
                if(!triedH) {
                    currentDirection = Directions.HORIZONTAL;
                    return this.scan(word);
                }
                break;
        }

        temp[0] = -1;
        temp[1] = -1;
        System.out.println("scan failed");
        return temp;
    }

    public void setRandomDirection(){

        int randDirection = (int)(Math.random() * Directions.values().length);
        currentDirection = Directions.values()[randDirection];

    }

    public void place(int[] location, Directions direction, String word) {
        for(int letter = 0; letter < wordLength; letter++) {
            switch(direction) {
                case HORIZONTAL:
                    wordSearch.get(location[0]).set(location[1] + letter, word.charAt(letter));
                    break;
                case VERTICAL:
                    wordSearch.get(location[0] + letter).set(location[1], word.charAt(letter));
                    break;
            }
        }
    }

}
