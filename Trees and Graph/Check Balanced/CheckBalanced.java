// implement a function to check if a BT is Balanced. ( balanced BT: the height of the two subTrees of any node never differ by more than one)



public class CheckBalanced {
    public static void main(String[] args) {
        // create a custom Tree using TreeNode class
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        
        int res = verifyBalanceTree(root);
        if( res == -1) System.out.println("The Tree failed Balance Test");
        else System.out.println("The Tree passed Balance Test");
    }
    public static int verifyBalanceTree(TreeNode root){
        // so at any node, if leftST - rightST > 1, return false;
        if( root == null) return 0;
        // what if i had only two nodes ?
        int leftST = verifyBalanceTree(root.left);
        if( leftST == -1) return -1;
        int rightST = verifyBalanceTree(root.right);
        if( rightST == -1) return -1;

        int currDiff = Math.abs( leftST - rightST);
        if( currDiff > 1) return -1;
        return Math.max(rightST, leftST) + 1;
    }
}

class TreeNode{
    // left, right and val
    TreeNode left;
    TreeNode right;
    int val;

    // constructor
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}