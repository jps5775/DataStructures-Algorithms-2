package DataStructures;

import java.util.HashMap;
import java.util.Map;

public class MyTrie {
    TrieNode root;

    public MyTrie() {
        root = new TrieNode('*', false);
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.childern.containsKey(c)){
                curr = curr.childern.get(c);
            }else{
                curr.childern.put(c, new TrieNode(c, false));
                curr = curr.childern.get(c);
            }
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.childern.containsKey(c)){
                curr = curr.childern.get(c);
            }else{
                return false;
            }
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()){
            if(curr.childern.containsKey(c)){
                curr = curr.childern.get(c);
            }else{
                return false;
            }
        }

        return true;
    }

    class TrieNode{
        char c;
        boolean isWord;
        Map<Character, TrieNode> childern;
        TrieNode(char c, boolean isWord){
            this.c = c;
            this.isWord = isWord;
            this.childern = new HashMap<>();
        }
    }
}
