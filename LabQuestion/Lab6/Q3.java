package LabQuestion;

import java.util.Random;

public class Q3 {

    public static void main(String[] args) {
        Random rnd = new Random();
        Queue<Card> player1 = new Queue<>();
        for (int i = 0; i < 5; i++) {
            player1.enqueue(new Card(rnd.nextInt(10), rnd.nextInt(4)));
        }
        System.out.println("Player 1 Card");
        player1.showQueue();

        Queue<Card> player2 = new Queue<>();
        for (int i = 0; i < 5; i++) {
            player2.enqueue(new Card(rnd.nextInt(10), rnd.nextInt(4)));
        }
        System.out.println("\nPlayer 2 Card");
        player2.showQueue();

        int score1 = 0;
        int score2 = 0;
        for (int i = 0; i < 5; i++) {
            Card cardPlayer1 = player1.dequeue();
            Card cardPlayer2 = player2.dequeue();
            if(cardPlayer1.compareTo(cardPlayer2) > 0){
                score1 ++;
            }else if(cardPlayer1.compareTo(cardPlayer2) < 0){
                score2 ++;
            }
        }
        System.out.println("\nPlayer 1 Score : " + score1);
        System.out.println("Player 2 Score : " + score2);
        if(score1 > score2){
            System.out.println("Player 1 WINS!");
        }else if(score1 < score2){
            System.out.println("Player 2 WINS!");
        }else{
            System.out.println("DRAW!");
        }
    }
}

class Card {

    private String colour;
    private String number;
    private int scoreNum, scoreColour;

    final String[] numbers = {"One", "Two", "Three", "Four", "Five", "Six",
         "Seven", "Eight", "Nine", "Ten"};
    final String[] colours = {"Yellow", "Red", "Green", "Blue"};

    public Card(int a, int b) {
        this.number = numbers[a];
        this.colour = colours[b];
        scoreNum = a;
        scoreColour = b;
    }

    public int compareTo(Card other) {
        if(this.getScoreNum() == other.getScoreNum()){
            return this.getScoreColour() - other.getScoreColour();
        }else{
            return this.getScoreNum() - other.getScoreNum();
        }
    }

    public int getScoreNum() {
        return scoreNum;
    }

    public int getScoreColour() {
        return scoreColour;
    }

    public String[] getNumbers() {
        return numbers;
    }

    public String[] getColours() {
        return colours;
    }

    public String getColour() {
        return colour;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + " " + colour;
    }

}
