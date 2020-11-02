package TutorialQuestion;

import java.util.ArrayList;

public class ArrayGraph<V extends Comparable<V>> {
    private V [] graph;
    private double [][] weight;
    private boolean [] mark;
    
    //a
    public ArrayGraph(){
        graph = (V[]) new Comparable[20];
        weight = new double[20][20];
        mark = new boolean[20];
    }
    
    //b
    public boolean isEmpty(){
        return graph[0] == null;
    }
    
    //c
    public boolean isFull(){
        return graph[19] != null;
    }
    
    //d
    public int getVerticeSize(){
        int count = 0 ;
        for(int i = 0 ; i < 20 ; i++){
            if(graph[i] != null){
                count ++;
            }else{
                return count;
            }
        }
        return count;
    }
    
    //e
    public void clear(){
        graph = (V[]) new Object[20];
        weight = new double[20][20];
        mark = new boolean[20];
    }
    
    
    //f
    public void addVertice(V a){
        graph[getVerticeSize()] = a;
    }
    
    //g
    public int hasVertice(V a){
        for(int i = 0 ; i < getVerticeSize() ; i ++){
            if(graph[i] == a){
                return i;
            }
        }
        return -1;
    }
    
    //h
    public boolean addEdge(V from, V to, double weight){
        int indexFrom = hasVertice(from);
        int indexTo = hasVertice(to);
        if(indexFrom == -1 || indexTo == -1){
            return false;
        }else{
            this.weight[indexFrom][indexTo] = weight;
            return true;
        }
    }
    
    //i
    public boolean deleteEdge(V from, V to){
        int indexFrom = hasVertice(from);
        int indexTo = hasVertice(to);
        if(indexFrom == -1 || indexTo == -1){
            return false;
        }else{
            this.weight[indexFrom][indexTo] = 0;
            return true;
        }
    }
    
    //j
    public boolean isEdge(V from, V to){
        int indexFrom = hasVertice(from);
        int indexTo = hasVertice(to);
        if(indexFrom == -1 || indexTo == -1){
            return false;
        }else{
            if(weight[indexFrom][indexTo] == 0)
                return false;
            else
                return true;
        }
    }
    
    //k
    public double getWeight(V from, V to){
        int indexFrom = hasVertice(from);
        int indexTo = hasVertice(to);
        if(indexFrom == -1 || indexTo == -1){
            return 0;
        }else{
            return weight[indexFrom][indexTo];
        }
    }
    
    //l
    public void markVertice(V a){
        int index = hasVertice(a);
        if(index != -1)
            mark[index] = true;
    }
    
    //m
    public boolean isMarked(V a){
        int index = hasVertice(a);
        if(index == -1)
            return false;
        else
            return mark[index];
    }
    
    //n
    public ArrayList getAdjacent(V a){
        ArrayList<V> array = new ArrayList();
        int index = hasVertice(a);
        for(int i  = 0 ; i < 20; i ++){
            if(weight[index][i] != 0)
                array.add(graph[i]);
        }
        return array;
    }
    
    public void showGraph(){
        for(int i = 0 ; i < getVerticeSize() ; i++){
            System.out.println(graph[i] + " -->");
            for(int j = 0 ; j < 20 ; j ++){
                if(weight[i][j] != 0)
                    System.out.print(" -> " + graph[j] + " : " + weight[i][j] );
            }
            System.out.println("");
        }
    }
}
