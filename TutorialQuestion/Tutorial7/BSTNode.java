package TutorialQuestion;

public class BSTNode <T extends Comparable<T>>{
    private T data;
    private BSTNode leftLink;
    private BSTNode rightLink;
    
    public BSTNode(){
        data = null;
        leftLink = null;
        rightLink = null;
    }

    public BSTNode(T data, BSTNode leftLink, BSTNode rightLink) {
        this.data = data;
        this.leftLink = leftLink;
        this.rightLink = rightLink;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BSTNode getLeftLink() {
        return leftLink;
    }

    public void setLeftLink(BSTNode leftLink) {
        this.leftLink = leftLink;
    }

    public BSTNode getRightLink() {
        return rightLink;
    }

    public void setRightLink(BSTNode rightLink) {
        this.rightLink = rightLink;
    }
    
}
