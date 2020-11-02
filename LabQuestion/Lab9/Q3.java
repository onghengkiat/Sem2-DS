package LabQuestion;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        ArrayHashTable <String,String>a = new ArrayHashTable<>();
        a.put("100-101", "ICND 1");
        a.put("200-101", "ICND 2");
        a.put("200-120", "CCNA Routing and Switching");
        a.put("210-260", "CCNA Security");
        System.out.println("The number of course is " + a.getSize());
        a.showHashTable();
        
        System.out.println("\nAdding a new course");
        a.put("300-101", "ROUTE");
        System.out.println("The number of course is " + a.getSize());
        a.showHashTable();
        
        System.out.println("\nModifying 210-260");
        a.put("210-260", "CCNA RS Security");
        System.out.println("The number of course is " + a.getSize());
        a.showHashTable();
        
        System.out.println("\nRemove the course 200-101");
        a.remove("200-101");
        System.out.println("The number of course is " + a.getSize());
        a.showHashTable();
        
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter a course code to search : ");
        String code = input.next();
        if(a.containsKey(code)){
            System.out.println("Course " + code + " : " + a.get(code));
        }else{
            System.out.println(code + " is not found");
        }
    }
    
}
