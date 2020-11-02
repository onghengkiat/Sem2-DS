package LabQuestion;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(new FileInputStream("lab7Q2.txt"));
            BST <wordFrequency>bst = new BST<>();
            while(input.hasNext()){
                String word = input.next();
                word = word.replaceAll("[^\\w]", "");
                word = convertLowerCase(word);
                wordFrequency words = new wordFrequency(word,1);
                if(bst.contains(words)){
                    wordFrequency originalWord = bst.getElement(words);
                    originalWord.setFrequency(originalWord.getFrequency()+1);
                }else{
                    bst.addNode(words);
                }
            }
            System.out.println("Word Frequency Generator Program");
            bst.setOrder(BST.INORDER);
            bst.showTree();
            input.close();
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
    
    public static String convertLowerCase(String str){
        for(int i = 0 ; i< str.length() ; i++){
            str = str.substring(0,i) + Character.toLowerCase(str.charAt(i)) + str.substring(i+1);
        }
        return str;
    }
}

class wordFrequency implements Comparable<wordFrequency>{
    private String word;
    private int frequency;

    public wordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(wordFrequency o) {
        return this.getWord().compareTo(o.getWord());
    }

    @Override
    public String toString() {
        int numOfZero = 4;
        int frequency = this.frequency;
        while(frequency != 0){
            numOfZero --;
            frequency /= 10;
        }
        return "0".repeat(numOfZero) + this.frequency + " " + word;
        
    }
    
}