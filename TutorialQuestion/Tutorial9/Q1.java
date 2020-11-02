package TutorialQuestion;

import java.util.Random;
import java.util.Scanner;


public class Q1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        
        char [] arr = new char[10];
        System.out.print("The Character data set are : ");
        for(int i = 0; i < 10 ; i++){
            arr[i] = (char)(rnd.nextInt(26) + 'A');
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nLinear Search");
        System.out.print("Enter a letter to search: ");
        Scanner input = new Scanner(System.in);
        char letter = input.next().charAt(0);
        LinearSearch a = new LinearSearch(arr);
        if(!a.exist(letter)){
            System.out.println(letter + " is not found");
        }else{
            System.out.println(letter + " is found ");
            System.out.print("The location of the " + letter + " are : ");
            for(int index : a.getIndex(letter)){
                System.out.print(index + " ");
            }
            System.out.println("");
        }
        
        System.out.print("Enter two letters to search (gein end) : ");
        char begin = input.next().charAt(0);
        char end = input.next().charAt(0);
        if(!a.exist(begin, end)){
            System.out.println("No character can be found in between " + begin + " and " + end);
        }else{
            System.out.println("The character can be found in between " + begin + " and " + end);
            System.out.println("The number of the elements in between " + begin + " and " + end + " in the data set is " + a.getOccurence(begin, end));
            System.out.print("The location of the elements in between " + begin + " and " + end + " are : " );
            for(int index : a.getIndex(begin,end)){
                System.out.print(index + " ");
            }
            System.out.println("");
        }
        
    }
}


class LinearSearch{
    private char [] array;

    public LinearSearch(int n){
        Random rnd = new Random();
        array = new char[n];
        
        for(int i = 0 ; i < n ; i ++){
            array[i] = (char)(rnd.nextInt(26) + 'A');
        }
    }
    
    public LinearSearch(char[] array) {
        System.out.println("Linear Search");
        this.array = array;
    }
    
    
    //1a
    public boolean exist(char n){
        for(int i = 0 ; i < array.length ; i ++){
            if(array[i] == n)
                return true;
        }
        return false;
    }
    
    //1b
    public int getOccurence(char n){
        int occurence = 0;
        
        for(int i = 0; i < array.length ; i ++){
            if(array[i] == n)
                occurence ++;
        }
        return occurence;
    }
    
    //1c
    public int [] getIndex(char n){
        int [] index = new int[getOccurence(n)];
        int currentIndex = 0;
        for(int i = 0 ; i< array.length; i ++){
            if(array[i] == n){
                index[currentIndex] = i;
                currentIndex ++;
            }
        }
        return index;
    }
            
    //1d
    public boolean exist( char start, char end){
        for(int i = 0 ; i < array.length ; i++){
            if(array[i] <= end && array[i] >= start){
                return true;
            }
        }
        return false;
    }
    
    //1e
    public int getOccurence(int start, int end){
        int occurence = 0;
        
        for(int i = 0; i < array.length ; i ++){
            if(array[i] <= end && array[i] >= start)
                occurence ++;
        }
        return occurence;
    }
    
    //1f
    public int [] getIndex(int start, int end){
        int [] index = new int[getOccurence(start,end)];
        int currentIndex = 0;
        for(int i = 0 ; i< array.length; i ++){
            if(array[i] <= end && array[i] >= start){
                index[currentIndex] = i;
                currentIndex ++;
            }
        }
        return index;
    }
}