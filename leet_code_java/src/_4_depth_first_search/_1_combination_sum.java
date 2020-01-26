package _4_depth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidtate numbers candidates and a target number target. Find
 * all unique combinations in candidates where the numbers sums to target.
 * 
 * 1.example 1: Input: candidates = [2, 3, 6, 7], target = 7 | Output: [[7], [2,
 * 2, 3]] 2.example 2: Input: candidates = [1], target = 3, Output: [[1, 1, 1]]
 * 
 * @author terry
 *
 */
public class _1_combination_sum {
	/**
	 * @param candidates: A list of integers
	 * @param target:     An integer
	 * @return: A list of lists of integers
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		// write your code here
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> combination = new ArrayList<Integer>();
		if (candidates == null) {
			return list;
		}
		Arrays.sort(candidates);
		helper(candidates, 0, list, combination, target);
		return list;
	}

	private void helper(int[] candidates, int index, List<List<Integer>> list, List<Integer> combination, int target) {
		if (target == 0) {
			list.add(new ArrayList(combination));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] > target) {
				break;
			}
			if (i != index && candidates[i] == candidates[i - 1]) {
				continue;
			}
			combination.add(candidates[i]);
			helper(candidates, i, list, combination, target - candidates[i]);
			combination.remove(combination.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
