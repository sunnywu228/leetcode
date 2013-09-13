package problems.src.leetcode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 10:46 PM
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        int prev = head.val;
        while (cur.next != null) {
            if (cur.next.val == prev) cur.next = cur.next.next;
            else {
                prev = cur.next.val;
                cur = cur.next;
            }
        }
        return head;
    }
}
