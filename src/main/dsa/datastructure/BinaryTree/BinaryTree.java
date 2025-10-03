package src.main.dsa.datastructure.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    
    private Node root;
    
    public BinaryTree(){
        root = null;
    }


    private static class Node {
        int val;
        Node right;
        Node left;

        Node(int val){
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }
    
    private Node insert(Node root, int val){
        if(root == null){
            return new Node(val);
        }
        
        if(val < root.val){
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }
        
        return root;
    }
    
    public void buildTree(int[] nodes){
        for(int value : nodes){
            root = insert(root, value);
        }
    }
    
    public void insert(int value){
        root = insert(root, value);
    }
    
    public void print(TraversalEnums printType){
        System.out.println();
        
        switch (printType){
            case INORDER -> inorderBF();
            case PRE_ORDER -> preOrderBF();
            case POST_ORDER -> postOrder(root);
        }
    }
    
    private void inorder(Node root){
        if(root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }
    
    private void preOrder(Node root){
        if(root != null){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    private void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }
    
    private void inorderBF() {
        Stack<Node> stack = new Stack<>();
        
        Node curr = root;
        
        while(curr != null || !stack.isEmpty()){
            
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    private void preOrderBF() {
        if(root == null ) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.print(curr.val + " ");

            // Push right first so left is processed first
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
    }
    
    private void postOrderBF() {
        if(root == null ) return;
        
    }
}
