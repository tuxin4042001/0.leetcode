package _2_binary_tree;

public class _11_binary_tree_longest_consecutive_sequence {

	/**
	 * @param root: the root of binary tree
	 * @return: the length of the longest consecutive sequence path
	 */
	// 1. traverse + divide conquer
	public int longestConsecutive(TreeNode root) {
		// write your code here
		return helper(root, null, 0);
	}

	public int helper(TreeNode root, TreeNode parent, int lengthWithoutRoot) {
		if (root == null) {
			return 0;
		}
		int length = (parent != null && parent.val + 1 == root.val) ? lengthWithoutRoot + 1 : 1;
		int left = helper(root.left, root, length);
		int right = helper(root.right, root, length);
		return Math.max(length, Math.max(left, right));
	}

	// 2. another divide conquer
	int longest;

	public int longestConsecutive2(TreeNode root) {
		// write your code here
		longest = 0;
		helper(root);
		return longest;
	}

	// helper will update the longest value and also will return subtreeLongest
	// length
	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		int subtreeLongest = 1;
		if (root.left != null && root.val + 1 == root.left.val) {
			subtreeLongest = Math.max(subtreeLongest, left + 1);
		}
		if (root.right != null && root.val + 1 == root.right.val) {
			subtreeLongest = Math.max(subtreeLongest, right + 1);
		}
		if (subtreeLongest > longest) {
			longest = subtreeLongest;
		}
		return subtreeLongest;
	}

	// 3. Divide conquer
	private class ResultType {
		int maxLengthFromSubtree;
		int maxLengthFromRoot;

		public ResultType(int maxLengthFromSubtree, int maxLengthFromRoot) {
			this.maxLengthFromSubtree = maxLengthFromSubtree;
			this.maxLengthFromRoot = maxLengthFromRoot;
		}
	}

	public int longestConsecutive3(TreeNode root) {
		// write your code here
		ResultType result = helper2(root);
		return result.maxLengthFromRoot;
	}

	private ResultType helper2(TreeNode root) {
		if (root == null) {
			return new ResultType(0, 0);
		}

		ResultType left = helper2(root.left);
		ResultType right = helper2(root.right);
		ResultType result = new ResultType(0, 1);
		if (root.left != null && root.val + 1 == root.left.val) {
			result.maxLengthFromRoot = Math.max(result.maxLengthFromRoot, left.maxLengthFromRoot + 1);
		}
		if (root.right != null && root.val + 1 == root.right.val) {
			result.maxLengthFromRoot = Math.max(result.maxLengthFromRoot, right.maxLengthFromRoot + 1);
		}
		result.maxLengthFromSubtree = Math.max(result.maxLengthFromRoot,
				Math.max(left.maxLengthFromSubtree, right.maxLengthFromSubtree));
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
