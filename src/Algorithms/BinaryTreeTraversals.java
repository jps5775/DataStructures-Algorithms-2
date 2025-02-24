package Algorithms;

import java.util.*;

public class BinaryTreeTraversals {

    public void preOrderTraveral(Node root){
        if(root == null){ return; }

        System.out.println(root.val);
        preOrderTraveral(root.left);
        preOrderTraveral(root.right);
    }

    public void inOrderTraveral(Node root){
        if(root == null){ return; }

        inOrderTraveral(root.left);
        System.out.println(root.val);
        inOrderTraveral(root.right);
    }

    public void postOrderTraveral(Node root){
        if(root == null){ return; }

        postOrderTraveral(root.left);
        postOrderTraveral(root.right);
        System.out.println(root.val);
    }

    public List<List<Integer>> levelOrderTraversal(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){ return ans; }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();

            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < n; i++){
                Node curr = q.poll();

                level.add(curr.val);

                if(curr.left != null){ q.add(curr.left); }
                if(curr.right != null){ q.add(curr.right); }
            }

            ans.add(level);
        }

        return ans;
    }

    private class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
}
