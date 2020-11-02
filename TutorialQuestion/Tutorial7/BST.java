package TutorialQuestion;

public class BST<T extends Comparable<T>> {
    private BSTNode root;
    private boolean found ;
    
    public BST(){
        root = null;
    }
    
    public boolean isEmpty(){
        return (root == null);
    }
    
    public int getSize(){
        return getSize(root);
    }
    
    public int getSize(BSTNode<T> a){
        if(a == null)
            return 0;
        else
            return getSize(a.getLeftLink()) + getSize(a.getRightLink()) +1;
    }
    
    public boolean contains(T t){
        return find(root,t);
    }
    
    public boolean find(BSTNode<T>a , T t){
        if(a == null )
            return false;
        else if(t.compareTo(a.getData())<0)
            return find(a.getLeftLink(),t);
        else if(t.compareTo(a.getData())>0)
            return find(a.getLeftLink(),t);
        else
            return true;
    }
    
    public T getElement(T t){
        return (T)getElement(root,t);
    }
    
    public T getElement(BSTNode <T> a, T t){
        if(a ==null)
            return null;
        else if(t.compareTo(a.getData())<0)
            return (T)getElement(a.getLeftLink(),t);
        else if(t.compareTo(a.getData())>0)
            return (T)getElement(a.getRightLink(),t);
        else
            return a.getData();
    }
    
    public void addNode(T t){
        root = add(root,t);
    }
    
    public BSTNode<T> add(BSTNode<T> a, T t){
        if(a == null)
            a = new BSTNode<T>(t, null ,null);
        else if(t.compareTo(a.getData()) <= 0)
            a.setLeftLink(add(a.getLeftLink(),t));
        else
            a.setRightLink(add(a.getRightLink(),t));
        return a;
    }
    
    public boolean remove (T t){
        root = remove(root ,t);
        return found;
    }

    public BSTNode<T> remove(BSTNode<T> a , T t){
        if( a == null)
            found = false;
        else if(t.compareTo(a.getData()) < 0)
            a.setLeftLink(remove(a.getLeftLink(),t));
        else if(t.compareTo(a.getData())>0)
            a.setRightLink(remove(a.getRightLink(),t));
        else{
            a = removeNode(a);
            found = true;
        }
        return a;
    }
    
    public BSTNode <T> removeNode (BSTNode<T>a){
        if(a.getLeftLink() == null)
            return a.getRightLink();
        else if(a.getRightLink () == null)
            return a.getLeftLink();
        else{
            T t = (T)getPredecessor(a.getLeftLink());
            a.setData(t);
            a.setLeftLink(remove(a.getLeftLink(),t));
            return a;
        }
    }
    
    public T getPredecessor(BSTNode <T> a){
        while(a.getRightLink()!=null)
            a = a.getRightLink();
        return a.getData();
    }
    
    public static final int PREORDER = 1;
    public static final int INORDER = 2;
    public static final int POSTORDER = 3;
    private Queue<T> Q ;
    private int traverse;
    
    public void showTree(){
        Q.showQueue();
    }
    
    public void setOrder(int a){
        traverse = a;
        Q = new Queue<>();
        if(traverse == INORDER)
            inOrder(root);
        else if(traverse == PREORDER)
            preOrder(root);
        else
            postOrder(root);
    }
    
    public void preOrder(BSTNode<T>a){
        if(a!= null){
            Q.enqueue(a.getData());
            preOrder(a.getLeftLink());
            preOrder(a.getRightLink());
        }
    }
    
    public void inOrder(BSTNode<T>a){
        if(a!= null){
            inOrder(a.getLeftLink());
            Q.enqueue(a.getData());
            inOrder(a.getRightLink());
        }
    }
    
    public void postOrder(BSTNode<T>a){
        if(a!= null){
            postOrder(a.getLeftLink());
            postOrder(a.getRightLink());
            Q.enqueue(a.getData());
        }
    }
}

