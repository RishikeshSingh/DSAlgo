import DataStructures.BST;
import DataStructures.Node;

/**
 * Created by Rishikesh on 14-06-2017.
 */
public class MainApplication {

    public static void main(String[] args) {
        int arr[] = {4,6,3,1,2,5,7};
        BST tree = new BST();
        Node root = null;
        for(int i=0;i<arr.length;i++){
            root = tree.insert(root, arr[i]);
        }

        tree.inorder(root);
        System.out.println();
        tree.preorder(root);
    }
}
