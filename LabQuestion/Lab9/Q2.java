package LabQuestion;

import java.util.Random;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        LinkedList <Integer> a = new LinkedList();
        Random rnd = new Random();
        for(int i = 0 ; i< 10 ; i++){
            a.addNode(rnd.nextInt(21));
        }
        Scanner input = new Scanner(System.in);
        a.showList();
        System.out.println("\nLinear Search");
        System.out.print("Enter a number to search: ");
        int number = input.nextInt();
        if(a.exist(number)){
            System.out.println(number + " is found");
            System.out.println("The number of " + number + " in the data set is " + a.occurence(number));
        }else{
            System.out.println(number + " is not found");
        }
        
        System.out.print("Enter two numbers to search(begin end) : ");
        int begin = input.nextInt();
        int end = input.nextInt();
        if(a.exist(begin,end)){
            System.out.println("The integer can be found in between " + begin + " and " + end);
            System.out.println("The number of the elements in between " + begin + " and " + end + " in the data set is " + a.occurence(begin,end));
        }else{
            System.out.println("No integer can be found in between " + begin + " and " + end);
        }
    }
    
}
