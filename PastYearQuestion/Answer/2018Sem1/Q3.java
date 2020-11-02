package PastYear;

public class Q3 {
    public static void main(String[] args) {
        //a
        Stack stack1 = new Stack(4);
        stack1.push("one");
        stack1.push("two");
        stack1.push("three");
        stack1.push("four");
        stack1.displayReverse();
        stack1.popAll();
        stack1.displayReverse();
        System.out.println("\n\n\n");
        
        //b
        Stack <String> stack = new Stack<>(4);
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        System.out.println(stack.peek());
        stack.display();
        stack.displayReverse();
        stack.popAll();
        
        Stack<Integer>stack2 = new Stack<>(4);
        stack2.push(100);
        stack2.push(200);
        stack2.push(300);
        stack2.push(400);
        System.out.println(stack2.peek());
        stack2.display();
        stack2.displayReverse();
        stack2.popAll();
    }
}

class Stack<T>{
    private StackNode<T> head;
    private int size;
    //i
    public Stack(int size){
        head = null;
        this.size = size;
    }
    
    //ii
    public boolean isEmpty(){
        return head == null;
    }
    
    //iii
    public T peek(){
        if(isEmpty()){
            return null;
        }else{
            StackNode<T> currentNode = head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            return currentNode.getValue();
        }
    }
    
    //iv
    public void push(T element){
        System.out.println("Push item into stack: " + element);
        if(isEmpty()){
            head = new StackNode(element,null);
        }else{
            StackNode<T> currentNode = head;
            while(currentNode.getNext() != null){
                currentNode =currentNode.getNext();
            }
            currentNode.setNext(new StackNode(element,null));
        }
    }
    
    //v
    public T pop(){
        if(isEmpty()){
            return null;
        }else{
            StackNode<T> currentNode = head.getNext();
            StackNode<T> previousNode = head;
            if(currentNode == null){
                T temp = head.getValue();
                System.out.println("Removing " + temp + " ..");
                head = null;
                return temp;
            }
            while(currentNode.getNext() != null){
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            
            T temp = currentNode.getValue();
            System.out.println("Removing " + temp + " ..");
            previousNode.setNext(null);
            return temp;
        }
    }
    
    //vi
    public void popAll(){
        System.out.println("Pop all item in stack:");
        while(!isEmpty()){
            pop();
        }
    }
    
    
    //vii
    public void display(){
        System.out.println("Display stack:");
        StackNode<T>currentNode = head;
        for(int i =0 ; i < size ; i++){
            System.out.println(currentNode);
            if(currentNode != null)
                currentNode =currentNode.getNext();
        }
    }
    
    //viii
    public void displayReverse(){
        System.out.println("Display stack in reverse:");
        StackNode<T>currentNode = head;
        StackNode [] arr = new StackNode[size];
        for(int i =0 ; i < size ; i++){
            arr[i] = currentNode;
            if(currentNode != null)
                currentNode =currentNode.getNext();
        }
        for(int i = size - 1; i >= 0 ; i--){
            System.out.println(arr[i]);
        }
    }
    
}
class StackNode<T>{
    private T value ;
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