package _7_array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an integer array, find a subarray with sum closest to zero. Return the
 * indexes of the first number and last number.
 * 
 * Example1
 * 
 * Input: [-3,1,1,-3,5] Output: [0,2] Explanation: [0,2], [1,3], [1,1], [2,2],
 * [0,4]
 * 
 * @author terry00
 *
 */

class Pair {
	int sum;
	int index;

	public Pair(int sum, int index) {
		this.sum = sum;
		this.index = index;
	}
}

public class _4_subarray_sum_closest {
	/*
	 * @param nums: A list of integers
	 * 
	 * @return: A list of integers includes the index of the first number and the
	 * index of the last number
	 */
	public int[] subarraySumClosest(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return new int[] { 0, 0 };
		}
		int[] arr = new int[2];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int sum = nums[i];
			if (sum == 0) {
				arr[0] = i;
				arr[1] = i;
				return arr;
			} else if (Math.abs(sum) < min) {
				min = Math.min(Math.abs(sum), min);
				arr[0] = i;
				arr[1] = i;
			}
			for (int j = i + 1; j < nums.length; j++) {
				sum += nums[j];
				if (sum == 0) {
					arr[0] = i;
					arr[1] = j;
					return arr;
				} else if (Math.abs(sum) < min) {
					min = Math.min(Math.abs(sum), min);
					arr[0] = i;
					arr[1] = j;
				}
			}
		}
		return arr;
	}

	// url:
	// https://yeqiuquan.blogspot.com/2017/04/lintcode-139-subarray-sum-closest.html
	public int[] subarraySumClosest2(int[] nums) {
		// write your code here
		int[] res = new int[2];
		if (nums == null || nums.length == 0) {
			return res;
		}

		if (nums.length == 1) {
			res[0] = 0;
			res[1] = 0;
			return res;
		}

		Pair[] prefixSum = new Pair[nums.length + 1];
		prefixSum[0] = new Pair(0, 0);
		for (int i = 1; i <= nums.length; i++) {
			prefixSum[i] = new Pair(prefixSum[i - 1].sum + nums[i - 1], i);
		}

		Pair[] sortedSum = prefixSum;
		Arrays.sort(sortedSum, new Comparator<Pair>() {
			public int compare(Pair x, Pair y) {
				return x.sum - y.sum;
			}
		});

		int closest = Integer.MAX_VALUE;
		for (int i = 1; i < sortedSum.length; i++) {
			if (sortedSum[i].sum - sortedSum[i - 1].sum < closest) {
				closest = sortedSum[i].sum - sortedSum[i - 1].sum;
				res[0] = sortedSum[i].index - 1;
				res[1] = sortedSum[i - 1].index - 1;
			}
		}

		Arrays.sort(res);
		res[0]++;
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { -3, 1, 1, -3, 5 };
		_4_subarray_sum_closest rs = new _4_subarray_sum_closest();
		int[] result = rs.subarraySumClosest(nums);
		System.out.print(result);
	}

}
