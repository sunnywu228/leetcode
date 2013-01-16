/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each
 * of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  	if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else {
			ListNode cur1 = l1;
			ListNode cur2 = l2;
			ListNode dummy = new ListNode(0);
			ListNode tail = dummy;
			int carry = 0;
			while (cur1 != null && cur2 != null) {
				int num = cur1.val + cur2.val + carry;
				tail.next = new ListNode(num % 10);
				carry = (int) num / 10;

				tail = tail.next;
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			while (cur1 != null) {
				int num = cur1.val + carry;
				tail.next = new ListNode(num % 10);
				carry = (int) num / 10;

				tail = tail.next;
				cur1 = cur1.next;
			}
			while (cur2 != null) {
				int num = cur2.val + carry;
				tail.next = new ListNode(num % 10);
				carry = (int) num / 10;

				tail = tail.next;
				cur2 = cur2.next;
			}

			if (carry == 1) {
				tail.next = new ListNode(carry);
			}

			return dummy.next;
		}
	}
}