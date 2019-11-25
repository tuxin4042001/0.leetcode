package _4_depth_first_search;

import java.util.ArrayList;
import java.util.List;

public class _6_permutations {

	public List<List<Integer>> permute(int[] nums) {
		// write your code here
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null) {
			return result;
		}
		List<Integer> list = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.length];
		backTrack(nums, visited, list, result);
		return result;
	}

	private void backTrack(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}
			list.add(nums[i]);
			visited[i] = true;
			backTrack(nums, visited, list, result);
			visited[i] = false;
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
