package _5_linked_list;

import _3_breadth_first_search.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * Example 1: Input: array = 1->2->3 Output: 2 / \ 1 3
 * 
 * Example 2: Input: 2->3->6->7 Output: 3 / \ 2 6 \ 7
 * 
 * @author terry00
 *
 */

public class _14_convert_sorted_list_to_binary_search_tree {
	/*
	 * @param head: The first node of linked list.
	 * 
	 * @return: a tree node
	 */
	// 1. Method 1: how to deal with two pointer slow, fast
	// if(fast != null && fast.next.next != null) fast = fast.next.next;
	public TreeNode sortedListToBST(ListNode head) {
		// write your code here
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode slow = head;
		ListNode fast = head;
		if (fast != null && fast.next != null) {
			fast = fast.next.next;
		}
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode tree = new TreeNode(slow.next.val);
		TreeNode treeRight = sortedListToBST(slow.next.next);
		slow.next = null;
		TreeNode treeLeft = sortedListToBST(head);
		tree.left = treeLeft;
		tree.right = treeRight;
		return tree;
	}

	// 2. Method 2: how to deal with two pointer slow, fast
	// use helper method BST(head, tail)
	public TreeNode sortedListToBST2(ListNode head) {
		// write your code here
		if (head == null) {
			return null;
		}
		return BST(head, null);
	}

	private TreeNode BST(ListNode head, ListNode tail) {
		if (head == tail) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode tree = new TreeNode(slow.val);
		tree.left = BST(head, slow);
		tree.right = BST(slow.next, tail);
		return tree;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
