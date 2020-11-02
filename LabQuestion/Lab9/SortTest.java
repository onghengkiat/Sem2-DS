package LabQuestion;

import java.util.Random;

public class SortTest<T extends Comparable<T>> {
    public static final int ASCENDING = 1;
    public static final int DESCENDING = 2;
    private T [][] value ;
    private int orderType ;
    
    public SortTest(T [][] value,int orderType){
        this.value = value;
        this.orderType = orderType;
    }
    
    
    //1a
    public boolean exist(T element){
        for(int i = 0 ; i < value.length ; i ++ ){
            for(int j = 0 ; j < value[i].length ; j ++){
                if(value[i][j].equals(element)){
                    return true;
                }
            }
        }
        return false;
    }
    
    //1b
    public int occurence(T element){
        int count = 0 ;
        for(int i = 0 ; i < value.length ; i ++ ){
            for(int j = 0 ; j < value[i].length ; j ++){
                if(value[i][j].equals(element)){
                    count ++;
                }
            }
        }
        return count;
    }
    
    //1c
    public int[][] index (T element){
        int [][] index = new int [occurence(element)][2];
        int currentIndex = 0 ;
        for(int i = 0 ; i < value.length ; i ++ ){
            for(int j = 0 ; j < value[i].length ; j ++){
                if(value[i][j].equals(element)){
                    index[currentIndex][0] = i;
                    index[currentIndex][1] = j;
                    currentIndex ++ ; 
                }
            }
        }
        return index;
    }
    
    public boolean isSorted(){
        for(int i = 0; i < value.length ; i++){
            for(int j = 0;  j < value[i].length -1 ; j ++){
                if(value[i][j].compareTo(value[i][j+1]) > 0 && orderType == ASCENDING)
                    return false;
                if(value[i][j].compareTo(value[i][j+1]) < 0 && orderType == DESCENDING)
                    return false;
            }
        }
        return true;
    }
    
    public void swap(int indexY1,int indexX1, int indexY2, int indexX2){
        T temp = value[indexY1][indexX1];
        value[indexY1][indexX1] = value[indexY2][indexX2];
        value[indexY2][indexX2] = temp;
    }
    
    public void showValue(){
        for(int i =0 ; i < value.length ; i ++){
            for (T item : value[i]) {
                System.out.print(item + " ");
            }
            System.out.println("");
        }
    }
}