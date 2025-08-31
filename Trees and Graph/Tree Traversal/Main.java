import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    public static void main(String[] args) {
        
            //      1
            //     / \
            //     2  3
            //    /
            //   4 
        
        // first create a tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left= new TreeNode(4);

        ArrayList<Integer> list = new ArrayList<>();
        InOrder(root, list);
        // print list
        System.out.println("In Order Traversal output: ");
        for(int i: list){
            System.out.print(i+" ,");
        }
        System.out.println();
        list.clear();
        PreOrder(root, list);
        // print list
        System.out.println("Pre Order Traversal output: ");
        for(int i: list){
            System.out.print(i+" ,");
        }
        System.out.println();
        list.clear();
        PostOrder(root, list);
        System.out.println("Post Order Traversal output: ");
        for(int i: list){
            System.out.print(i+" ,");
        }
    }
    static void InOrder(TreeNode root, ArrayList<Integer> list){
        // inorder: left -> root -> right
        if( root == null) return;
        InOrder( root.left, list);
        // what if i had only 2 nodes, root and left
        list.add(root.val);
        InOrder(root.right, list);
    }
    static void PreOrder(TreeNode root, ArrayList<Integer> list){
        // preOrder: root , left , right
        if( root == null) return;
        list.add( root.val);
        // what if i had only 2 nodes, root and right
        PreOrder(root.left, list);
        PreOrder(root.right, list);
    }
    static void PostOrder( TreeNode root, ArrayList<Integer> list){ 
        if( root == null) return;
        // postOrder: left, right , root
        PostOrder(root.left, list);
        // what if i had only 2 nodes, root and right
        PostOrder(root.right, list);
        list.add(root.val);
    }
}