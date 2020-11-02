package PastYear;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        SalesList [] original = {new SalesList("Asia","Ahmad",450) , new SalesList("Europe","Hemish",518),
        new SalesList("Europe","Banny",650), new SalesList("Greenland","Ain",200), new SalesList("Asia","Ali",390),
        new SalesList("Greenland","Ben",670),new SalesList("Asia","Lee",790)};
        SortSalesList [] selection = {new SortSalesList("Asia","Ahmad",450,0) , new SortSalesList("Europe","Hemish",518,0),
        new SortSalesList("Europe","Banny",650,0), new SortSalesList("Greenland","Ain",200,0), new SortSalesList("Asia","Ali",390,0),
        new SortSalesList("Greenland","Ben",670,0),new SortSalesList("Asia","Lee",790,0)};
        SortSalesList [] insertion = {new SortSalesList("Asia","Ahmad",450,1) , new SortSalesList("Europe","Hemish",518,1),
        new SortSalesList("Europe","Banny",650,1), new SortSalesList("Greenland","Ain",200,1), new SortSalesList("Asia","Ali",390,1),
        new SortSalesList("Greenland","Ben",670,1),new SortSalesList("Asia","Lee",790,1)};
        SortSalesList [] bubble = {new SortSalesList("Asia","Ahmad",450,2) , new SortSalesList("Europe","Hemish",518,2),
        new SortSalesList("Europe","Banny",650,2), new SortSalesList("Greenland","Ain",200,2), new SortSalesList("Asia","Ali",390,2),
        new SortSalesList("Greenland","Ben",670,2),new SortSalesList("Asia","Lee",790,2)};
        System.out.println("Original Data: ");
        for(int i = 0 ; i< 7 ; i++){
            System.out.println(original[i]);
        }
        
        //a
        for(int i = 0 ; i < selection.length - 1 ; i ++){
            SortSalesList min = selection[i];
            int minIndex = i ;
            for(int j = i + 1; j < selection.length ; j ++){
                if(min.compareTo(selection[j]) > 0){
                    min = selection[j];
                    minIndex = j;
                }
            }
            swap(selection,minIndex,i);
        }
        System.out.println("\nSorting Result on Region using SelectionSort:");
        for(int i = 0 ; i< 7 ; i++){
            System.out.println(selection[i]);
        }
        
        //b
        for(int i = 1 ; i < insertion.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(insertion[i].compareTo(insertion[j]) < 0){
                    for(int z = j ; z < i ; z++){
                        swap(insertion,z,i);
                    }
                    break;
                }
            }
            
        }
        System.out.println("\nSorting Result on Sales using InsertionSort:");
        for(int i = 0 ; i< 7 ; i++){
            System.out.println(insertion[i]);
        }
        //c
        for(int i = 0 ; i < bubble.length  ; i ++){
            for(int j = 0; j < bubble.length - 1; j ++){
                if(bubble[j].compareTo(bubble[j+1]) > 0){
                    swap(bubble,j,j+1);
                }
            }
        }
        
        System.out.println("\nSorting Result on SalesRep using BubbleSort:");
        for(int i = 0 ; i< 7 ; i++){
            System.out.println(bubble[i]);
        }
    }   
    
    public static void swap(SortSalesList [] array , int index1, int index2){
        SortSalesList temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

class SalesList{
    private String region;
    private String name;
    private int amount;
    public SalesList(){
        region = null;
        name = null;
        amount = 0;
    }
            
    public SalesList(String region, String name, int amount) {
        this.region = region;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%-15s" + amount + " " + name,region);
    }
    
}

class SortSalesList implements Comparable<SortSalesList>{ 
    private int order;
    private String region;
    private String name;
    private int amount;
            
    public SortSalesList(String region, String name, int amount, int order) {
        this.region = region;
        this.name = name;
        this.amount = amount;
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return String.format("%-15s" + amount + " " + name,region);
    }
    @Override
    public int compareTo(SortSalesList o) {
        if(order == 0){
            if(this.getRegion().compareTo(o.getRegion()) > 0){
                return -1;
            }else if(this.getRegion().compareTo(o.getRegion()) < 0){
                return 1;
            }else
                return 0 ;
        }else if(order == 1){
            if(this.getAmount() > (o.getAmount())){
                return 1;
            }else if(this.getAmount()< o.getAmount()){
                return -1;
            }else
                return 0 ;
        }else if(order == 2){
            if(this.getName().compareTo(o.getName()) > 0){
                return 1;
            }else if(this.getName().compareTo(o.getName()) < 0){
                return -1;
            }else
                return 0 ;
        }
        return 0;
    }

    public String getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

}
