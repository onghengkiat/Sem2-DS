package LabQuestion;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Infix Expression : ");
        String str = input.next();
        char [] infix = new char[str.length()];
        for(int i = 0 ; i < str.length() ; i++){
            infix[i] = str.charAt(i);
        }
        BSTExpression expression = new BSTExpression(infix);
        System.out.println("The number of elements in the tree : " + expression.getSize());
        System.out.println("The tree elements - INORDER : ");
        expression.setOrder(BSTExpression.INORDER);
        expression.showTree();
        System.out.println("\nThe tree elements - PREORDER : ");
        expression.setOrder(BSTExpression.PREORDER);
        expression.showTree();
        System.out.println("\nThe tree elements - POSTORDER : ");
        expression.setOrder(BSTExpression.POSTORDER);
        expression.showTree();
        
    }
}
