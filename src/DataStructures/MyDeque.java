package DataStructures;

public class MyDeque{
    Node front;
    Node back;

    public MyDeque(){
        front = new Node(-1);
        back = new Node(-1);
        front.next = back;
        back.prev = front;
    }

    public void append(int val){
        Node newNode = new Node(val);
        Node prev = back.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = back;
        back.prev = newNode;
    }

    public void prepend(int val){
        Node newNode = new Node(val);
        Node next = front.next;
        front.next = newNode;
        newNode.prev = front;
        newNode.next = next;
        next.prev = newNode;
    }

    public void deleteFront(){
        if(front.next == back){ return; }

        Node next = front.next.next;
        front.next = next;
        next.prev = front;
    }

    public void deleteBack(){
        if(back.prev == front){ return; }

        Node prev = back.prev.prev;
        back.prev = prev;
        prev.next = back;
    }

    public void printDeque(){
        Node curr = front;
        while(curr != back){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.print(back.val);
        System.out.println();
    }

    public boolean isEmpty(){
        return front.next == back;
    }
}


class Node{
    int val;
    Node next;
    Node prev;
    Node(int val){
        this.val = val;
    }
}