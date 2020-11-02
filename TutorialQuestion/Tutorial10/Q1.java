package TutorialQuestion;

import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        System.out.println("Creating a graph with 7 vertices and 7 edges");
        ArrayGraph<Character> graph = new ArrayGraph<>();
        graph.addVertice('A');
        graph.addVertice('B');
        graph.addVertice('C');
        graph.addVertice('D');
        graph.addVertice('E');
        graph.addVertice('F');
        graph.addVertice('G');
        graph.addEdge('A', 'B', 0.4);
        graph.addEdge('A', 'C', 0.3);
        graph.addEdge('B', 'C', 0.1);
        graph.addEdge('B', 'D', 0.2);
        graph.addEdge('B', 'E', 0.7);
        graph.addEdge('C', 'F', 0.3);
        graph.addEdge('F', 'G', 0.4);
        graph.showGraph();
        
        System.out.println("Remove edge from B to C");
        graph.deleteEdge('B','C');
        graph.showGraph();
        System.out.println("The weightage from C to F: " + graph.getWeight('C','F'));
        System.out.print("The adjacent of B : ");
        ArrayList<Character> adjacent = graph.getAdjacent('B');
        for(char a : adjacent)
            System.out.print(a + " ");
    }
    
}
