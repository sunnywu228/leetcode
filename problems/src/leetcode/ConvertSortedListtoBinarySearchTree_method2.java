package problems.src.leetcode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * User: chengyangwu
 * Date: 9/5/13
 * Time: 3:10 PM
 */
public class ConvertSortedListtoBinarySearchTree_method2 {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) return null;
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }

        return toBSTHelper (head, 0, len - 1);
    }

    public TreeNode toBSTHelper (ListNode node, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start)/2;
        TreeNode left = toBSTHelper (node, start, mid - 1);
        TreeNode root = new TreeNode (node.val);
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
        root.left = left;
        root.right = toBSTHelper (node, mid + 1, end);

        return root;
    }
}
