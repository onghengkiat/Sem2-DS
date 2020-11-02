package LabQuestion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

//Q1
abstract class Generator<T>{
    
    public abstract void generateNumbers(int n);
    
    public abstract void display();
}
class ArrayGenerator extends Generator<int[]>{
    private int[] list ;
    
    public ArrayGenerator(int n){
        list = new int[n] ;
        generateNumbers(n);
    }
    
    public void generateNumbers(int n){
        Random rnd = new Random();
        for(int i = 0 ; i < n ; i ++){
            int randomNum = rnd.nextInt(101);
            list[i] = randomNum;
            for(int j = 0 ; j < i ; j++){
                if(list[j] == randomNum){
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(list);
    }
    
    public void display(){
        for(int i : list)
            System.out.print(i + " ");
    }
}

class LinkedListGenerator extends Generator<LinkedList>{
    private LinkedList<Integer> list ;
    
    public LinkedListGenerator(int n){
        
        list = new LinkedList<>();
        generateNumbers(n);
    }
    
    public void generateNumbers(int n){
        Random rnd = new Random();
        for(int i = 0 ; i < n ; i ++){
            int randomNum = rnd.nextInt(101);
            if(list.size()>0){
                while(list.contains(randomNum)){
                    randomNum = rnd.nextInt(101);
                }
            }
            list.add(randomNum);
        }
        Collections.sort(list);
    }
    
    public void display(){
        for(Object i : list)
            System.out.print(i + " ");
    }
}

class testGenerate{
    public static void main(String[] args) {
        System.out.println("Generate 20 non-duplicate integer within 0-100");
        System.out.println("Linked List Implementation");
        LinkedListGenerator list1 = new LinkedListGenerator(20);
        list1.display();
        
        System.out.println("");
        
        System.out.println("Array Implementation");
        ArrayGenerator list2 = new ArrayGenerator(20);
        list2.display();
    }
}

//Q2
interface SimpleLog{
    public void insert(String item);
    public boolean checkFull();
    public int getSize();
    public boolean checkExist(String item);
    public void clear();
    public void display();
}

class TextFileLog implements SimpleLog{
    private String fileName;
    private int maximumRecord;
    private int size;
    
    public TextFileLog(String fileName , int maximumRecord){
        this.fileName = fileName;
        this.maximumRecord = maximumRecord;
        System.out.println("Create a text file log with maximum record equal to " + maximumRecord);
        size = getSize();
    }

    @Override
    public void insert(String item) {
        try{
            PrintWriter output = new PrintWriter(new FileOutputStream (fileName, true));
            System.out.println("Adding another record");
            if(!checkFull()){
                output.println(item);
                System.out.println(item + " is inserted");
                size++;
            }
            else{
                System.out.println("The log is full");
            }
            output.close();
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }

    @Override
    public boolean checkFull() {
        return size >= maximumRecord;
    }

    @Override
    public int getSize() {
        size = 0;
        try{
            Scanner input = new Scanner(new FileInputStream(fileName));
            while(input.hasNextLine()){
                input.nextLine();
                size++;
            }
        }catch(Exception e){
            System.out.println("ERROR");
        }
        System.out.println("Text File Log Size " + size);
        return size;
    }

    @Override
    public void display() {
        try{
            Scanner input = new Scanner(new FileInputStream(fileName));
            while(input.hasNextLine()){
                System.out.println(input.nextLine());
            }
            input.close();
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }

    @Override
    public boolean checkExist(String item) {
        try{
            Scanner input = new Scanner(new FileInputStream(fileName));
            int size = 0;
            System.out.println("Searching for " + item + " in the file");
            while(input.hasNextLine()){
                if(input.nextLine().equals(item)){
                    System.out.println("Text File Log contains " + item);
                    return true;
                }
            }
            input.close();
        }catch(Exception e){
            System.out.println("ERROR");
        }
        System.out.println("Text File Log does not contain " + item);
        return false;
    }

    @Override
    public void clear() {
        try{
            PrintWriter output = new PrintWriter(new FileOutputStream (fileName));
            System.out.println("Clear the text file log");
            output.close();
        }catch(Exception e){
            System.out.println("ERROR");
        }
        
    }
    
    
}

class testTextFileLog{
    public static void main(String[] args) {
        TextFileLog log = new TextFileLog("lab2.txt" , 5);
        log.insert("James");
        log.insert("Ahmad");
        log.insert("Siti");
        log.insert("Ramesh");
        log.insert("John");
        log.display();
        
        System.out.println("");
        log.insert("anything");
        log.checkExist("Siti");
        log.clear();
        log.getSize();
    }
}

//Q3
interface UNO{
    public void draw(int times);
    public String toString();
}

class ArrayUNO implements UNO{
    private String [] cards ;
    
    public ArrayUNO(int times){
        this.cards = new String[times];
        draw(times);
    }
    @Override
    public void draw(int times) {
        Random rnd = new Random();
        for(int i = 0 ; i < cards.length ; i++){
            String card = "";
            int randomNum = rnd.nextInt(5) ;
            switch(randomNum){
                case 0 : card = "Red";
                         break;
                case 1 : card = "Yellow";
                         break;
                case 2 : card = "Blue";  
                         break;
                case 3 : card = "Green";
                         break;
                case 4 : card = "Draw Four";
                         break;
            }
            if(!card.equals("Draw Four")){
                randomNum = rnd.nextInt(13);
                switch(randomNum){
                case 0 : card += "Zero";
                         break;    
                case 1 : card += "One";
                         break;
                case 2 : card += "Two";
                         break;
                case 3 : card += "Three";  
                         break;
                case 4 : card += "Four";
                         break;
                case 5 : card += "Five";
                         break;
                case 6 : card += "Six";
                         break;
                case 7 : card += "Seven";
                         break;
                case 8 : card += "Eight";  
                         break;
                case 9 : card += "Nine";
                         break;
                case 10: card += "Skip";
                         break;    
                case 11: card += "Reverse";
                         break;    
                case 12: card += "Draw Two";
                         break;    
                }
                cards[i] = card;
            }
        }
    }
    
    @Override
    public String toString(){
        String str = "";
        for(String i : cards){
            str += (i + " :: ");
        }
        return str;
    }
}

class LinkedListUNO implements UNO{
    private LinkedList<String> cards ;
    
    public LinkedListUNO(int times){
        this.cards = new LinkedList<>();
        draw(times);
    }
    
    @Override
    public void draw(int times) {
        Random rnd = new Random();
        for(int i = 0 ; i < times ; i++){
            String card = "";
            int randomNum = rnd.nextInt(5) ;
            switch(randomNum){
                case 0 : card = "Red ";
                         break;
                case 1 : card = "Yellow ";
                         break;
                case 2 : card = "Blue ";  
                         break;
                case 3 : card = "Green ";
                         break;
                case 4 : card = "Draw Four";
                         break;
            }
            if(!card.equals("Draw Four")){
                randomNum = rnd.nextInt(13);
                switch(randomNum){
                case 0 : card += "Zero";
                         break;    
                case 1 : card += "One";
                         break;
                case 2 : card += "Two";
                         break;
                case 3 : card += "Three";  
                         break;
                case 4 : card += "Four";
                         break;
                case 5 : card += "Five";
                         break;
                case 6 : card += "Six";
                         break;
                case 7 : card += "Seven";
                         break;
                case 8 : card += "Eight";  
                         break;
                case 9 : card += "Nine";
                         break;
                case 10: card += "Skip";
                         break;    
                case 11: card += "Reverse";
                         break;    
                case 12: card += "Draw Two";
                         break;    
                }
                cards.add(card);
            }
        }
    }
    
    @Override
    public String toString(){
        String str = "";
        for(String i : cards){
            str += (i + " :: ");
        }
        return str;
    }
}

class testUNO{
    public static void main(String[] args) {
        System.out.println("Array Implementation");
        ArrayUNO uno1 = new ArrayUNO(7);
        System.out.println("Player 1 draws 7 times");
        System.out.println(uno1.toString());
        
        System.out.println("Array Implementation");
        ArrayUNO uno2 = new ArrayUNO(7);
        System.out.println("Player 2 draws 7 times");
        System.out.println(uno2.toString());
        
        System.out.println("");
        
        System.out.println("Linked List Implementation");
        LinkedListUNO uno3 = new LinkedListUNO(7);
        System.out.println("Player 1 draws 7 times");
        System.out.println(uno3.toString());
        
        System.out.println("Linked List Implementation");
        LinkedListUNO uno4 = new LinkedListUNO(7);
        System.out.println("Player 2 draws 7 times");
        System.out.println(uno4.toString());
    }
}