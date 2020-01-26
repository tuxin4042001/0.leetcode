package _4_depth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of numbers with duplicate number in it. Find all unique
 * permutations. Input: [1,2,2] Output:[[1,2,2],[2,1,2],[2,2,1]]
 * 
 * @author terry00
 *
 */
public class _7_permutations_II {
	/*
	 * @param : A list of integers
	 * 
	 * @return: A list of unique permutations
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		// write your code here
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (nums == null) {
			return list;
		}
		List<Integer> permutation = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums);
		helper(nums, visited, list, permutation);
		return list;
	}

	private void helper(int[] nums, boolean[] visited, List<List<Integer>> list, List<Integer> permutation) {
		if (permutation.size() == nums.length) {
			list.add(new ArrayList(permutation));
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}
			if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
				continue;
			}
			permutation.add(nums[i]);
			visited[i] = true;
			helper(nums, visited, list, permutation);
			visited[i] = false;
			permutation.remove(permutation.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1 };
		_7_permutations_II r = new _7_permutations_II();
		List<List<Integer>> result = r.permuteUnique(nums);
	}

}
