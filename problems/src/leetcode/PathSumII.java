package problems.src.leetcode;

import java.util.ArrayList;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * return
 * [
 *   [5,4,11,2],
 *   [5,8,4,5]
 * ]
 *
 * User: chengyangwu
 * Date: 9/3/13
 * Time: 11:44 AM
 */
public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        if (root == null) return result;
        findPath(root, new ArrayList<Integer> (), 0, sum, result);
        return result;
    }

    public void findPath (TreeNode root, ArrayList<Integer> path, int curSum, int sum, ArrayList<ArrayList<Integer>> result) {
        if (root.left == null && root.right == null) {
            if (curSum + root.val == sum) {
                path.add(root.val);
                result.add(new ArrayList<Integer>(path));
                return;
            }
        }
        path.add(root.val);
        if (root.left != null) findPath(root.left, new ArrayList<Integer>(path), curSum + root.val, sum, result);
        if (root.right != null) findPath(root.right, new ArrayList<Integer>(path), curSum + root.val, sum, result);
    }
}
