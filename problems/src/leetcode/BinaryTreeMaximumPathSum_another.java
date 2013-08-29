package leetcode;

public class BinaryTreeMaximumPathSum_another {
	public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return 0;
        
        int[] max = new int[1];
        max[0] = root.val;
        dfs (root, max);
        
        return max[0];
    }
    
    public int dfs (TreeNode root, int[] max) {
        if (root == null) return 0;
        
        int left = dfs (root.left, max);
        int right = dfs (root.right, max);
        int childMax = Math.max(left, right);
        
        int m = root.val;
        m = (left > 0)?m+left:m;
        m = (right > 0)?m+right:m;
        max[0] = Math.max(max[0], m);
        
        return (childMax > 0)?(root.val+childMax):root.val;
    }
}
