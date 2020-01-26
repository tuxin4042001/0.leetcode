package _2_binary_tree;

public class _10_lowerest_common_ancester {
	/*
	 * @param root: The root of the binary search tree.
	 * 
	 * @param A: A TreeNode in a Binary.
	 * 
	 * @param B: A TreeNode in a Binary.
	 * 
	 * @return: Return the least common ancestor(LCA) of the two nodes.
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null || A == root || B == root) {
			return root;
		}
		// 1. find the lowest common ancestor from root
		// 2. find the lowest common ancestor from root.left
		// 3. find the lowest common ancestor from root.right
		// Notice: they could be exist at the same time since there could two same nodes
		// A or B
		TreeNode left = lowestCommonAncestor(root.left, A, B);
		TreeNode right = lowestCommonAncestor(root.right, A, B);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
