package problems.src.leetcode;

import java.util.LinkedList;
import java.util.Queue;

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
 * Time: 10:24 PM
 */
public class SymmetricTree_iterate {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return true;

        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;

        Queue<TreeNode> ql = new LinkedList<TreeNode>();
        Queue<TreeNode> qr = new LinkedList<TreeNode> ();
        ql.add(root.left);
        qr.add(root.right);

        while (!ql.isEmpty() && !qr.isEmpty()) {
            TreeNode left = ql.poll();
            TreeNode right = qr.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            ql.add(left.left);
            ql.add(left.right);
            qr.add(right.right);
            qr.add(right.left);
        }
        if (ql.isEmpty() && qr.isEmpty()) return true;
        return false;
    }
}
