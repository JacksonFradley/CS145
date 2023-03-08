public class SearchTree {
    Node root;

    public void addNode(Node newNode){
        if(root == null){
            root = newNode;
        }
        else{
            Node parentNode = scan(root, newNode.getData());


            if(parentNode.getData() > newNode.getData() && parentNode.getNextLeft() == null){
                parentNode.setNextLeft(newNode);
            }
            else if(parentNode.getData() < newNode.getData() && parentNode.getNextRight() == null){
                parentNode.setNextRight(newNode);
            }
            else{
                System.out.println("Data already exists in tree");
            }

        }
    }

    // returns null Node if data is not found. returns Node with data d if data is found.
    public Node scan(Node r, int d){

        if(r.getData() == d){
            return r;
        }
        else if(r.getData() > d){

            if(r.getNextLeft() == null){
                return r;
            }
            else if(r.getNextLeft().getData() == d){
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
            else if(r.getNextRight().getData() == d){
                return r;
            }
            else{
                return scan(r.getNextRight(), d);
            }
        }
    }

    public void printPre(Node r){
        System.out.println(r.getData());
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
        System.out.println(r.getData());
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
        System.out.println(r.getData());
    }

    public void deleteNode(int d){
        Node parentNode = scan(root, d);
        if(parentNode.getData() > d && parentNode.getNextLeft() != null){

            if(parentNode.getNextLeft().getNextLeft() == null){
                parentNode.setNextLeft(parentNode.getNextLeft().getNextRight());
            }
            else if(parentNode.getNextLeft().getNextRight() == null){
                parentNode.setNextLeft(parentNode.getNextLeft().getNextLeft());
            }
            else{
                Node temp = parentNode.getNextLeft().getNextRight();
                parentNode.setNextLeft(parentNode.getNextLeft().getNextLeft());
                addNode(temp);
            }

        }
        else if(parentNode.getData() < d && parentNode.getNextRight() != null){

            if(parentNode.getNextRight().getNextLeft() == null){
                parentNode.setNextRight(parentNode.getNextRight().getNextRight());
            }
            else if(parentNode.getNextRight().getNextRight() == null){
                parentNode.setNextRight(parentNode.getNextRight().getNextLeft());
            }
            else{
                Node temp = parentNode.getNextRight().getNextRight();
                parentNode.setNextRight(parentNode.getNextRight().getNextLeft());
                addNode(temp);
            }

        }
    }
}
