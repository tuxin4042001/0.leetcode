package _2_binary_tree;

public class _4_maximum_depth_binary_tree {
	/**
	 * @param root: The root of binary tree.
	 * @return: An integer
	 */
	public int maxDepth(TreeNode root) {
		// write your code here
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}

	int depth = 0;

	public int maxDepth2(TreeNode root) {
		// write your code here
		traverse(root, 1);
		return depth;
	}

	private void traverse(TreeNode root, int currDepth) {
		if (root == null) {
			return;
		}
		if (depth < currDepth) {
			depth = currDepth;
		}
		traverse(root.left, currDepth + 1);
		traverse(root.right, currDepth + 1);
	}

}
