package TutorialQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Tutorial2 {
    public static void main(String[] args) {
        //Q1
        genericMethod("Hello","World");
        genericMethod(12.4,64.3);
        genericMethod(20,35);
        genericMethod("Welcome","Welcome");
        
        //Q3
        maximum(42,15,58);
        maximum(12.45,41.28,19.82);
    }
    
    //Q1
    public static <T> void genericMethod(T a, T b){
        System.out.println("The parameters value are : " + a + " and " + b);
        if(a instanceof Integer){
            System.out.println("The sum of the integer is " + ((int)a + (int)b));
        }else if(a instanceof Double){
            System.out.println("The sum of the double is " + ((double)a + (double)b));
        }else if(a instanceof String){
            if(a.equals(b))
                System.out.println("The string is equal");
            else
                System.out.println("The string is not equal");
        }
    }
    
    //Q3
    public static <T extends Comparable<T>> void maximum(T a, T b, T c){
        T max = a;
        if(a.compareTo(b) > 0 && b.compareTo(c) > 0)
            max = a;
        else if(b.compareTo(c) > 0)
            max = b;
        else
            max = c;
        System.out.println("The maximum value of " + a + " " + b + " " + c + " is " +max);
    } 
}

//Q2
class SpecialEncoding<T>{
    private T [] something ;

    public SpecialEncoding(T[] something) {
        this.something = something;
    }
    
    public String toString(){
        String code = "The Code is " ;
        String command = "\nThe Command is ";
        for(int i = 0 ; i < something.length ; i++){
            code += something[i].toString() + " ";
            if(something[i].toString().matches("[0C]"))
                command += "Copy ";
            else if(something[i].toString().matches("[1D]"))
                command += "Delete ";
            else if(something[i].toString().matches("[2I]"))
                command += "Insert ";
            else if(something[i].toString().matches("[3P]"))
                command += "Print ";
            else if(something[i].toString().matches("[4R]"))
                command += "Rename ";
            else if(something[i].toString().matches("[5V]"))
                command += "Paste ";
            }
        return code + command;
    }
    
}

class testSpecialEncoding{
    public static void main(String[] args) {
        Integer[]num = {3,2,5,0,1};
        Character [] letter = {'P','I','V','C','D'};
        SpecialEncoding<Integer> a = new SpecialEncoding<>(num);
        SpecialEncoding<Character> b = new SpecialEncoding<>(letter);
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}

//Q4
interface Dice{
    public void roll(int times);
    public String toString();
    
}

class ArrayDice implements Dice{
    private ArrayList <Integer> value ;
    private int sum;   
    public ArrayDice() {
        value = new ArrayList<>();
        sum = 0;
    }

    @Override
    public void roll(int times) {
        System.out.println("Array Implementation: Roll " + times + " time(s)");
        Random rnd = new Random();
        for(int i = 0 ; i < times ; i++)
            value.add(rnd.nextInt(6)+1);
    }
    
    public String toString(){
        String line = "";
        for(int i = 0 ; i < value.size() ; i++){
            line += (value.get(i) + " ");
            sum+= value.get(i);
        }
        line += "\nTotal is " + sum;
        return line;
    }
}

class LinkedListDice implements Dice{
    private LinkedList <Integer> value ;
    private int sum;   
    public LinkedListDice() {
        value = new LinkedList<>();
        sum = 0;
    }

    @Override
    public void roll(int times) {
        System.out.println("Array Implementation: Roll " + times + " time(s)");
        Random rnd = new Random();
        for(int i = 0 ; i < times ; i++)
            value.add(rnd.nextInt(6)+1);
    }
    
    public String toString(){
        String line = "";
        for(Integer i : value){
            line += i+ " ";
            sum += i;
        }
        line += "\nTotal is " + sum;
        return line;
    }
}

class testADTDice{
    public static void main(String[] args) {
        ArrayDice dice1 = new ArrayDice();
        dice1.roll(5);
        System.out.println(dice1.toString());
        
        ArrayDice dice2 = new ArrayDice();
        dice2.roll(4);
        System.out.println(dice2.toString());
        
        LinkedListDice dice3 = new LinkedListDice();
        dice3.roll(3);
        System.out.println(dice3.toString());
        LinkedListDice dice4 = new LinkedListDice();
        dice4.roll(4);
        System.out.println(dice4.toString());
    }
}
