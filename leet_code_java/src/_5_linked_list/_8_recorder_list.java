package _5_linked_list;

/**
 * Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln
 * 
 * reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * 
 * Example 1: Input: 1->2->3->4->null Output: 1->4->2->3->null
 * 
 * Example 2: Input: 1->2->3->4->5->null Output: 1->5->2->4->3->null
 * 
 * @author terry00
 *
 */

public class _8_recorder_list {
	/**
	 * @param head: The head of linked list.
	 * @return: nothing
	 */
	public void reorderList(ListNode head) {
		// write your code here
		if (head == null || head.next == null) {
			return;
		}
		ListNode mid = findMiddle(head);
		ListNode tail = reverse(mid.next);
		mid.next = null;
		merge(head, tail);
	}

	// 1. find middle node, use two pointer, fast and slow
	private ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	// 2. inline reverse linked list
	private ListNode reverse(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		return newHead;
	}

	// 3. inline merge two linked list, why head1 move forward, however node1 in
	// main function not move
	private void merge(ListNode head1, ListNode head2) {
		int index = 0;
		ListNode dummy = new ListNode(0);
		while (head1 != null && head2 != null) {
			if (index % 2 == 0) {
				dummy.next = head1;
				head1 = head1.next;
			} else {
				dummy.next = head2;
				head2 = head2.next;
			}
			dummy = dummy.next;
			index++;
		}
		if (head1 != null) {
			dummy.next = head1;
		} else {
			dummy.next = head2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		_8_recorder_list rs = new _8_recorder_list();
		rs.merge(node1, node3);
	}

}
