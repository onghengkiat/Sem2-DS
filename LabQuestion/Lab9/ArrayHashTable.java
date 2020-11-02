package LabQuestion;

public class ArrayHashTable <K,V>{
    private MapNode <K,V>[] arr ; 
    
    //3a
    public ArrayHashTable(){
        arr = new MapNode[20];
    }
    
    
    //3b
    public boolean isEmpty(){
        return arr[0] == null;
    }
    
    //3c
    public boolean isFull(){
        return getSize() ==20;
    }
    
    //3d
    public int getSize(){
        int count = 0;
        for(int i = 0 ; i < arr.length ; i ++){
            if(arr[i] == null){
                return count;
            }
            count ++;
        }
        return count;
    }

    //3e
    public void clear(){
        arr = null;
    }
    
    //3f    
    public void showHashTable(){
        for(int i =0 ; i < getSize(); i++){
            System.out.print(arr[i].toString() + " | ");
        }
    }
    
    //3g
    public boolean containsKey(Comparable<K> k){
        for(int i = 0 ; i < getSize() ; i++){
            if(arr[i].getKey().equals(k))
                return true;
        }
        return false;
    }
    
    
    //3h
    public boolean containsValue(Comparable<V> v){
        for(int i = 0 ; i < getSize() ; i++){
            if(arr[i].getValue().equals(v))
                return true;
        }
        return false;
    }
    
    //3i
    public V get(Comparable<K> k){
        for(int i = 0 ; i < getSize() ; i++){
            if(arr[i].getKey().equals(k))
                return arr[i].getValue();
        }
        return null;
    }
    
    //3j
    public V put(Comparable <K> k , V v){
        MapNode newNode = new MapNode(k,v);
        if(isFull()){
            return null;
        }else{
            for(int i = 0 ; i <= getSize () ; i ++){
                if(arr[i] == null){
                    arr[i] = newNode;
                    return v;
                }else if(arr[i].getKey().equals(k)){
                    arr[i] = newNode;
                    return v;
                }
            }
        }
        return null;
    }
    
    //3k
    public V remove(Comparable<K>k){
        for(int i =0 ; i < getSize() ; i ++){
            if(arr[i].getKey().equals(k)){
                arr[i] = arr[getSize() - 1];
                arr[getSize() - 1] = null;
                return arr[i].getValue();
            }
        }
        return null;
    }
}
