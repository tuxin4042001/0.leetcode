package _2_binary_tree;

import java.util.Stack;

public class _16_binary_search_tree_iterator {
	/*
	 * @param root: The root of binary tree.
	 */
	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public _16_binary_search_tree_iterator(TreeNode root) {
		// do intialization if necessary
		pushAll(root);
	}

	/*
	 * @return: True if there has next node, or false
	 */
	public boolean hasNext() {
		// write your code here
		return !stack.isEmpty();
	}

	/*
	 * @return: return next node
	 */
	public TreeNode next() {
		// write your code here
		TreeNode header = stack.pop();
		if (header.right != null)
			pushAll(header.right);
		return header;
	}

	private void pushAll(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
