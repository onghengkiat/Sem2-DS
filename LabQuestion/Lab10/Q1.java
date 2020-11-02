package LabQuestion;

public class Q1 {
    public static void main(String[] args) {
        Graph a = new Graph();
        a.addVertice('A');
        a.addVertice('B');
        a.addVertice('C');
        a.addVertice('D');
        a.addVertice('E');
        a.addVertice('F');
        a.addVertice('G');
        a.addEdge('A', 'B', 1);
        a.addEdge('A', 'C', 1);
        a.addEdge('B', 'D', 1);
        a.addEdge('B', 'E', 1);
        a.addEdge('C', 'F', 1);
        a.addEdge('F', 'G', 1);
        System.out.println("Creating a graph with 7 vertices and 6 edges");
        a.showGraph();
        System.out.println("Find the path from A to G");
        Stack path = a.dfs('F', 'B');
        if(path != null)
            path.showStack();
        
    }
    
}