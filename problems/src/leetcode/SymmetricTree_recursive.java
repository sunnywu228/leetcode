package problems.src.leetcode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 9:27 PM
 */
public class SymmetricTree_recursive {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return true;
        return mirrored(root.left, root.right);
    }

    public boolean mirrored(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return a.val == b.val && mirrored(a.left, b.right) && mirrored(a.right, b.left);
    }
}
