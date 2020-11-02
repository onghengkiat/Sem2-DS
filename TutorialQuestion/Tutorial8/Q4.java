package TutorialQuestion;

import java.util.Random;

public class Q4 {
    public static void main(String[] args) {
        Random rnd = new Random();
        LinkedList <Integer> list = new LinkedList<>();
        for(int i = 0; i < 10 ; i ++){
            list.addNode(rnd.nextInt(101));
        }
        System.out.print("The random integers are : ");
        list.showList();
        System.out.println("");
        list.bubbleSort(2);
        list.showList();
    }
    
}
