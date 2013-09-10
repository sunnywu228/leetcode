package problems.src.leetcode;

import java.util.ArrayList;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 2:54 PM
 */
public class UniqueBinarySearchTreeII {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return treeGeneratorHelper(1, n);
    }

    private ArrayList<TreeNode> treeGeneratorHelper(int l, int r) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (l > r) {
            result.add(null);
            return result;
        }

        for (int i = l; i <= r; i ++) {
            for (TreeNode left : treeGeneratorHelper(l, i - 1)) {
                for (TreeNode right : treeGeneratorHelper(i + 1, r)) {
                    TreeNode curTree = new TreeNode(i);
                    curTree.left = left;
                    curTree.right = right;
                    result.add(curTree);
                }
            }
        }
        return result;
    }
}
