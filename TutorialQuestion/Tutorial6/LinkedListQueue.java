package TutorialQuestion;

import java.util.LinkedList;


public class LinkedListQueue <T>{
    private LinkedList<T> queue;
    
    public LinkedListQueue(){
        queue = new LinkedList<>();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    
    public int getSize(){
        return queue.size();
    }
    
    public T dequeue(){
        if(isEmpty()){
            System.out.println("It is empty queue");
            return null;
        }
        return queue.removeFirst();
    }
    
    public void enqueue(T a){
        queue.add(a);
    }
    
    public T peek(){
        if(queue.isEmpty()){
            System.out.println("It is empty queue");
            return null;
        }
        
        return queue.getFirst();
            
    }
    
    public void showQueue(){
        if(isEmpty())
            System.out.println("Empty Queue");
        else{
            for(T element : queue)
                System.out.print(element + " --> ");
        }
    }   
}
