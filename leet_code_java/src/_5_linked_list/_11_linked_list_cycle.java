package _5_linked_list;

import java.util.HashMap;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Example 1: Input: 21->10->4->5, then tail connects to node index 1(value 10).
 * 
 * Output: true
 * 
 * Example 2: Input: 21->10->4->5->null
 * 
 * Output: false
 * 
 * @author terry00
 *
 */

public class _11_linked_list_cycle {
	/**
	 * @param head: The first node of linked list.
	 * @return: True if it has a cycle, or false
	 */
	// 1. Method 1: use hash map
	public boolean hasCycle(ListNode head) {
		// write your code here
		if (head == null) {
			return false;
		}
		HashMap<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
		while (head != null) {
			if (map.containsKey(head)) {
				return true;
			} else {
				map.put(head, head);
				head = head.next;
			}
		}
		return false;
	}

	// 2. Method 2: use two pointers
	public boolean hasCycle2(ListNode head) {
		// write your code here
		if (head == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (slow.next != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(0);
		head.next = head;
		_11_linked_list_cycle rs = new _11_linked_list_cycle();
		boolean result = rs.hasCycle(head);
		System.out.print(result);
	}

}
