package PastYear;

public class Q1 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirstLink("Louis Vuitton", 10000000);
        list.insertFirstLink("Chanel", 100000000);
        list.insertFirstLink("Prada", 1000000);
        list.insertFirstLink("Tods", 500000000);
        list.display();
        list.addAfter("Chanel", "Coach",10000000);
        list.display();
        list.addAfter("Coach", "Mulberry",90000000);
        list.display();
        list.removeLink("Chanel");
        list.display();
        list.removeLink("Coach");
        list.display();
    }
   
}
class LinkedList{
    private ListNode head;
    
    public LinkedList(){
        head = null;
    }
    
    //i
    public void insertFirstLink(String brands, int sold){
        if(head == null){
            head = new ListNode(brands,sold,null);
        }else{
            ListNode currentNode = head;
            while(currentNode.getNext() != null)
                currentNode = currentNode.getNext();
            currentNode.setNext(new ListNode(brands,sold,null));
        }
    }
    
    //ii
    public boolean addAfter(String oldElement, String brands, int sold){
        int count = 1 ;
        ListNode currentNode = head;
        System.out.println("Adding " + brands + " after " + oldElement);
        while (currentNode != null) {
            if (currentNode.getBrands().equals(oldElement)) {
                System.out.println("Found " + oldElement + " which is handbag number " + count + " in the linked list\n");
                ListNode temp = currentNode.getNext();
                currentNode.setNext(new ListNode(brands,sold, temp));
                return true;
            }
            count++;
            currentNode = currentNode.getNext();
        }
        System.out.println(oldElement + " is not found");
        return false;
    }
    
    //iii
    public boolean removeLink(String brands){
        System.out.println("Removing " + brands + "..");
        int count = 1;
        if(head.getBrands().equals(brands)){
            head = head.getNext();
            System.out.println("Found a match.. " + brands + " is handbag number " + count + " in the linked list\n");
            return true;
        }else{
            ListNode currentNode = head;
            while(currentNode.getNext() != null){
                count ++;
                ListNode temp = currentNode.getNext();
                if(temp.getBrands().equals(brands)){
                    System.out.println("Found a match.. " + brands + " is handbag number " + count + " in the linked list\n");
                    currentNode.setNext(temp.getNext());
                    return true;
                }
                currentNode = currentNode.getNext();
            }
            return false;
        }
    }
    
    //iv
    public void display(){
        System.out.println("Displaying the Linked List " + "*".repeat(30));
        ListNode currentNode = head;
        while(currentNode != null){
            System.out.println(currentNode);
            currentNode = currentNode.getNext();
        }
        System.out.println("");
    }
}
class ListNode{
    private String brands;
    private int sold;
    private ListNode next;

    public ListNode(String brands, int sold, ListNode next) {
        this.brands = brands;
        this.sold = sold;
        this.next = next;
    }

    @Override
    public String toString() {
        String temp = "";
        String integerString = Integer.toString(sold);
        int count = 0 ;
        for(int i = integerString.length() - 1 ; i >= 0 ; i--){
            temp += integerString.charAt(i);
            count++;
            if(count % 3 == 0 && i != 0)
                temp += ",";
        }
        integerString ="";
        for(int i = temp.length() - 1 ; i >= 0 ; i--){
            integerString += temp.charAt(i);
        }
        return brands + ": " + integerString + " Sold";
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}
