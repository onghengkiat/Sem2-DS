package TutorialQuestion;

public class Q3 {
    public static void main(String[] args) {
        ArrayBST <Character>a= new ArrayBST<>();
        a.addNode('F');
        a.addNode('A');
        a.addNode('C');
        a.addNode('U');
        a.addNode('L');
        a.addNode('T');
        a.addNode('Y');
        System.out.println("The number of elements in the tree : " + a.getSize());
        System.out.print("The tree elements - PREORDER : ");
        a.preOrder(0);
        System.out.print("\nThe tree elements - INORDER : ");
        a.inOrder(0);
        System.out.print("\nThe tree elements - POSTORDER : ");
        a.postOrder(0);
        if(a.removeNode('L'))
            System.out.println("\nRemove 1 Character L");
        System.out.println("The number of elements in the tree : " + a.getSize());
        System.out.print("The tree elements - PREORDER : ");
        a.preOrder(0);
        System.out.print("\nThe tree elements - INORDER : ");
        a.inOrder(0);
        System.out.print("\nThe tree elements - POSTORDER : ");
        a.postOrder(0);
    }
}
