package LabQuestion;

public class ArrayHashTableHashChain <K,V>{
    private LinkedList<MapNode<K,V>>[] arr ; 
    
    public ArrayHashTableHashChain(){
        arr = new LinkedList[20];
    }
    
    
    public boolean isEmpty(){
        return getSize() == 0;
    }
    
    public boolean isFull(){
        return getSize() == arr.length;
    }
    
    public int getSize(){
        int count = 0;
        for(int i = 0 ; i < arr.length ; i ++){
            if(arr[i] != null){
                count += arr[i].length();
            }
        }
        return count;
    }

    public void clear(){
        arr = null;
    }
    
    public void showHashTable(){
        for(int i =0 ; i < arr.length; i++){
            if(arr[i] != null)
                System.out.println(arr[i].toString());
        }
    }
    
    public boolean containsKey(Comparable<K> k){
        int position = k.hashCode()%arr.length;
        if(arr[position] == null)
            return false;
        
        LinkedList<MapNode<K,V>> list = arr[position];
        MapNode <K,V>m = new MapNode(k,null);
        return list.contains(m);
    }
    
    
    public boolean containsValue(Comparable<V> v){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != null){
                LinkedList<MapNode<K,V>> list = arr[i];
                for(int j = 0; j < list.length() ; j++){
                    if(list.get(j).getValue().equals(v))
                        return true;
                }
            }
        }
        return false;
    }
    
    public V get(Comparable<K> k){
        if(!containsKey(k)){
            return null;
        }else{
            int position = k.hashCode()%arr.length;
            LinkedList<MapNode<K,V>> list = arr[position];
            MapNode <K,V>m = new MapNode(k,null);
            return list.get(list.indexOf(m)).getValue();
        }
    }
    
    public V put(Comparable <K> k , V v){
        MapNode newNode = new MapNode(k,v);
        int position = k.hashCode()%arr.length;
        if(arr[position] == null){
            LinkedList<MapNode<K,V>> newList = new LinkedList<>();
            arr[position] = newList;
        }
        System.out.println(newNode);
        arr[position].addNode(newNode);
        return v;
    }
    
    public V remove(Comparable<K>k){
        if(!containsKey(k)){
            return null;
        }else{
            int position = k.hashCode()%arr.length;
            LinkedList<MapNode<K,V>> list = arr[position];
            MapNode <K,V>m = new MapNode(k,null);
            V temp = list.get(list.indexOf(m)).getValue();
            list.deleteNodeByPosition(list.indexOf(m));
            return temp;
        }
    }
    
    public void location(Comparable<K>k){
        int position = k.hashCode()%arr.length;
        LinkedList<MapNode<K,V>> list = arr[position];
        list.showList();
        System.out.println("");
    }
}
