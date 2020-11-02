package TutorialQuestion;

public class ArrayBST<T extends Comparable<T>> {
    private T [] bst ;
    
    
    //3a
    public ArrayBST(){
        bst = (T[])new Comparable [20]; 
    }
    
    
    //3b
    public boolean isEmpty(){
        return (bst[0] == null);
    }
    
    
    //3c
    public int getSize(){
        int size = 0;
        for (T bst1 : bst) {
            if (bst1 != null) {
                size ++;
            }
        }
        return size;
    }
    
    
    //3d
    public int getHeight(){
        int height = 0;
        for(int i = 0; i < bst.length ; i ++){
        }
        return height;
    }
    
    
    //3e
    public void addNode(T a){
        if(bst[0] == null){
            bst[0] = a;
        }else{
            if(a.compareTo(bst[0]) > 0){
                addNode(a,2);
            }else{
                addNode(a,1);
            }
        }
    }
    
    public void addNode(T a, int index){
        if(bst[index] == null){
            bst[index] = a;
        }else{
            if(a.compareTo(bst[index]) > 0){
                addNode(a,index*2+2);
            }else{
                addNode(a,index*2+1);
            }
        }
    }
    
    //3f
    public void preOrder(int index){
        if(index<20){
            if(bst[index] != null ){
                System.out.print(bst[index] + " ");
                preOrder(index*2+1);
                preOrder(index*2+2);
            }
        }
    }
    
    //3g
    public void inOrder(int index){
        if(index<20){
            if(bst[index] != null ){
                inOrder(index*2+1);
                System.out.print(bst[index] + " ");
                inOrder(index*2+2);
            }
        }
    }
    
    //3h
    public void postOrder(int index){
        if(index<20){
            if(bst[index] != null){
                postOrder(index*2+1);
                postOrder(index*2+2);
                System.out.print(bst[index] + " ");
            }
        }
    }
    
    
    //3i
    public boolean removeNode(T a){
        return removeNode(a,0);
    }
    
    public boolean removeNode(T a, int index){
        if(index >= 20){
            return false;
        }else if(bst[index] == null){
            return false;
        }else if(a.compareTo(bst[index])>0){
            return removeNode(a,index*2+2);
        }else if(a.compareTo(bst[index]) < 0){
            return removeNode(a,index*2+1);
        }else{
            bst[index] = null;
            upLevel(index);
            return true;
        }
    }
    
    public void upLevel(int index){
        if(bst[index] == null){
            if(index*2+1 < 20){
                if(index*2+2 < 20){
                    if(bst[index*2+1] != null && bst[index*2+2] != null){
                        bst[index] = bst[index*2+2];
                        bst[index*2+2] = null;
                        upLevel(index*2+2);
                    }else if(bst[index*2+1] != null){
                        bst[index] = bst[index*2+1];
                        bst[index*2+1] = null;
                        upLevel(index*2+1);
                    }else if(bst[index*2+2] != null){
                        bst[index] = bst[index*2+2];
                        bst[index*2+2] = null;
                        upLevel(index*2+2);
                    }
                }else{
                    if(bst[index*2+1] != null){
                        bst[index] = bst[index*2+1];
                        bst[index*2+1] = null;
                        upLevel(index*2+1);
                    }
                }
            }
        }
    }
}
