package LabQuestion;

import java.util.Random;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        BST bst = new BST();
        System.out.print("The random numbers are ");
        for(int i = 0 ; i < 10 ; i++){
            int num = rnd.nextInt(21);
            System.out.print(num +  " ");
            bst.addNode(num);
        }
        
        System.out.println("The number of elements in the tree : " + bst.getSize());
        System.out.println("The tree elements - PREORDER : " );
        bst.setOrder(BST.PREORDER);
        bst.showTree();
        System.out.println("\nThe tree elements - INORDER : " );
        bst.setOrder(BST.INORDER);
        bst.showTree();
        System.out.println("\nThe tree elements - POST    ORDER : " );
        bst.setOrder(BST.POSTORDER);
        bst.showTree();
        System.out.println("\nThe minimum number is : " + bst.getMinimum());
        System.out.println("The maximum number is : " + bst.getMaximum());
        System.out.println("The total is " + bst.getTotal());
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to search : ");
        int search = input.nextInt();
        System.out.println("The number of occurence of " + search + " is " + bst.getOccurrence(search));
        
    }
}
