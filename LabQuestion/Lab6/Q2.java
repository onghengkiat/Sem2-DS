package LabQuestion;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        try {
            Scanner inputStream = new Scanner(new FileInputStream("lab6Q2.txt"));
            Queue<String> code = new Queue<>();
            while (inputStream.hasNext()) {
                String singleCode = inputStream.next();
                inputStream.next();
                if (!code.isExist(singleCode)) {
                    code.enqueue(singleCode);
                }
            }
            System.out.print("Product Code in Queue: ");
            code.showQueue();
            
            System.out.println("\nList of product by categories");
            while(!code.isEmpty()){
                String product = code.dequeue();
                System.out.println("Product : " + product);
                Scanner input = new Scanner(new FileInputStream ("lab6Q2.txt"));
                Queue<String> products = new Queue<>();
                while(input.hasNext()){
                    if(input.next().equals(product)){
                        products.enqueue(input.next());
                    }else{
                        input.next();
                    }
                }
                products.showQueue();
                System.out.println("");
                input.close();
            }
            inputStream.close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

}
