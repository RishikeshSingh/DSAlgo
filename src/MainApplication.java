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
        Node root2 = null;
        BST tree2 = new BST();
        int arr2[] = {3,1,2};
        for(int i=0;i<arr2.length;i++){
            root2 = tree2.insert(root2, arr2[i]);
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
        tree.reverseLevelOrder(root);
        System.out.println("Spiral View");
        tree.spiralView(root);
        System.out.println("Zig Zag View");
        tree.zigZagView(root);
        System.out.println("Height of the tree");
        System.out.println(tree.height(root));
        System.out.println("Diameter of the tree");
        System.out.println(tree.diameter(root));
        System.out.println("Kth node from the root");
        tree.printKthNode(root,3);
        System.out.println("Sum of the tree");
        //tree.returnSumTree(root);
        //System.out.println("level order");
        tree.levelOrder(root);
        System.out.println("common ancestor");
        int k[] = {0};
        Node ca = tree.lowestCommonAncestor(root,2,7);
        if(ca != null){
            ca.data();
        }*/
        //root2 = root2.left;
        System.out.println("##########################");
        root.data();
        root2.data();
        System.out.println(tree.subtree(root, root2));

    }
}
