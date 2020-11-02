package TutorialQuestion;

public class ArrayStack<T>{
    private T [] stack ;
    
    //2a
    public ArrayStack(){
        stack = (T[]) new Object[10];
    }
    
    
    //2b
    public boolean isEmpty(){
        return (stack[0] == null);
    }
    
    //2c
    public boolean isFull(){
        return (getSize() == stack.length);
    }
    
    //2d
    public int getSize(){
        int count =0 ;
        while(stack[count] != null){
            count ++;
        }
        return count;
    }
    
    //2e
    public void push(T a){
        int index = 0;
        while(stack[index] != null)
            index ++;
        if(index > stack.length)
            System.out.println("The stack is full");
        else
            stack[index] = a;
    }

    //2f
    public T pop(){
        if(stack[0] == null)
            return null;
        T temp = (T) stack[getSize() - 1];
        stack[getSize() - 1] = null;
        return temp;
    }
    
    //2g
    public T peek(){
        if(stack[0] == null)
            return null;
        else
            return (T) stack[getSize() - 1];
    }
    
    
    //2h
    public void showStack(){
        if(isEmpty())
            System.out.println("Empty Stack");
        else{
            for(int count = getSize() - 1; count >= 0 ; count --)
                System.out.print(" <-- " + stack[count].toString());
        }
    }
}
