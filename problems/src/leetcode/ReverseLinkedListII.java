package problems.src.leetcode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ? m ? n ? length of list.
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 10:32 PM
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (m == n) return head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        int i = 1;
        ListNode cur = dummyNode;
        while (i < m) {
            cur = cur.next;
            i ++;
        }

        ListNode mth = cur.next;
        ListNode firstEnd = cur;
        ListNode l = null;
        ListNode r = mth;

        while (i <= n) {
            ListNode tmp = r.next;
            r.next = l;
            l = r;
            r = tmp;
            i ++;
        }
        firstEnd.next.next = r;
        firstEnd.next = l;

        return dummyNode.next;
    }
}
