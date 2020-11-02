package TutorialQuestion;

public class HashTable <K,V>{
    private MapNode head;
    
    public HashTable(){
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public int getSize(){
        int count = 0;
        MapNode currentNode = head;
        while(currentNode != null){
            currentNode = currentNode.getLink();
            count++;
        }
        return count;
    }
    
    public void showHashTable(){
        MapNode currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
    }
    
    public void clear(){
        head = null;
    }
    
    public V put(Comparable <K> k , V v){
        if(isEmpty()){
            head = new MapNode(k,v,null);
        }else{
            MapNode newNode = new MapNode(k,v,null);
            MapNode currentNode =head;
            MapNode previousNode = null;
            while(currentNode != null){
                if(k.compareTo((K)currentNode.getKey())==0){
                    V temp = (V)currentNode.getValue();
                    currentNode.setValue(v);
                    return temp;
                }else{
                    previousNode = currentNode ;
                    currentNode = currentNode.getLink();
                }
            }
            if(previousNode == null){
                newNode.setLink(head);
                head = newNode;
            }else{
                previousNode.setLink(newNode);
                newNode.setLink(currentNode);
            }
        }
        return null;
    }
    
    public V remove(Comparable<K>k){
        if(isEmpty()){
            return null;
        }else{
            MapNode currentNode = head;
            MapNode previousNode = null;
            boolean found = false;
            while(currentNode != null){
                if(k.compareTo((K)currentNode.getKey()) == 0){
                    found = true;
                    break;
                }else{
                    previousNode = currentNode;
                    currentNode = currentNode.getLink();
                }
            }
            
            if(found){
                V temp = (V)currentNode.getValue();
                if(previousNode == null)
                    head = head.getLink();
                else{
                    previousNode.setLink(currentNode.getLink());
                }
                return temp;
            }else
                return null;
        }
    }
    
    public V get(Comparable<K> k){
        MapNode currentNode = head;
        while(currentNode != null){
            if(k.compareTo((K)currentNode.getKey()) == 0){
                return (V)currentNode.getValue();
            }else{
                currentNode = currentNode.getLink();
            }
        }
        return null;
    }
    
    public boolean containsKey(Comparable<K> k){
        MapNode currentNode =head;
        while(currentNode != null){
            if(k.compareTo((K)currentNode.getKey()) == 0){
                return true;
            }else{
                currentNode = currentNode.getLink();
            }
        }
        return false;
    }
    
    public boolean containsValue(Comparable<V> v){
        MapNode currentNode = head;
        while(currentNode != null){
            if(v.compareTo((V)currentNode.getValue()) == 0)
                return true;
            else
                currentNode = currentNode.getLink();
        }
        return false;
    }
}
