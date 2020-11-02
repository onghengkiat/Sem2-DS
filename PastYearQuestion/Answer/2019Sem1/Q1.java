package PastYear;

public class Q1 {
    public static void main(String[] args) {
        //a
        GenericStack<String> stack1 = new GenericStack<String>(5);
        stack1.push("one");
        stack1.display();
        stack1.pushMany("two,three four,five,six seven");
        stack1.display();
        System.out.println("Pop the top of stack...");
        stack1.pop();
        System.out.println("Pop the top of stack...");
        stack1.pop();
        stack1.display();
        System.out.println("-".repeat(50));
        GenericStack<Integer> stack2 = new GenericStack<Integer>(6);
        stack2.push(1);
        stack2.push(2);
        stack2.pushMany("3 4,5,6 7");
        stack2.display();
        stack2.popAll();
        stack2.display();
    }
}

class GenericStack<T>{
    private StackNode<T> head;
    private int maxSize;
    private int size;
    
    //i
    public GenericStack(int maxSize){
        head = null;
        this.maxSize = maxSize;
        size = 0;
    }
    
    //ii
    public boolean isEmpty(){
        return head == null;
    }
    
    //iii
    public boolean isFull(){
        return size >= maxSize;
    }
    
    //iv
    public T peek(){
        if(isEmpty()){
            return null;
        }else{
            StackNode<T> currentNode = head;
            while(currentNode.getNext()!= null){
                currentNode = currentNode.getNext();
            }
            return currentNode.getValue();
        }
    }

    
    //v
    public void push(T item){
        if(isEmpty()){
            size ++;
            System.out.println("Push: " + item);
            head = new StackNode(item,null);
        }else if(isFull()){
            System.out.println("Stack is full");
        }else{
            size ++;
            System.out.println("Push: " + item);
            StackNode <T> currentNode = head;
            while(currentNode.getNext() != null){
                currentNode =currentNode.getNext();
            }
            currentNode.setNext(new StackNode(item, null));
        }
    }
    
    //vi
    public void pushMany(String elements){
        T [] manyElements = (T[]) elements.split(",");
        for (T manyElement : manyElements) {
            push(manyElement);
        }
    
    }
    
    //vii
    public T pop(){
        if(isEmpty()){
            return null;
        }else{
            size --;
            StackNode<T> currentNode = head.getNext();
            StackNode<T> previousNode = head;
            if(currentNode == null){
                T temp = previousNode.getValue();
                head = null;
                return temp;
            }
                
            while(currentNode.getNext() != null){
                previousNode =currentNode;
                currentNode = currentNode.getNext();
            }
            
            T temp = currentNode.getValue();
            previousNode.setNext(null);
            return temp;
        }
    }
    
    //viii
    public void popAll(){
        System.out.println("\nThere are " + size + " items in the stack. Removing them all...");
        while(!isEmpty()){
            System.out.println("Removing " + pop() + " ..");
        }
    }
    
    //ix
    public void display(){
        if(isEmpty()){
            System.out.println("\nStack is empty, nothing to display...");
            return;
        }
        System.out.println("\nThere are " + size + " items in the stack. Displaying...");
        StackNode<T> currentNode = head;
        int i = 0;
        StackNode [] arr = new StackNode[size];
        while(currentNode != null){
            arr[i] = currentNode;
            i++;
            currentNode =currentNode.getNext();
        }
        for(int j = size - 1 ; j>= 0 ; j--){
            System.out.println(arr[j]);
        }
        System.out.println("");
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