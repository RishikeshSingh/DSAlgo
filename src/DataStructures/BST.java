package DataStructures;

/**
 * Created by Rishikesh on 14-06-2017.
 */
public class BST extends Tree {
    public Node insert(Node root, int data){
        if(root == null) {
            root = new Node(data);
            return root;
        }else{
            if(data < root.data){
                root.left = insert(root.left, data);
            }else{
                root.right = insert(root.right, data);
            }
        }
        return root;
    }
}
