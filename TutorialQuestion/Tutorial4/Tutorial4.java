package TutorialQuestion;

import java.util.Scanner;

public class Tutorial4 {
    public static void main(String[] args) {
        //Q1
        LinkedList <Double> list = new LinkedList<>();
        list.addNode(23.1);
        list.addNode(36.5);
        list.addNode(12.8);
        list.addNode(42.6);
        list.addNode(32.8);
        System.out.println("The number in the linked list");
        list.showList();
        
        
        System.out.println("");
        //Q2
        list.addSomething();
        System.out.println("The number in the linked list after updated");
        list.showList();
        
        
        System.out.println("");
        //Q3
        LinkedList <Integer> currencyNotes = new LinkedList<>();
        currencyNotes.addNode(100);
        currencyNotes.addNode(50);
        currencyNotes.addNode(20);
        currencyNotes.addNode(10);
        currencyNotes.addNode(5);
        currencyNotes.addNode(1);
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the total amount: ");
        int totalAmount = input.nextInt();
        System.out.println("Total amount: " + totalAmount);
        LinkedList <Integer> amountOfNotes = new LinkedList<>();
        for(int i = 0 ; i < currencyNotes.length() ; i++){
            int currency = currencyNotes.get(i);
            amountOfNotes.addNode(totalAmount/currency);
            totalAmount %= currency;
            System.out.println("MYR " + currency + " : " + amountOfNotes.get(i));
        }
        
        
        //Q4
        //example output is wrong 
        LinkedList <Integer>question4 = new LinkedList<>();
        question4.addNode(23);
        question4.addNode(15);
        question4.addNode(17);
        question4.addNode(28);
        question4.addNode(12);
        question4.addNode(40);
        question4.showList();
        System.out.println("Linked List has " + question4.length() + " node(s)");
        System.out.println("Total is " + question4.sum());
        System.out.println("Total even number is " + question4.even());
        
        //Q5
        LinkedList list1 = LinkedList.generateRandom(15);
        System.out.println("Linked List has "+ list1.length() + "node(s)");
        list1.showList();
        System.out.println("");
        if(list1.deleteNumber(4))
            System.out.println("Delete the number 4 from the list.");
        System.out.println("\nLinked List has "+ list1.length() + "node(s)");
        list1.showList();
        
        
        System.out.println("");
        //Q6
        LinkedList <Integer>question6 = new LinkedList<>();
        question6.addFrontNode(78);
        question6.addFrontNode(45);
        question6.addFrontNode(34);
        question6.addFrontNode(23);
        question6.addFrontNode(17);
        question6.addFrontNode(10);
        question6.addFrontNode(8);
        question6.showList();
        System.out.println("");
        System.out.println("The median is " + question6.middle());
    }
}
