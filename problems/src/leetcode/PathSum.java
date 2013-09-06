package problems.src.leetcode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * User: chengyangwu
 * Date: 9/3/13
 * Time: 11:04 AM
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return false;

        return pathSum(root, 0, sum);
    }

    public boolean pathSum (TreeNode root, int curSum, int sum) {
        boolean left = false;
        boolean right = false;
        if (root.left == null && root.right == null) {
            if (root.val + curSum == sum) return true;
            else return false;
        }
        right = root.right != null ? pathSum(root.right, curSum + root.val, sum) : false;
        left = root.left != null ? pathSum(root.left, curSum + root.val, sum) : false;
        return right || left;
    }
}
