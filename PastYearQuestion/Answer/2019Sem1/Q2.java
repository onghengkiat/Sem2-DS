package PastYear;

public class Q2 {
    public static void main(String[] args) {
        //a
        GenericQueue<String> q = new GenericQueue<String>(6);
        q.enqueue("Hello");
        q.enqueueMany("all,who,wants,ice cream,or cookies");
        q.display();
        q.dequeue();
        q.dequeueAll();
        q.display();
        System.out.println("-".repeat(50));
        GenericQueue<Integer> q2 = new GenericQueue<Integer>(6);
        q2.enqueue(1000);
        q2.enqueue(2000);
        q2.enqueueMany("3000,4000 5000,6000,7000,8000 9000");
        q2.display();
        q2.dequeue();
        q2.dequeue();
        q2.enqueue(8000);
        q2.dequeueAll();
        q2.display();
        
    }
}

class GenericQueue<T>{
    private QueueNode<T> head;
    private int maxSize;
    private int size;
    
    //i
    public GenericQueue(int maxSize){
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
            System.out.println("Peek(): "+ head);
            return head.getValue();
        }
    }

    
    //v
    public void enqueue(T item){
        if(isEmpty()){
            size ++;
            System.out.println("Enqueue: " + item);
            head = new QueueNode(item,null);
        }else if(isFull()){
            System.out.println("Queue is full");
        }else{
            size ++;
            System.out.println("Enqueue: " + item);
            QueueNode <T> currentNode = head;
            while(currentNode.getNext() != null){
                currentNode =currentNode.getNext();
            }
            currentNode.setNext(new QueueNode(item, null));
        }
    }
    
    //vi
    public void enqueueMany(String elements){
        T [] manyElements = (T[]) elements.split(",");
        for (T manyElement : manyElements) {
            enqueue(manyElement);
        }
    
    }
    
    //vii
    public T dequeue(){
        if(isEmpty()){
            return null;
        }else{
            size --;
            T temp = head.getValue();
            head = head.getNext();
            System.out.println("Dequeue: " + temp);
            return temp;
        }
    }
    
    //viii
    public void dequeueAll(){
        System.out.println("\nThere are " + size + " items in the queue. Removing them all...");
        while(!isEmpty()){
            dequeue();
        }
    }
    
    //ix
    public void display(){
        if(isEmpty()){
            System.out.println("\nNothing to display");
            return;
        }
        System.out.println("\nThere are " + size + " items in the queue. Displaying...");
        QueueNode<T> currentNode = head;
        int i = 0;
        while(currentNode != null){
            System.out.println(currentNode);
            currentNode =currentNode.getNext();
        }
        System.out.println("");
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