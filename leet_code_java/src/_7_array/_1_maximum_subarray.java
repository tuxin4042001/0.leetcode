package _7_array;

/**
 * Given an array of integers, find a contiguous subarray which has the largest
 * sum.
 * 
 * Example1:
 * 
 * Input: [−2,2,−3,4,−1,2,1,−5,3] Output: 6 Explanation: the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * Example2:
 * 
 * Input: [1,2,3,4] Output: 10 Explanation: the contiguous subarray [1,2,3,4]
 * has the largest sum = 10.
 * 
 * @author terry00
 *
 */

public class _1_maximum_subarray {
	/**
	 * @param nums: A list of integers
	 * @return: A integer indicate the sum of max subarray
	 */
	// 1. Method 1: greedy
	// a. max record the maximum sum
	// b. sum record positive sum, which means only update sum when sum greater than
	// 0
	public int maxSubArray(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}
		return max;
	}

	public int maxSubArray2(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int minSum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
