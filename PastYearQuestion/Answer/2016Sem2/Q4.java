package PastYear;

public class Q4 {
    public static void main(String[] args) {
        LinkedList s1 = new LinkedList();
        s1.add(10);
        s1.add(20);
        s1.add(30);
        s1.add(40);
        s1.add(50);
        s1.addAfter(11,10);
        s1.addAfter(21,20);
        s1.addAfter(31,30);
        s1.addAfter(41,40);
        s1.addAfter(51,50);
        System.out.println("");
        s1.traverse();
        s1.deleteFront();
        s1.deleteFront();
        s1.traverse();
        s1.deleteAfter(40);
        s1.deleteAfter(40);
        s1.deleteAfter(31);
        s1.deleteAfter(40);
        s1.traverse();
    }
    
}

class LinkedList<T extends Comparable<T>>{
    private ListNode<T> head;
    
    public LinkedList(){
        head = null;
    }
    
    //i
    public void add(T element){
        System.out.println("Adding: " + element);
        if(head == null){
            head = new ListNode(element,null);
        }else{
            ListNode<T> currentNode = head;
            while(currentNode.getNext() != null)
                currentNode = currentNode.getNext();
            currentNode.setNext(new ListNode(element,null));
        }
    }
    
    //ii
    public boolean addAfter(T newElement,T element){
        System.out.println("Adding " + newElement + " after " + element);
        ListNode<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getValue() == element) {
                ListNode<T> temp = currentNode.getNext();
                currentNode.setNext(new ListNode(newElement, temp));
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }
    
    //iii
    public boolean deleteFront(){
        if(head == null){
            System.out.println("The list is empty, no element to be deleted.\n");
            return false;
        }
        System.out.println("Deleting front: " + head + "\n");
        head = head.getNext();
        return true;
    }
    
    //iv
    public boolean deleteAfter(T element){
        System.out.println("Testing deleteAfter:");
        ListNode<T> currentNode = head;
        while(currentNode != null){
            if(currentNode.getValue() == element){
                ListNode<T> temp = currentNode.getNext();
                if(temp == null)
                    System.out.println("After " + element + " is " + temp + "\n");
                else
                    System.out.println("After " + element + " is " + temp + ". Deleting " + temp + "\n");
                currentNode.setNext(currentNode.getNext().getNext());
                return true;
            }
            currentNode = currentNode.getNext();
        }
        System.out.println("Element (" + element + ") not found...\n");
        return false;
    }
    
    //v
    public void traverse(){
        System.out.println("Showing content of my linked list:");
        ListNode<T> currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println("\n");
    }
}

class ListNode<T extends Comparable<T>>{
    private T value;
    private ListNode next;

    public ListNode(T value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value+"";
    }
    
}