package _3_breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _4_convert_binary_tree_to_linked_list {

	public List<ListNode> binaryTreeToLists(TreeNode root) {
		// Write your code here
		List<ListNode> list = new ArrayList<ListNode>();
		if (root == null) {
			return list;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		ListNode dummy = new ListNode(0);
		while (!queue.isEmpty()) {
			dummy.next = null;
			ListNode level = dummy;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				if (head.left != null) {
					queue.offer(head.left);
				}
				if (head.right != null) {
					queue.offer(head.right);
				}
				level.next = new ListNode(head.val);
				level = level.next;
			}
			list.add(dummy.next);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
