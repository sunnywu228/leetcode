package leetcode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *      1
 *    /   \
 *   2     3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * 
 * 
 * @author chengyangwu
 *
 */
public class SumRootToLeafNumbers_Recursive {
	public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return 0;
        return dfs (root, 0);
    }
    
    public int dfs (TreeNode root, int curSum) {
        if (root == null) return 0;
        curSum = curSum * 10 + root.val;
        
        if (root.left == null && root.right == null) return curSum;
        return dfs (root.left, curSum) + dfs (root.right, curSum);
    }
}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}
