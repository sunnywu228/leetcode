package problems.src.leetcode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.
 *
 * User: chengyangwu
 * Date: 9/3/13
 * Time: 12:01 PM
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return true;
        boolean[] balanced = new boolean[1];
        balanced[0] = true;
        check(root, balanced);
        return balanced[0];
    }

    public int check (TreeNode root, boolean[] balanced) {
        if (root.left == null && root.right == null) {
            balanced[0] = true && balanced[0];
            return 0;
        }
        if (balanced[0]) {
            int left = root.left == null ? 0 : 1 + check (root.left, balanced);
            int right = root.right == null ? 0 : 1 + check (root.right, balanced);

            balanced[0] = Math.abs (left - right) <= 1 && balanced[0];
            return Math.max (left, right);
        }
        return 0;
    }
}
