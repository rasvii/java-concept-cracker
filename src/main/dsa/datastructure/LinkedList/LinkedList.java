package src.main.dsa.datastructure.LinkedList;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public LinkedList(){}

    private static class Node<T>{

        T value;
        Node<T> next;

        Node(T value){
            this.value = value;
            this.next = null;
        }

    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void add(T value){
        Node<T> newNode = new Node<>(value);
        
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            Node<T> lastNode = tail;
            tail = newNode;
            lastNode.next = newNode;
        }
        
        size++;
    }
    
    public void printAll(){
        Node<T> tmp = head;
        
        if(tmp == null){
            System.out.println("Nothing to print. List is empty");
            return;
        }
        
        while(tmp != null){
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }
    
    public void deleteFirst(){
        
        if(head == null){
            System.out.println("Nothing to delete. List is empty");
            return;
        }
        
        Node<T> nodeToDelete = head;
        
        if(nodeToDelete.next == null){
            tail = null;
            head = null;
        }
        else{
            head = nodeToDelete.next;
        }
        size--;
    }

    public void deleteLast(){

        if(head == null){
            System.out.println("Nothing to delete. List is empty");
            return;
        }

        Node<T> nodeToDelete = tail;

        if(nodeToDelete.next == null){
            tail = null;
            head = null;
        }
        else{
            head = nodeToDelete.next;
        }
        size--;
    }

}
