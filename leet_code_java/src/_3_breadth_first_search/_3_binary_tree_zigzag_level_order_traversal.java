package _3_breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _3_binary_tree_zigzag_level_order_traversal {
	/**
	 * @param root: A Tree
	 * @return: A list of lists of integer include the zigzag level order traversal
	 *          of its nodes' values.
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		// write your code here
		boolean reverse = false;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				if (head.left != null) {
					queue.offer(head.left);
				}
				if (head.right != null) {
					queue.offer(head.right);
				}
				if (reverse == true) {
					level.add(0, head.val);
				} else {
					level.add(head.val);
				}
			}
			reverse = !reverse;
			list.add(level);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
