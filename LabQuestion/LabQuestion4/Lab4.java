package LabQuestion;

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Lab4 {
    public static void main(String[] args) {
        //Q1
        LinkedList <Integer> question1 = new LinkedList<>();
        Random rnd = new Random();
        System.out.print("The random numbers are : ");
        int [] randomNum = new int[10];
        for(int i = 0; i < 10 ; i++){
            randomNum[i] = rnd.nextInt(101);
            System.out.print(randomNum[i] + " ");
        }
        
        System.out.println("Insert the random numbers at the back of the linked list");
        for(int i = 0 ; i < 10 ; i++){
            question1.addNode(randomNum[i]);
        }
        question1.showList();
        
        
        System.out.println("\n");
        question1.clear();
        System.out.println("Insert the random numbers in front of the linked list");
        for(int i = 0 ; i < 10 ; i++){
            question1.addFrontNode(randomNum[i]);
        }
        question1.showList();
        
        
        System.out.println("\n");
        question1.clear();
        System.out.println("Insert the random numbers in a sorted linked list");
        for(int i = 0 ; i < 10 ; i++){
            question1.addSortNode(randomNum[i]);
        }
        question1.showList();
        
        System.out.println("");
        //Q2
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word :　");
        String sentence = input.next();
        char [] arr = sentence.toCharArray();
        LinkedList<Character> question2 = new LinkedList<>();
        for(int i = 0 ; i < arr.length ; i++){
            question2.addNode(arr[i]);
        }
        System.out.print("The original list : ");
        question2.showList();
        System.out.println("");
        System.out.println("Split the list into two");
        question2.splitList();
        System.out.println("Split the list by alternating the nodes");
        LinkedList<Character>[] lists = question2.alternateList();
        System.out.println("Merge First List and Second List by alternating the nodes");
        question2.mergeList(lists[0], lists[1]);
        System.out.println("Reverse the list. Recursive method in the LinkedList");
        question2.reverse();
        System.out.println("Reverse the list. Recursive method in tester class");
        Lab4.reverse(question2);
        
        
        System.out.println("");
        //Q3
        LinkedList <Course> question3 = new LinkedList<>();
        question3.addNode(new Course("WXX101","Programming","B",5));
        question3.addNode(new Course("WXX201","Networking","C",4));
        question3.addNode(new Course("WXX301","Operating System","A",3));
        question3.showList();
        int totalPoint = 0;
        int totalCredit = 0;
        for(int i = 0 ; i < question3.length() ; i++){
            Course temp = question3.get(i);
            totalPoint += temp.getPoint();
            totalCredit += temp.getCreditHours();
        }
        System.out.println("Total point is " + totalPoint);
        System.out.println("Total credit is " + totalCredit);
        System.out.printf("Grade point average is %.2f\n", ((double)totalPoint/totalCredit));
        
        
        System.out.println("");
        //Q4
        LinkedList<Character> player1 = new LinkedList<>();
        LinkedList<Character> player2 = new LinkedList<>();
        int turn = rnd.nextInt(2);
        if(turn == 0){
            System.out.println("Player 1 start first");
        }else
            System.out.println("Player 2 start first");
        while(player1.length() <= 20 && player2.length() <= 20){
            int dice = rnd.nextInt(6)+1;
            if(turn % 2 == 0){
                for(int i = 0 ; i < dice ; i++){
                    player1.addNode('*');
                }
                System.out.print("Player 1: ");
                player1.showList();
                System.out.println("");
                if(player1.length() > 20){
                    System.out.println("Player 1 wins the game");
                    break;
                }
            }else{
                for(int i = 0 ; i < dice ; i++){
                    player2.addNode('*');
                }
                System.out.print("Player 2: ");
                player2.showList();
                System.out.println("");
                if(player2.length() > 20){
                    System.out.println("Player 2 wins the game");
                    break;
                }
            }
            turn ++ ;
        }
        
        
        System.out.println("");
        //Q5
        LinkedList<String> question5 = new LinkedList<>();
        question5.addNode("ARS");
        question5.addNode("AST");
        question5.addNode("CHE");
        question5.addNode("LEI");
        question5.addNode("MAN");
        question5.addNode("LIV");
        question5.addNode("TOT");
        System.out.print("The list consists of ");question5.showList();
        System.out.println("\nRemove all the word that consists of the A character using iterator.");
        LinkedList.LinkedListIterator iterator  = question5.new LinkedListIterator(0);
        while(iterator.hasNext()){
            if(iterator.getCurrentData().toString().contains("A"))
                iterator.remove();
            else
                iterator.next();
        }
        System.out.print("The updated list consist of ");question5.showList();
            
        
        System.out.println("");
        //Q6
        DoubleLinkedList <Integer>question6 = new DoubleLinkedList<>();
        
        System.out.print("The random numbers are : ");
        int [] randomNumber = new int[10];
        for(int i = 0; i < 10 ; i++){
            randomNumber[i] = rnd.nextInt(101);
            System.out.print(randomNumber[i] + " ");
            question6.addRightNode(randomNumber[i]);
        }
        System.out.println("\nInsert the random numbers into the doubly linked list");
        question6.showList();
        //6a
        System.out.println("\nRemove a number from the third position");
        question6.deleteNodeByPosition(2);
        question6.showList();
        
        //6b
        System.out.println("\nReplace the number in seventh position with 999");
        question6.deleteNodeByPosition(6);
        question6.addNodeByPosition(999, 6);
        question6.showList();
        
        //6c
        System.out.println("\nRemove all even number from the doubly linked list");
        question6.deleteEven();
        question6.showList();
        
        
        System.out.println("");
        //Q7
        CircularLinkedList<String> question7 = new CircularLinkedList<>();
        System.out.print("Enter a sentence : ");
        Scanner in = new Scanner(System.in);
        String [] sentenceInput = in.nextLine().split(" ");
        for(int i = 0 ; i < sentenceInput.length ; i++)
            question7.addCircularNode(sentenceInput[i]);
        System.out.println("\nThe words in the circular linked list");
        question7.showCircularList();
        System.out.println("After delete a word");
        question7.deleteCircularNode();
        question7.showCircularList();
        System.out.println("The second item in the list is " + question7.getCircularItem(1));
        
        
        System.out.println("");
        //Q8
        CircularLinkedList<Music> playList = new CircularLinkedList<>();
        playList.addCircularNode(new Music("song1","song1.mp3"));
        playList.addCircularNode(new Music("song2","song2.mp3"));
        playList.addCircularNode(new Music("song3","song3.mp3"));
        playList.addCircularNode(new Music("song4","song4.mp3"));
        System.out.println("My Music Play List");
        Scanner input2 = new Scanner(System.in);
        int whichMusic = 0;
        Music music = playList.getCircularItem(whichMusic%playList.length());
        while(true){
            playList.showCircularList();
            System.out.print("1 Play Music | 2 Forward | 3 Back | 4 Stop | -1 Exit : ");
            int instruction = input.nextInt();
            if(instruction == 1)
                music.play();
            else if(instruction == 2){
                music.stop();
                whichMusic ++;
                music.forward();
                music = playList.getCircularItem(whichMusic%playList.length());
                music.play();
            }else if (instruction == 3){
                music.stop();
                whichMusic--;
                music.back();
                music = playList.getCircularItem(whichMusic%playList.length());
                music.play();
            }else if (instruction == 4){
                System.out.println("Stop Playing");
                music.stop();
            }else{
                music.exit();
            }
        }
    }
    
    //2e
    public static void reverse(LinkedList list){
        list.reverse();
    }
}

