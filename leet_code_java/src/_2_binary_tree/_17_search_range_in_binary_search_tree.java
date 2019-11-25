package _2_binary_tree;

import java.util.ArrayList;

public class _17_search_range_in_binary_search_tree {
	private ArrayList<Integer> results;

	/**
	 * @param root: The root of the binary search tree.
	 * @param k1    and k2: range k1 to k2.
	 * @return: Return all keys that k1<=key<=k2 in increasing order.
	 */
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		results = new ArrayList<Integer>();
		helper(root, k1, k2);
		return results;
	}

	private void helper(TreeNode root, int k1, int k2) {
		if (root == null) {
			return;
		}
		if (root.val > k1) {
			helper(root.left, k1, k2);
		}
		if (root.val >= k1 && root.val <= k2) {
			results.add(root.val);
		}
		if (root.val < k2) {
			helper(root.right, k1, k2);
		}
	}
}
