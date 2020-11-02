package LabQuestion;

public class LinkedList<T extends Comparable <T>> {
    private ListNode head;
    
    public LinkedList(){
        head = null;
    }
    
    public int length(){
        int count = 0 ;
        ListNode currentNode = head;
        while(currentNode != null){
            currentNode = currentNode.getLink();
            count++;
        }
        return count;
    }
    
    public void clear(){
        head = null;
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
    public void showList(){
        ListNode currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
    }
    
    public void addNode(T a ){
        ListNode newNode = new ListNode(a , null);
        ListNode currentNode = head;
        if(head == null){
            head = newNode;
        }else{
            while(currentNode.getLink() != null)
                currentNode = currentNode.getLink();
            currentNode.setLink(newNode);
        }
    }
    
    public void deleteNode(){
        ListNode currentNode = head;
        ListNode previousNode = head;
        if(head != null){
            if(currentNode.getLink() == null)
                head = null;
            else{
                while(currentNode.getLink() != null){
                    previousNode = currentNode;
                    currentNode = currentNode.getLink();
                }
                previousNode.setLink(null);
            }
        }else
            System.out.println("The list is empty");
    }
    
    public void addFrontNode(T a){
        head = new ListNode(a,head);
    }
    
    public void deleteFrontNode(){
        if(head !=null)
            head = head.getLink();
        else
            System.out.println("The list is empty");
    }
    
    public boolean contains(T t){
        ListNode currentNode = head;
        while(currentNode != null){
            if(t.compareTo((T) currentNode.getData()) == 0){
                return true;
            }
            currentNode = currentNode.getLink();
        }
        return false;
    }
    
    public void addNodeByPosition(T a , int index){
        if(index == 0 )
            addFrontNode(a);
        else if (index == length())
            addNode(a);
        else if(index > length())
            System.out.println("Invalid index. No node inserted");
        else{
            ListNode newNode = new ListNode(a,null);
            ListNode currentNode = head;
            for(int i = 1 ; i < index ;i++)
                currentNode = currentNode.getLink();
            ListNode tempNode = currentNode.getLink();
            currentNode.setLink(newNode);
            newNode.setLink(tempNode);
        }
    }
    
    public void deleteNodeByPosition(int index){
        if(index == 0)
            deleteFrontNode();
        else if(index == length() -1)
            deleteNode();
        else if(index >= length())
            System.out.println("Invalid index. No node deleted");
        else{
            ListNode currentNode = head;
            for(int i = 1 ; i < index; i ++)
                currentNode = currentNode.getLink();
            ListNode tempNode = currentNode.getLink();
            currentNode.setLink(tempNode.getLink());
            tempNode = null;
        }
    }
    
    public void setFront(T t){
        if(head != null)
            head.setData(t);
        else
            System.out.println("Invalid update. List is empty");
    }
    
    public void setBack(T t){
        if(head != null){
            ListNode currentNode = head;
            while(currentNode.getLink() != null)
                currentNode = currentNode.getLink();
            currentNode.setData(t);
        }
        else
            System.out.println("Invalid update. List is empty");
    }
    
    public void set(T t, int index){
        if(index == 0)
            setFront(t);
        else if (index == length() -1)
            setBack(t);
        else if(index >= length ())
            System.out.println("Invalid index. Update failed.");
        else{
            ListNode currentNode = head;
            for(int i = 1 ; i <= index; i++)
                currentNode = currentNode.getLink();
            currentNode.setData(t);
        }
    }
            
    public T getFront(){
        if(head != null)
            return (T) head.getData();
        else
            return null;
    }
    
    public T getBack(){
        if(head != null){
            ListNode currentNode = head;
            while(currentNode.getLink() != null)
                currentNode = currentNode.getLink();
            return (T) currentNode.getData();
        }
        else 
            return null;
    }
    
    public T get(int index){
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
    
    //2a
    public boolean exist(T element){
        ListNode currentNode = head;
        while(currentNode != null){
            if(head.getData().equals(element))
                return true;
            currentNode = currentNode.getLink();
        }
        return false;
    }   
    
    //2b
    public int occurence(T element){
        ListNode currentNode = head;
        int count = 0 ;
        while(currentNode != null){
            if(currentNode.getData().equals(element))
                count ++;
            currentNode = currentNode.getLink();
        }
        return count;
    }   
    
    //2c
    public boolean exist(T begin , T end){
        ListNode <T>currentNode = head;
        while(currentNode != null){
            T currentElement = currentNode.getData();
            if(currentElement.compareTo(begin) >= 0 && currentElement.compareTo(end) <= 0)
                return true;
            currentNode = currentNode.getLink();
        }
        return false;
    }   
    
    //2d
    public int occurence(T begin, T end){
        ListNode <T>currentNode = head;
        int count = 0 ;
        while(currentNode != null){
            T currentElement = currentNode.getData();
            if(currentElement.compareTo(begin) >= 0 && currentElement.compareTo(end) <= 0)
                count ++;
            currentNode = currentNode.getLink();
        }
        return count;
    }   
    
    //5
    public int indexOf(T t){
        ListNode currentNode = head;
        if(!contains(t))
            return -1;
        
        int count = 0 ;
        while(currentNode != null){
            if(t.compareTo((T) currentNode.getData()) == 0){
                return count;
            }
            count ++;
            currentNode = currentNode.getLink();
        }
        return count;
    }
}