//Q3
class Course implements Comparable<Course>{
    private String courseCode, courseName,grade;
    private int creditHours;

    public Course(String courseCode, String courseName, String grade, int creditHours) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.grade = grade;
        this.creditHours = creditHours;
    }

    @Override
    public int compareTo(Course o) {
        return this.creditHours - o.creditHours;
    }
    
    public String toString(){
        return "Course : " + courseCode + " (" + courseName + ") - " + creditHours + " credit hours. Grade : " + grade; 
    }
    
    public int getPoint(){
        switch (grade){
            case "A" : return 4*creditHours;
            case "B" : return 3*creditHours;
            case "C" : return 2*creditHours;
            case "D" : return 1*creditHours;
            default : return 0;
        }
    }

    public int getCreditHours() {
        return creditHours;
    }
}

class Music{
    private String musicTitle, fileName;
    private JFXPanel panel = new JFXPanel();
    private Media hit ;
    private MediaPlayer mediaPlayer ;

    public Music(String musicTitle, String fileName) {
        this.musicTitle = musicTitle;
        this.fileName = fileName;
        hit = new Media(new File(fileName).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
    }
    
    public String toString(){
        return "Music : " + musicTitle ;
    }
    
    public void play(){
        System.out.println("Play " + toString());
        mediaPlayer.play();
    }
    
    public void forward(){
        System.out.print("Forward One Position - ");
    }
    
    public void back(){
        System.out.print("Backward One Position");
    }
    
    public void stop(){
        mediaPlayer.stop();
    }
    
    public void exit(){
        stop();
        System.out.println("Exit Music Player");
        System.exit(0);
    }
    
}
