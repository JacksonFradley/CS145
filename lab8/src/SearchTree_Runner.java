import java.util.Scanner;

public class SearchTree_Runner {
    SearchTree Tree;
    public SearchTree_Runner(){
        SearchTree Tree = new SearchTree();
        System.out.println("Welcome to the search tree dictionary")
    }

    public void recursive(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Add a member (a)\n" +
                "Delete a member (d)\n" +
                "Modify a member (m)\n" +
                "Lookup all members (l)\n" +
                "List number of records (n)\n" +
                "Quit (q)");
        String option = myObj.nextLine();
        switch(option){
            case "a":

                break;
            case "d":

                break;
            case "m":

                break;
            case "l":

                break;
            case "n":

                break;
            case "q":
                System.exit(0);
                break;
        }
    }
}
