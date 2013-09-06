package problems.src.leetcode;

/**
 * User: chengyangwu
 * Date: 9/3/13
 * Time: 12:02 PM
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num == null || num.length == 0) return null;
        return helper (num, 0, num.length/2, num.length - 1);
    }

    public TreeNode helper (int[] num, int start, int mid, int end) {
        if (end < start) return null;

        TreeNode curRoot = new TreeNode (num[mid]);
        int leftInd = (mid - start)/2 + start;
        int rightInd = end - (end - mid)/2;
        curRoot.left = helper (num, start, leftInd, mid - 1);
        curRoot.right = helper (num, mid + 1, rightInd, end);
        return curRoot;
    }
}
