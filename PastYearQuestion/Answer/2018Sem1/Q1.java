package PastYear;

public class Q1 {
    public static void main(String[] args) {
        //a
        //Assume n as the total number of discs. Firstly, move n-1 discs from first pole to the free pole.
        //Then move 1 disc from the first pole to the third pole which is from starting point to destination.
        //After that, move n-1 disc from free pole to destination.
        //Repeat this process until there is only 1 disc left,n= 1 (except the disc that already reach destination)
        
        towerOfHanoi(3,"pole 1","pole 3","pole 2",2);
    }
    
    
    //b
    static int step = 0;
    public static void towerOfHanoi(int n, String from, String to, String free,int disc){
        if(n == 1){
            step ++;
            System.out.println("Step " + step + ": Move disc " + disc + " from " + from + " to " + to);
        }else if(n > 1){
            towerOfHanoi(n-1,from,free,to,n-1);
            towerOfHanoi(1,from,to,free,n);
            towerOfHanoi(n-1,free,to,from,n-1);
        }
    }
    
}
