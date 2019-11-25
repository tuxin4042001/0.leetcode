package _2_binary_tree;

import java.util.ArrayList;
import java.util.List;

public class _3_postorder_traverse {
	/**
	 * @param root: A Tree
	 * @return: Postorder in ArrayList which contains node values.
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		// write your code here
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		List<Integer> left = postorderTraversal(root.left);
		List<Integer> right = postorderTraversal(root.right);
		list.addAll(left);
		list.addAll(right);
		list.add(root.val);
		return list;
	}

	public List<Integer> postorderTraversal2(TreeNode root) {
		// write your code here
		List<Integer> list = new ArrayList<Integer>();
		traverse(root, list);
		return list;
	}

	private void traverse(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		traverse(root.left, list);
		traverse(root.right, list);
		list.add(root.val);
	}

}
