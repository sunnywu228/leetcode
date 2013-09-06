package problems.src.leetcode;

import java.util.Arrays;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * User: chengyangwu
 * Date: 9/3/13
 * Time: 12:03 PM
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);

        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        for (; inorder[i] != preorder[0]; i ++) ;
        if (i != 0) {
            root.left = buildTree (Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
        }
        if (i != inorder.length - 1) {
            root.right = buildTree (Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
        }
        return root;
    }
}
