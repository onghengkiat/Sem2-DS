package LabQuestion;


public class PriorityQueue <T extends Comparable<T>>{
    private ListNode head;
    
    public PriorityQueue(){
        head = null;
    }
    public boolean isEmpty(){
        return (head == null);
    }
    
    public int getSize(){
        int count = 0;
        ListNode currentNode = head;
        while(currentNode != null){
            currentNode = currentNode.getLink();
            count++;
        }
        return count;
    }
    
    public T dequeue(){
        if (head == null)
            return null;
        T temp = (T) head.getData();
        head = head.getLink();
        return temp;
    }
    
    public void enqueue(T a){
        ListNode newNode = new ListNode(a, null);
        if(head == null){
            head = newNode;
        }else{
            ListNode currentNode = head;
            T currentData = (T)currentNode.getData();
            if(a.compareTo(currentData) > 0){
                newNode.setLink(currentNode);
                head = newNode;
                return;
            }
            while(currentNode.getLink() != null){
                T nextData = (T)currentNode.getLink().getData();
                if(a.compareTo(nextData) > 0){
                    ListNode temp = currentNode.getLink();
                    currentNode.setLink(newNode);
                    newNode.setLink(temp);
                    return;
                }
                currentNode = currentNode.getLink();
            }
            currentNode.setLink(newNode);
        }
    }
    
    public T peek(){
        if(head == null)
            return null;
        else
            return (T) head.getData();
    }
    
    public void showQueue(){
        if(isEmpty())
            System.out.println("Empty Queue");
        else{
            ListNode currentNode = head;
            while(currentNode!= null){
                System.out.print(currentNode.toString());
                currentNode = currentNode.getLink();
            }
        }
    }
    
    public boolean isExist(T a){
        if(isEmpty()){
            return false;
        }else{
            if(head.getData().equals(a))
                return true;
            
            ListNode currentNode = head ;
            while(currentNode.getLink() != null){
                currentNode = currentNode.getLink();
                if(currentNode.getData().equals(a))
                    return true;
            }
        }
        return false;
    }
}
