public class ListNode{
    public ListNode next;
    public String fName;
    public String lName;
    public String address;
    public String city;
    public String phone;

    public ListNode(){
        next = null;
        fName = null;
        lName = null;
        address = null;
        city = null;
        phone = null;
    }
    public ListNode (String fName, String lName, String address, String city, String phone){
        next = null;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

    public ListNode getNext(){
        return next;
    }

    public void setNext (ListNode node){
        next = node;
    }

    public void setFirstName (String fName){
        this.fName = fName;
    }
    public void setLastName (String lName){
        this.lName = lName;
    }
    public void setAddress (String address){
        this.address = address;
    }
    public void setCity (String city){
        this.city = city;
    }
    public void setPhone (String phone){
        this.phone = phone;
    }

    public String getFirstName (){
        return fName;
    }
    public String getLastName (){
        return lName;
    }
    public String getAddress (){
        return address;
    }
    public String getCity (){
        return city;
    }
    public String getPhone (){
        return phone;
    }




    public String toString (){
        String print;
        print = fName + " " + lName + ", " + address + " " + city + ", " + phone;
        return print;
    }
}
