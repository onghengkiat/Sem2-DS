package PastYear;

public class Q2 {
    public static void main(String[] args) {
        //c
        Queue<Integer> queue = new Queue<>();
        for(int i = 1 ; i < 10 ; i++)
            queue.enqueue(i*10);
        System.out.println(queue.toString());
        queue.ChangeOrder(4);
        System.out.println(queue.toString());
    }
}

//a
class Queue<Item>{
    private Node<Item> head;
    //i
    public Queue(){
        head = null;
    }
    
    //ii
    public boolean isEmpty(){
        return head == null;
    }
    
    //iii
    public int size(){
        Node<Item> currentNode = head;
        int count = 0 ;
        while(currentNode != null){
            count ++;
            currentNode = currentNode.getNext();
        }
        return count;
    }
    
    //iv
    public Item peek(){
        if(isEmpty()){
            return null;
        }else{
            return head.getValue();
        }
    }
    
    //v
    public void enqueue(Item item){
        if(isEmpty()){
            head = new Node(item,null);
        }else{
            Node<Item> currentNode = head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node(item,null));
        }
    }
    
    //vi
    public Item dequeue(){
        if(isEmpty()){
            return null;
        }else{
            Item temp = head.getValue();
            head = head.getNext();
            return temp;
        }
    }
    
    //vii
    public String toString(){
        String str = "";
        Node<Item>currentNode = head;
        while(currentNode != null){
            str += currentNode + " ";
            currentNode = currentNode.getNext();
        }
        return str;
    }
    
    //b
    public void ChangeOrder(int k){
        if(k > size() - 1)
            return ;
        Node<Item>currentNode = head;
        for(int i = 0 ; i < k - 1 ; i++){
            enqueue(dequeue());
        }
        //not sure the question is asking for this or not, because if like this then output not same liao
        //enqueue(peek());
    }
}
class Node<T>{
    private T value;
    private Node<T>next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }
    
}
