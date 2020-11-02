package PastYear;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        System.out.print("Say input: ");
        Scanner input = new Scanner(System.in);
        String word = input.next();
        Stack reverse = new Stack();
        for(int i = 0 ; i< word.length() ; i++){
            reverse.push(word.charAt(i));
        }
        System.out.print("Thus the output: ");
        while(!reverse.isStackEmpty()){
            System.out.print(reverse.pop());
        }
        System.out.println("");
    }
    
}


class Stack{
    StackNode<Character> head ;
    public Stack(){
        head = null;
    }
    
    //i
    public void push(char element){
        if(isStackEmpty()){
            head = new StackNode(element,null);
        }else{
            StackNode<Character> currentNode = head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new StackNode(element,null));
        }
    }
    
    //ii
    public Character pop(){
        if(isStackEmpty()){
            return null;
        }
        StackNode<Character> currentNode = head.getNext();
        StackNode<Character> previousNode = head;
        if(currentNode == null){
            char temp = head.getValue();
            head = null;
            return temp;
        }
        
        while(currentNode.getNext() != null){
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        
        char temp = currentNode.getValue();
        previousNode.setNext(null);
        return temp;
    }
    
    //iii
    public Character peek(){
        if(isStackEmpty()){
            return null;
        }
        StackNode<Character> currentNode = head;
        while(currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }
    
    //iv
    public boolean isStackEmpty(){
        return head == null;
    }
    
    //v
    public boolean isStackFull(){
        //why the stack will full, dont understand this question.
        //maybe we need to use array?
        return false;
    }
    
    public void show(){
        StackNode<Character> currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode + " ");
            currentNode = currentNode.getNext();
        }
    }
}

class StackNode<T>{
    private T value;
    private StackNode<T> next;

    public StackNode(T value, StackNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }
    
    
}