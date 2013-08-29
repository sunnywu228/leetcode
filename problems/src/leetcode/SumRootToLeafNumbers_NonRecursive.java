package leetcode;

import java.util.Stack;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *      1
 *    /   \
 *   2     3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * 
 * 
 * @author chengyangwu
 *
 */
public class SumRootToLeafNumbers_NonRecursive {
	
	// this method will change the value of the nodes
	public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return 0;
        
        int sum = 0;
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        stack.push(root);
        
        while (!stack.isEmpty()) {
        	TreeNode curNode = stack.pop();
        	if (curNode.right != null) {
        		curNode.right.val = curNode.val * 10 + curNode.right.val;
        		stack.push(curNode.right);
        	}
        	if (curNode.left != null) {
        		curNode.left.val = curNode.val * 10 + curNode.left.val;
        		stack.push(curNode.left);
        	}
        	if (curNode.left == null && curNode.right == null) {
        		sum += curNode.val;
        	}
        }
        return sum;
    }
}
