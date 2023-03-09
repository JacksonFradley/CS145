public class Node {
    long phoneNumber;
    String fName;
    String lName;
    String address;
    String city;
    String state;
    String email;
    String zip;
    Node nextLeft;
    Node nextRight;

    public Node(long pn, String fn, String ln, String adrs, String c, String s, String em, String z){
        phoneNumber = pn;
        fName = fn;
        lName = ln;
        address = adrs;
        city = c;
        state = s;
        email = em;
        zip = z;
    }

    public void setPhoneNumber(int d){
        phoneNumber = d;
    }

    public long getPhoneNumber(){
        return phoneNumber;
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
