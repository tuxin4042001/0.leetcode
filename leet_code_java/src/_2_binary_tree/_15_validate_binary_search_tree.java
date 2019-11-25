package _2_binary_tree;

public class _15_validate_binary_search_tree {
	/**
	 * @param root: The root of binary tree.
	 * @return: True if the binary tree is BST, or false
	 */
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.val >= max || root.val <= min) {
			return false;
		}
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
