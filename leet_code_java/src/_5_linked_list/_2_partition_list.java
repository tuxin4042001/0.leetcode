package _5_linked_list;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example 1:
 * 
 * Input: list = null, x = 0 Output: null Explanation: The empty list Satisfy
 * the conditions by itself.
 * 
 * Example 2:
 * 
 * Input: list = 1->4->3->2->5->2->null, x = 3 Output: 1->2->2->4->3->5->null
 * 
 * @author terry00
 *
 */
public class _2_partition_list {
	/**
	 * @param head: The first node of linked list
	 * @param x:    An integer
	 * @return: A ListNode
	 */
	public ListNode partition(ListNode head, int x) {
		// write your code here
		if (head == null) {
			return null;
		}
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode curr1 = dummy1;
		ListNode curr2 = dummy2;
		while (head != null) {
			if (head.val < x) {
				curr1.next = head;
				curr1 = curr1.next;
			} else {
				curr2.next = head;
				curr2 = curr2.next;
			}
			head = head.next;
		}
		curr2.next = null;
		curr1.next = dummy2.next;
		return dummy1.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
