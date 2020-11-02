package PastYear;

public class Q2 {
    public static void main(String[] args) {
        //a
        Queue q = new Queue(5);
        
        q.enqueue("hello");
        q.enqueue("all");
        q.enqueue("who");
        q.enqueue("wants");
        q.enqueue("ice cream");
        q.dequeue();
        q.dequeue();
        q.enqueue("1000");
        q.enqueue("2000");
        q.peek();
        
        q.display();
    }
}

class Queue<T>{
    private QueueNode<T> head;
    private int maxSize;
    private int size;
    
    //i
    public Queue(int maxSize){
        head = null;
        this.maxSize = maxSize;
        size = 0;
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
            System.out.println("Peek(): "+ head);
            return head.getValue();
        }
    }

    public boolean isFull(){
        return size >= maxSize;
    }
    
    //iv
    public void enqueue(T item){
        if(isEmpty()){
            size ++;
            System.out.println("Data " + item + " inserted");
            head = new QueueNode(item,null);
        }else if(isFull()){
            System.out.println("The queue is full");
        }else{
            size ++;
            System.out.println("Data " + item + " inserted");
            QueueNode <T> currentNode = head;
            while(currentNode.getNext() != null){
                currentNode =currentNode.getNext();
            }
            currentNode.setNext(new QueueNode(item, null));
        }
    }
    
    //v
    public T dequeue(){
        if(isEmpty()){
            return null;
        }else{
            size --;
            T temp = head.getValue();
            head = head.getNext();
            System.out.println("Data " + temp + " has been removed");
            return temp;
        }
    }
    
    //vi
    public void display(){
        QueueNode<T> currentNode = head;
        String node = "| ";
        String index = "| ";
        int i = 0;
        while(currentNode != null){
            index += i + " | ";
            i ++;
            node += currentNode + " | ";
            currentNode =currentNode.getNext();
        }
        System.out.println("-".repeat(50));
        System.out.println(index);
        System.out.println("-".repeat(50));
        System.out.println(node);
        System.out.println("-".repeat(50));
    }
}
class QueueNode<T>{
    private T value;
    private QueueNode<T> next;

    public QueueNode(T value, QueueNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public QueueNode<T> getNext() {
        return next;
    }

    public void setNext(QueueNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }
    
}