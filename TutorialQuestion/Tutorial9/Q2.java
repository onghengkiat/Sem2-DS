package TutorialQuestion;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        Integer [] data = new Integer[10];
//        Integer [] data = {0,3,5,6,10,13,14,17,17,19};
        for(int i = 0 ; i < 10 ; i++){
            data[i] = rnd.nextInt(20);
        }
        System.out.print("The Integer data set are : ");
        Arrays.sort(data);
        for(int i = 0 ; i < 10 ; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println("\nBinary Search");
        System.out.print("Enter a number to search: ");
        Integer number = input.nextInt();
        if(!exist(data,number)){
            System.out.println(number + " is not found");
        }else{
            System.out.println(number + " is found");
            System.out.println("The number of " + number + " in the data set is " + occurence(data,number));
            System.out.print("The location of " + number + " is : ");
            for(int a : getIndex(data,number)){
                System.out.print(a + " ");
            }
            System.out.println("");
        }
        System.out.print("Enter two numbers to search (begin end) : ");
        Integer start = input.nextInt();
        Integer end = input.nextInt();
        if(!exist(data, start, end)){
            System.out.println("No integer can be found in between " + start + " and " + end);
        }else{
            System.out.println("The integer can be found in between " + start + " and " + end);
            System.out.println("The number of the elements in between " + start + " in the data set is " + occurence(data,start,end));
            System.out.print("The location of the elements in between " + start + " and " + end + " are : ");
            for(int a : getIndex(data,start,end)){
                System.out.print(a + " ");
            }
        }
    }  
    
    
    //2a
    public static <T extends Comparable<T>>boolean exist(T [] arr, T element){
        int left = 0 ; 
        int right = arr.length - 1;
        int middle = (left + right)/2;
        while(left <= right){
            if(arr[middle].compareTo(element) < 0){
                left = middle + 1; 
            }else if(arr[middle].compareTo(element) > 0){
                right = middle - 1;
            }else{
                System.out.println(arr[middle]);
                return true;
            }
            middle = (left + right)/2;
        }
        return false;
    }
    
    
    //2b
    public static <T extends Comparable<T>> int occurence(T [] arr, T element){
        int left = 0 ; 
        int right = arr.length - 1 ;
        int middle = (left + right)/2;
        int count = 0 ;
        while(left <= right){
            if(arr[middle].compareTo(element) < 0){
                left = middle + 1; 
            }else if(arr[middle].compareTo(element) > 0){
                right = middle - 1;
            }else{
                for(int i = middle ; i >= 0 ; i--){
                    if(arr[i].compareTo(element) == 0){
                        count ++;
                    }else
                        break;
                }
                for(int i = middle +1 ; i < arr.length ; i++){
                    if(arr[i].compareTo(element) == 0){
                        count ++;
                    }else
                        break;
                }
                return count;
            }
            middle = (left + right)/2;
        }
        return count;
    }
    
    //2c
    public static <T extends Comparable<T>> int[] getIndex(T [] arr, T element){
        int left = 0 ; 
        int right = arr.length - 1;
        int middle = (left + right)/2;
        int [] index = new int[occurence(arr,element)];
        int currentIndex = 0 ;
        while(left <= right){
            if(arr[middle].compareTo(element) < 0){
                left = middle + 1; 
            }else if(arr[middle].compareTo(element) > 0){
                right = middle - 1;
            }else{
                for(int i = middle ; i >= 0 ; i--){
                    if(arr[i].compareTo(element) == 0){
                        index[currentIndex] = i;
                        currentIndex ++;
                    }else
                        break;
                }
                for(int i = middle +1 ; i < arr.length ; i++){
                    if(arr[i].compareTo(element) == 0){
                        index[currentIndex] = i;
                        currentIndex ++;
                    }else
                        break;
                }
                return index;
            }
            middle = (left + right)/2;
        }
        return index;
    }
    
    //2d
    public static <T extends Comparable<T>>boolean exist(T [] arr, T start, T end){
        int left = 0 ; 
        int right = arr.length - 1;
        int middle = (left + right)/2;
        while(left <= right){
            if(arr[middle].compareTo(end) <=0 && arr[middle].compareTo(start) >=0){
                return true;
            }else if(arr[middle].compareTo(end) > 0 ){
                right = middle - 1;
            }else if(arr[middle].compareTo(start)<0){
                left = middle + 1; 
            }
            middle = (left + right)/2;
        }
        return false;
    }
    
    //2e
    public static <T extends Comparable<T>> int occurence(T [] arr, T start, T end){
        int left = 0 ; 
        int right = arr.length - 1;
        int middle = (left + right)/2;
        int count = 0 ;
        while(left <= right){
            if(arr[middle].compareTo(start) >=0 && arr[middle].compareTo(end) <= 0){
            
                for(int i = middle ; i >= 0 ; i--){
                    if(arr[i].compareTo(start) >= 0 && arr[i].compareTo(end) <= 0){
                        count ++;
                    }else
                        break;
                }
                for(int i = middle +1 ; i < arr.length ; i++){
                    if(arr[i].compareTo(start) >= 0 && arr[i].compareTo(end) <= 0){
                        count ++;
                    }else
                        break;
                }
                return count;
            }else if(arr[middle].compareTo(end) > 0 ){
                right = middle - 1;
            }else if(arr[middle].compareTo(start)<0){
                left = middle + 1; 
            }
            middle = (left + right)/2;
        }
        return count;
    }
    
    //2f
    public static <T extends Comparable<T>> int[] getIndex(T [] arr, T start, T end){
        int left = 0 ; 
        int right = arr.length - 1;
        int middle = (left + right)/2;
        int [] index = new int[occurence(arr,start,end)];
        int currentIndex = 0 ;
        while(left <= right){
            if(arr[middle].compareTo(start) >=0 && arr[middle].compareTo(end) <= 0){
                for(int i = middle ; i >= 0 ; i--){
                    if(arr[i].compareTo(start) >= 0 && arr[i].compareTo(end) <= 0){
                        index[currentIndex] = i;
                        currentIndex ++;
                    }else
                        break;
                }
                for(int i = middle +1 ; i < arr.length ; i++){
                    if(arr[i].compareTo(start) >= 0 && arr[i].compareTo(end) <= 0){
                        index[currentIndex] = i;
                        currentIndex ++;
                    }else
                        break;
                }
                return index;
            }else if(arr[middle].compareTo(end) > 0 ){
                right = middle - 1;
            }else if(arr[middle].compareTo(start)<0){
                left = middle + 1; 
            }
            middle = (left + right)/2;
        }
        return index;
    }
}

