package TutorialQuestion;

public class ArrayQueue<T> {
    T [] queue ;
    
    //2a
    public ArrayQueue(){
        queue = (T[])new Object[10];
    }

    
    //2b
    public boolean isEmpty(){
        return(queue[0] == null);
    }
    
    
    //2c
    public boolean isFull(){
        if(queue[9] != null)
            return true;
        return false;
    }
    
    //2d
    public int getSize(){
        for(int i = 0 ; i < queue.length ; i++){
            if(queue[i] == null)
                return i;
        }
        return 10;
    }
    
    //2e
    public void enqueue(T a){
        if(isFull()){
            System.out.println("The queue is full");
        }else{
            for(int i = 0; i < queue.length ; i++){
                if(queue[i] == null){
                    queue[i] = a;
                    break;
                }
            }
        }
    }
    
    //2f
    public T dequeue(){
        if(isEmpty())
            return null;
        else{
            T temp = queue[0];
            for(int i = 0 ; i < queue.length - 1; i++){
                queue[i] = queue[i+1];
            }
            queue[queue.length - 1] = null;
            return temp;
        }
    }
    
    
    //2g
    public T peek(){
        if(queue[0] == null)
            return null;
        else
            return queue[getSize()-1];
    }
    
    //2h
    public void showQueue(){
        if(isEmpty())
            System.out.println("Empty Queue");
        else{
            for(int i = 0 ; i < getSize() ; i++){
                System.out.print(queue[i] + " --> ");
            }
        }
    }   
}
