package _5_linked_list;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * Input: 1->3->2->null Output: 1->2->3->null
 * 
 * Example 2:
 * 
 * Input: 1->7->2->6->null Output: 1->2->6->7->null
 * 
 * @author terry00
 *
 */

public class _13_sort_list {
	/**
	 * @param head: The head of linked list.
	 * @return: You should return the head of the sorted linked list, using constant
	 *          space complexity.
	 */
	// 1. Method 1: merge method
	public ListNode sortList(ListNode head) {
		// write your code here
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		ListNode slow = head;
		ListNode fast = head;
		// 1. separate half and half
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;

		// 2. sort first half list and second half list
		head = sortList(head);
		slow = sortList(slow);

		// 3. merge
		return merge(head, slow);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}

		if (l1 != null) {
			curr.next = l1;
		}

		if (l2 != null) {
			curr.next = l2;
		}

		return dummy.next;
	}

	public ListNode sortList2(ListNode head) {
		// write your code here
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode small = dummy1;
		ListNode large = dummy2;
		ListNode prev = head;
		ListNode node = head.next;
		while (node != null) {
			if (head.val < node.val) {
				large.next = node;
				large = large.next;
			} else if (head.val == node.val) {
				prev.next = node;
				prev = prev.next;
			} else {
				small.next = node;
				small = small.next;
			}
			node = node.next;
		}
		small.next = prev.next = large.next = null;
		dummy1.next = sortList(dummy1.next);
		dummy2.next = sortList(dummy2.next);
		small = dummy1;
		while (small.next != null) {
			small = small.next;
		}
		small.next = head;
		prev.next = dummy2.next;
		return dummy1.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
