package LabQuestion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
      
//        //Q1
//        System.out.println("The candies in the container: ");
//        Stack <String> container = new Stack<>();
//        Stack <String> outside = new Stack<>();
//        container.push("Orange");
//        container.push("Red");
//        container.push("Blue");
//        container.push("Orange");
//        container.push("Yellow");
//        container.push("Yellow");
//        container.push("Blue");
//        container.showStack();
//        
//        System.out.println("\nAli takes all the candies one by one from the container and eats the blue ones.");
//        while(!container.isEmpty()){
//            if(container.peek().equals("Blue"))
//                container.pop();
//            else
//                outside.push(container.pop());
//        }
//        System.out.println("He puts back the rest of candies in the container.");
//        while(!outside.isEmpty())
//            container.push(outside.pop());
//        System.out.println("The candies in the container: ");
//        container.showStack();
//        
//        
//        System.out.println("");
//        //Q2
//        for(int i = 0; i < 3; i++){
//            System.out.println("");
//            System.out.print("Enter infix expression : ");
//            Scanner input = new Scanner(System.in);
//            String line = input.nextLine();
//            String infixExpression = convertToInfix(line);
//            System.out.println("The infix expression is: "+infixExpression);
//            String postfixExpression = convertToPostfix(infixExpression);
//            System.out.println("The postfix expression is: " + postfixExpression);
//            System.out.println("The result is: " +postfixEvaluation(postfixExpression));
//        }
//        
//        
//        System.out.println("");
//        //Q3
//        System.out.print("How many queens? Enter a number : ");
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        System.out.println("Solving the " + n + " Queens problem");
//        int solution = 0;
//        int currentPosition = 0;
//        Stack <Integer> question3 = new Stack<>();
//        while(true){
//            boolean position = false;
//            for(int i = currentPosition; i < n ; i++){
//                if(validPosition(question3, i)){
//                    question3.push(i);
//                    currentPosition = 0 ;
//                    position = true;
//                }
//            }
//            if(position == false){
//                if(question3.isEmpty())
//                    break;
//                else{
//                    currentPosition = question3.pop();
//                    currentPosition ++;
//                }
//            }
//            
//            if(question3.getSize() == n){
//                solution ++;
//                int targetPosition = 0;
//                for(int row = 0; row < n ; row++){
//                    targetPosition = question3.pop();
//                    for(int column = 0; column < n ;column++){
//                        if(column == targetPosition)
//                            System.out.print("Q ");
//                        else
//                            System.out.print("* ");
//                    }
//                    System.out.println("");
//                }
//                System.out.println("");
//                currentPosition = ++targetPosition ;
//            }
//        }
//        
//        System.out.println("The number of solutions are : " + solution);
//        
//        
//        System.out.println("");
//        //Q4
//        for(int i = 0 ; i < 4 ; i++){
//            Scanner input = new Scanner(System.in);
//            System.out.print("Enter an expression : ");
//            String expression = input.nextLine();
//            System.out.println(expression);
//            Stack<Character> question4 = new Stack<>();
//            boolean balance = true;
//            boolean peek = false;
//            for(int j = 0 ; j < expression.length() ; j++){
//                if(expression.charAt(j) == '\\'){
//                    j ++;
//                }else if(expression.charAt(j) == '(' || expression.charAt(j) == '[' || expression.charAt(j) == '{'){
//                    question4.push(expression.charAt(j));
//                }else if(expression.charAt(j) == ')'){
//                    peek = false;
//                    do{
//                        if(question4.isEmpty()){
//                            System.out.println(" ".repeat(j) + "^ Extra )" );
//                            balance = false;
//                            break;
//                        }else{
//                            char pop = question4.pop();
//                            if(pop == '('){
//                                peek = true;
//                            }else if(pop == '{'){
//                                System.out.println(" ".repeat(j) + "^ Missing }");
//                                balance = false;
//                            }else{
//                                System.out.println(" ".repeat(j) + "^ Missing ]");
//                                balance = false;
//                            }
//                        }
//                    }while(peek == false);
//                }else if(expression.charAt(j) == ']'){
//                    peek = false;
//                    do{
//                        if(question4.isEmpty()){
//                            System.out.println(" ".repeat(j) + "^ Extra ]" );
//                            balance = false;
//                            break;
//                        }else{
//                            char pop = question4.pop();
//                            if(pop == '('){
//                                balance = false;
//                                System.out.println(" ".repeat(j) + "^ Missing )");
//                            }else if(pop == '['){
//                                peek = true;
//                            }else{
//                                balance = false;
//                                System.out.println(" ".repeat(j) + "^ Missing }");
//                            }
//                        }
//                    }while(peek == false);
//                }else if(expression.charAt(j) == '}'){
//                    peek = false;
//                    do{
//                        if(question4.isEmpty()){
//                            System.out.println(" ".repeat(j) + "^ Extra }" );
//                            balance = false;
//                            break;
//                        }else{
//                            char pop = question4.pop();
//                            if(pop == '('){
//                                System.out.println(" ".repeat(j) + "^ Missing )");
//                                balance = false;
//                            }else if(pop == '['){
//                                System.out.println(" ".repeat(j) + "^ Missing ]");
//                                balance = false;
//                            }else{
//                                peek = true;
//                            }
//                            balance = false;
//                        }
//                    }while(peek == false);
//                }
//            }
//            while(!question4.isEmpty()){
//                if(question4.pop() == '(')
//                    System.out.println(" ".repeat(expression.length() - 1) + "^ Missing )" );
//                else if(question4.pop() == '[')
//                    System.out.println(" ".repeat(expression.length() - 1) + "^ Missing ]" );
//                else if(question4.pop() == '{')
//                    System.out.println(" ".repeat(expression.length() - 1) + "^ Missing }" );
//                balance = false;
//            }
//            if(balance)
//                System.out.println("The expression is balanced");
//            System.out.println("");
//        }
//        
//            
//        //Q5
//        try{
//            Scanner sc = new Scanner(new FileInputStream("test.xml"));
//            Stack<String> element = new Stack<>();
//            boolean valid = false;
//            String error = "";
//            while(sc.hasNextLine()){
//                String line = sc.nextLine();
//                //next contents
//                if(!line.equals("") && valid == false){
//                }else if(line.equals("")){
//                    if(valid)
//                        System.out.println("The xml document is valid.");
//                    else
//                        System.out.println(error);
//                    valid = true;
//                    error = "";
//                    if(sc.hasNextLine()){
//                        System.out.println("\nContents of XML file");
//                        element = new Stack<>();
//                    }
//                }else{
//                    if(line.contains("</")){
//                        String closeElement = line.substring(line.indexOf("</"));
//                        if(closeElement.substring(1).contains("<")){
//                            closeElement = closeElement.substring(0,closeElement.indexOf(">") + 1);
//                            String pop = element.pop();
//                            String openElement = line.substring(line.lastIndexOf("<"),line.lastIndexOf(">")+1);
//                            if(openElement.equals(element.peek())){
//                                    error = "Duplicate root element " + openElement;
//                                    valid = false;
//                            }
//                            element.push(openElement);
//                            if(!pop.equals(closeElement.replace("/",""))){
//                                valid = false;
//                                error = "Begin Element : " + pop + " Invalid ending element : " + closeElement;
//                            }
//                        }else{
//                            if(line.substring(0,line.indexOf("</")).contains("<")){
//                                String openElement = line.substring(line.indexOf("<"),line.indexOf(">")+1);
//                                if(openElement.equals(element.peek())){
//                                    error = "Duplicate root element " + openElement;
//                                    valid = false;
//                                }
//                                element.push(openElement);
//                                String pop = element.pop();
//                                if(!pop.equals(closeElement.replace("/",""))){
//                                    valid = false;
//                                    error = "Begin Element : " + pop + " Invalid ending element : " + closeElement;
//                                }
//                            }else{
//                                if(element.isEmpty()){
//                                    error = "Ending element " + closeElement + " with no begin element";
//                                }else{
//                                    String pop = element.pop();
//                                    if(!pop.equals(closeElement.replace("/",""))){
//                                        valid = false;
//                                        error = "Begin Element : " + pop + " Invalid ending element : " + closeElement;
//                                    }
//                                }
//                            }
//                        }
//                        
//                    }else if(line.contains("<")){
//                        element.push(line.substring(line.indexOf("<"),line.indexOf(">") + 1));
//                    }
//                    System.out.println(line);
//                }
//            }
//        }catch(FileNotFoundException e){
//            System.out.println("ERROR");
//        }
        
        
        System.out.println("");
        //Q6
        Stack<Coordinate> path = new Stack<>();
        Maze maze = new Maze();
        maze.readMaze();
        
        String [] map = maze.getArray();
        boolean [][] thisJalanIGotWalk = new boolean [map.length][map[0].length()]; 
        System.out.println("The original maze is");
        for(String str : map){
            System.out.println(str);
        }
        
        everything:
        for(int i = 0 ; i < map.length; i++){
            if(map[i].contains("S")){
                for(int j = 0 ; j < map[i].length() ; j++){
                    if(map[i].charAt(j) == 'S'){ 
                        //一开始先放一个starting point在path里面
                        path.push(new Coordinate (i,j));
                        //找着那个路径
                        while(!path.isEmpty()){
                            Coordinate point = path.pop();
                            //换那个最后一个point的direction，可是coordinate还是保持一样
                            String direction = point.getDirection();
                            i = point.getRow();
                            j = point.getColumn();
                            
                            if(point.getDirection().equals("UP"))
                                point.setDirection("RIGHT");
                            else if(point.getDirection().equals("RIGHT"))
                                point.setDirection("DOWN");
                            else if(point.getDirection().equals("DOWN"))
                                point.setDirection("LEFT");
                            else
                                point.setDirection("NO");
                            
                            path.push(point);
                            
                            if(map[i].charAt(j) == 'F')
                                break;
                            //只要那个point没有走过，而且是没有#就可以放进去了，照着上右下左的方向来顺序test看可不可以走
                            if(direction.equals("UP")){
                                if(i-1 >=0 && map[i-1].charAt(j) != '#' && thisJalanIGotWalk[i-1][j] == false){
                                    thisJalanIGotWalk[i-1][j] = true;
                                    path.push(new Coordinate(i-1,j));
                                }
                            }else if(direction.equals("RIGHT")){
                                if(j+1 < map[i].length() && map[i].charAt(j+1) != '#' && thisJalanIGotWalk[i][j+1] == false){
                                    thisJalanIGotWalk[i][j+1] = true;
                                    path.push(new Coordinate(i,j+1));
                                }
                            }else if(direction.equals("DOWN")){
                                if(i + 1 < map.length && map[i+1].charAt(j) != '#' && thisJalanIGotWalk[i+1][j] == false){
                                    thisJalanIGotWalk[i+1][j] = true;
                                    path.push(new Coordinate(i+1,j));
                                }
                            }else if(direction.equals("LEFT")){
                                if(j - 1 >= 0 && map[i].charAt(j - 1) != '#' && thisJalanIGotWalk[i][j - 1] == false){
                                    thisJalanIGotWalk[i][j-1] = true;
                                    path.push(new Coordinate(i,j-1));
                                }
                            }else{
                                //如果上下左右都试过了，那么就代表说这条路行不通了，就丢掉它，然后继续try其他的路
                                thisJalanIGotWalk[i][j] = false;
                                path.pop();
                            }
                        }
                        
                        //把那些路assign进去map里面
                        while(!path.isEmpty()){
                            Coordinate point = path.pop();
                            i = point.getRow();
                            j = point.getColumn();
                            if(map[i].charAt(j) =='F' || map[i].charAt(j) =='S')
                                continue;
                            map[i] = map[i].substring(0,j) + "." + map[i].substring(j+1);
                        }
                        break everything;
                    }
                }
            }
        }
        
        System.out.println("\nThe Solution is");
        for(String str : map)
            System.out.println(str);
    }
    
    //Q2
    public static String convertToInfix(String line){
        String [] operator = line.split(" ");
        String str = "";
        for(int i = 0; i < operator.length; i++){
            switch (operator[i]) {
                case "add":
                    str += " + ";
                    break;
                case "sub":
                    str += " - ";
                    break;
                case "mul":
                    str += " * ";
                    break;
                case "div":
                    str += " / ";
                    break;
                case "mod":
                    str += " % ";
                    break;
                case "ob":
                    str += "( ";
                    break;
                case "cb":
                    str += " )";
                    break;
                default:
                    str += operator[i];
                    break;
            }
        }
        return str;
    }
    
    public static String convertToPostfix(String infixExpression){
        String something = "";
        String str = "";
        String [] temp = infixExpression.split(" ");
        Stack <String> num = new Stack<>();
        int priority = 0;
        for(int i = 0; i < temp.length ; i++){
            if(isInteger(temp[i])){
                str += temp[i] + " ";
            }else if(temp[i].equals("(")){
                num.push(temp[i]);
            }else if(temp[i].equals(")")){
                something = num.pop();
                while(!something.equals("(")){
                    str += something + " ";
                    something = num.pop();
                }
            }else{
                if(!num.isEmpty()){
                    if(num.peek().equals("("))
                        num.push(temp[i]);
                    else{
                        something = num.peek();
                        while(getPriority(temp[i]) <= getPriority(something)){
                            str += num.pop() + " ";
                            if(!num.isEmpty()){
                                something = num.peek();
                                if(something.equals("("))
                                    break;
                            }
                            else
                                break;
                        }
                        num.push(temp[i]);
                    }
                }else
                    num.push(temp[i]);
            }
        }
        
        while(!num.isEmpty() ){
                str += num.pop() + " ";
        }
        
        return str ;
    }
    
    public static int postfixEvaluation(String postfixExpression){
        String [] temp = postfixExpression.split(" ");
        Stack<Integer> num = new Stack<>();
        for(int i = 0; i < temp.length; i++){
            if(isInteger(temp[i]))
                num.push(Integer.parseInt(temp[i]));
            else
                num.push(getResult(num.pop(), num.pop(),temp[i]));
        }
        return num.pop();
    }
    public static int getResult(int num1, int num2, String operator){
        switch(operator){
            case "*" : return num2 * num1;
            case "/" : return num2 / num1;
            case "%" : return num2 % num1;
            case "+" : return num2 + num1;
            case "-" : return num2 - num1;
            default :
                return 0;
        }
    }
    
    public static int getPriority(String operator){
        switch(operator){
            case "*" :
            case "/" :
            case "%" :
                return 2;
            case "+" :
            case "-" :
                return 1;
            default :
                return 0;
        }
    }
    
    public static boolean isInteger(String str){
        try{
            Integer.parseInt(str);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    //Q3
    public static boolean validPosition(Stack<Integer>positions, int index){
        boolean valid = true;
        int [] temp = new int[positions.getSize()];
        for(int i = 0; i < temp.length ;i++){
            temp[i] = positions.pop();
            if(temp[i] == index)
                valid = false;
            if(index - (i+1) == temp[i] || index + (i+1) == temp[i])
                valid = false;
        }
        
        for(int i = temp.length - 1; i >= 0; i--)
            positions.push(temp[i]);
        return valid;
    }
}


//Q6
class Maze{
    private String [] array;

    public Maze() {
        this.array = null;
    }

    public String[] getArray() {
        return array;
    }
        
    public void readMaze(){
        int line = 0 ;
        try{
            Scanner input = new Scanner(new FileInputStream("Maze.txt"));
            while(input.hasNextLine()){
                input.nextLine();
                line ++;
            }
        }catch(Exception e){
            System.out.println("ERROR");
        }

        array = new String [line] ;

        try{
            Scanner input = new Scanner(new FileInputStream("Maze.txt"));
            for(int i = 0 ; i < array.length ; i++){
                array[i] = input.nextLine();
            }
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
}

class Coordinate{
    private int row ;
    private int column; 
    private String direction;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
        this.direction = "UP";
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getDirection() {
        return direction;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "x : " + column  + ",y : " + row ;
    }
    
}