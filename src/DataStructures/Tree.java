package DataStructures;

/**
 * Created by Rishikesh on 14-06-2017.
 */
public class Tree {
    //public Node insert(Node root, int data){

    //}
    public void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.data+", ");
            inorder(root.right);
        }
    }

    public void preorder(Node root){
        if(root != null){
            System.out.print(root.data+", ");
            preorder(root.left);
            preorder(root.right);
        }
    }

}
