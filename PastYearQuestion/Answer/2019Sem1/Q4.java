package PastYear;

public class Q4 {
    public static void main(String[] args) {
        MyHashMap<String,String> myHashMap = new MyHashMap<>();
        myHashMap.put("BruceW","011-8998990");
        myHashMap.put("DeanW","017-2274000");
        myHashMap.put("TonyS","019-4550800");
        myHashMap.put("LaraC","014-6402009");
        
        String e1 = myHashMap.get("DeanW");
        System.out.println("Value: " + e1);
        String e2 = myHashMap.get("TonyS");
        System.out.println("Value: " + e2);
        
        myHashMap.put("BruceW","011-5677900");
        String e3 = myHashMap.get("BruceW");
        System.out.println("Value: " + e3);
        
        myHashMap.put("JeanG","019-9001123");
        String e4 = myHashMap.get("JeanG");
        System.out.println("Value: " + e4);
        
    }
}

class MyHashMap<K,V>{
    HashNode <K,V> [] map ;
    //i
    public MyHashMap(){
        map = new HashNode[200000];
    }
    
    //ii
    public V get(K key){
        int index = key.hashCode()% map.length;
        while(!map[index].getKey().equals(key)){
            if(index == map.length - 1){
                index = 0 ;
            }else{
                index ++;
            }
            if(map[index] == null)
                return null;
        }
        
        return map[index].getValue();
    }
    //iii
    public void put(K key,V value){
        int index = key.hashCode()%map.length;
        while(map[index] != null){
            if(index == map.length - 1){
                index = 0 ;
            }else{
                index ++;
            }
        }
        map[index] = new HashNode(key,value);
    }
}

class HashNode<K,V>{
    private K key;
    private V value;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
    
}