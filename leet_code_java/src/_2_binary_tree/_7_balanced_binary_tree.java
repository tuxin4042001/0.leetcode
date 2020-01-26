package _2_binary_tree;

class ResultType2 {
	boolean isBalanced;
	int height;

	public ResultType2(boolean isBalanced, int height) {
		this.isBalanced = isBalanced;
		this.height = height;
	}
}

public class _7_balanced_binary_tree {
	/**
	 * @param root: The root of binary tree.
	 * @return: True if this Binary tree is Balanced, or false.
	 */
	// 1. Traverse Method
	boolean isBalanced = true;

	public boolean isBalanced(TreeNode root) {
		// write your code here
		helper(root);
		return isBalanced;
	}

	public int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = helper(root.left);
		int rightHeight = helper(root.right);
		int height = Math.max(leftHeight, rightHeight) + 1;
		if (Math.abs(leftHeight - rightHeight) > 1) {
			isBalanced = false;
		}
		return height;
	}

	// 2. Divide Conquer
	public boolean isBalanced2(TreeNode root) {
		// write your code here
		ResultType2 result = helper2(root);
		return result.isBalanced;
	}

	public ResultType2 helper2(TreeNode root) {
		if (root == null) {
			return new ResultType2(true, 0);
		}
		ResultType2 leftResult = helper2(root.left);
		ResultType2 rightResult = helper2(root.right);
		ResultType2 result = new ResultType2(true, Math.max(leftResult.height, rightResult.height) + 1);
		if (leftResult.isBalanced == false || rightResult.isBalanced == false) {
			result.isBalanced = false;
		} else if (Math.abs(leftResult.height - rightResult.height) > 1) {
			result.isBalanced = false;
		} else {
			result.isBalanced = true;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
