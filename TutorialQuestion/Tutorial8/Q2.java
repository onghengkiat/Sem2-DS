package TutorialQuestion;

public class Q2 {
    public static void main(String[] args) {
        //a
        String a = "";
        SortTest <String> test1 = new SortTest<>(1,a);
        test1.mergeSort();
        test1.showValue();
        
        //b
        SortTest <String> test2 = new SortTest<>(1,a);
        test2.quickSort();
        test2.showValue();
    }
}
