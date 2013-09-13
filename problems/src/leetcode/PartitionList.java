package problems.src.leetcode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes
 * greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 10:43 PM
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode small = dummy1, large = dummy2;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                small.next = cur;
                cur = cur.next;
                small = small.next;
                small.next = null;
            } else {
                large.next = cur;
                cur = cur.next;
                large = large.next;
                large.next = null;
            }
        }
        small.next = dummy2.next;
        return dummy1.next;
    }
}
