package _5_linked_list;

import java.util.Stack;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * 
 * Example 1
 * 
 * Input: list = 1->2->3->4->5->null k = 2 Output: 2->1->4->3->5
 * 
 * Example 2
 * 
 * Input: list = 1->2->3->4->5->null k = 3 Output: 3->2->1->4->5
 * 
 * analysis: https://www.youtube.com/watch?v=pLx1VP-FnuY
 * 
 * @author terry00
 *
 */

public class _1_reverse_nodes_in_k_group {
	/**
	 * @param head: a ListNode
	 * @param k:    An integer
	 * @return: a ListNode
	 */
	// 1. method 1, use stack to implement reverse
	public ListNode reverseKGroup(ListNode head, int k) {
		// write your code here
		if (head == null) {
			return null;
		}
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;
		ListNode next = dummy.next;
		while (next != null) {
			for (int i = 0; i < k; i++) {
				if (next != null) {
					stack.push(next);
					next = next.next;
				} else {
					break;
				}
			}
			// not enough node
			if (stack.size() != k) {
				return dummy.next;
			}
			while (stack.size() != 0) {
				current.next = stack.pop();
				current = current.next;
			}
			current.next = next;
		}
		return dummy.next;
	}

	// 2. method 2, without stack
	public ListNode reverseKGroup2(ListNode head, int k) {
		// write your code here
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		while (prev != null) {
			prev = reverse(prev, k);
		}
		return dummy.next;
	}

	private ListNode reverse(ListNode prev, int k) {
		// Avoid to prev == null
		ListNode last = prev;
		for (int i = 0; i < k + 1; i++) {
			last = last.next;
			if (i != k && last == null) {
				return null;
			}
		}
		/**
		 * dummy ---> 1 ---> 2 ---> 3 ---> 4 ---> null prev tail curr next last 2 ---> 1
		 * dummy ---> 2 ---> 1 dummy ---> 2 ---> 1 ---> 3 tail always point to 1, and
		 * curr always point to node you want to reverse
		 */
		ListNode tail = prev.next;
		ListNode curr = prev.next.next;
		while (curr != last) {
			ListNode next = curr.next;
			curr.next = prev.next;
			prev.next = curr;
			tail.next = next;
			curr = next;
		}
		return tail;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		node3.next = node4;
		node2.next = node3;
		node1.next = node2;
		_1_reverse_nodes_in_k_group rs = new _1_reverse_nodes_in_k_group();
		ListNode result = rs.reverseKGroup(node1, 2);
	}

}
