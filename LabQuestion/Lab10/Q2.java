package LabQuestion;

public class Q2 {
    public static void main(String[] args) {
        System.out.println("Creating a graph with 8 vertices and 10 edges");
        Graph a = new Graph();
        a.addVertice('A');
        a.addVertice('B');
        a.addVertice('C');
        a.addVertice('D');
        a.addVertice('E');
        a.addVertice('F');
        a.addVertice('G');
        a.addVertice('H');
        a.addEdge('A', 'B', 0.4);
        a.addEdge('A', 'C', 0.7);
        a.addEdge('A', 'G', 0.8);
        a.addEdge('B', 'C', 0.1);
        a.addEdge('B', 'D', 0.2);
        a.addEdge('B', 'E', 0.7);
        a.addEdge('C', 'F', 0.3);
        a.addEdge('E', 'H', 0.5);
        a.addEdge('F', 'H', 0.4);
        a.addEdge('G', 'H', 0.8);
        System.out.println("Creating a graph with 7 vertices and 6 edges");
        a.showGraph();
        System.out.println("The shortest path from A - H by distance");
        Queue path = a.bfs('A', 'H');
        if(path != null)
            path.showQueue();
        
        System.out.println("\nThe shortest path from A - H by cost");
        path = a.minCostPath('A', 'H');
        if(path != null)
            path.showQueue();
        
    }
    
}
