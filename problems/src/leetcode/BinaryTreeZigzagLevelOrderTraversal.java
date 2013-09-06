package problems.src.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its zigzag level order traversal as:
 *
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 *
 * User: chengyangwu
 * Date: 9/3/13
 * Time: 12:04 PM
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        if (root == null) return result;

        Stack<TreeNode> curS = new Stack<TreeNode> ();
        Stack<TreeNode> nextS = new Stack<TreeNode> ();
        boolean leftToRight = true;

        curS.push(root);
        ArrayList<Integer> curLevel = new ArrayList<Integer> ();
        while (!curS.isEmpty()) {
            TreeNode curNode = curS.pop();
            curLevel.add(curNode.val);
            if (leftToRight) {
                if (curNode.left != null) nextS.push(curNode.left);
                if (curNode.right != null) nextS.push(curNode.right);
            } else {
                if (curNode.right != null) nextS.push(curNode.right);
                if (curNode.left != null) nextS.push(curNode.left);
            }

            if (curS.isEmpty ()) {
                result.add(curLevel);
                curLevel = new ArrayList<Integer>();
                Stack<TreeNode> tmp = curS;
                curS = nextS;
                nextS = tmp;
                leftToRight = !leftToRight;
            }
        }
        return result;
    }
}
