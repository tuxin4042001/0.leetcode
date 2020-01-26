package _5_linked_list;

/**
 * Reverse a linked list.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->null Output: 3->2->1->null
 * 
 * Example 2:
 * 
 * Input: 1->2->3->4->null Output: 4->3->2->1->null
 * 
 * @author terry00
 *
 */
public class _4_reverse_linked_list {
	/**
	 * @param head: n
	 * @return: The new head of reversed linked list.
	 */
	public ListNode reverse(ListNode head) {
		// write your code here
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode start = pre.next;
		ListNode end = start.next;
		while (end != null) {
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
