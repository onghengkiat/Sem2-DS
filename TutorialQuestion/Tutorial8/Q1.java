package TutorialQuestion;

public class Q1 {
    public static void main(String[] args) {
        //a
        Character b = 'a';
        SortTest<Character> test1 = new SortTest<>(2,b);
        test1.selectionSort();
        test1.showValue();
        
        //b
        SortTest<Character> test2 = new SortTest<>(2,b);
        test2.bubbleSort();
        test2.showValue();
        
        //c
        SortTest<Character> test3 = new SortTest<>(2,b);
        test3.insertionSort();
        test3.showValue();
        
        //d
        SortTest<Character> test4 = new SortTest<>(2,b);
        test4.mergeSort();
        test4.showValue();
        
        //e
        SortTest<Character> test5 = new SortTest<>(2,b);
        test5.quickSort();
        test5.showValue();
        
    }
}
