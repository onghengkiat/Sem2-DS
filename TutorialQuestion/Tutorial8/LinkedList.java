package TutorialQuestion;


public class LinkedList<T extends Comparable <T>> {
    private ListNode head;
    final private int ASCENDING = 1;
    final private int DESCENDING = 2;
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
        boolean found = false;
        ListNode currentNode = head;
        while(currentNode != null){
            if(t.compareTo((T) currentNode.getData()) == 0){
                found = true;;
                break;
            }
            currentNode = currentNode.getLink();
        }
        
        return found;
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
    
    
    //Q3
    public void selectionSort(int orderType){
        System.out.print("Selection Sort - ");
        if(orderType == DESCENDING)
            System.out.println("Descending Order");
        else if(orderType == ASCENDING)
            System.out.println("Ascending Order");
        ListNode currentNode = head;
        while(currentNode.getLink() != null){
            ListNode minNode = getMinNode(orderType,currentNode);
            T currentData = (T)currentNode.getData();
            T minData = (T)minNode.getData();
            currentNode.setData(minData);
            minNode.setData(currentData);
            currentNode = currentNode.getLink();
        }
    }
    
    public ListNode getMinNode(int orderType, ListNode minNode){
        T minData = (T)minNode.getData();
        ListNode currentNode = minNode;
        while(currentNode.getLink() != null){
            currentNode = currentNode.getLink();
            T currentData = (T)currentNode.getData();
            if(orderType == ASCENDING){
                if(minData.compareTo(currentData) > 0){
                    minNode = currentNode;
                    minData = currentData;
                }
            }
            else if(orderType == DESCENDING){
                if(minData.compareTo(currentData) < 0){
                    minNode = currentNode;
                    minData = currentData;
                }
            }
        }
        return minNode;
    }
    
    
    //Q4
    public void bubbleSort(int orderType){
        System.out.print("Bubble Sort - ");
        if(orderType == DESCENDING)
            System.out.println("Descending Order");
        else if(orderType == ASCENDING)
            System.out.println("Ascending Order");
        for(int iteration = 0 ; iteration < length() - 1 ; iteration ++){
            ListNode currentNode = head;
            while(currentNode.getLink() != null){
                T currentValue = (T)currentNode.getData();
                ListNode nextNode = currentNode.getLink();
                T nextValue = (T)nextNode.getData();
                if(currentValue.compareTo(nextValue) > 0 && orderType == ASCENDING){
                    currentNode.setData(nextValue);
                    nextNode.setData(currentValue);
                }
                else if(currentValue.compareTo(nextValue) < 0 && orderType == DESCENDING){
                    currentNode.setData(nextValue);
                    nextNode.setData(currentValue);
                }
                currentNode = nextNode;
            }
        }
    }
}
