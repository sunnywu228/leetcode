package problems.src.leetcode;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * User: chengyangwu
 * Date: 9/3/13
 * Time: 12:01 PM
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int left = (root.left != null) ? minDepth(root.left) + 1 : -1;
        int right = (root.right != null) ? minDepth(root.right) + 1 : -1;

        return left == -1 ? right : right == -1 ? left : Math.min(left, right);
    }
}
