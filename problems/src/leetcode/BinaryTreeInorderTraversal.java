package problems.src.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
 *
 * User: chengyangwu
 * Date: 9/6/13
 * Time: 5:06 PM
 */
public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal_recursive(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;

        result.addAll(inorderTraversal_recursive(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal_recursive(root.right));

        return result;
    }

    public ArrayList<Integer> inorderTraversal_iterate(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if (root == null) return result;

        HashMap<TreeNode, Integer> visited = new HashMap<TreeNode, Integer> ();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.peek();
            if (curNode != null) {
                if (!visited.containsKey(curNode)) {
                    visited.put(curNode, 1);
                    stack.push(curNode.left);
                } else {
                    result.add(curNode.val);
                    stack.pop();
                    stack.push(curNode.right);
                }
            } else {
                stack.pop();
            }
        }

        return result;
    }
}
