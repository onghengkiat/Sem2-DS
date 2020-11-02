package LabQuestion;

public class Stack<T> {
    private ListNode head ;
    
    public Stack(){
        head = null;
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
    public int getSize(){
        int count =0 ;
        ListNode currentNode = head;
        while(currentNode != null){
            currentNode = currentNode.getLink();
            count ++;
        }
        return count;
    }
    
    public void push(T a){
        head = new ListNode(a,head);
    }
    
    public T pop(){
        if(head == null)
            return null;
        T temp = (T) head.getData();
        head = head.getLink();
        return temp;
    }
    
    public T peek(){
        if(head == null)
            return null;
        else
            return (T) head.getData();
    }
    
    public void showStack(){
        if(isEmpty())
            System.out.println("Empty Stack");
        else{
            ListNode currentNode = head;
            while(currentNode != null){
                System.out.print(currentNode.toString());
                currentNode = currentNode.getLink();
            }
        }
    }
}
