package TutorialQuestion;
public class Q1 {
    public static void main(String[] args) {
        BST<Integer> a = new BST<>();
        a.addNode(50);
        a.addNode(30);
        a.addNode(25);
        a.addNode(71);
        a.addNode(80);
        a.addNode(99);
        a.addNode(40);
        a.addNode(1);
        a.addNode(7);
        a.addNode(5);
        
        a.setOrder(1);
        a.showTree();
        System.out.println("");
        a.setOrder(2);
        a.showTree();
        System.out.println("");
        a.setOrder(3);
        a.showTree();
        System.out.println("");
    }
}
