package _2_binary_tree;

public class _14_binary_tree_path_sum_III {
	class Solution {
		public int pathSum(TreeNode root, int sum) {
			if (root == null)
				return 0;
			return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
		}

		private int helper(TreeNode node, int sum) {
			int result = 0;
			if (node == null)
				return result;
			if (node.val == sum)
				result = 1;
			return result + helper(node.left, sum - node.val) + helper(node.right, sum - node.val);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
