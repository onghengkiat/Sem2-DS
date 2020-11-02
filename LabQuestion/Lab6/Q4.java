package LabQuestion;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(new FileInputStream("lab6Q4.txt"));
            
            Queue <transaction> transactions = new Queue<>();
            //the format of the data stored in the txt file is
            //day buy/sell Amount Price
            while(input.hasNextLine()){
                transactions.enqueue(new transaction(input.nextInt(),
                        input.next(), input.nextInt(),input.nextInt()));
            }
            System.out.println("List of Transactions");
            transactions.showQueue();
            
            Queue <transaction> buy = new Queue<>();
            int profit = 0 ;
            int amount = 0 ;
            int stock = 0;
            int stockPrice = 0;
            while(!transactions.isEmpty()){
                transaction t = transactions.dequeue();
                amount = t.getAmount();
                if(t.getAction().equals("B")){
                    buy.enqueue(t);
                }else{
                    while(amount != 0){
                        if(stock != 0){
                            if(amount <= stock){
                                profit += (t.getPrice() - stockPrice)*amount;
                                stock -= amount ;
                                break;
                            }else{
                               profit += (t.getPrice() - stockPrice)*stock; 
                               stock = 0;
                               stockPrice = 0;
                               break;
                            }
                        }
                        transaction buyT = buy.dequeue();
                        
                        if(amount <= buyT.getAmount()){
                            profit += (t.getPrice() -buyT.getPrice() )*amount;
                            stock = buyT.getAmount() - amount;
                            stockPrice = buyT.getPrice();
                            amount = 0 ;
                            break;
                        }
                        
                        amount -= buyT.getAmount();
                        profit += (t.getPrice()-buyT.getPrice())*buyT.getAmount();
                    }
                }
            }
            System.out.println("\nTotal Gain " + profit);
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}


class transaction{
        private int day,amount,price;
        private String action;


        public transaction(int day, String action, int amount, int price) {
            this.day = day;
            this.amount = amount;
            this.price = price;
            this.action = action;
        }

        public int getDay() {
            return day;
        }

        public int getAmount() {
            return amount;
        }

        public int getPrice() {
            return price;
        }

        public String getAction() {
            return action;
        }
        
        @Override
        public String toString() {
            String str = "Day " + day + " : ";
            if(action.equals("B"))
                str += "Buy ";
            else 
                str += "Sell ";
            str += amount + " shares at RM " + price;
            return str;
        }
        
    }