package TutorialQuestion;

public class Q2 {
    public static void main(String[] args) {
        BST<Character> a = new BST<>();
        //2a
        a.addNode('F');
        a.addNode('A');
        a.addNode('C');
        a.addNode('U');
        a.addNode('L');
        a.addNode('T');
        a.addNode('Y');
        
        
        //2b
        System.out.println("The number of elements in the tree : " + a.getSize());
        
        //2c
        a.setOrder(1);
        System.out.print("The tree elements - PREORDER : ");
        a.showTree();
        a.setOrder(2);
        System.out.print("\nThe tree elements - INORDER : ");
        a.showTree();
        a.setOrder(3);
        System.out.print("\nThe tree elements - POSTORDER : ");
        a.showTree();
        System.out.println("");
        
        //2d
        System.out.println("Remove 1 Character L");
        a.remove('L');
        System.out.println("The number of elements in the tree : " + a.getSize());
        
        //2e
        a.setOrder(1);
        System.out.print("The tree elements - PREORDER : ");
        a.showTree();
        a.setOrder(2);
        System.out.print("\nThe tree elements - INORDER : ");
        a.showTree();
        a.setOrder(3);
        System.out.print("\nThe tree elements - POSTORDER : ");
        a.showTree();
        System.out.println("");
        
    }
}
