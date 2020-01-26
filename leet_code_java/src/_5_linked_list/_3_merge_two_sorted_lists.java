package _5_linked_list;

/**
 * Merge two sorted (ascending) linked lists and return it as a new sorted list.
 * The new sorted list should be made by splicing together the nodes of the two
 * lists and sorted in ascending order.
 * 
 * Example 1: Input: list1 = null, list2 = 0->3->3->null Output: 0->3->3->null
 * 
 * 
 * Example 2: Input: list1 = 1->3->8->11->15->null, list2 = 2->null Output:
 * 1->2->3->8->11->15->null
 * 
 * @author terry00
 *
 */
public class _3_merge_two_sorted_lists {
	/**
	 * @param l1: ListNode l1 is the head of the linked list
	 * @param l2: ListNode l2 is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	// 1. method 1, no recursive method
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// write your code here
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		ListNode curr1 = l1;
		ListNode curr2 = l2;
		while (curr1 != null && curr2 != null) {
			if (curr1.val < curr2.val) {
				curr.next = curr1;
				curr = curr.next;
				curr1 = curr1.next;
			} else {
				curr.next = curr2;
				curr = curr.next;
				curr2 = curr2.next;
			}
		}
		if (curr1 == null) {
			curr.next = curr2;
		}
		if (curr2 == null) {
			curr.next = curr1;
		}
		return dummy.next;
	}

	// 2. method 2, recursive method
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		// write your code here
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists2(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists2(l1, l2.next);
			return l2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
