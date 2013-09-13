package problems.src.leetcode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 10:46 PM
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        boolean delete = false;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                delete = true;
                pre.next = cur.next;
            } else if (delete) {
                delete = false;
                pre.next = cur.next;
            } else pre = cur;
            cur = cur.next;
        }
        if (delete && cur != null) pre.next = null;

        return dummy.next;
    }
}
