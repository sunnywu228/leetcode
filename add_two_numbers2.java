/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
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
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int ival1 = (l1 != null) ? l1.val : 0;
            int ival2 = (l2 != null) ? l2.val : 0;
            
            int num = ival1 + ival2 + carry;
            
            carry = num / 10;
            num = num % 10;
            tail.next = new ListNode(num);
            tail = tail.next;
            l1 = (l1 != null) ? l1.next : l1;
            l2 = (l2 != null) ? l2.next : l2;
        }
        return dummy.next;
    }
}
