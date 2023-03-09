public class SearchTree {
    Node root;

    public void addNode(Node newNode){
        if(root == null){
            root = newNode;
        }
        else{
            Node parentNode = scan(root, newNode.getPhoneNumber());


            if(parentNode.getPhoneNumber() > newNode.getPhoneNumber() && parentNode.getNextLeft() == null){
                System.out.println("member successfully added");
                parentNode.setNextLeft(newNode);
            }
            else if(parentNode.getPhoneNumber() < newNode.getPhoneNumber() && parentNode.getNextRight() == null){
                System.out.println("member successfully added");
                parentNode.setNextRight(newNode);
            }
            else{
                System.out.println("Phone number already exists in tree");
            }

        }
    }

    // returns null Node if data is not found. returns Node with data d if data is found.
    public Node scan(Node r, int d){

        if(r.getPhoneNumber() == d){
            return r;
        }
        else if(r.getPhoneNumber() > d){

            if(r.getNextLeft() == null){
                return r;
            }
            else if(r.getNextLeft().getPhoneNumber() == d){
                return r;
            }
            else{
                return scan(r.getNextLeft(), d);
            }
        }
        else{

            if(r.getNextRight() == null){
                return r;
            }
            else if(r.getNextRight().getPhoneNumber() == d){
                return r;
            }
            else{
                return scan(r.getNextRight(), d);
            }
        }
    }

    public void printPre(Node r){
        System.out.println(r.getPhoneNumber());
        if(r.getNextLeft() != null){
            printPre(r.getNextLeft());
        }
        if(r.getNextRight() != null){
            printPre(r.getNextRight());
        }
    }

    public void printIn(Node r){
        if(r.getNextLeft() != null){
            printPre(r.getNextLeft());
        }
        System.out.println(r.getPhoneNumber());
        if(r.getNextRight() != null){
            printPre(r.getNextRight());
        }
    }

    public void printPost(Node r){
        if(r.getNextLeft() != null){
            printPre(r.getNextLeft());
        }
        if(r.getNextRight() != null){
            printPre(r.getNextRight());
        }
        System.out.println(r.getPhoneNumber());
    }

    public void deleteNode(int d){
        Node parentNode = scan(root, d);
        if(parentNode.getPhoneNumber() > d && parentNode.getNextLeft() != null){

            if(parentNode.getNextLeft().getNextLeft() == null){
                System.out.println("member successfully deleted");
                parentNode.setNextLeft(parentNode.getNextLeft().getNextRight());
            }
            else if(parentNode.getNextLeft().getNextRight() == null){
                System.out.println("member successfully deleted");
                parentNode.setNextLeft(parentNode.getNextLeft().getNextLeft());
            }
            else{
                System.out.println("member successfully deleted");
                Node temp = parentNode.getNextLeft().getNextRight();
                parentNode.setNextLeft(parentNode.getNextLeft().getNextLeft());
                addNode(temp);
            }

        }
        else if(parentNode.getPhoneNumber() < d && parentNode.getNextRight() != null){

            if(parentNode.getNextRight().getNextLeft() == null){
                System.out.println("member successfully deleted");
                parentNode.setNextRight(parentNode.getNextRight().getNextRight());
            }
            else if(parentNode.getNextRight().getNextRight() == null){
                System.out.println("member successfully deleted");
                parentNode.setNextRight(parentNode.getNextRight().getNextLeft());
            }
            else{
                System.out.println("member successfully deleted");
                Node temp = parentNode.getNextRight().getNextRight();
                parentNode.setNextRight(parentNode.getNextRight().getNextLeft());
                addNode(temp);
            }

        }
        System.out.println("phone number doesn't exist in tree");
    }
}
