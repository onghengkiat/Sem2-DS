package PastYear;

public class Q3{
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
class Queue<Item> {
    private QueueNode head;
    
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
        QueueNode <Item> currentNode = head;
        int count = 0;
        while(currentNode != null){
            currentNode = currentNode.getNext();
            count ++;
        }
        return count;
    }

    //iv
    public Item peek(){
        return (Item) head.getValue();
    }
    
    //v
    public void enqueue(Item a){
        if(isEmpty()){
            head = new QueueNode<>(a,null);
        }else{
            QueueNode <Item> currentNode = head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new QueueNode<>(a,null));
        }
    }
    
    //vi
    public Item dequeue(){
        if(isEmpty())
            return null;
        QueueNode<Item> temp = head;
        head = head.getNext();
        return temp.getValue();
    }
    
    //vii
    @Override
    public String toString(){
        QueueNode<Item>currentNode = head;
        String str = "";
        while(currentNode != null){
            str += (currentNode.getValue() + " --> ");
            currentNode = currentNode.getNext();
        }
        return str;
    }
    
    //b
    public void ChangeOrder(int k){
        if(k > size() - 1)
            return ;
        QueueNode<Item>currentNode = head;
        for(int i = 0 ; i < k - 1 ; i++){
            enqueue(dequeue());
        }
        //not sure the question is asking for this or not, because if like this then output not same liao
        //enqueue(peek());
    }
}

class QueueNode<Item>{
    private Item value;
    private QueueNode <Item>next;

    public QueueNode(Item value, QueueNode<Item> next) {
        this.value = value;
        this.next = next;
    }

    public Item getValue() {
        return value;
    }

    public void setValue(Item value) {
        this.value = value;
    }

    public QueueNode<Item> getNext() {
        return next;
    }

    public void setNext(QueueNode<Item> next) {
        this.next = next;
    }
    
}