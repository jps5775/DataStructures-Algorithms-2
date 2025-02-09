package DataStructures;

public class MyQueue {
    Node front;
    Node back;

    public void enqueue(int val){
        if(back == null){
            back = new Node(val);
            front = back;
        }else{
            Node newNode = new Node(val);
            back.next = newNode;
            back = back.next;
        }
    }

    public int dequeue(){
        if(front == null){ return -1; }

        int val = front.val;
        front = front.next;
        if(front == null){
            back = null;
        }

        return val;
    }

    private class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
}
