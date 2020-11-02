package LabQuestion;

public class MapNode <K,V> implements Comparable<MapNode<K,V>>{
    private K key;
    private V value;
    
    public MapNode(){
        key = null;
        value = null;
    }

    public MapNode(K key, V value) {
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
        return key + " : " + value;
    }

    @Override
    public int compareTo(MapNode o) {
        return this.key.hashCode() - o.key.hashCode();
    }
}
