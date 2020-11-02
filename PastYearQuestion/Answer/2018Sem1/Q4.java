package PastYear;

public class Q4 {
    public static void main(String[] args) {
        //a
        //similar code,not exactly same code
        LinkedList list = new LinkedList();
        
        list.add(new Subject("Data Structure",5));
        list.add(new Subject("Programming I",5));
        list.add(new Subject("Principles of AI",3));
        list.add(new Subject("Computing Mathematics 1",3));
//        list.display();
        list.totalCreditHours();
        list.addAfter("Programming I", new Subject("Software Architecture",4));
//        list.display();
        list.addAfter("Software Architecture", new Subject("Networking",4));
//        list.display();
        list.totalCreditHours();
        
        list.remove(new Subject("Networking",4));
//        list.display();
        
        list.remove(new Subject("Principles of AI",3));
//        list.display();
        list.totalCreditHours();
    }
}

class Subject implements Comparable<Subject>{
    private String name;
    private int duration;

    @Override
    public String toString() {
        return name + ": " + duration + " hours";
    }

    public Subject(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
    
    @Override
    public int compareTo(Subject o) {
        return this.getName().compareTo(o.getName());
    }
    
}

class LinkedList{
    private ListNode<Subject> head;
    
    //i
    public LinkedList(){
        head = null;
    }
    
    //iii
    public boolean isEmpty(){
        return head == null;
    }
    
    //iv
    public void add(Subject element){
        if(isEmpty()){
            head = new ListNode(element, null);
        }else{
            ListNode<Subject> currentNode = head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            
            currentNode.setNext(new ListNode(element, null));
        }
    }
    
    //v
    public boolean addAfter(String oldElement, Subject element){
        System.out.println("Adding " + element.getName() + " after " + oldElement);
        if(!isEmpty()){
            int count = 0 ;
            ListNode<Subject>currentNode = head;
            while(currentNode != null){
                count ++;
                if(currentNode.getValue().getName().compareTo(oldElement) == 0){
                    System.out.println("Found " + oldElement + " which is book number " + count + " in the linked list\n");
                    ListNode <Subject> temp = currentNode.getNext();
                    currentNode.setNext(new ListNode(element,temp));
                    return true;
                }
                currentNode = currentNode.getNext();
            }
        }
        System.out.println(oldElement + " is not found\n");
        return false;
    }
    
    //vi
    public Subject remove(){
        if(isEmpty()){
            return null;
        }else{
            ListNode<Subject> currentNode = head.getNext();
            ListNode<Subject> previousNode = head;
            if(currentNode == null){
                Subject temp = head.getValue();
                head = null;
                return temp;
            }
            while(currentNode.getNext() != null){
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            Subject temp = currentNode.getValue();
            previousNode.setNext(null);
            return temp;
        }
    }
    public Subject remove(Subject element){
        if(isEmpty()){
            return null;
        }else{
            System.out.println("Removing " + element.getName() + "..");
            int count = 1 ;
            ListNode<Subject> currentNode = head.getNext();
            ListNode<Subject> previousNode = head;
            if(head.getValue().compareTo(element) == 0){
                System.out.println("Found a match.. " + element.getName() + " is book number " + count + " in the linked list\n");
                Subject temp = head.getValue();
                head = head.getNext();
                return temp;
            }
            if(currentNode == null)
                return null;
            
            while(currentNode.getNext() != null){
                count ++;
                if(currentNode.getValue().compareTo(element) == 0){
                    System.out.println("Found a match.. " + element.getName() + " is book number " + count + " in the linked list\n");
                    Subject temp = currentNode.getValue();
                    previousNode.setNext(currentNode.getNext());
                    return temp;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            return null;
        }
    }
    
    //vii
    public void display(){
        System.out.println("Displaying the Linked List " + "*".repeat(30) + "\n" );
        ListNode<Subject> currentNode = head;
        while(currentNode != null){
            System.out.println(currentNode + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println("");
    }
    
    //b
    public int totalCreditHours(){
        ListNode<Subject> currentNode = head;
        int creditHour = 0;
        while(currentNode != null){
            creditHour += currentNode.getValue().getDuration();
            currentNode = currentNode.getNext();
        }
        System.out.println("Total credit hours taken: " + creditHour + "\n");
        return creditHour;
    }
    
}

class ListNode<T>{
    private T value;
    private ListNode<T> next;

    //ii
    public ListNode(T value, ListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }
    
}