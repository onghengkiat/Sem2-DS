package LabQuestion;

import java.util.Random;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        System.out.print("Enter N Special Random Number within 0-100: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int [n];
        Random rnd = new Random();
        
        System.out.print("The Special Number are : ");
        for(int i = 0; i < n ;i ++){
            arr[i] = rnd.nextInt(101);
            System.out.print(arr[i] + " ");
        }
        
        mergeSort(arr);
        System.out.print("\nAfter Merge Sort : ");
        for(int i = 0; i < n ;i ++){
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void mergeSort(int [] arr){
        int middle = arr.length/ 2 ;
        mergeSort(arr, 0 , middle - 1);
        mergeSort(arr , middle , arr.length-1);
        merge(arr, 0, middle - 1, middle ,arr.length -1);
        
    }
    
    public static void mergeSort(int [] arr , int start , int end ){
        //until the array splits into size of 1 
        if(end - start > 0){
            int middle = (end+start)/2;
            
            //first half of the array
            mergeSort(arr, start , middle);
            //second half of the array
            mergeSort(arr, middle+1, end);
            merge(arr, start , middle, middle +1, end);
        }
    }
    
    public static void merge(int [] arr , int firstFirst, int firstLast, int secondFirst, int secondLast){
        int [] temp = new int [arr.length] ;
        int currentIndex = firstFirst;
        int currentFirst = firstFirst;
        int currentSecond = secondFirst;
        while(currentFirst <= firstLast && currentSecond <= secondLast){
            if(arr[currentFirst] % 2 == 1 && arr[currentSecond] % 2 == 1 || 
                    arr[currentFirst] % 2 == 0 && arr[currentSecond] % 2 == 0){
                if(arr[currentFirst] <= arr[currentSecond]){
                    temp[currentIndex] = arr[currentFirst];
                    currentFirst ++;
                }else{
                    temp[currentIndex] = arr[currentSecond];
                    currentSecond ++;
                }
            }else if(arr[currentFirst] % 2 == 1){
                temp[currentIndex] = arr[currentFirst];
                currentFirst ++;
            }else{
                temp[currentIndex] = arr[currentSecond];
                currentSecond ++;
            }
            currentIndex ++;
        }
        
        while(currentFirst <= firstLast){
            temp[currentIndex] = arr[currentFirst];
            currentIndex ++;
            currentFirst ++;
        }
        
        while(currentSecond <= secondLast){
            temp[currentIndex] = arr[currentSecond];
            currentIndex ++;
            currentSecond ++;
        }
        
        for(int i = firstFirst ; i <= secondLast ; i++){
            arr[i] = temp[i];
        }
    }
}

