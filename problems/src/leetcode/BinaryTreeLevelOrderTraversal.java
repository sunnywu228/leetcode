package problems.src.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *        3
 *       / \
 *      9  20
 *        /  \
 *       15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * User: chengyangwu
 * Date: 9/3/13
 * Time: 12:04 PM
 */
public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        if (root == null) return result;

        Queue<TreeNode> curQ = new LinkedList<TreeNode>();
        Queue<TreeNode> nextQ = new LinkedList<TreeNode> ();

        curQ.add (root);
        ArrayList<Integer> curLevel = new ArrayList<Integer> ();
        while (!curQ.isEmpty ()) {
            TreeNode curNode = curQ.poll ();
            curLevel.add (curNode.val);
            if (curNode.left != null) nextQ.add (curNode.left);
            if (curNode.right != null) nextQ.add (curNode.right);

            if (curQ.isEmpty()) {
                result.add(curLevel);
                curLevel = new ArrayList<Integer> ();
                Queue<TreeNode> tmp = curQ;
                curQ = nextQ;
                nextQ = tmp;
            }
        }
        return result;
    }
}
