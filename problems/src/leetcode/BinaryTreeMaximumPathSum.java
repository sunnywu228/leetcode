package leetcode;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * Given the below binary tree,
 * 
 *        1
 *       / \
 *      2   3
 * Return 6.
 * 
 * @author chengyangwu
 *
 */
public class BinaryTreeMaximumPathSum {
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
        if (root == null) return Integer.MIN_VALUE;
        
        int left = dfs (root.left, max);
        int right = dfs (root.right, max);
        int childMax = Math.max(left, right);
        
        int res = (childMax == Integer.MIN_VALUE)?root.val:((childMax > 0)?(childMax+root.val):root.val);
        
        int curMax;
        if (childMax == Integer.MIN_VALUE) {
            curMax = root.val;
        } else if (left == Integer.MIN_VALUE) {
            curMax = Math.max(root.val, root.val + right);
        } else if (right == Integer.MIN_VALUE) {
            curMax = Math.max(root.val, root.val + left);
        } else {
            curMax = Math.max (root.val, childMax);
            curMax = Math.max (curMax, root.val + childMax);
            curMax = Math.max (curMax, left + root.val + right);
        }
        
        max[0] = Math.max(curMax, max[0]);
        return res;
    }
}
