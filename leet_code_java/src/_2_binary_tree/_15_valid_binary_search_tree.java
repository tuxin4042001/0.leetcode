package _2_binary_tree;

public class _15_valid_binary_search_tree {
	/**
	 * @param root: The root of binary tree.
	 * @return: True if the binary tree is BST, or false
	 */
	public boolean isValidBST(TreeNode root) {
		// write your code here
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean helper(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.val <= min || root.val >= max) {
			return false;
		}
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
