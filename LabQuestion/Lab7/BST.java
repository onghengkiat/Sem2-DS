package LabQuestion;

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
            return find(a.getRightLink(),t);
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
    
    
    //Q1a
    public T getMinimum(){
        BSTNode currentNode = root;
        if(root == null)
            return null;
        while(currentNode.getLeftLink() != null){
            currentNode = currentNode.getLeftLink();
        }
        return (T)currentNode.getData();
    }
    
    
    //Q1b
    public T getMaximum(){
        BSTNode currentNode = root;
        if(root == null)
            return null;
        while(currentNode.getRightLink() != null){
            currentNode = currentNode.getRightLink();
        }
        return (T)currentNode.getData();
    }
    
    
    //Q1c 
    public Number getTotal(){
        if(root == null)
            return null;
        return getTotal(root);
    }
    
    public Number getTotal(BSTNode currentNode){
        T currentData = (T)currentNode.getData();
        if(currentData instanceof Integer){
            int sum = 0;
            if(currentNode.getLeftLink() != null && currentNode.getRightLink() != null){
                return (Integer)getTotal(currentNode.getRightLink()) + (Integer)getTotal(currentNode.getLeftLink()) + (Integer)currentData;
            }else if(currentNode.getLeftLink() != null){
                return (Integer)getTotal(currentNode.getLeftLink()) + (Integer)currentData;
            }
            else if(currentNode.getRightLink() != null){
                return (Integer)getTotal(currentNode.getRightLink()) + (Integer)currentData;
            }else{
                return (Integer)currentData;
            }
        }else if(currentData instanceof Double){
            int sum = 0;
            if(currentNode.getLeftLink() != null && currentNode.getRightLink() != null){
                return (Double)getTotal(currentNode.getRightLink()) + (Double)getTotal(currentNode.getLeftLink()) + (Double)currentData;
            }else if(currentNode.getLeftLink() != null){
                return (Double)getTotal(currentNode.getLeftLink()) + (Double)currentData;
            }
            else if(currentNode.getRightLink() != null){
                return (Double)getTotal(currentNode.getRightLink()) + (Double)currentData;
            }else{
                return (Integer)currentData;
            }
        }
        else
            return 0;
    }
    
    
    //Q1d
    public int getOccurrence(T a){
        return getOccurrence(a, root) ;
    }
    
    public int getOccurrence(T a,BSTNode currentNode){
        if(currentNode == null){
            return 0 ;
        }
        
        T currentData = (T)currentNode.getData();
        
        if(a.compareTo(currentData) > 0){
            return getOccurrence(a,currentNode.getRightLink());
        }else if(a.compareTo(currentData) < 0){
            return getOccurrence(a,currentNode.getLeftLink());
        }else{
            return 1 + getOccurrence(a,currentNode.getLeftLink());
        }
        
    }
}

