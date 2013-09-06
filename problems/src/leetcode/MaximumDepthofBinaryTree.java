package problems.src.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: chengyangwu
 * Date: 9/3/13
 * Time: 12:03 PM
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth_recursive(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return 0;
        return Math.max(maxDepth_recursive(root.left), maxDepth_recursive(root.right)) + 1;
    }

    public int maxDepth_iter(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return 0;
        Queue<TreeNode> curQ = new LinkedList<TreeNode>();
        Queue<TreeNode> nextQ = new LinkedList<TreeNode> ();
        int depth = 0;

        curQ.add(root);
        while (!curQ.isEmpty()) {
            TreeNode curNode = curQ.poll();
            if (curNode.left != null) nextQ.add(curNode.left);
            if (curNode.right != null) nextQ.add(curNode.right);

            if (curQ.isEmpty()) {
                depth ++;
                Queue<TreeNode> tmp = curQ;
                curQ = nextQ;
                nextQ = tmp;
            }
        }
        return depth;
    }
}
