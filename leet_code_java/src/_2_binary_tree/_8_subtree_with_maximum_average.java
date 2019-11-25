package _2_binary_tree;

// Solution1: traverse and divide conquer
public class _8_subtree_with_maximum_average {
	/**
	 * @param root: the root of binary tree
	 * @return: the root of the maximum average of subtree
	 */
	class ResultType {
		int sum = 0;
		int size = 0;

		public ResultType(int sum, int size) {
			this.sum = sum;
			this.size = size;
		}
	}
	
	TreeNode subtree = null;
	ResultType subtreeResult = null;

	public TreeNode findSubtree2(TreeNode root) {
		// write your code here
		helper(root);
		return subtree;
	}

	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, 0);
		}

		ResultType leftResult = helper(root.left);
		ResultType rightResult = helper(root.right);
		ResultType result = new ResultType(root.val + leftResult.sum + rightResult.sum,
				1 + leftResult.size + rightResult.size);

		if (subtree == null || subtreeResult.sum * result.size < result.sum * subtreeResult.size) {
			subtree = root;
			subtreeResult = result;
		}
		return result;
	}
}