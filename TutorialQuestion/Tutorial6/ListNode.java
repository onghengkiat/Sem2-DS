package TutorialQuestion;

public class ListNode <T>{
    private T data;
    private ListNode link;
    
    public ListNode(){
        data = null;
        link = null;
    }

    public ListNode(T data, ListNode link) {
        this.data = data;
        this.link = link;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode getLink() {
        return link;
    }

    public void setLink(ListNode link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return data + " --> ";
    }
}
