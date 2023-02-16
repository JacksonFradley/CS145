import java.util.ArrayList;

public class WordSearchGenerator {
    ArrayList<ArrayList<String>> wordSearch = new ArrayList<ArrayList<String>>();

    public void generate(String newWord){
        // is the size predefined or should it be fluid? if fluid, How?
        // randomly choose if it's going to be Horizontal, Vertical, Diagonal-up, or Diagonal-down
        // evaluate all available locations - identifed by the location of the first letter. (include all possible intersections???)
        // randomly choose one of the available locations
            // branching off of this /\. maybe have a method that will run every time you generate a new word.
            // this method would be specific to the randomly chosen direction and the defined length of the word.
            // this method running every time a word is generated would allow it to have the option to be placed
            // in locations specific to that word based off of intersections.
            // maybe it prioritizes intersections because they make for a more interesting word search?
    }
}
