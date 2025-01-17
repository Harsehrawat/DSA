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


public class code {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        minimalBST(array);

    }
    
    TreeNode minimalBST(int[] array){
        return createBST(array, 0, array.length-1);
    }

    TreeNode createBST(int[] arr,int start,int end){
        if(start>end) return null;
        // rec case.
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(arr[mid]);

        node.left = createBST(arr, start, mid-1);
        node.right = createBST(arr, mid+1, end);

        return node;
    }
}