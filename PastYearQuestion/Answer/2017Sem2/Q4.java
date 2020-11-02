package PastYear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        //b(i) && b(ii)
        Character [] alphabet = new Character[26];
        Queue<Integer> index = new Queue<>();
        for(int i = 0 ; i < 26 ; i++){
            alphabet[i] = (char)('a' + i);
            index.enqueue(i);
        }
        Queue<Character> queue = new Queue<>(alphabet);
        
        System.out.println("Queue: " + queue);
        System.out.println("Index: " + index);
        System.out.print("\nHow many times will you enter a number: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Queue<Integer> number = new Queue<>();
        //b(iii)
        System.out.println("(Please enter your number(s) between 0-" + (queue.getSize() - 1)+ ".)");
        for(int i = 0 ; i < n ; i++){
            System.out.print("Enter number " + (i+1) + " >> ");
            number.enqueue(input.nextInt());
        }
        System.out.println("The entered numbers are " + number);
        //b(iv)
        System.out.print("The deciphered values are ");
        if(number.isEmpty()){
            System.out.println("-Cannot decipher. No values are entered.-");
        }
        while(!number.isEmpty()){
            System.out.print(queue.getElement(number.dequeue()));
        }
    }
}

//a
class Queue<E>{
    ArrayList<E> queue ;
    
    //i
    public Queue(E [] items){
        queue = new ArrayList<>();
        for(int i = 0 ; i < items.length; i++){
            queue.add(items[i]);
        }
    }
    
    //ii
    public Queue(){
        queue = new ArrayList<>();
    }
    
    //iii
    public void enqueue(E e){
        queue.add(e);
    }
    
    //iv
    public E dequeue(){
        return queue.remove(0);
    }
    
    //v
    public E getElement(int i ){
        return queue.get(i);
    }
    
    //vi
    public int getSize(){
        return queue.size();
    }
    
    //vii
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    
    //viii
    @Override
    public String toString() {
        return queue.toString();
    }
    
}