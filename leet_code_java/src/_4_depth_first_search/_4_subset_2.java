package _4_depth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set). Note: The solution set must not contain
 * duplicate subsets.
 * 
 * Input: [1,2,2] Output:[[2], [1], [1,2,2], [2,2], [1,2], []]
 * 
 * @author terry
 *
 */
public class _4_subset_2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> subset = new ArrayList<Integer>();
		if (nums == null) {
			return list;
		}
		Arrays.sort(nums);
		helper(nums, 0, list, subset);
		return list;
	}

	private void helper(int[] nums, int index, List<List<Integer>> list, List<Integer> subset) {
		if (subset != null) {
			list.add(new ArrayList(subset));
		}
		for (int i = index; i < nums.length; i++) {
			if (i != index && nums[i] == nums[i - 1]) {
				continue;
			}
			subset.add(nums[i]);
			helper(nums, i + 1, list, subset);
			subset.remove(subset.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
