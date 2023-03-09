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
        ,DIAGONAL_UP
        ,DIAGONAL_DOWN
        }

    int wordLength;
    Directions currentDirection;
    boolean triedH = false;
    boolean triedV = false;
    boolean triedDD = false;
    boolean triedDU = false;

    ArrayList<int[]> horizontalMemory = new ArrayList<>();
    ArrayList<int[]> verticalMemory = new ArrayList<>();
    ArrayList<int[]> diagonalUpMemory = new ArrayList<>();
    ArrayList<int[]> diagonalDownMemory = new ArrayList<>();



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

    public String toString(boolean showSolution){
        String temp = "";
        for(ArrayList<Character> arr : wordSearch){
            for(Character chr : arr){
                if(chr == (char)32){
                    if(showSolution) {
                        temp += "X ";
                    }
                    else{
                        temp += (char)((Math.random() * 26) + 65) + " ";
                    }
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
        //System.out.println("Scanning for " + word);
        boolean canPlace;
        boolean flagIntersection;
        ArrayList<int[]> validPositions = new ArrayList<>();

        // Come back to this and optimize the flagIntersection boolean

        switch(currentDirection){
            case HORIZONTAL:
                triedH = true;
                //System.out.println("started H scan");
                for(int i = 0; i < wordSearch.size(); i++){
                    //System.out.println("Scanning array " + i);
                    for(int ii = 0; ii <= wordSearch.size() - wordLength; ii++){
                        //System.out.println("Scanning char " + ii);
                        canPlace = true;
                        flagIntersection = false;
                        for(int[] memoryAccess: horizontalMemory){
                            //System.out.println("accessing memory");
                            for(int letter = 0; letter < memoryAccess[2] + 1; letter++){
                                //System.out.println("checking letter " + letter);
                                if(i == memoryAccess[0] && ii == memoryAccess[1] + letter){
                                    //System.out.println("Memory conflict");
                                    canPlace = false;
                                }
                            }
                        }
                        for(int letter = 0; letter < wordLength; letter++){
                            if(!(wordSearch.get(i).get(ii + letter) == (char)32 || wordSearch.get(i).get(ii + letter) == word.charAt(letter))){
                                //System.out.println("Can't place at [" + ii + ", " + i + "]");
                                canPlace = false;
                            }
                            if(wordSearch.get(i).get(ii + letter) == word.charAt(letter)){
                                flagIntersection = true;
                                //System.out.println("flagging intersection");
                            }
                        }
                        if(canPlace){

                                //System.out.println("Can Place H");
                            int[] temp = new int[2];
                            temp[0] = i;
                            temp[1] = ii ;
                            if(flagIntersection){
                                store(temp);
                                return temp;
                            }
                            validPositions.add(temp);
                        }
                    }
                }
                if(!validPositions.isEmpty()){
                    int random = (int)(Math.random() * validPositions.size());
                    store(validPositions.get(random));
                    return validPositions.get(random);
                }
                if(!triedV){
                    currentDirection = Directions.VERTICAL;
                    return this.scan(word);
                }
                break;
            case VERTICAL:
                triedV = true;
                //System.out.println("Started V scan");
                for(int i = 0; i <= wordSearch.size() - wordLength; i++){
                    //System.out.println("Scanning array " + i);
                    for(int ii = 0; ii < wordSearch.size(); ii++){
                        //System.out.println("Scanning char " + ii);
                        canPlace = true;
                        flagIntersection = false;
                        for(int[] memoryAccess: verticalMemory){
                            //System.out.println("accessing memory");
                            for(int letter = 0; letter < memoryAccess[2] + 1; letter++){
                                //System.out.println("checking letter " + letter);
                                if(i == memoryAccess[0] + letter && ii == memoryAccess[1]){
                                    //System.out.println("Memory conflict");
                                    canPlace = false;
                                }
                            }
                        }
                        for(int letter = 0; letter < wordLength; letter++){
                            if(!(wordSearch.get(i+letter).get(ii) == (char)32 || wordSearch.get(i + letter).get(ii) == word.charAt(letter))){
                                //System.out.println("Can't place at [" + ii + ", " + i + "]");
                                canPlace = false;
                            }
                            if(wordSearch.get(i + letter).get(ii) == word.charAt(letter)){
                                flagIntersection = true;
                                //System.out.println("flagging intersection");
                            }
                        }
                        if(canPlace){
                            //System.out.println("Can Place V");
                            int[] temp = new int[2];
                            temp[0] = i;
                            temp[1] = ii ;
                            if(flagIntersection) {
                                store(temp);
                                return temp;
                            }
                            validPositions.add(temp);
                        }
                    }
                }
                if(!validPositions.isEmpty()){
                    int random = (int)(Math.random() * validPositions.size());
                    store(validPositions.get(random));
                    return validPositions.get(random);
                }
                if(!triedDD) {
                    currentDirection = Directions.DIAGONAL_DOWN;
                    return this.scan(word);
                }
                break;
            case DIAGONAL_DOWN:
                triedDD = true;
                //System.out.println("Started DD scan");
                for(int i = 0; i <= wordSearch.size() - wordLength; i++){
                    //System.out.println("Scanning array " + i);
                    for(int ii = 0; ii <= wordSearch.size() - wordLength; ii++){
                        //System.out.println("Scanning char " + ii);
                        canPlace = true;
                        flagIntersection = false;
                        for(int[] memoryAccess: diagonalDownMemory){
                            //System.out.println("accessing memory");
                            for(int letter = 0; letter < memoryAccess[2] + 1; letter++){
                                //System.out.println("checking letter " + letter);
                                if(i == memoryAccess[0] + letter && ii == memoryAccess[1] + letter){
                                    //System.out.println("Memory conflict");
                                    canPlace = false;
                                }
                            }
                        }
                        for(int letter = 0; letter < wordLength; letter++){
                            if(!(wordSearch.get(i+letter).get(ii+letter) == (char)32 || wordSearch.get(i + letter).get(ii+letter) == word.charAt(letter))){
                                //System.out.println("Can't place at [" + ii + ", " + i + "]");
                                canPlace = false;
                            }
                            if(wordSearch.get(i + letter).get(ii + letter) == word.charAt(letter)){
                                flagIntersection = true;
                                //System.out.println("flagging intersection");
                            }
                        }
                        if(canPlace){
                            //System.out.println("Can Place DD");
                            int[] temp = new int[2];
                            temp[0] = i;
                            temp[1] = ii ;
                            if(flagIntersection) {
                                store(temp);
                                return temp;
                            }
                            validPositions.add(temp);
                        }
                    }
                }
                if(!validPositions.isEmpty()){
                    int random = (int)(Math.random() * validPositions.size());
                    store(validPositions.get(random));
                    return validPositions.get(random);
                }
                if(!triedH) {
                    currentDirection = Directions.HORIZONTAL;
                    return this.scan(word);
                }
                break;
            case DIAGONAL_UP:
                triedDU = true;
                //System.out.println("Started DU scan");
                for(int i = wordLength; i < wordSearch.size(); i++){
                    //System.out.println("Scanning array " + i);
                    for(int ii = 0; ii <= wordSearch.size() - wordLength; ii++){
                        //System.out.println("Scanning char " + ii);
                        canPlace = true;
                        flagIntersection = false;
                        for(int[] memoryAccess: diagonalUpMemory){
                            //System.out.println("accessing memory");
                            for(int letter = 0; letter < memoryAccess[2] + 1; letter++){
                                //System.out.println("checking letter " + letter);
                                if(i == memoryAccess[0] - letter && ii == memoryAccess[1] + letter){
                                    //System.out.println("Memory conflict");
                                    canPlace = false;
                                }
                            }
                        }
                        for(int letter = 0; letter < wordLength; letter++){
                            if(!(wordSearch.get(i-letter).get(ii+letter) == (char)32 || wordSearch.get(i - letter).get(ii+letter) == word.charAt(letter))){
                                //System.out.println("Can't place at [" + ii + ", " + i + "]");
                                canPlace = false;
                            }
                            if(wordSearch.get(i - letter).get(ii + letter) == word.charAt(letter)){
                                flagIntersection = true;
                                //System.out.println("flagging intersection");
                            }
                        }
                        if(canPlace){
                            //System.out.println("Can Place DU");
                            int[] temp = new int[2];
                            temp[0] = i;
                            temp[1] = ii ;
                            if(flagIntersection) {
                                store(temp);
                                return temp;
                            }
                            validPositions.add(temp);
                        }
                    }
                }
                if(!validPositions.isEmpty()){
                    int random = (int)(Math.random() * validPositions.size());
                    store(validPositions.get(random));
                    return validPositions.get(random);
                }
                if(!triedH) {
                    currentDirection = Directions.HORIZONTAL;
                    return this.scan(word);
                }
                break;
        }

        //System.out.println("failed scan, increasing size");
        increaseSize(2);
        triedH = false;
        triedV = false;
        return scan(word);
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
                case DIAGONAL_DOWN:
                    wordSearch.get(location[0] + letter).set(location[1] + letter, word.charAt(letter));
                    break;
                case DIAGONAL_UP:
                    wordSearch.get(location[0] - letter).set(location[1] + letter, word.charAt(letter));
            }
        }
    }

    public void store(int[] position){
        int[] temp = new int[3];
        for(int i = 0; i< position.length; i++){
            temp[i] = position[i];
        }
        temp[2] = wordLength;
        switch(currentDirection){
            case HORIZONTAL:
                horizontalMemory.add(temp);
                break;
            case VERTICAL:
                verticalMemory.add(temp);
                break;
            case DIAGONAL_DOWN:
                diagonalDownMemory.add(temp);
                break;
            case DIAGONAL_UP:
                diagonalUpMemory.add(temp);
        }
    }

}
