package _4_depth_first_search;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of numbers, return all possible permutations. example: Input:
 * [1,2,3], Output:[[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
 * 
 * @author terry00
 *
 */
public class _6_permutations {
	/*
	 * @param nums: A list of integers.
	 * 
	 * @return: A list of permutations.
	 */
	public List<List<Integer>> permute(int[] nums) {
		// write your code here
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (nums == null) {
			return list;
		}
		List<Integer> permutation = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.length];
		helper(nums, visited, list, permutation);
		return list;
	}

	private void helper(int[] nums, boolean[] visited, List<List<Integer>> list, List<Integer> permutation) {
		if (permutation != null && permutation.size() == nums.length) {
			list.add(new ArrayList(permutation));
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
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

	}

}
