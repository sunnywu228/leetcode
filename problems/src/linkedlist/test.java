package linkedlist;

public class test {
	public static void main (String []args) {
		ListNode list1 = new ListNode (1);
		LinkedList.add(10, 5, list1);
		LinkedList.add(10, 6, list1);
		LinkedList.add(10, 9, list1);
		LinkedList.add(10, 3, list1);
		LinkedList.add(10, 12, list1);
		LinkedList.print(list1);
		
		ListNode list2 = new ListNode (11);
		System.out.println(LinkedList.getLastNth(list1, 1).val);
		LinkedList.append(list1, list2);
		LinkedList.print(list1);
		list1 = LinkedList.reverseIter(list1);
		LinkedList.print(list1);
		list1 = LinkedList.reverseRecur(list1);
		LinkedList.print(list1);
		LinkedList.add(10, 2, list2);
		LinkedList.add(10, 5, list2);
		LinkedList.add(10, 5, list2);
		LinkedList.add(10, 2, list2);
		LinkedList.add(10, 1, list2);
		LinkedList.print(list2);
		System.out.println(LinkedList.isPalm(list2));
		
		ListNode list3 = new ListNode (1);
		LinkedList.add(10, 5, list3);
		LinkedList.add(10, 6, list3);
		LinkedList.add(10, 9, list3);
		LinkedList.add(10, 11, list3);
		LinkedList.add(10, 12, list3);
		LinkedList.print(list3);
		
		ListNode list4 = new ListNode (0);
		LinkedList.add(10, 3, list4);
		LinkedList.add(10, 4, list4);
		LinkedList.add(10, 8, list4);
		LinkedList.add(10, 11, list4);
		LinkedList.add(10, 15, list4);
		LinkedList.print(list4);
		list3 = LinkedList.merge(list3, list4);
		LinkedList.print(list3);
		
		list4 = LinkedList.split(list3);
		LinkedList.print(list4);
		LinkedList.print(list3);
		
		list3 = LinkedList.shuffleMerge(list3, list4);
		LinkedList.print(list3);
		LinkedList.print(LinkedList.blockRev(list3, 5));
	}
}
