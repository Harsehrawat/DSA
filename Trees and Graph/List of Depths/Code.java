import java.util.ArrayList;
import java.util.LinkedList;

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

public class Code {
    public static void main(String[] args) {
        // Example tree creation
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Get list of depth levels
        ArrayList<LinkedList<TreeNode>> result = depth(root);

        // Print the levels
        for (int i = 0; i < result.size(); i++) {
            System.out.print("Level " + i + ": ");
            for (TreeNode node : result.get(i)) {
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
        
    }
    static ArrayList<LinkedList<TreeNode>> depth(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();

        if(root!=null) current.add(root);

        while (current.size()>0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();

            for(TreeNode parent : parents){
                if(parent.left!=null) current.add(parent.left);
                if(parent.right!=null) current.add(parent.right);
            }
        }

        return result;
    }
}