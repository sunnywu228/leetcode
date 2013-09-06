package problems.src.leetcode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * User: chengyangwu
 * Date: 9/3/13
 * Time: 12:01 PM
 */
public class ConvertSortedListtoBinarySearchTree {
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) return null;
        node = head;
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        return toBSTHelper (0, len - 1);
    }

    public TreeNode toBSTHelper (int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start)/2;
        TreeNode left = toBSTHelper (start, mid - 1);
        TreeNode root = new TreeNode (node.val);
        node = node.next;
        root.left = left;
        root.right = toBSTHelper (mid + 1, end);

        return root;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
