package _6_two_pointers;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example 1:
 * 
 * Input: nums = [0, 1, 0, 3, 12], Output: [1, 3, 12, 0, 0].
 * 
 * Example 2:
 * 
 * Input: nums = [0, 0, 0, 3, 1], Output: [3, 1, 0, 0, 0].
 * 
 * @author terry00
 *
 */

public class _1_move_zeros {
	/**
	 * @param nums: an integer array
	 * @return: nothing
	 */
	// 1. Method 1: two pointer method
	public void moveZeroes(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return;
		}
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != 0) {
				nums[slow++] = nums[fast];
			}
			fast++;
		}
		while (slow < nums.length) {
			nums[slow++] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_1_move_zeros mz = new _1_move_zeros();
		int[] nums = { 0, 1, 0, 3, 12 };
		mz.moveZeroes(nums);
	}
}
