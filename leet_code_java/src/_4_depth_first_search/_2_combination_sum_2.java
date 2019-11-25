package _4_depth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2_combination_sum_2 {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		// write your code here
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null) {
			return result;
		}
		List<Integer> combination = new ArrayList<Integer>();
		Arrays.sort(num);
		helper(num, 0, target, combination, result);
		return result;
	}

	void helper(int[] num, int index, int target, List<Integer> combination, List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(combination));
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
			helper(num, i + 1, target - num[i], combination, result);
			combination.remove(combination.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
