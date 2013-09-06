package problems.src.leetcode;

import java.util.Arrays;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * User: chengyangwu
 * Date: 9/3/13
 * Time: 12:03 PM
 */
public class ConstructTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (postorder.length == 0) return null;
        if (postorder.length == 1) return new TreeNode(postorder[0]);

        TreeNode root = new TreeNode (postorder[postorder.length - 1]);
        int i = 0;
        for (; inorder[i] != postorder[postorder.length - 1]; i ++) ;

        if (i != 0) {
            root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        }
        if (i != postorder.length - 1) {
            root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));
        }

        return root;
    }
}
