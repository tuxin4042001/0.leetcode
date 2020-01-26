package _5_linked_list;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example:
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * @author terry00
 *
 */

public class _7_swap_nodes_in_pairs {
	// 1. method 1: recursion method
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode n = head.next;
		head.next = swapPairs(head.next.next);
		n.next = head;
		return n;
	}

	// 2. method 2: inline swap
	public ListNode swapPairs2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = dummy;
		while (curr.next != null && curr.next.next != null) {
			ListNode node1 = curr.next;
			ListNode node2 = curr.next.next;
			ListNode next = node2.next;
			curr.next = node2;
			node2.next = node1;
			node1.next = next;
			curr = curr.next.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
