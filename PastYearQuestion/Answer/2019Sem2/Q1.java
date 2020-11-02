package PastYear;

//c
public class Q1 {
    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        MyLinkedList<Integer> newList = new MyLinkedList<>();
        list1.addLast(2);
        list1.addLast(10);
        list1.addLast(38);
        list1.addLast(41);
        list1.addLast(51);
        System.out.println(list1);
        list2.addLast(5);
        list2.addLast(12);
        list2.addLast(18);
        list2.addLast(21);
        list2.addLast(35);
        list2.addLast(41);
        list2.addLast(56);
        System.out.println(list2);
        System.out.println("The newList is:");
        newList = combine(list1,list2);
        System.out.println(newList);
    }
    
    public static <T extends Comparable<T>> MyLinkedList<T> combine(MyLinkedList<T> list1, MyLinkedList<T> list2){
        MyLinkedList<T> newList = new MyLinkedList<>();
        T currentFirstList = list1.removeFirst();
        T currentSecondList = list2.removeFirst();
        while(currentFirstList != null && currentSecondList != null){
            if(currentFirstList.compareTo(currentSecondList) > 0){
                newList.addLast(currentSecondList);
                currentSecondList = list2.removeFirst();
            }else{
                newList.addLast(currentFirstList);
                currentFirstList = list1.removeFirst();
            }
        }
        
        while(currentFirstList != null){
            newList.addLast(currentFirstList);
            currentFirstList = list1.removeFirst();
        }
        while(currentSecondList != null){
            newList.addLast(currentSecondList);
            currentSecondList = list2.removeFirst();
        }
        return newList;
    }
}
//b
class MyLinkedList<T>{
    //i
    private Node<T> head;
    private Node<T> tail;
    private int size;

    //ii
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    //iii
    public int getSize(){
        return size;
    }
    
    //iv
    public void addFirst(T element){
        size++;
        if(head == null){
            head = new Node(element);
        }else{
            Node<T> temp = head;
            head = new Node(element);
            head.setNext(temp);
        }
    }
    
    //v
    public void addLast(T element){
        size++;
        if(head == null){
            head = new Node(element);
        }else{
            Node<T> currentNode = head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node(element));
        }
    }
    
    //vi
    public T removeFirst(){
        T temp = null;
        if(head != null){
            size --;
            temp = head.getValue();
            head = head.getNext();
        }
        return temp;
    }
    
    //vii
    @Override
    public String toString() {
        String str = "";
        Node<T> currentNode = head;
        while(true){
            if(currentNode.getNext() == null){
                str += currentNode;
                break;
            }
            str += currentNode + " >> ";
            currentNode = currentNode.getNext();
        }
        return "[size=" + getSize() + "] >> "+str;
    }
    
    
}
//a
class Node<T>{
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
        next = null;
    }

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

    @Override
    public String toString() {
        return value.toString();
    }
}
