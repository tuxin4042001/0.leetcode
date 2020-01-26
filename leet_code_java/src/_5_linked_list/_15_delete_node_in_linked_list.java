package _5_linked_list;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked
 * list, given only access to that node.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->null 3 Output: 1->2->4->null
 * 
 * Example 2:
 * 
 * Input: 1->3->5->null 3 Output: 1->5->null
 * 
 * @author terry00
 *
 */

public class _15_delete_node_in_linked_list {
	/*
	 * @param node: the node in the list should be deleted
	 * 
	 * @return: nothing
	 */
	public void deleteNode(ListNode node) {
		// write your code here
		if (node != null && node.next != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
