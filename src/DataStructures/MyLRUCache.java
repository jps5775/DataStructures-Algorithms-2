package DataStructures;

import java.util.HashMap;
import java.util.Map;

class MyLRUCache {

    Node front;
    Node back;
    Map<Integer, Node> map;
    int capacity;

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        front = new Node();
        back = new Node();
        map = new HashMap<>();
        front.next = back;
        back.prev = front;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        addToBack(node);

        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            // update and move to back
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addToBack(node);
            return;
        }

        if(map.size() == capacity){
            // evict front
            Node removeNode = front.next;
            map.remove(removeNode.key);
            remove(removeNode);
        }

        Node newNode = new Node(key, value);

        map.put(key, newNode);
        addToBack(newNode);
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addToBack(Node node){
        Node prev = back.prev;
        prev.next = node;
        node.next = back;
        back.prev = node;
        node.prev = prev;
    }

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(){}
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}