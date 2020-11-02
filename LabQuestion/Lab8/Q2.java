package LabQuestion;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(new FileInputStream ("lab8Q2.txt"));
            ArrayList<Product> products = new ArrayList<>();
            System.out.println("Reading data from product text file");
            while(input.hasNextLine()){
                String [] arr = input.nextLine().split(",");
                Product product =new Product(arr[0],arr[1],Double.parseDouble(arr[2].trim()),Integer.parseInt(arr[3].trim()));
                System.out.println(product);
                products.add(product);
            }
            Product [] productsArr = new Product[products.size()];
            products.toArray(productsArr);
            quickSort(productsArr);
            System.out.println("After Quick Sort (Price, PID) : ");
            for(int i = 0;  i< productsArr.length ; i++){
                System.out.println(productsArr[i]);
            }
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
    
    public static void quickSort(Product [] products){
        quickSort(products,0,products.length-1);
    }
    
    public static void quickSort(Product[]products,int first, int last){
        if(first < last){
            int splitindex = split(products,first, last);
            quickSort(products,first, splitindex - 1);
            quickSort(products,splitindex +1 , last);
        }
    }
    
    public static int split(Product [] products,int first, int last){
        boolean correctSide;
        Product splitvalue = products[first];
        int index = first;
        first ++;
        do{
            correctSide = true;
            while(correctSide){
                if(splitvalue.compareTo(products[first])<0 )
                    correctSide = false;
                else{
                    first ++;
                    if(first <= last)
                        correctSide = true;
                    else
                        correctSide = false;
                }
            }
            if(first <= last)
                correctSide = true;
            else
                correctSide = false;
            
            while(correctSide){
                if(splitvalue.compareTo(products[last]) >= 0)
                    correctSide = false;
                else{
                    last --;
                    if(first <= last)
                        correctSide = true;
                    else
                        correctSide = false;
                }
            }
            if(first < last){
                swap(products,first, last);
                first ++;
                last --;
            }
        }while(first <= last);
        
        swap(products,index, last);
        return last;
    }
    
    public static void swap(Product [] products ,int index1, int index2){
        Product temp = products[index1];
        products[index1] = products[index2];
        products[index2] = temp;
    }
}

class Product implements Comparable <Product>{
    private String PID, SID;
    private double price;
    private int quantity;

    public Product(String PID, String SID, double price, int quantity) {
        this.PID = PID;
        this.SID = SID;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return PID + " : " + SID + " : " + price + " : " + quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product o) {
        if(this.price > o.price)
            return 1;
        else if(this.price < o.price)
            return -1;
        else
            return this.PID.compareTo(o.PID);
    }
}
