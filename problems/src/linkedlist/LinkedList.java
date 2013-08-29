package linkedlist;

class ListNode {
	int val;
	ListNode next;
	public ListNode (int value) {
		this.val = value;
		this.next = null;
	}
}

public class LinkedList {
	
	/** 
	 * 1. Print the list. If the list is [1,2,3], the output string should be "1 2 3".
	 */
	public static void print (ListNode head) {
		System.out.println("Print is callled.");
		ListNode ptr = head;
		while (ptr != null) {
			System.out.print(ptr.val + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
	
	/**
	 * 2. Return the length of the list.
	 */
	public static int length (ListNode head) {
		ListNode ptr = head;
		int res = 0;
		while (ptr != null) {
			ptr = ptr.next;
			res ++;
		}
		return res;
	}
	
	/**
	 * 3. Count the number of appearance of a target in the list. If the list is [1,3,3,4] and the target is 3, return 2 because 3 appeared twice in the list.
	 */
	public static int countTarget (ListNode head, int target) {
		ListNode ptr = head;
		int res = 0;
		while (ptr != null) {
			if (ptr.val == target)
				res ++;
			ptr = ptr.next;
		}
		return res;
	}
	
	/**
	 * 4. Get the n-th node in the list.
	 */
	public static ListNode getNth (ListNode head, int n) {
		ListNode ptr = head;
		int count = 0;
		while (ptr != null) {
			count ++;
			if (count == n) {
				return ptr;
			}
			ptr = ptr.next;
		}
		System.out.println ("The length of the list is less than n.");
		return null;
	}
	
	/**
	 * 5. Get the last n-th node in the list.
	 */
	public static ListNode getLastNth (ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		int count = 0;
		while (fast != null && count != n) {
			fast = fast.next;
			count ++;
		}
		if (fast == null) {
			System.out.println("Two short.");
			return null;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	
	/**
	 * 6. Delete the list. (This question doesn't make sense for Java because Java has garbage collection you can just make head point to null. But for C++, if you do that, there will be memory leaks.)
	 */
	
	
	/**
	 * 7. Insert a new node into the i-th position of the list. If i is 0, insert before head; if i is larger than or equal to the length of the list, insert at the end; otherwise, insert at proper positions.
	 */
	public static ListNode add (int index, int toAdd, ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode ptr = dummy;
		ptr.next = head;
		
		ListNode added = new ListNode(toAdd);
		int count = index;
		while (ptr.next != null) {
			if (count == 0) {
				added.next = ptr.next;
				ptr.next = added;
				return dummy.next;
			}
			ptr = ptr.next;
		}
		ptr.next = added;
		return dummy.next;
	}
	
	/**
	 * 8. Append a list at the end of another list.
	 */
	public static ListNode append (ListNode appendTo, ListNode extra) {
		if (appendTo == null) return extra;
		ListNode ptr = appendTo;
		while (ptr.next != null) ptr = ptr.next;
		ptr.next = extra;
		return appendTo;
	}
	
	/**
	 * Here are some more advanced ones:
	 */
	
	
	/**
	 * 1. Reverse a list. Do it iteratively and recursively.
	 */
	public static ListNode reverseIter (ListNode head) {
		ListNode dummy = new ListNode (0);
		ListNode tail = dummy;
		dummy.next = head;
		
		ListNode right = head;
		ListNode left = null;
		while (right != null) {
			tail.next = right;
			right = right.next;
			tail.next.next = left;
			left = tail.next;
		}
		return dummy.next;
	}
	
	public static ListNode reverseRecur (ListNode head) {
		if (head == null || head.next == null) return head;
		return reverseHelper (null, head);
	}
	
	private static ListNode reverseHelper (ListNode newHead, ListNode oldHead) {
		if (oldHead == null) return newHead;
		ListNode temp = oldHead;
		oldHead = oldHead.next;
		temp.next = newHead;
		newHead = temp;
		return reverseHelper (newHead, oldHead);
	}
	
	/**
	 * 2. Check if a list is palindrome. A list is palindrome if reading it left to right is same with right to left, for example [1,2,3,2,1] is palindrome while [1,2,3] is not. Try to solve this recursively.
	 */
	private static ListNode first;
	
	public static boolean isPalm (ListNode head) {
		if (head == null) return true;
		first = head;
		return palmHelper(head);
	}
	
	private static boolean palmHelper (ListNode last) {
		boolean res = true;
		if (last.next != null) res = palmHelper (last.next);
		if (last.val != first.val) 
			res = false;
		first = first.next;
		return res;
	}
	
	/**
	 * 3. Merge two sorted linked list into one sorted linked list. For example, if list A is [1, 9, 19] and list B is [3, 7, 12, 30], you should return [1, 3, 7, 9, 12, 19, 30]. Note that you should not create new linked list nodes in this operation. It doesn't matter what A or B becomes after this operation. 
	 */
	public static ListNode merge (ListNode list1, ListNode list2) {
		ListNode a = list1;
		ListNode b = list2;
		
		ListNode dummy = new ListNode (0);
		ListNode ptr = dummy;
		while (a != null && b != null) {
			if (a.val < b.val) {
				ptr.next = a;
				a = a.next;
			} else {
				ptr.next = b;
				b = b.next;
			}
			ptr = ptr.next;
			ptr.next = null;
		}
		
		if (a == null) 
			ptr.next = b;
		else 
			ptr.next = a;
		return dummy.next;
	}
	
	/**
	 * 4. Alternating split. Split an original list into two sub lists. Sublists are made from alternating elements in the original list. For example, If original list is [1, 2, 3, 4, 5, 6], you put [1, 3, 5] into the first list and [2, 4, 6] into the second list.
	 */
	public static ListNode split (ListNode original) {
		ListNode ptr = original;
		ListNode dummy = new ListNode (0);
		ListNode tail = dummy;
	
		while (ptr != null && ptr.next != null) {
			tail.next = ptr.next;
			ptr.next = ptr.next.next;
			ptr = ptr.next;
			tail = tail.next;
		}
		
		return dummy.next;
	}
	
	/**
	 * 5. Shuffle merge. As the opposite operation of the above problem, can you merge the two lists you split back into the original one?
	 */
	public static ListNode shuffleMerge (ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		ListNode head1 = list1;
		ListNode head2 = list2;
		while (head1 != null && head2 != null) {
			tail.next = head1;
			tail = tail.next;
			head1 = head1.next;
			
			tail.next = head2;
			tail = tail.next;
			head2 = head2.next;
		}
		if (head1 != null) {
			tail.next = head1;
		} else {
			tail.next = head2;
		}
		System.out.println("ShuffleMerge ended.");
		return dummy.next;
	}
	
	/**
	 * 6. Can you do a binary search for a linked list? Why or Why not?
	 */
	// No, it takes too much. We cannot reach one value by index.
	
	/**
	 * 7. Reverse a linked list by block size. For example, if the block size is 3 and the list is [1,2,3,4,5,6,7,8], the returned list should be [3,2,1,6,5,4,8,7].
	 */
	public static ListNode blockRev (ListNode head, int n) {
		int count = n;
		ListNode dummy = new ListNode (0);
		ListNode ptr = dummy;
		ListNode left = null;
		ListNode right = head;
		ListNode tail = head;
		while (right != null) {
			ListNode temp = right;
			right = right.next;
			temp.next = left;
			left = temp;
			ptr.next = temp;
			count --;
			if (count == 0) {
				ptr.next = left;
				ptr = tail;
				tail = right;
				left = null;
				count = n;
			}
		}
		return dummy.next;
	}
	
	/**
	 * 8. Complex list copy. Here we change the definition of our linked list node, not only it has pointer to its next, but it also holds a pointer to possibly any node in the linked list. How do you represent your new list node in Java? How do you copy such a complex list into a brand new one?
	 */
	// Use HashMap, old node to new node
	
	/**
	 * 9. Implement merge sort of a linked list. 
	 * Merge sort has two operations, split the list into front and back and sorted 
	 * merge them back together again. So just to divide it to small problems, you 
	 * can implement a new front_and_back split method and use the sorted_merge method 
	 * you already implemented in problem 3 of advanced ones to merge them.
	 */
	
	
	/**
	 * 10. Implement insert sort of a linked list.
	 */
	
	
	/**
	 * 11. LCA problem. You may not have heard the problem before but you can refer to http://en.wikipedia.org/wiki/Lowest_common_ancestor for a description. Basically it's a tree problem(not necessarily a binary tree). But if in the tree, nodes have pointers to its parent, it's a linked list problem. How do you solve it?
	 */
	
	
	/**
	 * Problems on LeetCode Online Judge. Each problem in LeetCode has a title. Here I just list the titles and you can always refer to its website http://www.leetcode.com/onlinejudge for the detailed description of the problem.
	 */
	
	/**
	 * 1. Add two numbers
	 */
	
	
	/**
	 * 2. Merge k sorted lists
	 */
	
	
	/**
	 * 3. Merge two sorted lists
	 */
	
	
	/**
	 * 4. Partition list
	 */
	
	
	/**
	 * 5. Remove duplicates from sorted list
	 */
	
	
	/**
	 * 6. Remove duplicates from sorted list II
	 */
	
	
	/**
	 * 7. Remove n-th node from end of list
	 */
	
	
	/**
	 * 8. Reverse linked list II
	 */
	
	
	/**
	 * 9. Reverse nodes in k-group
	 */
	
	
	/**
	 * 10. Rotate list
	 */
	
	
	/**
	 * 11. Swap nodes in pairs
	 */
	
	
}
