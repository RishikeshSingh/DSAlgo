package DataStructures;
import java.util.*;

/**
 * Created by Rishikesh on 14-06-2017.
 */
public class Tree {
    //public Node insert(Node root, int data){

    //}
    public void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+", ");
            inOrder(root.right);
        }
    }

    public void preOrder(Node root){
        if(root != null){
            System.out.print(root.data+", ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+", ");

        }
    }

    public void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> level = new LinkedList<>();
        int level_track = 0;
        int current_level;
        level.add(0);

        Iterator it = queue.iterator();

        while(it.hasNext()){

            current_level = level.remove();

            if(level_track < current_level){
                System.out.println();
                level_track = current_level;
            }

            Node node = queue.remove();
            System.out.print(node.data+" ");

            if(node.left != null){
                queue.add(node.left);
                level.add(current_level+1);
            }
            if(node.right != null){
                queue.add(node.right);
                level.add(current_level+1);
            }
            //queue.remove();
            //level.remove();
        }
    }


    public void reverseLevelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> level = new LinkedList<>();
        int level_track = 0;
        int current_level;
        level.add(0);

        Iterator it = queue.iterator();
        Stack<Integer> arr = new Stack();

        while(it.hasNext()){

            current_level = level.remove();

            if(level_track < current_level){
                level_track = current_level;
                arr.push(null);
            }

            Node node = queue.remove();
            arr.push(node.data);

            if(node.left != null){
                queue.add(node.left);
                level.add(current_level+1);
            }
            if(node.right != null){
                queue.add(node.right);
                level.add(current_level+1);
            }
            //queue.remove();
            //level.remove();
        }

        while(arr.empty() != true){
            Integer i = arr.pop();
            if(i == null){
                System.out.println();
            }else{
                System.out.print(i+" ");
            }
        }

    }

    public void mirrorView(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> level = new LinkedList<>();
        int level_track = 0;
        int current_level;
        level.add(0);

        Iterator it = queue.iterator();

        while(it.hasNext()){

            current_level = level.remove();

            if(level_track < current_level){
                System.out.println();
                level_track = current_level;
            }

            Node node = queue.remove();
            System.out.print(node.data+" ");

            if(node.right != null){
                queue.add(node.right);
                level.add(current_level+1);
            }
            if(node.left != null){
                queue.add(node.left);
                level.add(current_level+1);
            }

            //queue.remove();
            //level.remove();
        }
    }

    //function that prints the left view of the tree
    void printLeftView(Node root, int[] flag, int level){
        if(root == null){
            return;
        }
        else{
            if(flag[0]<level){
                System.out.println(root.data+" ");
                flag[0]++;
            }
            printLeftView(root.left, flag, level+1);
            printLeftView(root.right, flag, level+1);

        }
    }

    //function that prints the right view
    void printRightView(Node root, int[] flag, int level){
        if(root == null){
            return;
        }
        else{
            if(flag[0]<level){
                System.out.println(root.data+" ");
                flag[0] = level;
            }
            printRightView(root.right, flag, level+1);
            printRightView(root.left, flag, level+1);

        }
    }

    public void leftView(Node root){
        int[] flag = {0};
        int level = 1;
        printLeftView(root, flag, level);
    }

    public void rightView(Node root){
        int[] flag = {0};
        int level = 1;
        printRightView(root, flag, level);
    }

    void printTopView(Node root, int[] l_flag, int[] r_flag, int dist){
        if(root == null){
            return;
        }else{
            if(l_flag[0] > dist){
                System.out.print(root.data+" ");
                l_flag[0] = dist;
            }
            if(r_flag[0] < dist){
                System.out.print(root.data+" ");
                r_flag[0] = dist;
            }
            printTopView(root.left, l_flag, r_flag, dist-1);
            printTopView(root.right, l_flag, r_flag, dist+1);
        }
    }

    public void topView(Node root){
        int[] l_flag = {1};
        int[] r_flag = {0};
        int dist = 0;
        printTopView(root, l_flag, r_flag, dist);
    }

    void printBottomView(Node root, int dist, SortedMap hm){
        if(root == null){
            return;
        }else{
            hm.put(dist, root.data);
            printBottomView(root.left, dist-1, hm);
            printBottomView(root.right, dist+1, hm);
        }
    }

    public void bottomView(Node root){
        int dist = 0;
        SortedMap<Integer, Integer> hm = new TreeMap<>();
        printBottomView(root, dist, hm);

        for(Map.Entry<Integer, Integer> it : hm.entrySet()){
            System.out.print(it.getValue()+" ");
        }

    }

    public void zigZagView(Node root){
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        int level_flag = 0;

        while(stack1.empty() != true || stack2.empty() != true){

            while(stack1.empty() != true){
                Node node = stack1.pop();
                if(level_flag == 0){
                    System.out.print(node.data+" ");
                    level_flag = 1;
                }

                if(node.right != null){
                    stack2.push(node.right);
                }
                if(node.left != null){
                    stack2.push(node.left);
                }
            }

            level_flag = 0;
            System.out.println();

            while(stack2.empty() != true){
                Node node = stack2.pop();
                if(level_flag == 0){
                    System.out.print(node.data+" ");
                    level_flag = 1;
                }

                if(node.left != null){
                    stack1.push(node.left);
                }
                if(node.right != null){
                    stack1.push(node.right);
                }
            }

            level_flag = 0;
            System.out.println();
        }
    }

    public void spiralView(Node root){
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while(stack1.empty() != true || stack2.empty() != true){
            while(stack1.empty() != true){
                Node node = stack1.pop();
                System.out.print(node.data+" ");
                if(node.right != null){
                    stack2.push(node.right);
                }
                if(node.left != null){
                    stack2.push(node.left);
                }
            }
            System.out.println();
            while(stack2.empty() != true){
                Node node = stack2.pop();
                System.out.print(node.data+" ");
                if(node.left != null){
                    stack1.push(node.left);
                }
                if(node.right != null){
                    stack1.push(node.right);
                }
            }
            System.out.println();
        }
    }

    public int height(Node root){
        if(root == null){
            return 0;
        }else{
            int left = height(root.left);
            int right = height(root.right);
            if(left > right){
                return left+1;
            }else{
                return right+1;
            }
        }
    }

    int getDiameter(Node root, int[] max){
        if(root == null) {
            return 0;
        }else{
            int left = getDiameter(root.left, max);
            int right = getDiameter(root.right, max);
            if(max[0] < left+right+1){
                max[0] = left+right+1;
            }
            if(left > right){
                return left+1;
            }else{
                return right+1;
            }
        }
    }

    public int diameter(Node root){
        int max[] = {-1};
        getDiameter(root, max);
        return max[0];
    }

    public void printKthNode(Node root, int k){
        if(root == null){
            return;
        }
        if(k==0){
            System.out.print(root.data);
            return;
        }else{
            printKthNode(root.left,k-1);
            printKthNode(root.right,k-1);
        }
    }

    public int returnSumTree(Node root){
        if(root == null){
            return 0;
        }
        int temp = root.data;
        root.data = returnSumTree(root.left)+returnSumTree(root.right);
        return temp;
    }

    public Node commonAncestor(Node root, int a, int b, int[] count){
        if(root == null){
            return null;
        }

        if(root.data == a || root.data == b){
            //System.out.println("node found");
            count[0]++;
            return root;
        }

        Node left = commonAncestor(root.left, a ,b, count);
        Node right = commonAncestor(root.right, a, b, count);


        if(left != null && right != null){

            if(left.data == a && right.data == b){
                return root;
            }

            if(left.left.data == a && left.right.data == b){
                return left;
            }
            if(right.left.data == a && right.right.data == b){
                return right;
            }
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;
    }

    public Node lowestCommonAncestor(Node root, int a, int b){
        int count[] = {0};
        Node node = commonAncestor(root, a, b, count);
        if(count[0] == 2){
            return node;
        }
        return null;
    }

    public Node findRoot(Node troot, Node stroot){
        if(troot == null || stroot == null){
            return null;
        }
        if(troot.data == stroot.data){
            return troot;
        }
        Node left = findRoot(troot.left, stroot);
        Node right = findRoot(troot.right, stroot);

        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;
    }

    public int treeCheck(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return 1;
        }
        if(root1 == null || root2 == null || root1.data != root2.data){
            return -1;
        }
        int left = treeCheck(root1.left, root2.left);
        int right = treeCheck(root1.right, root2.right);

        if(left == 1 && right == 1){
            return 1;
        }
        return -1;
    }

    public boolean subtree(Node troot, Node stroot){
        Node start_point = findRoot(troot, stroot);
        if(start_point == null){
            return false;
        }
        int check = treeCheck(start_point, stroot);
        if(check == 1){
            return true;
        }
        return false;
    }

}
