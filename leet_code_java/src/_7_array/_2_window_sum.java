package _7_array;

/**
 * Given an array of n integers, and a moving window(size k), move the window at
 * each iteration from the start of the array, find the sum of the element
 * inside the window at each moving.
 * 
 * Example 1
 * 
 * Input：array = [1,2,7,8,5], k = 3 Output：[10,17,20]
 * 
 * Explanation： 1 + 2 + 7 = 10 2 + 7 + 8 = 17 7 + 8 + 5 = 20
 * 
 * @author terry00
 *
 */

public class _2_window_sum {
	/**
	 * @param nums: a list of integers.
	 * @param k:    length of window.
	 * @return: the sum of the element inside the window at each moving.
	 */
	// 1. Method 1: two pointers, two iterations, O(n^2) O(n)
	public int[] winSum(int[] nums, int k) {
		// write your code here
		if (nums == null || nums.length == 0 || k <= 0 || nums.length < k) {
			return new int[0];
		}
		int[] sums = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length - k + 1; i++) {
			int sum = 0;
			for (int j = 0; j < k; j++) {
				sum += nums[i + j];
			}
			sums[i] = sum;
		}
		return sums;
	}

	// 2. Method 2: dynamic process + array difference
	// url: https://yeqiuquan.blogspot.com/2017/03/lintcode-604-window-sum.html
	public int[] winSum2(int[] nums, int k) {
		// write your code here
		if (nums == null || nums.length == 0 || k < 0) {
			return new int[0];
		}
		int[] sums = new int[nums.length - k + 1];

		for (int i = 0; i < k; i++) {
			sums[0] += nums[i];
		}

		for (int i = 1; i < nums.length - k + 1; i++) {
			sums[i] = sums[i - 1] - nums[i - 1] + nums[i - 1 + k];
		}

		return sums;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
