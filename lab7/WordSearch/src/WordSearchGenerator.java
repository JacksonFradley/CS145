import java.util.ArrayList;
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

    public WordSearchGenerator(){

    }

    public void generate(String newWord){
        int wordLength = newWord.length();

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
}
