package DataStructures;

import java.util.Arrays;

public class MyHashMap {
    Node[] map;

    public MyHashMap(int size) {
        map = new Node[size];
        Arrays.fill(map, new Node());
    }

    public void put(int key, int value) {
        int index = getHash(key);

        Node curr = map[index];
        while(curr.next != null){
            if(curr.next.key == key){
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new Node(key, value);
    }

    public int get(int key) {
        int index = getHash(key);

        Node curr = map[index];
        int ans = -1;
        while(curr.next != null){
            if(curr.next.key == key){
                ans = curr.next.val;
                break;
            }
            curr = curr.next;
        }

        return ans;
    }

    public void remove(int key) {
        int index = getHash(key);

        Node curr = map[index];
        while(curr.next != null){
            if(curr.next.key == key){
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    private int getHash(int key){
        return key % map.length;
    }

    class Node{
        int key;
        int val;
        Node next;
        Node(){}
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
