package PastYear;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        //a
        /* Use stack to store all the left brackets.When there is a right bracket,
        pop the bracket out from the stacket, if it is not the same type of bracket
        then means it is false. After iterate through all the characters in the string,
        then check is the stack empty or not, if not, then it is false, else it is true.*/
        try{
            Scanner input = new Scanner(new FileInputStream("BracMatch.txt"));
            while(input.hasNextLine()){
                String str = input.nextLine();
                if(!checkBracket(str)){
                    System.out.println("Not all brackets are matched.");
                }
            }
        
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
    
    //b
    public static boolean checkBracket(String str){
        Stack<Character> bracket = new Stack<>();
        boolean gotBracket = false;
        for(int i = 0 ;i < str.length() ; i++){
            if(str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '('){
                gotBracket = true;
                bracket.push(str.charAt(i));
            }
            if(str.charAt(i) == ']'){
                if(bracket.isEmpty())
                    return false;
                if(bracket.pop() != '[')
                    return false;
            }
            if(str.charAt(i) == '}'){
                if(bracket.isEmpty())
                    return false;
                if(bracket.pop() != '{')
                    return false;
            }
            if(str.charAt(i) == ')'){
                if(bracket.isEmpty())
                    return false;
                if(bracket.pop() != '(')
                    return false;
            }
        }
        if(!gotBracket){
            System.out.println("There is no bracket in the input");
            return true;
        }
        if(bracket.isEmpty()){
            System.out.println("YES - all matched!");
            return true;
        }else{
            return false;
        }
    }
}
