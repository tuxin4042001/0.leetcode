package _5_linked_list;

/**
 * Reverse a linked list from position m to n.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->5->NULL, m = 2 and n = 4, Output: 1->4->3->2->5->NULL.
 * 
 * Example 2:
 * 
 * Input: 1->2->3->4->NULL, m = 2 and n = 3, Output: 1->3->2->4->NULL.
 * 
 * @author terry00
 *
 */

public class _5_reverse_linked_list_II {
	/**
	 * @param head: ListNode head is the head of the linked list
	 * @param m:    An integer
	 * @param n:    An integer
	 * @return: The head of the reversed ListNode
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// write your code here
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		for (int i = 0; i < m - 1; i++) {
			pre = pre.next;
		}
		ListNode start = pre.next;
		ListNode end = start.next;
		for (int i = 0; i < n - m; i++) {
			start.next = end.next;
			end.next = pre.next;
			pre.next = end;
			end = start.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
