package _4_depth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4_subset_2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		// write your code here
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null) {
			return result;
		}
		List<Integer> subset = new ArrayList<Integer>();
		Arrays.sort(nums);
		helper(nums, 0, subset, result);
		return result;
	}

	void helper(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
		result.add(new ArrayList<Integer>(subset));
		for (int i = index; i < nums.length; i++) {
			if (i != index && nums[i] == nums[i - 1]) {
				continue;
			}
			subset.add(nums[i]);
			helper(nums, i + 1, subset, result);
			subset.remove(subset.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
