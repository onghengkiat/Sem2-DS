package LabQuestion;

import java.util.Iterator;
import java.util.function.Consumer;

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
        boolean found = false;
        ListNode currentNode = head;
        while(currentNode != null){
            if(t.compareTo((T) currentNode.getData()) == 0){
                found = true;
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
    
    //Q1C
    public void addSortNode(T value){
        ListNode currentNode = head;
        if(currentNode == null){
            head = new ListNode(value, null);
        }else if(currentNode.getLink() == null){
            if(value.compareTo((T) currentNode.getData()) > 0){
                addNode(value);
            }else{
                addFrontNode(value);
            }
        }else{
            boolean add = false;
            while(currentNode != null){
                if(value.compareTo((T)currentNode.getData()) < 0){
                    ListNode previousNode = head;
                    if(previousNode == currentNode){
                        addFrontNode(value);
                        add = true;
                        break;
                    }else{
                        while(previousNode.getLink() != currentNode){
                            previousNode = previousNode.getLink();
                        }
                        ListNode newNode = new ListNode(value,currentNode);
                        previousNode.setLink(newNode);
                        add = true;
                        break;
                    }
                }
                currentNode = currentNode.getLink();
            }
            if(add == false)
                addNode(value);
        }
    }
    
    //2a
    public LinkedList<T>[] splitList(){
        LinkedList<T> list1 = new LinkedList<>(); 
        LinkedList<T> list2 = new LinkedList<>(); 
        ListNode currentNode = head;
        int turn = 0 ;
        int middle = length()/2 +1;
        while(currentNode != null){
            if(turn < middle)
                list1.addNode((T) currentNode.getData());
            else
                list2.addNode((T) currentNode.getData());
            turn ++;
            currentNode = currentNode.getLink();
        }
        System.out.println("Split the list into two");
        System.out.print("First List : ");
        list1.showList();
        System.out.println("");
        System.out.print("Second List : ");
        list2.showList();
        System.out.println("");
        LinkedList<T>[] lists = new LinkedList[2];
        lists[0] = list1;
        lists[1] = list2;
        return lists;
    }
    
    //2b
    public LinkedList<T>[] alternateList(){
        LinkedList<T> list1 = new LinkedList<>(); 
        LinkedList<T> list2 = new LinkedList<>(); 
        ListNode currentNode = head;
        int turn = 0 ;
        while(currentNode != null){
            if(turn % 2 == 0)
                list1.addNode((T) currentNode.getData());
            else
                list2.addNode((T) currentNode.getData());
            turn ++;
            currentNode = currentNode.getLink();
        }
        System.out.println("Split the list by alternating the nodes");
        System.out.print("First List : ");
        list1.showList();
        System.out.println("");
        System.out.print("Second List : ");
        list2.showList();
        System.out.println("");
        LinkedList<T>[] lists = new LinkedList[2];
        lists[0] = list1;
        lists[1] = list2;
        return lists;
    }
    
    //2c
    public LinkedList<T> mergeList(LinkedList<T> list1, LinkedList<T> list2){
        
        int turn = 0 ;
        ListNode currentNode1 = list1.head;
        ListNode currentNode2 = list2.head;
        LinkedList <T>list = new LinkedList<>();
        while(currentNode1 != null || currentNode2 != null){
            if(turn % 2 == 0){
                list.addNode((T)currentNode1.getData());
                currentNode1 = currentNode1.getLink();
            }
            else{
                list.addNode((T)currentNode2.getData());
                currentNode2 = currentNode2.getLink();
            }
            turn ++;
        }
        list.showList();
        System.out.println("");
        return list;
    }
    
    //2d
    public void reverse(){
        reverse(head);
        showList();
        System.out.println("");
    }
    
    public void reverse(ListNode currentNode){
        if(currentNode == null){
            clear();
        }else{
            reverse(currentNode.getLink());
            addNode((T)currentNode.getData());
        }
    }
    
    //Q5
    public ListNode getNode(int index){
        if(index == 0)
            return head;
        else if(index >= length())
            return null;
        else{
            ListNode currentNode = head;
            for(int i = 0 ; i < index; i ++)
                currentNode = currentNode.getLink();
            return currentNode;
        }
    }
    
    //5
    class LinkedListIterator implements Iterator{

        private ListNode currentNode ;
        private int index ;
        
        public LinkedListIterator(int i){
            currentNode = getNode(i);
            index = i;
        }
        
        public boolean hasPrevious(){
            return currentNode != head;
        }
        
        public T previous(){
            ListNode previousNode = head;
            index -- ;
            if(hasPrevious())
                while(previousNode.getLink() != currentNode)
                    previousNode = previousNode.getLink();
            return (T) previousNode;
        }
        
        @Override
        public T next(){
            index ++;
            currentNode = currentNode.getLink();
            return (T)currentNode.getData();
        }
        
        @Override
        public boolean hasNext() {
            if(currentNode == null)
                return false;
            if(currentNode.getLink() == null)
                return false;
            return true;
        }
        
        public int getIndex(){
            return index;
        }
        
        public void remove(){
            if(hasNext())
                currentNode = currentNode.getLink();
            else
                currentNode = null;
            deleteNodeByPosition(index);
        }

        public T getCurrentData() {
            return get(index);
        }
        
    }
}
