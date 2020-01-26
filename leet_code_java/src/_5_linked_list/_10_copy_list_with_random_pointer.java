package _5_linked_list;

import java.util.HashMap;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @author terry00
 *
 */

public class _10_copy_list_with_random_pointer {
	/**
	 * @param head: The head of linked list with a random pointer.
	 * @return: A new head of a deep copy of the list.
	 */
	// 1. Method 1: HashMap method
	public RandomListNode copyRandomList(RandomListNode head) {
		// write your code here
		if (head == null) {
			return head;
		}
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode dummy = new RandomListNode(0);
		dummy.next = head;
		RandomListNode pre = dummy;
		RandomListNode newNode = new RandomListNode(0);
		while (head != null) {
			if (map.containsKey(head)) {
				newNode = map.get(head);
			} else {
				newNode = new RandomListNode(head.label);
				map.put(head, newNode);
			}
			pre.next = newNode;
			if (head.random != null) {
				if (map.containsKey(head.random)) {
					newNode.random = map.get(head.random);
				} else {
					newNode.random = new RandomListNode(head.random.label);
					map.put(head.random, newNode.random);
				}
			}
			pre = pre.next;
			head = head.next;
		}
		return dummy.next;
	}

	// 2. Method 2: inline method, create a copy 1 -> 2 -> 3 -> 4, 1 -> 1' -> 2 ->
	// 2' -> 3 -> 3' -> 4 -> 4'
	public RandomListNode copyRandomList2(RandomListNode head) {
		// write your code here
		if (head == null) {
			return head;
		}
		copyNext(head);
		copyRandom(head);
		return splitList(head);
	}

	private void copyNext(RandomListNode head) {
		while (head != null) {
			RandomListNode newNode = new RandomListNode(head.label);
			newNode.next = head.next;
			newNode.random = head.random;
			head.next = newNode;
			head = head.next.next;
		}
	}

	private void copyRandom(RandomListNode head) {
		while (head != null) {
			if (head.next.random != null) {
				head.next.random = head.random.next;
			}
			head = head.next.next;
		}
	}

	private RandomListNode splitList(RandomListNode head) {
		RandomListNode dummy = new RandomListNode(0);
		dummy.next = head.next;
		while (head != null) {
			RandomListNode temp = head.next;
			head.next = temp.next;
			head = head.next;
			if (temp.next != null) {
				temp.next = temp.next.next;
			}
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
