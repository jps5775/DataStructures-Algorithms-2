package DataStructures;

public class MyHashMap {
    Node[] arr;

    public MyHashMap(int n){
        arr = new Node[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Node();
        }
    }

    public void put(int key, int val){
        int hashIndex = getHash(key);
        Node curr = arr[hashIndex];
        while(curr.next != null){
            if(curr.next.key == key){
                curr.next.val = val;
                return;
            }
            curr = curr.next;
        }
        curr.next = new Node(key, val);
    }

    public int get(int key){
        int hashIndex = getHash(key);
        Node curr = arr[hashIndex];
        while(curr.next != null){
            if(curr.next.key == key){
                return curr.next.val;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key){
        int hashIndex = getHash(key);
        Node curr = arr[hashIndex];
        while(curr.next != null && curr.next.key != key){
            curr = curr.next;
        }

        if(curr.next == null){ return; }

        curr.next = curr.next.next;
    }

    private int getHash(int key){
        return key % arr.length;
    }

    private class Node{
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
