package LabQuestion;

public class Edge<E> {
    private GraphNode verticeLink;
    private Edge edgeLink;
    private E weight;
    
    public Edge(){
        verticeLink = null;
        weight = null;
        edgeLink = null;
    }
    
    public Edge(GraphNode a, E b ,Edge c){
        verticeLink = a;
        weight = b;
        edgeLink = c;
    }

    public GraphNode getVerticeLink() {
        return verticeLink;
    }

    public void setVerticeLink(GraphNode verticeLink) {
        this.verticeLink = verticeLink;
    }

    public Edge getEdgeLink() {
        return edgeLink;
    }

    public void setEdgeLink(Edge edgeLink) {
        this.edgeLink = edgeLink;
    }

    public E getWeight() {
        return weight;
    }

    public void setWeight(E weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return " -> " + verticeLink.getVertice() + " : " + weight;
    }
}
