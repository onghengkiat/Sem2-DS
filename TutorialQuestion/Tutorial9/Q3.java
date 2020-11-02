package TutorialQuestion;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        HashTable<String,String> map = new HashTable<>();
        map.put("100-101", "ICND 1");
        map.put("200-101", "ICND 2");
        map.put("200-120", "CCNA Routing and Switching");
        map.put("210-260", "CCNA Security");
        System.out.println("Hash Table");
        System.out.println("The number of elements in the Hash Table " + map.getSize());
        map.showHashTable();
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter a code to search : ");
        String code = input.next();
        if(map.containsKey(code)){
            System.out.println("Course " + code + " : " + map.get(code));
        }else{
            System.out.println("The course " + code + " cannot be found");
        }
    }
}
