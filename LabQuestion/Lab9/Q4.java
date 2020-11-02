package LabQuestion;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(new FileInputStream("lab9Q4.txt"));
            System.out.println("The data set from the File");
            ArrayHashTableHashing<Integer,String> table = new ArrayHashTableHashing<>();
            while(input.hasNextLine()){
                table.put(input.nextInt(), input.nextLine());
            }
            table.showHashTable();
            System.out.println("The Hash Table size is " + table.getSize());
            System.out.print("Enter a PID to search : ");
            Scanner sc = new Scanner(System.in);
            Integer pid = sc.nextInt();
            if(table.containsKey(pid)){
                System.out.println("Product ID : " + pid + "　" + table.get(pid));
                System.out.println("Location : " + table.location(pid));
            }else{
                System.out.println("Product ID " + pid + " cannot be found");
            }
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
}