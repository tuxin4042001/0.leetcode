package _2_binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _2_inorder_traverse {
	/**
	 * @param root: A Tree
	 * @return: Inorder in ArrayList which contains node values.
	 */
	// 1. 使用stack, 先左后右
	public List<Integer> inorderTraversal(TreeNode root) {
		// write your code here
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		// if curr.left not null, continue to push the curr.left into stack
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			list.add(curr.val);
			curr = curr.right;
		}
		return list;
	}

	// 2. 分治法，处理好 left root.val right的关系
	public List<Integer> inorderTraversal2(TreeNode root) {
		// write your code here
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		List<Integer> left = inorderTraversal2(root.left);
		List<Integer> right = inorderTraversal2(root.right);
		list.addAll(left);
		list.add(root.val);
		list.addAll(right);
		return list;
	}

	// 3.Traverse, 本质和分治法一致，就是处理好左右的关系
	public List<Integer> inorderTraversal3(TreeNode root) {
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
		list.add(root.val);
		traverse(root.right, list);
	}

}
