package TutorialQuestion;

public class MapNode <K,V>{
    private K key;
    private V value;
    private MapNode link;
    
    public MapNode(){
        key = null;
        value = null;
        link = null;
    }

    public MapNode(K key, V value, MapNode link) {
        this.key = key;
        this.value = value;
        this.link = link;
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

    public MapNode getLink() {
        return link;
    }

    public void setLink(MapNode link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return key + ":" + value + " --> " ;
    }
}
