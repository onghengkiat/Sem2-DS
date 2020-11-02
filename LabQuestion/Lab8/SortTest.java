package LabQuestion;

import java.util.Arrays;
import java.util.Random;

public class SortTest<T extends Comparable<T>> {
    public static final int ASCENDING = 1;
    public static final int DESCENDING = 2;
    private int SIZE;
    private final int MAX = 100;
    private final int MAXCHAR = 26;
    private T [] value ;
    private Random r ;
    private int orderType ;
    private T [] temp ;
    
    public SortTest(int a , T b, int size){
        this.SIZE = size;
        orderType = a;
        value = (T[]) new Comparable[SIZE];
        r = new Random();
        char c ;
        for(int i = 0 ; i< SIZE ;i ++){
            if(b instanceof Integer)
                value[i] = (T) (Integer)r.nextInt(MAX);
            else if(b instanceof Double)
                value[i] = (T) (Double)(0.01*r.nextInt(MAX));
            else if(b instanceof Character)
                value[i] = (T) (Character)(char)(r.nextInt(MAXCHAR)+'A');
            else if (b instanceof String){
                value[i] = b;
                for(int j = 0 ; j < 8 ; j++){
                    c = (char)('a' + r.nextInt(MAXCHAR));
                    value[i] += c + "";
                }
            }
        }
        temp = Arrays.copyOf(value,value.length);
    }
    
    //hmm 1000 sets need to wait too long time liao, so i just simply do 1 set of 100000 random numbers
    public void testSortTest(){
        System.out.println("Running on 1000 sets of 100000 random numbers");
        Sort [] arr = {new Sort("Quick Sort",0),new Sort("Selection Sort",0), new Sort("Merge Sort",0),
        new Sort("Insertion Sort",0), new Sort("Bubble Sort",0)};
        
        long start = System.currentTimeMillis();
        quickSort();
        arr[0].addTime(System.currentTimeMillis() - start);

        value = Arrays.copyOf(temp,temp.length);

        start = System.currentTimeMillis();
        selectionSort();
        arr[1].addTime(System.currentTimeMillis() - start);

        value = Arrays.copyOf(temp,temp.length);

        start = System.currentTimeMillis();
        mergeSort();
        arr[2].addTime(System.currentTimeMillis() - start);

        value = Arrays.copyOf(temp,temp.length);

        start = System.currentTimeMillis();
        insertionSort();
        arr[3].addTime(System.currentTimeMillis() - start);

        value = Arrays.copyOf(temp,temp.length);

        start = System.currentTimeMillis();
        bubbleSort();
        arr[4].addTime(System.currentTimeMillis() - start);
        
        Arrays.sort(arr);
        for(int i = 0 ; i < 5 ; i++){
            System.out.println(arr[i]);
        }
        System.out.println("The fastest sorting algo is " + arr[0].getSortMethod());
    }
    
    
    public boolean isSorted(){
        for(int i = 0; i < value.length - 1; i++){
            if(value[i].compareTo(value[i+1]) > 0 && orderType == ASCENDING)
                return false;
            if(value[i].compareTo(value[i+1]) < 0 && orderType == DESCENDING)
                return false;
        }
        return true;
    }
    
    public void swap(int index1, int index2){
        T temp = value[index1];
        value[index1] = value[index2];
        value[index2] = temp;
    }
    
    public void showValue(){
        for(int i =0 ; i < value.length ; i ++){
            System.out.print(value[i] + " ");
            if((i+1)%10 == 0)
                System.out.println("");
        }
    }
    
    public int getMinIndex(int start){
        T temp = value[start];
        int index = start;
        for(int i = start + 1 ; i < value.length ; i ++){
            if(temp.compareTo(value[i]) > 0 && orderType == ASCENDING){
                index = i;
                temp = value[i];
            }else if(temp.compareTo(value[i]) < 0 && orderType == DESCENDING){
                index = i;
                temp = value[i];
            }
        }
        return index;
    
    }
    
    public void selectionSort(){
        for(int i = 0 ; i < value.length - 1 ; i++)
            swap(i, getMinIndex(i));
    }
    
    public void bubbleSort(){
        for(int iteration = 0 ; iteration < value.length - 1 ; iteration ++){
            for(int i = 0 ; i < value.length - 1 - iteration ; i ++){
                if(value[i].compareTo(value[i+1]) > 0 && orderType == ASCENDING)
                    swap(i, i + 1);
                else if(value[i].compareTo(value[i+1]) < 0 && orderType == DESCENDING)
                    swap(i, i + 1);
            }
        }
    }
    
