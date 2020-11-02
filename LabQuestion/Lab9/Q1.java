package LabQuestion;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter N : ");
        int n = input.nextInt();
        Integer [][] arr = new Integer[n][n];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                arr[i][j] = rnd.nextInt(10)+10;
            }
        }
        System.out.println("The matrix are : ");
        SortTest a = new SortTest(arr,1);
        a.showValue();
        System.out.println("\nLinear Search");
        System.out.print("Enter a number to search: ");
        int number = input.nextInt();
        if(a.exist(number)){
            System.out.println(number + " is found");
            System.out.println("The number of " + number + " in the matrix is " + a.occurence(number));
            System.out.print("The location of " + number + " are : ");
            for(int[] location : a.index(number)){
                System.out.print(Arrays.toString(location));
            }
        }else{
            System.out.println(number + " is not found");
        }
    }
}
