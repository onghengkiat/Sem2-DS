package LabQuestion;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter N characters : ");
        int n = input.nextInt();
        char a = 'a';
        SortTest test = new SortTest(1,a,n);
        test.heapSort();
    }
   
}
