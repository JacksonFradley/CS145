public class Node {
    int key;
    Node nextLeft;
    Node nextRight;

    public Node(int d){
        key = d;
    }

    public void setData(int d){
        key = d;
    }

    public int getData(){
        return key;
    }

    public Node getNextLeft(){
        return nextLeft;
    }

    public Node getNextRight(){
        return nextRight;
    }

    public void setNextLeft(Node l){
        nextLeft = l;
    }

    public void setNextRight(Node r){
        nextRight = r;
    }
}
