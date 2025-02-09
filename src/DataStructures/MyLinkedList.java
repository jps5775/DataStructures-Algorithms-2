package DataStructures;

public class MyLinkedList {
    Node head;

    public void prepend(int val){
        if(head == null){
            head = new Node(val);
            return;
        }

        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void append(int val){
        if(head == null){
            head = new Node(val);
            return;
        }

        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = new Node(val);
    }


    public void delete(int val){
        if(head == null){ return; }

        if(head.val == val){
            head = head.next;
            return;
        }

        Node curr = head;
        while(curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    private class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
}
