package PastYear;

import java.util.HashMap;
import java.util.Stack;

public class Q3 {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(3);
        tree.add(5);
        tree.printTreeInOrder();
        tree.printTreeInOrder();
        System.out.println(tree.contains(2));
        System.out.println(tree.contains(1));
        System.out.println(tree.contains(4));
        System.out.println(tree.contains(3));
        System.out.println(tree.contains(0));
        System.out.println(tree.contains(5));
    }
}

class BST<E extends Comparable<E>>{
    Node<E> root ;
    BST(){
        root = null;
    }
    
    //i
    public boolean add(E item){
        if(root == null){
            root = new Node(item,null,null);
            return true;
        }else{
            Node<E> currentNode = root;
            while(true){
                if(item.compareTo(currentNode.getValue()) > 0){
                    if(currentNode.getRight()==null){
                        currentNode.setRight(new Node(item,null,null));
                        return true;
                    }
                    currentNode = currentNode.getRight();
                }else{
                    if(currentNode.getLeft()==null){
                        currentNode.setLeft(new Node(item,null,null));
                        return true;
                    }
                    currentNode = currentNode.getLeft();
                }
            }
        }
    }
    
    //ii
    public void printTreeInOrder(){
        Node<E> currentNode = root;
        Stack<Node<E>>leftNode = new Stack<>();
        HashMap<Node<E>,Boolean> mark = new HashMap<>();
        while(currentNode != null){
            if(currentNode.getLeft() == null || mark.containsKey(currentNode)){
                System.out.print(currentNode);
                if(currentNode.getRight() != null){
                    currentNode = currentNode.getRight();
                }else{
                    if(!leftNode.isEmpty()){
                        currentNode = leftNode.pop();
                    }else{
                        currentNode = null;
                        System.out.println("");
                    }
                }
            } else { 
                mark.put(currentNode,true);
                leftNode.push(currentNode);
                currentNode = currentNode.getLeft();
            } 
        }
    }
    
    //iii
    public boolean contains(E item){
        if(root == null){
            return false;
        }else{
            Node<E> currentNode = root;
            while(currentNode != null){
                if(item.compareTo(currentNode.getValue()) > 0){
                    currentNode = currentNode.getRight();
                }else if(item.compareTo(currentNode.getValue()) < 0){
                    currentNode = currentNode.getLeft();
                }else
                    return true;
            }
            return false;
        }
    }
}

class Node<E>{
    E value;
    Node<E> left;
    Node<E> right;

    public Node(E value, Node<E> left, Node<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return value + " ";
    }

}