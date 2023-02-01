public class Tester {
    public static void main(String[] args) {
        LinkedList newList = new LinkedList();
        newList.insertAtBegin(new ListNode("Jackson", "Fradley", "1000 Smith Street", "Bellingham", "3601231234"));
        newList.insertAtEnd(new ListNode("Jacksonson", "Fradley", "2000 Smith Street", "Bellingham", "3601231234"));
        newList.insertAtEnd(new ListNode("Jacksonsonson", "Fradley", "3000 Smith Street", "Bellingham", "3601231234"));
        System.out.println(newList.toString());
        System.out.println("\n\n\n");
        System.out.println("Jackson lives on " + newList.getfNameNode("Jackson").address);
        System.out.println("\n\n\n");
        newList.remove(1);
        System.out.println(newList.toString());
        System.out.println("\n\n\n");
        newList.removeFromEnd();
        System.out.println(newList.toString());
        System.out.println("\n\n\n");
        newList.getfNameNode("Jackson").setCity("St.Pete");
        System.out.println(newList.toString());
    }
}
