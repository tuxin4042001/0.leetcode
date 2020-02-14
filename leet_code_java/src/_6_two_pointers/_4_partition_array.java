package _6_two_pointers;

/**
 * Given an array nums of integers and an int k, partition the array (i.e move
 * the elements in "nums") such that:
 * 
 * All elements < k are moved to the left All elements >= k are moved to the
 * right
 * 
 * Example Example 1:
 * 
 * Input: [],9 Output: 0
 * 
 * Example 2:
 * 
 * Input: [3,2,2,1],2 Output:1 Explanation: the real array is[1,2,2,3].So return
 * 1
 * 
 * @author terry00
 *
 */

public class _4_partition_array {
	/**
	 * @param nums: The integer array you should partition
	 * @param k:    An integer
	 * @return: The index after partition
	 */
	public int partitionArray(int[] nums, int k) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			while (start <= end && nums[start] < k)
				start++;
			while (start <= end && nums[start] >= k) {
				swap(nums, start, end);
				end--;
			}
		}
		return start;
	}

	private void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
