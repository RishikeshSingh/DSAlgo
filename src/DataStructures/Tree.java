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



}