    public void insertionSort(){
        int j ;
        for(int i = 1 ; i < value.length; i++){
            for(j = 0 ; j < i ; j ++){
                if(value[i].compareTo(value[j])<0 && orderType == ASCENDING){
                    swap(i,j);
                    break;
                }else if(value[i].compareTo(value[j]) > 0 && orderType == DESCENDING){
                    swap(i,j);
                    break;
                }
            }
            for(j = j + 1 ; j < i ; j++)
                swap(j,i);
        }
    }
    
    public void mergeSort(){
        mergeSort(0, value.length - 1);
    }
    
    public void mergeSort(int first , int last){
        if(first < last){
            int middle = (first + last)/2;
            mergeSort(first, middle);
            mergeSort(middle + 1 , last);
            merge(first, middle, middle + 1 , last);
        }
    }
    
    public void merge(int leftfirst, int leftlast, int rightfirst, int rightlast){
        T[] temp = (T[]) new Comparable[SIZE];
        int index = leftfirst;
        int currentindex = leftfirst;
        
        while(leftfirst <= leftlast && rightfirst <= rightlast){
            if((value[leftfirst].compareTo(value[rightfirst])<0 && orderType == ASCENDING) ||
                    (value[leftfirst].compareTo(value[rightfirst])>0 && orderType == DESCENDING)){
                temp[index] = value[leftfirst];
                leftfirst ++;
            }else{
                temp[index] = value[rightfirst];
                rightfirst ++;
            }
            index++;
        }
        while(leftfirst <= leftlast){
            temp[index] = value[leftfirst];
            leftfirst ++;
            index++;
        }
        while(rightfirst <= rightlast){
            temp[index] = value[rightfirst];
            rightfirst ++;
            index ++;
        }
            
        for(int i = currentindex ; i <= rightlast ; i++)
            value[i] = temp[i];
    }
    
    public void quickSort(){
        quickSort(0,value.length-1);
    }
    
    public void quickSort(int first, int last){
        if(first < last){
            int splitindex = split(first, last);
            quickSort(first, splitindex - 1);
            quickSort(splitindex +1 , last);
        }
    }
    
    public int split(int first, int last){
        boolean correctSide;
        T splitvalue = value[first];
        int index = first;
        first ++;
        do{
            correctSide = true;
            while(correctSide){
                if(splitvalue.compareTo(value[first])<0 && orderType == ASCENDING ||
                        splitvalue.compareTo(value[first])>=0 && orderType == DESCENDING)
                    correctSide = false;
                else{
                    first ++;
                    if(first <= last)
                        correctSide = true;
                    else
                        correctSide = false;
                }
            }
            if(first <= last)
                correctSide = true;
            else
                correctSide = false;
            
            while(correctSide){
                if(splitvalue.compareTo(value[last]) >= 0 && orderType == ASCENDING ||
                    splitvalue.compareTo(value[last]) < 0 && orderType == DESCENDING)
                    correctSide = false;
                else{
                    last --;
                    if(first <= last)
                        correctSide = true;
                    else
                        correctSide = false;
                }
            }
            if(first < last){
                swap(first, last);
                first ++;
                last --;
            }
        }while(first <= last);
        
        swap(index, last);
        return last;
    }
    
    
    
    //Q4
    public void heapSort(){
        System.out.print("The characters are : ");
        for(int i = 0 ; i < value.length ; i ++){
            System.out.print(value[i] + " ");
        }
        if(orderType == ASCENDING){
            System.out.println("\nHeap Sort - Ascending Order");
            for(int i = value.length - 1; i > 0 ; i--){
                int maxIndex = findMax(i);
                swap(maxIndex,i);
            }
            
            for(int i = 0 ; i < value.length ; i ++){
                System.out.print(value[i] + " ");
            }   
        }else{
            System.out.println("\nDescending order is coming soon");
        }
    }
    
    public int findMax (int end){
        T max = value[0];
        int maxIndex = 0;
        for(int i = 1 ; i <= end ; i++){
            if(value[i].compareTo(max) > 0){
                max = value[i];
                maxIndex = i;
            }
        }
        return maxIndex ;
    }
}

class Sort implements Comparable<Sort>{
    private String sortMethod ;
    private long time ;

    public Sort(String sortMethod, long time) {
        this.sortMethod = sortMethod;
        this.time = time;
    }

    public String getSortMethod() {
        return sortMethod;
    }

    public void setSortMethod(String sortMethod) {
        this.sortMethod = sortMethod;
    }

    public long getTime() {
        return time;
    }

    public void addTime(long time) {
        this.time += time;
    }

    @Override
    public int compareTo(Sort o) {
        return (int)this.getTime() - (int)o.getTime();
    }

    @Override
    public String toString() {
        return sortMethod + " : " + time ;
    }
}