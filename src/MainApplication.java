import DataStructures.BST;
import DataStructures.Node;

/**
 * Created by Rishikesh on 14-06-2017.
 */
public class MainApplication {

    public static void main(String[] args) {
        int arr[] = {4,3,6,1,2,5,7};
        BST tree = new BST();
        Node root = null;
        for(int i=0;i<arr.length;i++){
            root = tree.insert(root, arr[i]);
        }
        /*
        System.out.println("Inorder traversal");
        tree.inOrder(root);
        System.out.println("Preorder traversal");
        tree.preOrder(root);
        System.out.println("Left View");
        tree.leftView(root);
        System.out.println("Right View");
        tree.rightView(root);
        System.out.println("Top View");
        tree.topView(root);*/
        System.out.println("level order");
        tree.levelOrder(root);
        /*
        System.out.println("Mirror View");
        tree.mirrorView(root);
        System.out.println("Bottom View");
        tree.bottomView(root);
        System.out.println("Reverse Level Order");
        tree.reverseLevelOrder(root);*/
        System.out.println("Spiral View");
        tree.spiralView(root);
        System.out.println("Zig Zag View");
        tree.zigZagView(root);
    }
}
