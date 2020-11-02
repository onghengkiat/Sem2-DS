package PastYear;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Stack<Character> path = new Stack<>();
        try{
            Scanner input = new Scanner(new FileInputStream("maze.txt"));
            int line = 0 ;
            int width = 0;
            while(input.hasNextLine()){
                line++;
                width = input.nextLine().split("\\s").length;
            }
            input.close();
            char [][] map = new char[line][width];
            boolean [][] visited = new boolean[line][width];
            Scanner sc = new Scanner(new FileInputStream("maze.txt"));
            Coordinate destination = null ;
            System.out.println("The Triwizard Maze:");
            for(int i = 0 ; i < line;  i++){
                for(int j = 0; j < width; j++){
                    map[i][j] = sc.next().charAt(0);
                    System.out.print(map[i][j] + " ");
                    if(map[i][j] == 'C'){
                        destination = new Coordinate(i,j);
                    }
                }
                System.out.println("");
            }
            sc.close();
            if(findPath(path,map,visited,0,0)){
                Stack<Coordinate> coordinates = new Stack<>();
                coordinates.push(destination);
                while(!path.isEmpty()){
                    char direction = path.pop();
                    if(direction == 'U')
                        coordinates.push(new Coordinate(coordinates.peek().getX()+1,coordinates.peek().getY()));
                    else if(direction == 'D')
                        coordinates.push(new Coordinate(coordinates.peek().getX()-1,coordinates.peek().getY()));
                    else if(direction == 'L')
                        coordinates.push(new Coordinate(coordinates.peek().getX(),coordinates.peek().getY()+1));
                    else if(direction == 'R')
                        coordinates.push(new Coordinate(coordinates.peek().getX(),coordinates.peek().getY()-1));
                }
                System.out.println("\nHurray!!! Harry found the Triwizard Cup at " + destination);
                System.out.print("This is the path Harry has taken: ");
                while(!coordinates.isEmpty()){
                    System.out.print(coordinates.pop());
                    if(!coordinates.isEmpty())
                        System.out.print(" > ");
                }
            }else
                System.out.println("\nOh no!!! Harry couldn't find the Triwizard Cup!\nSomeone quickly gets Professor Dumbledore.");
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
    
    public static boolean findPath(Stack<Character>path, char[][] map,boolean [][] visited, int x ,int y){
        if(map[y][x] == '0'){
            visited[y][x] = true;
            return false;
        }else if(map[y][x] == 'C'){
            return true;
        }else{
            visited[y][x] = true;
            if(x > 0 && visited[y][x-1] == false){
                path.push('L');
                if( findPath(path,map,visited, x-1,y)){
                    return true;
                }
                path.pop();
            }
            if(x < map[y].length - 1 && visited[y][x+1] == false){
                path.push('R');
                if( findPath(path,map,visited, x+1,y)){
                    return true;
                }
                path.pop();
            }
            if(y > 0 && visited[y-1][x] == false){
                path.push('U');
                if( findPath(path,map,visited, x,y-1)){
                    return true;
                }
                path.pop();
            }
            if(y < map.length - 1 && visited[y+1][x] == false){
                path.push('D');
                if( findPath(path,map,visited, x,y+1)){
                    return true;
                }
                path.pop();
            }
            return false;
        }
    }
}

class Coordinate{
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//a
class Stack<T>{
    StackNode<T> head ;
    public Stack(){
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public T peek(){
        if(isEmpty()){
            return null;
        }
        StackNode<T> currentNode = head;
        while(currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }
    
    public T pop(){
        if(isEmpty()){
            return null;
        }
        StackNode<T> currentNode = head.getNext();
        StackNode<T> previousNode = head;
        if(currentNode == null){
            T temp = head.getValue();
            head = null;
            return temp;
        }
        
        while(currentNode.getNext() != null){
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        
        T temp = currentNode.getValue();
        previousNode.setNext(null);
        return temp;
    }
    
    public void push(T element){
        if(isEmpty()){
            head = new StackNode(element,null);
        }else{
            StackNode<T> currentNode = head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new StackNode(element,null));
        }
    }
    
    public void show(){
        StackNode<T> currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode + " ");
            currentNode = currentNode.getNext();
        }
    }
}

class StackNode<T>{
    private T value;
    private StackNode<T> next;

    public StackNode(T value, StackNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }
    
    
}