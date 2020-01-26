package _5_linked_list;

/**
 * Given a linked list and two values v1 and v2. Swap the two nodes in the
 * linked list with values v1 and v2. It's guaranteed there is no duplicate
 * values in the linked list. If v1 or v2 does not exist in the given linked
 * list, do nothing.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->null, v1 = 2, v2 = 4 Output: 1->4->3->2->null
 * 
 * Example 2:
 * 
 * Input: 1->null, v1 = 2, v2 = 1 Output: 1->null
 * 
 * @author terry00
 *
 */

public class _6_swap_two_nodes_in_linked_list {
	/**
	 * @param head: a ListNode
	 * @param v1:   An integer
	 * @param v2:   An integer
	 * @return: a new head of singly-linked list
	 */
	public ListNode swapNodes(ListNode head, int v1, int v2) {
		// write your code here
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode node1Prev = null, node2Prev = null;
		ListNode curr = dummy;
		// find node1Prev and node2Prev
		while (curr.next != null) {
			if (curr.next.val == v1) {
				node1Prev = curr;
			} else if (curr.next.val == v2) {
				node2Prev = curr;
			}
			curr = curr.next;
		}

		// return head if node1Prev or node2Prev is null
		if (node1Prev == null || node2Prev == null) {
			return head;
		}

		// swap two nodes
		// 1. scenario 1: some node --> node2 --> node1 --> some node, not clear why
		if (node2Prev.next == node1Prev) {
			ListNode t = node1Prev;
			node1Prev = node2Prev;
			node2Prev = t;
		}

		ListNode node1 = node1Prev.next;
		ListNode node2 = node2Prev.next;
		ListNode next = node2.next;

		// 2. scenario 2: some node --> node1 --> node2 --> some node
		if (node1Prev.next == node2Prev) {
			node1Prev.next = node2;
			node2.next = node1;
			node1.next = next;
			// 3. scenario 3: some node --> node1 --> some node --> node2
			// scenario 4: some node --> node2 --> some node --> node1
		} else {
			node1Prev.next = node2;
			node2.next = node1.next;

			node2Prev.next = node1;
			node1.next = next;
		}
		return dummy.next;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
