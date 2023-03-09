import java.util.Scanner;

public class SearchTree_Runner {
    SearchTree Tree = new SearchTree();
    public SearchTree_Runner(){
        SearchTree Tree = new SearchTree();
        System.out.println("Welcome to the search tree dictionary");
        recursive();
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
                long phonenum = 0;
                while(phonenum == 0) {
                    System.out.println("Please enter phone number of new member. no dashes or spaces.");
                    try {
                        phonenum = Long.valueOf(myObj.nextLine());
                    } catch (Exception e) {
                        System.out.println("error, please try again");
                    }
                }
                System.out.println("Please enter first name of new member");
                String firstN = myObj.nextLine();
                System.out.println("Please enter last name of new member");
                String lastN = myObj.nextLine();
                System.out.println("Please enter address of new member");
                String addr = myObj.nextLine();
                System.out.println("Please enter city of new member");
                String cit = myObj.nextLine();
                System.out.println("Please enter state of new member");
                String stat = myObj.nextLine();
                System.out.println("Please enter email of new member");
                String emai = myObj.nextLine();
                System.out.println("Please enter zip of new member");
                String zi = myObj.nextLine();

                Node newNode = new Node(phonenum, firstN, lastN, addr, cit, stat, emai, zi);
                Tree.addNode(newNode);
                break;
            case "d":
                long phonenumdelete = 0;
                while(phonenumdelete == 0) {
                    System.out.println("Please enter the phone number of the member you would like to delete");
                    try {
                        phonenumdelete = Long.valueOf(myObj.nextLine());
                    } catch (Exception e) {
                        System.out.println("error, please try again");
                    }
                }
                Tree.deleteNode(phonenumdelete);
                break;
            case "m":
                modify();
                break;
            case "l":
                System.out.println("Pre (p), In (i), or Post (o)?");
                String option2 = myObj.nextLine();
                switch(option2){
                    case "p":
                        Tree.printPre(Tree.root);
                        System.out.println("\n");
                        break;
                    case "i":
                        Tree.printIn(Tree.root);
                        System.out.println("\n");
                        break;
                    case "o":
                        Tree.printPost(Tree.root);
                        System.out.println("\n");
                        break;
                }
                break;
            case "n":
                System.out.println("There are " + Tree.count + " members stored in the tree");
                break;
            case "q":
                System.exit(0);
                break;
        }
        recursive();
    }

    public void modify(){
        if(Tree.root == null){
            System.out.println("There are no nodes to modify");
            return;
        }
        Scanner myObj = new Scanner(System.in);
        long phonenummodify = 0;
        while(phonenummodify == 0) {
            System.out.println("Please enter the phone number of the member who's data you would like to modify");
            try {
                phonenummodify = Long.valueOf(myObj.nextLine());
            } catch (Exception e) {
                System.out.println("error, please try again");
            }
        }

        Node temp = Tree.scan(Tree.root, phonenummodify);

        if(temp.getNextLeft() != null){
            if(temp.getNextLeft().getPhoneNumber() == phonenummodify){
                temp = temp.getNextLeft();
            }
        }
        else if(temp.getNextRight() != null){
            if(temp.getNextRight().getPhoneNumber() == phonenummodify){
                temp = temp.getNextRight();
            }
        }
        else if(temp.getPhoneNumber() != phonenummodify){
            System.out.println("Phone number not found in tree");
            return;
        }

        System.out.println("what do you want to modify" +
                "\nphone number (p)" +
                "\nfirst name (f)" +
                "\nlast name (l)" +
                "\naddress (a)" +
                "\ncity (c)" +
                "\nstate (s)" +
                "\nemail (e)" +
                "\nzip (z)");
        String option = myObj.nextLine();
        String newtemp;
        switch(option){
            case "p":
                long newtempint = 0;
                while(newtempint == 0) {
                    System.out.println("Please enter new phone number");
                    try {
                        newtempint = Long.valueOf(myObj.nextLine());
                    } catch (Exception e) {
                        System.out.println("error, please try again");
                    }
                }
                Node temp2 = new Node(newtempint, temp.fName, temp.lName, temp.address, temp.city, temp.state, temp.email, temp.zip);
                Tree.deleteNode(temp.phoneNumber);
                Tree.addNode(temp2);
                System.out.println("modification successful");
                break;
            case "f":
                System.out.println("Please enter new first name");
                newtemp = myObj.nextLine();
                temp.fName = newtemp;
                System.out.println("modification successful");
                break;
            case "l":
                System.out.println("Please enter new last name");
                newtemp = myObj.nextLine();
                temp.lName = newtemp;
                System.out.println("modification successful");
                break;
            case "a":
                System.out.println("Please enter new address");
                newtemp = myObj.nextLine();
                temp.address = newtemp;
                System.out.println("modification successful");
                break;
            case "c":
                System.out.println("Please enter new city");
                newtemp = myObj.nextLine();
                temp.city = newtemp;
                System.out.println("modification successful");
                break;
            case "s":
                System.out.println("Please enter new state");
                newtemp = myObj.nextLine();
                temp.state = newtemp;
                System.out.println("modification successful");
                break;
            case "e":
                System.out.println("Please enter new email");
                newtemp = myObj.nextLine();
                temp.email = newtemp;
                System.out.println("modification successful");
                break;
            case "z":
                System.out.println("Please enter new zip");
                newtemp = myObj.nextLine();
                temp.zip = newtemp;
                System.out.println("modification successful");
                break;
        }
    }
}
