package LabQuestion;

public class ArrayHashTableHashing <K,V>{
    private MapNode <K,V>[] arr ; 
    
    //3a
    public ArrayHashTableHashing(){
        arr = new MapNode[20];
    }
    
    
    //3b
    public boolean isEmpty(){
        return getSize() == 0;
    }
    
    //3c
    public boolean isFull(){
        return getSize() == arr.length;
    }
    
    //3d
    public int getSize(){
        int count = 0;
        for(int i = 0 ; i < arr.length ; i ++){
            if(arr[i] != null){
                count ++;
            }
        }
        return count;
    }

    //3e
    public void clear(){
        arr = null;
    }
    
    //3f    
    public void showHashTable(){
        for(int i =0 ; i < arr.length; i++){
            if(arr[i] != null)
                System.out.println(arr[i].toString());
        }
    }
    
    //3g//4a
    public boolean containsKey(Comparable<K> k){
        int position = k.hashCode()%arr.length;
        if(arr[position] == null)
            return false;
        
        while(!arr[position].getKey().equals(k)){
            if(position >= arr.length-1){
                position = 0;
            }else{
                position ++;
            }
            
            if(position == k.hashCode()%arr.length || arr[position] == null){
                return false;
            }
            
        }
        return true;
    }
    
    
    //3h
    public boolean containsValue(Comparable<V> v){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != null)
                if(arr[i].getValue().equals(v))
                    return true;
        }
        return false;
    }
    
    //3i
    public V get(Comparable<K> k){
        if(!containsKey(k)){
            return null;
        }else{
            int position = k.hashCode()%arr.length;
            while(!arr[position].getKey().equals(k)){
                if(position >= arr.length - 1){
                    position = 0;
                }else{
                    position ++;
                }
            }
            return arr[position].getValue();
        }
    }
    
    //3j
    public V put(Comparable <K> k , V v){
        MapNode newNode = new MapNode(k,v);
        if(isFull()){
            return null;
        }else{
            int position = k.hashCode()%arr.length;
            while(arr[position] != null){
                if(position >= arr.length - 1){
                    position = 0;
                }else{
                    position ++;
                }
            }
            arr[position] = newNode;
            return v;
        }
    }
    
    //3k
    public V remove(Comparable<K>k){
        if(!containsKey(k)){
            return null;
        }else{
            int position = k.hashCode()%arr.length;
            while(!arr[position].getKey().equals(k)){
                if(position >= arr.length - 1){
                    position = 0;
                }else{
                    position ++;
                }
            }
            return arr[position].getValue();
        }
    }
    
    //4b
    public int location(Comparable<K>k){
        int count = 0;
        for(int i = 0 ; i < arr.length ; i ++){
            if(arr[i] != null){
                if(arr[i].getKey().equals(k))
                    return count;
                count ++;
            }
        }
        return count;
    }
}
