package _2_binary_tree;

import java.util.ArrayList;
import java.util.List;

public class _13_binary_tree_path_sum_II {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> solution = new ArrayList<Integer>();
		helper(list, solution, root, sum);
		return list;
	}

	private void helper(List<List<Integer>> list, List<Integer> solution, TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		sum = sum - root.val;
		if (root.left == null && root.right == null) {
			if (sum == 0) {
				solution.add(root.val);
				list.add(new ArrayList<Integer>(solution));
				solution.remove(solution.size() - 1);
			}
			return;
		}
		solution.add(root.val);
		helper(list, solution, root.left, sum);
		helper(list, solution, root.right, sum);
		solution.remove(solution.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
