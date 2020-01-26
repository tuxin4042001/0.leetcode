package _4_depth_first_search;

import java.util.Stack;

import _3_breadth_first_search.TreeNode;

public class _16_binary_tree_iterator {
	private Stack<TreeNode> stack = new Stack<TreeNode>();

	/*
	 * @param root: The root of binary tree.
	 */
	public void BSTIterator(TreeNode root) {
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
		TreeNode head = stack.pop();
		if (head.right != null) {
			pushAll(head.right);
		}
		return head;
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
