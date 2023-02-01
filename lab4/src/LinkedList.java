public class LinkedList {
    private int length;
    ListNode head;
    ListNode tail;

    public LinkedList(){
        length = 0;
    }

    public String toString() {
        String result = "[\n";
        if (head == null) {
            return result + "]";
        }
        result = result + head.toString() + "\n";
        ListNode temp = head.getNext();
        while (temp != null) {
            result = result + temp.toString() + "\n";
            temp = temp.getNext();
        }
        return result + "]";
    }

    public synchronized ListNode getHead(){
        return head;
    }

    public synchronized ListNode getTail(){
        return tail;
    }
    public synchronized void insertAtBegin(ListNode node) {
        node.setNext(head);
        head = node;
        if(head.next == null){
            tail = head;
        }
        length++;
    }

    public synchronized void insertAtEnd(ListNode node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        length++;
    }

    public void insert(ListNode temp, int position) {
        if (position < 0) {
            insertAtBegin(temp);
        }
        if (position >= length) {
            insertAtEnd(temp);
        }
        ListNode seek = head;
        for (int i = 1; i < position; i += 1) {
            seek = seek.getNext();
        }
        temp.next = seek.next;
        seek.setNext(temp);
        length += 1;
    }

    public synchronized ListNode removeFromEnd() {
        if(isEmpty()){
            return null;
        }
        ListNode p = head, q = null, next = head.getNext();
        if (next == null) {
            head = null;
            tail = null;
            length -= 1;
            return p;
        }
        while ((next = p.getNext()) != null) {
            q = p;
            p = next;
        }
        tail = q;
        q.setNext(null);
        length -= 1;
        return p;
    }

    public synchronized ListNode removeFromBegin(){
        ListNode temp = head;
        head = head.getNext();
        length -= 1;
        return temp;
    }

    public ListNode remove(int position) {
        if (isEmpty()) {
            return null;
        }
        if (position < 0) {
            removeFromBegin();
        }
        if (position >= length) {
            removeFromEnd();
        }


        ListNode temp = head;
        for (int i = 1; i < position; i += 1) {
            temp = temp.getNext();
        }
        ListNode t = temp.getNext().getNext();
        temp.setNext(temp.getNext().getNext());

        length -= 1;
        return t;
    }

    public int getfNamePosition(String name) {
        ListNode temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.getFirstName() == name) {
                // return the position if found
                return pos;
            }
            pos += 1;
            temp = temp.getNext();
        }
        // else return -1
        return Integer.MIN_VALUE;
    }

    public ListNode getfNameNode(String name) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.getFirstName() == name) {
                // return the position if found
                return temp;
            }
            temp = temp.getNext();
        }
        // else return -1
        return null;
    }


    public int length(){
        return length;
    }

    public Boolean isEmpty(){
        return length == 0;
    }

    public void clearList(){
        head = null;
        tail = null;
        length = 0;
    }
}
