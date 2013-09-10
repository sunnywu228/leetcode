package problems.src.leetcode;

import java.util.ArrayList;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 8:49 PM
 */
public class RecoverBinarySearchTree {
    private TreeNode prev;
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> toSwap = new ArrayList<TreeNode> ();
        prev = null;
        inorder(root, toSwap);

        int tmp = toSwap.get(0).val;
        toSwap.get(0).val = toSwap.get(toSwap.size() - 1).val;
        toSwap.get(toSwap.size() - 1).val = tmp;

    }

    public void inorder(TreeNode root, ArrayList<TreeNode> toSwap) {
        if (root == null) return;
        inorder(root.left, toSwap);
        if (prev != null && prev.val >= root.val) {
            toSwap.add(prev);
            toSwap.add(root);
        }
        prev = root;
        inorder(root.right, toSwap);
    }
}
