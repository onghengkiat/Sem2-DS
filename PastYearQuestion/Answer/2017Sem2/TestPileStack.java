package PastYear;

import java.util.ArrayList;
import java.util.Scanner;

//c
public class TestPileStack {
    public static void main(String[] args) {
        GenericStack<String> books = new GenericStack<>();
        System.out.println("isEmpty() returns " + books.isEmpty());
        System.out.println("\nPush 3 books to the pile:");
        Scanner input = new Scanner(System.in);
        for(int i = 0 ; i < 3 ; i++){
            System.out.print("Enter book title " + (i + 1) + ": ");
            books.push(input.nextLine());
        }
        System.out.println("\nThe new books that you added are: " + books);
        System.out.println("\nThe pile should not be empty:");
        System.out.println("isEmpty() returns " + books.isEmpty());
        System.out.println("The pile has " + books.size() + " books.");
        System.out.println("\nGet the top book and remove the top book:");
        
        System.out.println("The " + books.peek() + " is at the top of the pile");
        System.out.println("The " + books.pop() + " is removed from the pile");
        System.out.println("\nThe " + books.peek() + " is at the top of the pile");
        System.out.println("The " + books.pop() + " is removed from the pile");
        System.out.println("\nThe " + books.peek() + " is at the top of the pile");
        System.out.println("The " + books.pop() + " is removed from the pile");
        
        System.out.println("\nThe pile should be empty:");
        System.out.println("isEmpty() returns " + books.isEmpty());
    }
 
}

//a
interface StackInterface<E>{
    ArrayList list = new ArrayList();
    //interface cannot have constructor
    public int size();
    public E peek();
    public E pop();
    public void push(E element);
    public boolean isEmpty();
}

//b
class GenericStack<E> implements StackInterface<E>{

    public GenericStack() {
        System.out.println("Create a new stack: an empty pile of books");
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public E peek() {
        return (E) list.get(size()-1);
    }

    @Override
    public E pop() {
        return (E) list.remove(size()-1);
    }

    @Override
    public void push(E element) {
        list.add(element);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}