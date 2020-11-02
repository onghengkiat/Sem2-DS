package TutorialQuestion;

import java.util.Random;

public class Q3 {
    public static void main(String[] args) {
        Random rnd = new Random();
        LinkedList <Integer> list = new LinkedList<>();
        for(int i = 0; i < 10 ; i ++){
            list.addNode(rnd.nextInt(101));
        }
        System.out.print("The random integers are : ");
        list.showList();
        System.out.println("");
        list.selectionSort(1);
        list.showList();
    }
}
