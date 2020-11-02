package LabQuestion;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Queue <Transaction> transactions = new Queue<>();
        
        System.out.print("Enter transcactions : ");
        
        Scanner input = new Scanner(System.in);
        int currentIndex = 0;
        for(int i = 0 ; i< 5 ; i++){
            transactions.enqueue(new Transaction(input.next().charAt(0),input.nextInt()));
            input.next();
        }
        transactions.enqueue(new Transaction(input.next().charAt(0),input.nextInt()));
        
        transactions.showQueue();
        System.out.print("\nInitial Balance : ");
        int balance = input.nextInt();
        while(!transactions.isEmpty()){
            Transaction a = transactions.dequeue();
            if(a.getAction() == 'D'){
                balance += a.getAmount();
                System.out.println("Deposit " + a.getAmount() + "\t\tNew Balance " + balance);
            }else{
                if(balance < a.getAmount()){
                    System.out.println("Withdraw " + a.getAmount() + " Rejected\tNew Balance " + balance);
                }else{
                    balance -= a.getAmount();
                    System.out.println("Withdraw " + a.getAmount() + "\t\tNew Balance " + balance);
                }
            }
        }
    }
    
}

class Transaction{
    private char action;
    private int amount;

    public Transaction(char action, int amount) {
        this.action = action;
        this.amount = amount;
    }

    public char getAction() {
        return action;
    }

    public void setAction(char action) {
        this.action = action;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return this.getAction() + " " + this.getAmount() ;
    }
    
}