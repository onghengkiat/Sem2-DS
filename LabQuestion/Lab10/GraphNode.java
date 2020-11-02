package LabQuestion;

public class GraphNode <V,E>{
    private V vertice;
    private GraphNode verticeLink;
    private E edgeLink;
    private boolean marked;
    
    public GraphNode(){
        vertice = null;
        verticeLink = null;
        edgeLink = null;
        marked = false;
    }
    
    public GraphNode(V a, GraphNode b){
        vertice = a;
        verticeLink = b;
        edgeLink = null;
        marked = false;
    }

    public V getVertice() {
        return vertice;
    }

    public void setVertice(V vertice) {
        this.vertice = vertice;
    }

    public GraphNode getVerticeLink() {
        return verticeLink;
    }

    public void setVerticeLink(GraphNode verticeLink) {
        this.verticeLink = verticeLink;
    }

    public E getEdgeLink() {
        return edgeLink;
    }

    public void setEdgeLink(E edgeLink) {
        this.edgeLink = edgeLink;
    }

    public boolean getMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    @Override
    public String toString() {
        return vertice + " --> ";
    }
    
    
}
