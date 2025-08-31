import java.util.List; 
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
        
        // so, I've to store nodes of each level in a linkedList .
        ArrayList<TreeNode> Parent = new ArrayList<>();
        if( root == null){
            System.out.print("Tree is Null");
        }
        else{
            Parent.add(root);
            ArrayList<List<TreeNode>> result = new ArrayList<>();
            result.add( Parent);
            result = fillFunction( Parent, result);
            // print list
            // ✅ Print each level
            int level = 0;
            for (List<TreeNode> levelNodes : result) {
                System.out.print("Level " + level + ": ");
                for (TreeNode node : levelNodes) {
                    System.out.print(node.val + " ");
                }
                System.out.println();
                level++;
            }
        }

    }
    static ArrayList<List<TreeNode>> fillFunction(ArrayList<TreeNode> Parent, ArrayList<List<TreeNode>> result){
        // i've parent nodes, hover over each and store child nodes of each of them 
        ArrayList<TreeNode> childNodes = new ArrayList<>();
        for( TreeNode currParent: Parent){
            if( currParent.left != null) childNodes.add(currParent.left);
            if( currParent.right != null) childNodes.add(currParent.right);
        }

        // now, either i'd be at end of BT or not
        // if childNodes.size == 0, means Parent was the leafNodes already and no more childNodes available
        if(childNodes.size() == 0){
            return result;
        }
        result.add( childNodes);
        return fillFunction( childNodes, result);
    }
}