package DataStructures;

public class MyStack {
    Node head;

    public void push(int val){
        if(head == null) {
            head = new Node(val);
            return;
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public int pop(){
        if(head == null){ return -1; }

        int val = head.val;
        head = head.next;
        return val;
    }

    public int peek(){
        return head == null ? -1 : head.val;
    }

    public boolean isEmpty(){
        return head == null;
    }

    private class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
}
