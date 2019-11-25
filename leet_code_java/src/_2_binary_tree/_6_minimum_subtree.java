package _2_binary_tree;

class ResultType {
	public TreeNode minSubtree;
	public int sum, minSum;

	public ResultType(TreeNode minSubtree, int minSum, int sum) {
		this.minSubtree = minSubtree;
		this.minSum = minSum;
		this.sum = sum;
	}
}

public class _6_minimum_subtree {

	private TreeNode subtree = null;
	private int subtreeSum = Integer.MAX_VALUE;

	// 1.Traverse + Divide Conquer
	// helper return integer, but can have no variable receive the value;
	public TreeNode findSubtree(TreeNode root) {
		helper(root);
		return subtree;
	}

	public int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = root.val + helper(root.left) + helper(root.right);
		if (sum <= subtreeSum) {
			subtreeSum = sum;
			subtree = root;
		}
		return sum;
	}

	// 2.Pure divide conquer + ResultType
	public TreeNode findSubtree2(TreeNode root) {
		ResultType result = helper2(root);
		return result.minSubtree;
	}

	public ResultType helper2(TreeNode root) {
		if (root == null) {
			return new ResultType(null, Integer.MAX_VALUE, 0);
		}
		ResultType leftResult = helper2(root.left);
		ResultType rightResult = helper2(root.right);

		ResultType result = new ResultType(root, root.val + leftResult.sum + rightResult.sum,
				root.val + leftResult.sum + rightResult.sum);
		if (leftResult.minSum <= result.minSum) {
			result.minSubtree = leftResult.minSubtree;
			result.minSum = leftResult.minSum;
		}

		if (rightResult.minSum <= result.minSum) {
			result.minSubtree = rightResult.minSubtree;
			result.minSum = rightResult.minSum;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
