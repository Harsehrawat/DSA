/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // when we find target node, there would be some nodes in k distance up from the target node and some in k distance downwards from the target node .
        // tricky part is to get nodes k distance up the tree from the target.
        // for this, we've to back-track the nodes we've covered.
        List<Integer> res = new ArrayList<>();
        findTargetNode( root, target, k, res);
        return res;
    }
    static int findTargetNode(TreeNode root, TreeNode target, int k, List<Integer> res) {
        if( root == null) return -1;
        
        if( root == target){ // target found
            kDistanceNodes( root, k, res);
            return 0;
        }

        int leftST = findTargetNode( root.left, target, k, res);
        if( leftST != -1){ // means target was hit by leftST of currRoot
            // if target is the leftChild of root, i shouldn't call kDistacneNodes for leftSide of root as it's already been added by leftChild ( target Node)
            if( leftST + 1 == k) res.add( root.val);
            else kDistanceNodes( root.right, k - leftST - 2, res);
            return leftST + 1;
        }

        int rightST = findTargetNode( root.right, target, k, res);
        if( rightST != -1){ // target was hit by rightST of currRoot
            if( rightST + 1 == k) res.add( root.val);
            else kDistanceNodes( root.left, k - rightST - 2, res);
            return rightST + 1;
        }

        return -1;
    }

    static void kDistanceNodes( TreeNode root, int dist, List<Integer> res){
        if( root == null) return;
        if( dist == 0){
            res.add( root.val);
            return;
        }

        kDistanceNodes( root.left, dist - 1, res);
        kDistanceNodes( root.right, dist - 1, res);
    }
    
}