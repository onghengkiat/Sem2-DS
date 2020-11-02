package LabQuestion;

//Q1

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

class Time{
    private int hour, minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
    
    public boolean checkValid(){
        if(hour < 0 || hour > 23){
            return false;
        }
        
        if(minute < 0 || minute > 59){
            return false;
        }
        
        return true;
    }
    
    public void display(){
        if(checkValid() == false){
            System.out.println("Hour: " + hour + " Minute: " + minute + "  Invalid time input" );
        }else if(hour>12)
            System.out.println("Hour: " + hour + " Minute: " + minute + "  " + hour%12 + ":" + minute + " PM");
        else
            System.out.println("Hour: " + hour + " Minute: " + minute + "  " + hour + ":" + minute + " AM");
    }
}

class testTime{
    public static void main(String[] args) {
        Time pm = new Time(13,45);
        Time invalid = new Time(33,15);
        Time am = new Time(10,52);
        pm.display();invalid.display();am.display();
    }
}

//Q2
class Polynomial{
    private int degree;
    private double[] coefficient;

    public Polynomial(int degree, double [] coefficient) {
        this.degree = degree + 1;
        this.coefficient = coefficient;
    }
    
    public void compute(double x){
        System.out.println("when x = " + x);
        
        double ans =  coefficient[0]*Math.pow(x,coefficient.length - 1);
        System.out.print(coefficient[0] + "x^" + (coefficient.length - 1) + " ");
        
        //assume the coefficient array is arrange from higher order to lower order
        for(int i = 1 ; i < coefficient.length ; i++){
            int power = coefficient.length - i - 1;
            
            if(coefficient[i] > 0)
                System.out.print("+");
            System.out.print(coefficient[i]);
            
            if(power > 0) {
                System.out.print("x");
                if(power > 1)
                    System.out.print("^" + power);
            }
            System.out.print(" ");
            ans += coefficient[i]*Math.pow(x,coefficient.length - i - 1);
        }
        System.out.println("= " + ans);
    }
}

class testPolynomial{
    public static void main(String[] args) {
        double [] coefficient = {4.0,2.0,-0.5,-20.0};
        Polynomial p = new Polynomial(3, coefficient);
        p.compute(2.0);
        p.compute(-3.5);
    }
}

//Q3
class SimpleNetwork{
    private String name, IpAddress, subnetMask ,status;

    public SimpleNetwork(String name, String IpAddress, String subnetMask, String status) {
        this.name = name;
        this.IpAddress = IpAddress;
        this.subnetMask = subnetMask;
        this.status = status;
    }
    
    public static boolean pingValid(SimpleNetwork a , SimpleNetwork b){
        if(b.getStatus().equals("DOWN")){
            System.out.println(a.getName() + " cannot ping " + b.getName() + " because the destination " + b.getStatus() + " is down.");
            return false;
            
        }
        if(!a.getIpAddress().equals(b.getIpAddress()) || !a.getSubnetMask().equals(b.getSubnetMask())){
            System.out.println(a.getName() + " cannot ping " + b.getName() + " because the destination " + b.getName() + " is located in different network.");
            return false;
        }
        
        System.out.println(a.getName() + " can ping " + b.getName());
        return true;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public String getSubnetMask() {
        return subnetMask;
    }
    
    public void display(){
        System.out.println("Host Name: " + name + " IP: " + IpAddress + " Subnet Mask: " + subnetMask + " Status: " + status);
    }
}

class testSimpleNetwork{
    public static void main(String[] args) {
        //question wrong liao maybe, host 4 ip address no 5, i think so
        SimpleNetwork [] hostList = {new SimpleNetwork("Host 1", "10.1.1.1", "255.255.255.224", "UP"),
        new SimpleNetwork("Host 2", "10.1.1.2", "255.255.255.224", "DOWN"),new SimpleNetwork("Host 3", "10.1.1.70", "255.255.255.224", "UP")
        ,new SimpleNetwork("Host 4", "10.1.1.1", "255.255.255.224", "UP")};
        for(int i = 0 ; i < hostList.length ; i++){
            hostList[i].display();
        }
        
        for(int i = 1 ; i < hostList.length ; i++){
            SimpleNetwork.pingValid(hostList[0],hostList[i]);
        }
    }
}

//Q4 good luck 
abstract class banner{
    
}

class AG extends banner{

}

class HN extends banner{

}

class OT extends banner{

}

class UZ extends banner{

}

//Q5
interface FileIO{
    public static void writeFile(String fileName){
    }
    
    public static void readFile(String fileName){
    }
}

class TextFile implements FileIO{
    public static void writeFile(String fileName, String line){
        System.out.println("Write to text file");
        try{
            PrintWriter output = new PrintWriter(new FileOutputStream(fileName+".txt"));
            output.println(line);
            System.out.println(line);
            output.close();
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
    
    public static void readFile(String fileName){
        System.out.println("Read from text file");
        try{
            Scanner input = new Scanner(new FileInputStream(fileName+".txt"));
            while(input.hasNextLine()){
                System.out.println(input.nextLine());
            }
            input.close();
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
}

class BinaryFile implements FileIO{
    public static void writeFile(String fileName, String line){
        System.out.println("Write to binary file");
        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName+".dat"));
            System.out.println(line);
            output.writeUTF(line);
            output.close();
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
    
    public static void readFile(String fileName){
        System.out.println("Read from binary file");
        try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName+".dat"));
            try{
                while (true){
                    System.out.println(input.readUTF());
                }
            }catch(EOFException f){
            
            }
            input.close();
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
}

class testFileIO{
    public static void main(String[] args) {
        String fileName = "Lab1";
        String content = "Welcome to FSKTM!\nPlease register your matric number.\nPlease register your UMMail account.";
        TextFile.writeFile(fileName, content);
        TextFile.readFile(fileName);
        BinaryFile.writeFile(fileName, "Welcome to FSKTM!\nPlease register your matric number.\nPlease register your UMMail account.");
        BinaryFile.readFile(fileName);
    }
}
