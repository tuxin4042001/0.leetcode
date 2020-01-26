package _4_depth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array num and a number target. Find all unique combinations in num
 * where the numbers sum to target.
 * 
 * 1.Example 1: Input: num = [7,1,2,5,1,6,10], target = 8 Output:
 * [[1,1,6],[1,2,5],[1,7],[2,6]] 2.Example 2: Input: num = [1,1,1], target = 2
 * Output: [[1,1]]
 * 
 * @author terry
 *
 */
public class _2_combination_sum_2 {
	/**
	 * @param num:    Given the candidate numbers
	 * @param target: Given the target number
	 * @return: All the combinations that sum to target
	 */
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		// write your code here
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> combination = new ArrayList<Integer>();
		if (num == null) {
			return list;
		}
		Arrays.sort(num);
		helper(num, 0, list, combination, target);
		return list;
	}

	private void helper(int[] num, int index, List<List<Integer>> list, List<Integer> combination, int target) {
		if (target == 0) {
			list.add(new ArrayList(combination));
			return;
		}
		for (int i = index; i < num.length; i++) {
			if (num[i] > target) {
				break;
			}
			if (i != index && num[i] == num[i - 1]) {
				continue;
			}
			combination.add(num[i]);
			helper(num, i + 1, list, combination, target - num[i]);
			combination.remove(combination.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
