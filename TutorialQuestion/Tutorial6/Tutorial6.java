package TutorialQuestion;

import java.util.Random;
import java.util.Scanner;


public class Tutorial6 {
    public static void main(String[] args) {
        Queue <Character>question1 = new Queue<>();
        System.out.println("Queue Implementation using Linked List");
        
        //Q1a
        System.out.println("Enqueue three nodes");
        question1.enqueue('B');
        question1.enqueue('M');
        question1.enqueue('W');
        question1.showQueue();
        
        //Q1b
        System.out.println("\nDequeue one node");
        question1.dequeue();
        question1.showQueue();
        
        //Q1c
        System.out.println("\nThe front node of the queue is " + question1.peek());
        
        //Q1d
        System.out.println("The queue size is " + question1.getSize());
        
        
        System.out.println("");
        //Q2
        System.out.println("Queue Implementation using Array");
        System.out.println("Enqueue three nodes");
        ArrayQueue<Character> question2 = new ArrayQueue<>();
        question2.enqueue('B');
        question2.enqueue('M');
        question2.enqueue('W');
        question2.showQueue();
        System.out.println("\nDequeue one node");
        question2.dequeue();
        question2.showQueue();
        
        System.out.println("\nThe front node of the queue is " + question2.peek());
        System.out.println("The queue size is "+ question2.getSize());
        
        
        System.out.println("");
        //Q3
        Queue <String> question3 = new Queue<>();
        System.out.println("Simulating a Queue to purchase MY phone");
        Random rnd = new Random();
        int sum = 0 ;
        int num = 0;
        while ( sum < 30){
            int randomNum = rnd.nextInt(3) + 1;
            if(randomNum + sum > 30){
                randomNum = sum + randomNum - 30;
                sum = 30;
            }else
                sum += randomNum;
            num ++;
            question3.enqueue("Custormer " + num + " : " + randomNum + " set(s)");
        }
        question3.showQueue();
        System.out.println("\nNumber of Customer : " + question3.getSize());
        
        
        System.out.println("");
        //Q4
        Scanner input =new Scanner(System.in);
        for(int i = 0 ; i < 5 ; i++){
            Queue<Character> question4 = new Queue<>();
            System.out.print("Enter a sentence : ");
            String str = input.nextLine();
            int middle = str.length()/2;
            for(int j = 0 ; j < middle ; j++){
                question4.enqueue(str.charAt(j));
            }
            boolean palindrome = true;
            if(str.length() % 2 == 1){
                middle += 1;
            }
            for(int j = str.length() - 1 ; j >= middle ; j--){
                if(question4.dequeue() != str.charAt(j)){
                    System.out.println(str + " is not a palindrome.");
                    palindrome = false;
                    break;
                }
            }
            if(palindrome){
                System.out.println(str + " is a palindrome.");
            }
        }
        
        System.out.println("");
        //Q4
        Scanner in =new Scanner(System.in);
        for(int i = 0 ; i < 5 ; i++){
            System.out.print("Enter a sentence : ");
            Queue<Character> question5 = new Queue<>();
            String str = in.nextLine();
            int middle = str.length()/2;
            for(int j = 0 ; j < middle ; j++){
                if(!Character.isAlphabetic(str.charAt(j)))
                    continue;
                question5.enqueue(str.charAt(j));
            }
            
            boolean palindrome = true;
            if(str.length() % 2 == 1){
                middle += 1;
            }
            for(int j = str.length() - 1 ; j >= middle ; j--){
                if(!Character.isAlphabetic(str.charAt(j)) )
                    continue;
                if(Character.toUpperCase(question5.dequeue()) != Character.toUpperCase(str.charAt(j))){
                    System.out.println(str + " is not a palindrome.");
                    palindrome = false;
                    break;
                }
            }
            if(palindrome){
                System.out.println(str + " is a palindrome.");
            }
        }
        
        
        System.out.println("");
        //Q6
        System.out.print("Enter a sentence : ");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        Queue<String> question6 =new Queue<>();
        int currentIndex = 0;
        while(currentIndex < sentence.length()){
            int indexOfSpace = sentence.indexOf(" " , currentIndex);
            if(indexOfSpace == -1){
                question6.enqueue(sentence.substring(currentIndex));
                break;
            }
            question6.enqueue(sentence.substring(currentIndex,indexOfSpace));
            currentIndex = indexOfSpace + 1;
        }
        System.out.print("The original queue : ");
        question6.showQueue();
        
        System.out.print("\nReverse all the elements in the queue : ");
        reverseQueue(question6);
        question6.showQueue();
    }
    
    //Q6
    public static void reverseQueue(Queue <String> question6){
        reverseQueue(question6,"");
    }
    
    public static void reverseQueue(Queue <String> question6 , String str){
        if(question6.isEmpty()){
            
        }else{
            String s = question6.dequeue();
            reverseQueue(question6,s);
            question6.enqueue(s);
        }
    }
}
