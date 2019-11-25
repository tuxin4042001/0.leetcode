package _3_breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2_binary_tree_level_order_traversal_II {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
				level.add(head.val);
			}
			list.add(0, level);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
