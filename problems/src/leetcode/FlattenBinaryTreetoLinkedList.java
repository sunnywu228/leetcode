package problems.src.leetcode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 *        1
 *       / \
 *      2   5
 *     / \   \
 *    3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 *
 * User: chengyangwu
 * Date: 9/2/13
 * Time: 3:17 PM
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            root.right = left;
            root.left = null;

            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        }
        flatten(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
