import java.util.Scanner;

public class SearchTree_Runner {
    SearchTree Tree;
    public SearchTree_Runner(){
        SearchTree Tree = new SearchTree();
        System.out.println("Welcome to the search tree dictionary");
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
                System.out.println("Please enter phone number of new member. no dashes or spaces.");
                int phonenum = Integer.valueOf(myObj.nextLine());
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
                System.out.println("Please enter the phone number of the member you would like to delete");
                int phonenumdelete = Integer.valueOf(myObj.nextLine());
                Tree.deleteNode(phonenumdelete);
                break;
            case "m":
                System.out.println("Please enter the phone number of the member who's data you would like to modify");
                int phonenummodify = Integer.valueOf(myObj.nextLine());
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
                else{
                    System.out.println("Phone number not found in tree");
                    break;
                }

                System.out.println("what do you want to modify\n" +
                        "phone");
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

    public void modify(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter the phone number of the member who's data you would like to modify");
        int phonenummodify = Integer.valueOf(myObj.nextLine());
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
        else{
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
                System.out.println("Please enter new phone number");
                int newtempint = Integer.valueOf(myObj.nextLine());
                Node temp2 = new Node(newtempint, temp.fName, temp.lName, temp.address, temp.city, temp.state, temp.email, temp.zip);
                
                break;
            case "f":
                System.out.println("Please enter new first name");
                newtemp = myObj.nextLine();
                break;
            case "l":
                System.out.println("Please enter new last name");
                newtemp = myObj.nextLine();
                break;
            case "a":
                System.out.println("Please enter new address");
                newtemp = myObj.nextLine();
                break;
            case "c":
                System.out.println("Please enter new city");
                newtemp = myObj.nextLine();
                break;
            case "s":
                System.out.println("Please enter new state");
                newtemp = myObj.nextLine();
                break;
            case "e":
                System.out.println("Please enter new email");
                newtemp = myObj.nextLine();
                break;
            case "z":
                System.out.println("Please enter new zip");
                newtemp = myObj.nextLine();
                break;
        }
    }
}
