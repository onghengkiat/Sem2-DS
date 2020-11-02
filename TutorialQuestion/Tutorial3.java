package TutorialQuestion;
public class Tutorial3 {
    //Q1a
    public static int smallest(int [] elements ){
        if(elements.length > 1)
            return smallest(elements, 1, elements[0]);
        else if(elements.length == 1)
            return elements[0];
        else
            return 0;
    }
    
    public static int smallest(int[] elements, int i , int min){
        if(i > elements.length - 1){
            return min;
        }else{
            if(elements[i] - min < 0)
                return smallest(elements,i + 1,elements[i]);
            else
                return smallest(elements,i + 1,min);
        }
    }
    
    //Q1b
    public static int sum(int [] elements ){
        if(elements.length > 1)
            return sum(elements, 1, elements[0]);
        else if(elements.length == 1)
            return elements[0];
        else
            return 0;
    }
    
    public static int sum(int[] elements, int i , int sum){
        if(i > elements.length - 1){
            return sum;
        }else{
            return sum(elements, i + 1, sum + elements[i]);
        }
    }
    
    //Q1c
    public static int GCD(int x, int y){
        if(y == 0){
            return x;
        }else{
            return GCD(y,x%y);
        }
    }
    
    //Q1d
    public static String convertToBinary(int decimal){
        if(decimal > 1){
            return convertToBinary("", decimal);
        }else{
            return Integer.toString(decimal);
        }
    
    }
    public static String convertToBinary(String binary,int decimal){
        if(decimal == 0 ){
            return reverseString(binary);
        }else{
            return convertToBinary(binary += decimal%2, decimal/2);
        }
    }
    
    public static String reverseString(String str){
        String temp = "";
        for(int i = str.length() - 1; i >= 0 ; i--){
            temp += str.charAt(i);
        }
        return temp;
    }
    
    //Q1e
    public static double sumOfCubes(int n ){
        //n/Math.abs(n) = sign
        if(Math.abs(n) < 2)
            return Math.pow(n,3);
        else
            return sumOfCubes(n,2*n/Math.abs(n),Math.pow(1*n/Math.abs(n),3));
    }
    
    public static double sumOfCubes(int n , int i , double sum){
        if(i == n)
            return sum + Math.pow(n,3);
        else{
            return sumOfCubes(n,(Math.abs(i)+1)*i/Math.abs(i),sum + Math.pow(i,3));
        }
        
    }
    
    //Q2
    public static int Acker(int m , int n){
        if(m == 0 ){
            return n + 1;
        }else if(n == 0 ){
            return Acker(m-1,1);
        }else{
            return Acker(m-1, Acker(m,n-1));
        }
    }
    
    //Q3 
    public static void writeLine(char character , int times){
        if(times != 0){
            System.out.print(character);
            writeLine(character , times-1);
        }
    }
    
    
    public static void writeBlock(char character, int times, int lines){
        if(lines != 0){
            writeLine(character, times );
            System.out.println("");
            writeBlock(character , times, lines-1);
        }
    }
    
    public static void main(String[] args) throws exception {
        //Q2
        System.out.println(Acker(3,4));
        System.out.println(Acker(2,5));
        
        //Q3
        writeBlock('$',3,2);
        
        //Q4
        try{
            String str1 = "123456789012";
            if(str1.length()>12)
                throw new exception("More than 12 liao");
            System.out.println(str1);
            
            String str2 = "1234567890123";
            if(str2.length()>12)
                throw new exception("More than 12 liao");
            System.out.println(str2);
            
            String str3 = "4567890123";
            if(str3.length()>12)
                throw new exception("More than 12 liao");
            System.out.println(str3);
            
        }catch(exception e){
            System.out.println(e);
        }
    }
}

//Q4
class exception extends Exception{
    private String str ; 

    public exception(String message) {
        super(message);
    }
}
