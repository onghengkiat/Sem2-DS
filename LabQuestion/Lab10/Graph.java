package LabQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Graph<V extends Comparable<V>, E> {
    private GraphNode head;
    
    public Graph(){
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public int getSize(){
        int count = 0 ;
        GraphNode currentNode = head;
        while(currentNode != null){
            currentNode = currentNode.getVerticeLink();
            count ++;
        }
        return count;
    }
    
    public void clear(){
        head = null;
    }
    
    public void showGraph(){
        GraphNode currentNode = head;
        while(currentNode != null){
            System.out.println(currentNode.toString());
            Edge edgeNode = (Edge)currentNode.getEdgeLink();
            while(edgeNode != null){
                System.out.print(edgeNode.toString());
                edgeNode = edgeNode.getEdgeLink();
            }
            System.out.println("");
            currentNode = currentNode.getVerticeLink();
        }
    }
    
    public GraphNode hasVertice(V a){
        GraphNode currentNode = head;
        if(isEmpty()){
            return null;
        }else{
            while(currentNode != null){
                if(a.compareTo((V)currentNode.getVertice()) == 0){
                    return currentNode;
                }
                currentNode = currentNode.getVerticeLink();
            }
        }
        return null;
    }
    
    public void addVertice(V a){
        GraphNode newNode = new GraphNode(a,null);
        GraphNode currentNode = head;
        if(head == null){
            head = newNode;
        }else{
            while(currentNode.getVerticeLink() != null)
                currentNode = currentNode.getVerticeLink();
            currentNode.setVerticeLink(newNode);
        }
    }
    
    public void markVertice(V a){
        if(hasVertice(a) != null){
            GraphNode currentNode = head;
            while(currentNode != null){
                if(a.compareTo((V)currentNode.getVertice()) == 0){
                    currentNode.setMarked(true);
                    break;
                }else
                    currentNode = currentNode.getVerticeLink();
            }
        }
    }
    
    public boolean isMarked(V a){
        if(hasVertice(a) != null){
            GraphNode currentNode = head;
            while(currentNode != null){
                if(a.compareTo((V) currentNode.getVertice()) == 0){
                    return currentNode.getMarked();
                }else{
                    currentNode = currentNode.getVerticeLink();
                }
            }
        }
        return false;
    }
    
    public boolean addEdge(V from, V to , E weight){
        if(hasVertice(from) == null || hasVertice(to) == null)
            return false;
        else{
            GraphNode currentNode = head;
            while(currentNode != null){
                if(from.compareTo((V) currentNode.getVertice()) == 0){
                    GraphNode temp = hasVertice(to);
                    Edge newNode =new Edge(temp,weight, null);
                    Edge edgeNode = (Edge) currentNode.getEdgeLink();
                    if(edgeNode == null){
                        currentNode.setEdgeLink(newNode);
                    }else{
                        while(edgeNode.getEdgeLink() != null)
                            edgeNode = edgeNode.getEdgeLink();
                        edgeNode.setEdgeLink(newNode);
                    }
                    return true;
                }
                else
                    currentNode = currentNode.getVerticeLink();
            }
        }
        return false;
    }
    
    public boolean deleteEdge(V from, V to){
        if(!isEdge(from,to)){
            return false;
        }else{
            GraphNode currentNode = head;
            while(currentNode != null){
                if(from.compareTo((V)currentNode.getVertice()) == 0){
                    GraphNode temp = hasVertice(to);
                    Edge previousNode = null;
                    Edge edgeNode = (Edge)currentNode.getEdgeLink();
                    while(edgeNode != null){
                        if(edgeNode.getVerticeLink() == temp){
                            if(previousNode == null){
                                currentNode.setEdgeLink(edgeNode.getEdgeLink());
                            }else{
                                previousNode.setEdgeLink(edgeNode.getEdgeLink());
                            }
                            return true;
                        }else{
                            previousNode = edgeNode;
                            edgeNode = edgeNode.getEdgeLink();
                        }
                    }
                }else{
                    currentNode =currentNode.getVerticeLink();
                }
            }
        }
        return false;
    }
    
    public boolean isEdge(V from, V to){
        if(hasVertice(from) == null || hasVertice(to) == null)
            return false;
        else{
            GraphNode currentNode = head;
            while(currentNode != null){
                if(from.compareTo((V)currentNode.getVertice()) == 0){
                    GraphNode temp = hasVertice(to);
                    Edge edgeNode =(Edge) currentNode.getEdgeLink();
                    if(edgeNode == null)
                        return false;
                    else{
                        while(edgeNode != null){
                            if(edgeNode.getVerticeLink() == temp)
                                return true;
                            edgeNode = edgeNode.getEdgeLink();
                        }
                    }
                }else
                    currentNode = currentNode.getVerticeLink();
            }
        }
        return false;
    }
    
    public E getWeight(V from, V to){
        if(isEdge(from,to)){
            GraphNode currentNode = head;
            while(currentNode != null){
                if(from.compareTo((V)currentNode.getVertice()) == 0){
                    GraphNode temp = hasVertice(to);
                    Edge edgeNode = (Edge) currentNode.getEdgeLink();
                    while(edgeNode != null){
                        if(edgeNode.getVerticeLink() == temp){
                            return (E)edgeNode.getWeight();
                        }
                        edgeNode = edgeNode.getEdgeLink();
                    }
                }else
                    currentNode =currentNode.getVerticeLink();
            }
        }
        return null;
    }
    
    public ArrayList getAdjacent(V a){
        ArrayList<V> array = new ArrayList();
        if(hasVertice(a) != null){
            GraphNode currentNode = head;
            while(currentNode != null){
                if(a.compareTo((V)currentNode.getVertice()) == 0){
                    Edge edgeNode = (Edge) currentNode.getEdgeLink();
                    while(edgeNode != null){
                        array.add((V)edgeNode.getVerticeLink().getVertice());
                        edgeNode = edgeNode.getEdgeLink();
                    }
                    break;
                }else
                    currentNode = currentNode.getVerticeLink();
            }
        }
        return array;
    }
    
    //1
    public Stack<V> dfs(V from, V to){
        Stack<V> temp = new Stack<>();
        if(dfs(from,to,temp) == false){
            System.out.println("There is no path to reach there");
            return null;
        }
        
        Stack<V> list = new Stack<>();
        while(!temp.isEmpty()){
            list.push(temp.pop());
        }
        return list;
    }
    public boolean dfs(V from, V to,Stack<V> list){
        if(hasVertice(from) == null){
            list.pop();
            return false;
        }else{
            list.push(from);
            if(from == to){
                return true;
            }else{
                Edge edgeNode = (Edge) hasVertice(from).getEdgeLink();
                while(edgeNode != null){
                    if(dfs((V) edgeNode.getVerticeLink().getVertice(),to,list) == true){
                        return true;
                    }else{
                        list.pop();
                        edgeNode = edgeNode.getEdgeLink();
                    }
                }
                return false;
            }
        }
    }
    
    //2a
    public Queue<V> bfs(V from, V to){
        Queue<V> path = new Queue<>();
        Queue<V> frontier = new Queue<>();
        HashMap<V,V> parentList = new HashMap<>();
        frontier.enqueue(from);
        parentList.put(from,null);
        
        label:
        while(!frontier.isEmpty()){
            V parent = (V)frontier.dequeue();
            ArrayList<V> edgeList = getAdjacent(parent);
;            for(V vertice : edgeList){
                //if the vertice has be visted before
                if(parentList.get(vertice) != null){
                    continue;
                }
                //assigning parent for the vertice
                parentList.put(vertice, parent);
                //if it reachs the destination
                if(vertice == to){
                    break label;
                }
                frontier.enqueue(vertice);
            }
        }
        
        V currentVertice = to;
        
        if(parentList.get(currentVertice) == null){
            System.out.println("There is no path to reach " + to);
            return null;
        }
        
        Stack<V> temp = new Stack<>();
        while(currentVertice != null){
            temp.push(currentVertice);
            currentVertice = parentList.get(currentVertice);
        }
        while(!temp.isEmpty()){
            path.enqueue(temp.pop());
        }
        return path;
    }
    
    //2b
    public Queue<V> minCostPath(V from, V to){
        Queue<V> path = new Queue<>();
        PriorityQueue<BFSNode> frontier = new PriorityQueue<>();
        HashMap<V,V> parentList = new HashMap<>();
        
        frontier.add(new BFSNode(from,0));
        parentList.put(from,null);
        
        while(!frontier.isEmpty()){
            BFSNode<V> parentNode = frontier.remove();
            V parent = parentNode.getVertice();
            //if it reachs the destination
            if(parent == to){
                break;
            }
            Edge edgeNode = (Edge) hasVertice(parent).getEdgeLink();
            label:
            while(edgeNode!= null){
                V vertice = (V) edgeNode.getVerticeLink().getVertice();
                BFSNode newNode = new BFSNode(vertice,parentNode.getWeight()+(double)edgeNode.getWeight());
                for (BFSNode oldNode : frontier) {
                    if(oldNode.getVertice() == newNode.getVertice()){
                        if(oldNode.compareTo(newNode) >0){
                            frontier.remove(oldNode);
                            break;
                        }else{
                            edgeNode = edgeNode.getEdgeLink();
                            continue label;
                        }
                    }
                }
                //assigning parent for the vertice
                parentList.put(vertice, parent);
                frontier.add(newNode);
                edgeNode = edgeNode.getEdgeLink();
            }
        }
        
        V currentVertice = to;
        
        if(parentList.get(currentVertice) == null){
            System.out.println("There is no path to reach " + to);
            return null;
        }
        
        Stack<V> temp = new Stack<>();
        while(currentVertice != null){
            temp.push(currentVertice);
            currentVertice = parentList.get(currentVertice);
        }
        while(!temp.isEmpty()){
            path.enqueue(temp.pop());
        }
        return path;
    }
}

class BFSNode<V extends Comparable<V>> implements Comparable<BFSNode>{
    V vertice;
    double weight;

    public BFSNode(V vertice, double weight) {
        this.vertice = vertice;
        this.weight = weight;
    }

    public V getVertice() {
        return vertice;
    }

    public void setVertice(V vertice) {
        this.vertice = vertice;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(BFSNode o) {
        if(this.getWeight() > o.getWeight())
            return 1;
        else if(this.getWeight() < o.getWeight())
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return vertice.toString() + " ";
    }
    
}