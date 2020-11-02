package TutorialQuestion;

import java.util.LinkedList;

public class LinkedListStack <T>{
    private LinkedList<T> stack ;
    
    public LinkedListStack(){
        stack = new LinkedList<>();
    }
    
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    
    public int getSize(){
        return stack.size();
    }
    
    public void push(T a){
        stack.add(a);
    }
    
    public T pop(){
        if(isEmpty())
            return null;
        else {
            return stack.removeLast();
        }
    }
    
    public T peek(){
        if(isEmpty())
            return null;
        else
            return stack.getLast();
    }
    
    public void showStack(){
        if(isEmpty())
            System.out.println("Empty Stack");
        else{
            for(T element : stack){
                System.out.print(element.toString() + " ");
            }
        }
    }
}
