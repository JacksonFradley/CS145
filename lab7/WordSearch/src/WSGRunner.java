import java.util.Scanner;

public class WSGRunner {
    WordSearchGenerator wordSearch = new WordSearchGenerator();
    public WSGRunner() {
        System.out.println("Welcome to the Word Search Generator.");
        options();
    }

    public void options(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please select an option: \n" +
                "Generate a new word search (g)\n" +
                "Print out your word search (p)\n" +
                "Show the solution to your word search (s)\n" +
                "Quit the program (q)");
        String option = myObj.nextLine();
        switch(option){
            case "g":
                System.out.println("How many words do you want to add?");
                int amount = Integer.parseInt(myObj.nextLine());
                String newWord;
                for(int i = 0; i < amount; i++){
                    System.out.println("What word do you want to add:");
                    newWord = myObj.nextLine();
                    wordSearch.generate(newWord);
                }
                break;
            case "p":
                System.out.println(wordSearch.toString(false));
                break;
            case "s":
                System.out.println(wordSearch.toString(true));
                break;
            case "q":
                System.exit(0);
                break;
        }
        options();
    }

}
