package TutorialQuestion;

import java.util.Random;
import java.util.Scanner;

public class Tutorial5 {
    public static void main(String[] args) {
        //Q1a
        System.out.println("Stack implementation using Linked List");
        Stack <Character>question1 = new Stack<>();
        question1.push('A');
        question1.push('N');
        question1.push('D');
        System.out.println("Insert three nodes into the stack");
        question1.showStack();
        
        //Q1b
        question1.pop();
        System.out.println("\nPop one node from the stack");
        question1.showStack();
        
        //Q1c
        System.out.println("\nThe element on the top of the stack is " + question1.peek());
        question1.showStack();
        
        //Q1d
        System.out.println("\nThe number of elements in the stack is " + question1.getSize());
        
        
        System.out.println("");
        //Q2
        System.out.println("Stack implementation using Array");
        ArrayStack <Character> question2 = new ArrayStack<>();
        question2.push('A');
        question2.push('N');
        question2.push('D');
        System.out.println("Insert three nodes into the stack");
        question2.showStack();
        question2.pop();
        System.out.println("\nPop one node from the stack");
        question2.showStack();
        System.out.println("\nThe element on the top of the stack is " + question2.peek());
        question2.showStack();
        System.out.println("\nThe number of elements in the stack is " + question2.getSize());
        
        //Q3
        System.out.print("Enter a sentence : ");
        LinkedListStack <String>question3 = new LinkedListStack<>();
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        System.out.print("Original Sentence : ");
        System.out.println(line);
        
        for(int i = 0 ; i < line.length() ; i++)
            question3.push(line.charAt(i)+"");
        System.out.print("The sentence in reverse order : ");
        while(!question3.isEmpty())
            System.out.print(question3.pop() );
        
        String [] words = line.split(" ");
        for(String str : words)
            question3.push(str);
        System.out.print("\nThe word in reverse order : ");
        while(!question3.isEmpty())
            System.out.print(question3.pop() + " ");
        
        
        System.out.println("\n");
        //Q4
        solveFibonacci(1);
        solveFibonacci(5);
        solveFibonacci(8);
        solveFibonacci(14);
        
        
        System.out.println("");
        //Q5
        solveParentheses("(())");
        solveParentheses(")()(");
        solveParentheses("((())())()");
        solveParentheses("(())()))");
        solveParentheses("(()");
        
        
        System.out.println("");
        //Q6
        Random rnd = new Random();
        int [] randomNum = new int[10];
        for(int i = 0 ; i < 10 ; i++)
            randomNum [i] = rnd.nextInt(100)+1;
        System.out.print("The random numbers are : ");
        for(int i : randomNum){
            System.out.print(i + " ");
        }
        
        boolean [] insertedNum = new boolean[10];
        Stack<Integer>question6 = new Stack<>();
        boolean inserted = true;
        while(inserted){
            inserted = false;
            if(question6.isEmpty()){
                for(int i = 0; i< 10; i++){
                    if(randomNum[i]%2 == 1 && insertedNum[i]==false){
                        question6.push(randomNum[i]);
                        inserted = true;
                        insertedNum[i] = true;
                        break;
                    }
                }
            }else if(question6.peek() % 2 == 1){
                for(int i = 0; i< 10; i++){
                    if(randomNum[i]%2 ==0 && insertedNum[i]==false){
                        question6.push(randomNum[i]);
                        inserted = true;
                        insertedNum[i] = true;
                        break;
                    }
                }
            }else if(question6.peek()%2 == 0){
                for(int i = 0; i< 10; i++){
                    if(randomNum[i]%2 == 1 && insertedNum[i]==false){
                        question6.push(randomNum[i]);
                        inserted = true;
                        insertedNum[i] = true;
                        break;
                    }
                }
            }
        }
        System.out.print("\nThe numbers in the stack : ");
        question6.showStack();
        
        System.out.print("\n123The numbers remain in the array : ");
        for(int i = 0; i < 10 ; i++)
            if(insertedNum[i] == false)
                System.out.print(randomNum[i] + " ");
    }
    
    //Q4
    public static void solveFibonacci(int num){
        LinkedListStack <Integer> question4 = new LinkedListStack<>();
        if(num == 1)
            System.out.println("Fib(" + 1 +"): "+ 1);
        else if(num == 2){
            System.out.println("Fib(" + 2 +"): "+ 2);
        }else{
            question4.push(1);
            question4.push(1);
            for(int i = 2; i < num ; i++){
                int last = question4.pop();
                int last2 = question4.pop();
                int newLast = last+last2;
                question4.push(last);
                question4.push(newLast);
            }
            System.out.println("Fib(" + (num) + "): " + question4.pop());
        }
    }
    
    //Q5
    public static void solveParentheses(String parentheses){
        LinkedListStack <Character>question5 = new LinkedListStack<>();
        for(int i = 0 ; i < parentheses.length() ; i++)
            question5.push(parentheses.charAt(i));
        
        int countCloseLeft=0;
        int countCloseRight=0;
        if(parentheses.charAt(0) == ')')
            System.out.println(parentheses + " is not balanced");
        else if(parentheses.charAt(parentheses.length() -1) == '(')
            System.out.println(parentheses + " is not balanced");
        else{
            while(!question5.isEmpty()){
                if(question5.pop()=='(')
                    countCloseRight ++;
                else
                    countCloseLeft++;
            }
            if(countCloseRight == countCloseLeft)
                System.out.println(parentheses + " is balanced");
            else
                System.out.println(parentheses + " is not balanced");
        }
    }
}
