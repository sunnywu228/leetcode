package problems.src.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *       3
 *      / \
 *     9  20
 *       /  \
 *      15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7]
 *   [9,20],
 *   [3],
 * ]
 *
 * User: chengyangwu
 * Date: 9/3/13
 * Time: 12:02 PM
 */
public class BinaryTreeLevelOrderTraversalII {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        if (root == null) return result;

        Stack<ArrayList<Integer>> tmpResult = new Stack<ArrayList<Integer>> ();
        Queue<TreeNode> curQ = new LinkedList<TreeNode> ();
        Queue<TreeNode> nextQ = new LinkedList<TreeNode>();
        curQ.add(root);

        ArrayList<Integer> curLevel = new ArrayList<Integer> ();

        while(!curQ.isEmpty()) {
            TreeNode curNode = curQ.poll();
            curLevel.add(curNode.val);
            if (curNode.left != null) nextQ.add(curNode.left);
            if (curNode.right != null) nextQ.add(curNode.right);

            if (curQ.isEmpty()) {
                tmpResult.push(curLevel);
                curLevel = new ArrayList<Integer>();
                Queue<TreeNode> tmp = curQ;
                curQ = nextQ;
                nextQ = tmp;
            }
        }

        while(!tmpResult.isEmpty()) {
            result.add(tmpResult.pop());
        }
        return result;
    }
}
