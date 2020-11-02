package LabQuestion;

public class CircularLinkedList<T> {
    private ListNode head ;
    private ListNode tail;
    
    public CircularLinkedList(){
        head = null;
        tail = null;
    }
    
    //7a
    public int length(){
        int count = 0 ;
        ListNode currentNode = head;
        do{
            if(currentNode == null)
                return count;
            currentNode = currentNode.getLink();
            count++;
        }while(currentNode != head);
        
        return count;
    }
    
    public void clear(){
        head = null;
        tail = null;
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
    //7d
    public void showCircularList(){
        ListNode currentNode = head;
        if(head != null){
            do{
                System.out.print(currentNode.toString());
                currentNode = currentNode.getLink();
            }while(currentNode != head);
            System.out.println(currentNode.getData());
        }else
            System.out.println("The list is empty");
    }
    
    //7b
    public void addCircularNode(T a ){
        ListNode currentNode = head;
        if(head == null){
            head = new ListNode(a,tail);
        }else if(tail == null){
            tail = new ListNode(a,head);
            head.setLink(tail);
        }else{
            while(currentNode != tail)
                currentNode = currentNode.getLink();
            tail = new ListNode(a,head);
            currentNode.setLink(tail);
        }
    }
    
    //7c
    public void deleteCircularNode(){
        ListNode currentNode = head;
        if(head != null){
            if(tail == null)
                head = null;
            else if (head.getLink() == tail){
                tail = null;
                head.setLink(tail);
            }else{
                while(currentNode.getLink() != tail){
                    currentNode = currentNode.getLink();
                }
                currentNode.setLink(head);
                tail = currentNode;
            }
        }else
            System.out.println("The list is empty");
    }
    
    public void addFrontNode(T a){
        ListNode frontNode = head;
        head = new ListNode(a,frontNode);
        tail.setLink(head);
    }
    
    public void deleteFrontNode(){
        if(head !=null)
            head = head.getLink();
        else
            System.out.println("The list is empty");
    }
    
    //7e
    public T getCircularItem(int index){
        if(index == 0 )
            return getFront();
        else if (index == length() - 1)
            return getBack();
        else if(index >= length())
            return null;
        else{
            ListNode currentNode = head;
            for(int i = 1 ; i <= index ; i++)
                currentNode = currentNode.getLink();
            return (T) currentNode.getData();
        }
    }
    
    public T getFront(){
        if(head != null)
            return (T) head.getData();
        else
            return null;
    }
    
    public T getBack(){
        if(tail != null)
            return (T)tail.getData();
        else 
            return null;
    }
}