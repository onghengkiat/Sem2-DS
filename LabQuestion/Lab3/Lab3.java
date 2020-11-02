package LabQuestion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Random;

public class Lab3 {
    public static void main(String[] args) {
        //Q1
        System.out.println("Mesh Topology");
        System.out.println("There are 4 switches in the campus.");
        System.out.println("The total number of connections required is " + numOfConnections(4));
        System.out.println("There are 7 switches in the campus."); 
        System.out.println("The total number of connections required is " + numOfConnections(7));
        
        //Q2
        readAndWrite("read.txt", "write.txt");
        
        //Q3
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        System.out.print("Enter number of elements: ");
        int num = input.nextInt();
        int [] elements = new int[num];
        System.out.print("The elements of the array: ");
        for(int i = 0 ; i < num ; i++){
            elements[i] = rnd.nextInt(10);
            System.out.print(elements[i]);
        }
        System.out.println("");
        permutations(elements);

        //Q4
        Date a  = new Date();
        int day = a.getDate();
        int month = a.getMonth()+1;
        int year = a.getYear()+1900;
        int whatDay = a.getDay();
        System.out.println("Today Date (dd//mm/yyyy): " + day + "/" + month + "/" + year);
        String [] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        System.out.println("Today is on " + days[whatDay]);
        searchDate(day,month,year,whatDay);
        //Q5
        int [] array = new int[5];
        createArray(array ,0);
    }
    
    //Q1
    public static int numOfConnections(int switches){
        return numOfConnections(switches - 1, 0);
    }
    
    public static int numOfConnections(int switches,int connections){
        if(switches == 0)
            return connections;
        else
            return numOfConnections(switches - 1,connections += switches);
    }
    
    //Q2
    public static void readAndWrite(String sourceFile , String targetFile){
        try{
            Scanner input = new Scanner(new FileInputStream(sourceFile));
            PrintWriter output =new PrintWriter(new FileOutputStream(targetFile));
            readAndWrite(input,output);
            output.close();
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
    
    public static void readAndWrite(Scanner input, PrintWriter output){
        if(input.hasNextLine()){
            try{
                String str = input.nextLine();
                readAndWrite(input,output);
                System.out.println(str);
                output.println(str);
            }catch(Exception e){
                System.out.println("ERROR");
            }
        }else{
            input.close();
        }
    }
    
    //Q3
    public static void permutations(int [] elements){
        if(elements.length >= 1 ){
            LinkedHashSet<String> list = new LinkedHashSet<>();
            permutations(elements,0,list);
            ArrayList <String> sortedList = new ArrayList<>(list);
            for(String temp : sortedList){
                System.out.print(temp);
                System.out.println("");
            }
        }
    }
    
    public static void permutations(int [] elements, int index, LinkedHashSet<String> list){
        
        if(index == elements.length ){
            String str = "";
            boolean zero = true;
            for(int i = 0; i < elements.length ; i++){
                if(elements[i] != 0)
                    zero = false;
                if(zero == false)
                    str += elements[i];
            }
            list.add(str);
        }else{
            for(int i = index ; i < elements.length;i++){
                int temp = elements[index];
                elements[index] = elements[i]; 
                elements[i] = temp;
                
                permutations(elements, index+1,list);
                
                //change it back to the original place
                temp = elements[index];
                elements[index] = elements[i]; 
                elements[i] = temp;
            }
        }
    }
    
    //Q4
    public static void searchDate(int day,int month,int year, int whatDay){
        //assume the past date is 20/8/2015
        while(day != 20 || month != 8 || year != 2015){
            day --;
            whatDay -- ;
            if(whatDay < 0)
                whatDay = 6;
            if(day == 0){
                month --;
                switch(month){
                    case 0:
                            month = 12;
                            year--;
                    case 1:
                    case 3:
                    case 5:    
                    case 7:
                    case 8:
                    case 10: day = 31;
                             break;
                    case 4:
                    case 6:
                    case 9:    
                    case 11: day = 30;
                             break;
                    case 2:  if( (year % 4 == 0 && year % 100 == 0 ) || year % 400 == 0)
                                day = 29;
                             else
                                day = 28;
                             break;
                }
            }
        }
        whatDay--;
        
        System.out.println("Search Date (dd//mm/yyyy): " + day + "/" + month + "/" + year);
        
        String [] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        System.out.println("Search is on " + days[whatDay]);
    }
    
    
    //Q5
    public static void createArray(int [] array,int i){
        Scanner input = new Scanner (System.in);
        try{
            System.out.print("Enter an Integer: ");
            array[i] = input.nextInt();
            createArray(array,++i);
        }catch(InputMismatchException f){
            System.out.println("Invalid input type");
            createArray(array,i);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("The array of integers is");
            for(int j : array)
                System.out.print(j + " ");
        }
    }
    
}

