package _7_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an integer array, find a subarray where the sum of numbers is zero.
 * Your code should return the index of the first number and the index of the
 * last number.
 * 
 * Example 1:
 * 
 * Input: [-3, 1, 2, -3, 4] Output: [0, 2] or [1, 3]. Explanation: return anyone
 * that the sum is 0.
 * 
 * Example 2:
 * 
 * Input: [-3, 1, -4, 2, -3, 4] Output: [1,5]
 * 
 * @author terry00
 *
 */

public class _3_subarray_sum {
	/**
	 * @param nums: A list of integers
	 * @return: A list of integers includes the index of the first number and the
	 *          index of the last number
	 */
	// 1. Method 1: two pointers
	public List<Integer> subarraySum(int[] nums) {
		// write your code here
		List<Integer> list = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return list;
		}
		for (int i = 0; i < nums.length; i++) {
			int sum = nums[i];
			if (sum == 0) {
				list.add(i);
				list.add(i);
				return list;
			} else {
				for (int j = i + 1; j < nums.length; j++) {
					sum += nums[j];
					if (sum == 0) {
						list.add(i);
						list.add(j);
						return list;
					}
				}

			}
		}
		return list;
	}

	// 2. Method 2: hash map + array difference
	// map.key: sum - k = sum - 0 = sum
	// map.val: index
	// if sum appear in nums[i] and appear in nums[j] again
	// list should be {i + 1, j}
	// url:
	// https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-%2B-HashMap
	public List<Integer> subarraySum2(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}
		List<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				list.add(map.get(sum));
				list.add(i);
				return list;
			}
			map.put(sum, i + 1);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
