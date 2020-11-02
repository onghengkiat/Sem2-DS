package LabQuestion;

import java.util.Arrays;


public class BSTExpression {
    private Node root ;
    private int stopIndex;
    public BSTExpression(char[] infix){
        root = addNode(infix);
        stopIndex = infix.length - 1;
    }
    
    public boolean isEmpty(){
        return (root == null);
    }
    
    public int getSize(){
        return getSize(root);
    }
    
    public int getSize(Node a){
        if(a == null)
            return 0;
        else
            return getSize(a.getLeft()) + getSize(a.getRight()) +1;
    }
    
    public Node addNode(char[] infix){
        root = new Node(null,null,null,infix[infix.length - 1]);
        Node currentNode = root;
        int priority = 0;
        
        for(int i = infix.length - 2 ; i >= 0 ; i --){
            if(infix[i] == '+' || infix[i] == '-' || infix[i] == '*' || 
                    infix[i] == '/' || infix[i] == '%'){
                if(priority >= getPriority(infix[i]) || priority == 0){
                    Node newNode = new Node(null,currentNode,null,infix[i]);
                    currentNode.setParent(newNode);
                    currentNode = newNode;
                    priority = getPriority(infix[i]);
                }else{
                    char [] subArr = Arrays.copyOf(infix,i + 2);
                    currentNode.setRight(addNode(subArr));
                    currentNode.getRight().setParent(currentNode);
                    return findRoot();
                }
            }else if(infix[i] == ')'){
                char [] subArr = Arrays.copyOf(infix,i);
                currentNode.setRight(addNode(subArr));
                currentNode.getRight().setParent(currentNode);
                while(currentNode.getRight() != null){
                    currentNode = currentNode.getRight();
                }
                currentNode = currentNode.getParent();
                i = stopIndex;
            }else if(infix[i] == '('){
                stopIndex = i - 1;
                return findRoot();
            }else {
                Node newNode = new Node(currentNode,null,null,infix[i]);
                currentNode.setRight(newNode);
            }
        }
        return findRoot();
    }
    
    public int getPriority(char c){
        if(c == '+' || c == '-')
            return 1;
        else if(c == '*' || c == '/' || c == '%')
            return 2;
        else if(c == ')')
            return 3;
        else
            return 0;
    }
    
    public Node findRoot(){
        while(root.getParent() != null)
            root = root.getParent();
        return root;
    }
    
    public static final int PREORDER = 1;
    public static final int INORDER = 2;
    public static final int POSTORDER = 3;
    private Stack<Character> S ;
    private int traverse;
    
    public void showTree(){
        S.showStack();
    }
    
    public void setOrder(int a){
        traverse = a;
        S = new Stack<>();
        if(traverse == INORDER)
            inOrder(root);
        else if(traverse == PREORDER)
            preOrder(root);
        else
            postOrder(root);
    }
    
    public void preOrder(Node a){
        if(a!= null){
            S.push(a.getData());
            preOrder(a.getLeft());
            preOrder(a.getRight());
        }
    }
    
    public void inOrder(Node a){
        if(a!= null){
            inOrder(a.getLeft());
            S.push(a.getData());
            inOrder(a.getRight());
        }
    }
    
    public void postOrder(Node a){
        if(a!= null){
            postOrder(a.getLeft());
            postOrder(a.getRight());
            S.push(a.getData());
        }
    }
    
    public boolean isOperator(char c) { 
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') { 
            return true; 
        } 
        return false; 
    }
}



class Node{
    private Node parent ;
    private Node left ; 
    private Node right;
    private Character data;

    public Node(Node parent, Node left, Node right, Character data) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Character getData() {
        return data;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setData(Character data) {
        this.data = data;
    }
    
}
