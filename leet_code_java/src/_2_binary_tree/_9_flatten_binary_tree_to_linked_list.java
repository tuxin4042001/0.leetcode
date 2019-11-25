package _2_binary_tree;

import java.util.Stack;

public class _9_flatten_binary_tree_to_linked_list {
	/**
	 * @param root: a TreeNode, the root of the binary tree
	 * @return: nothing
	 */
	// 1. Stack Method
	public void flatten(TreeNode root) {
		// write your code here
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (stack.size() != 0) {
			TreeNode head = stack.pop();
			if (head.right != null) {
				stack.push(head.right);
			}
			if (head.left != null) {
				stack.push(head.left);
			}
			if (stack.size() != 0) {
				head.left = null;
				head.right = stack.peek();
			}
		}
	}

	// 2. Traverse
	TreeNode lastNode = null;

	public void flatten2(TreeNode root) {
		// write your code here
		if (root == null) {
			return;
		}

		if (lastNode != null) {
			lastNode.left = null;
			lastNode.right = root;
		}
		lastNode = root;

		TreeNode right = root.right;
		flatten2(root.left);
		flatten2(right);
	}

	// 3. Divide Conquer
	public void flatten3(TreeNode root) {
		// write your code here
		helper(root);
	}

	private TreeNode helper(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode leftLast = helper(root.left);
		TreeNode rightLast = helper(root.right);
		if (leftLast != null) {
			leftLast.right = root.right;
			root.right = root.left;
			root.left = null;
		}
		if (rightLast != null) {
			return rightLast;
		}
		if (leftLast != null) {
			return leftLast;
		}
		return root;
	}

}