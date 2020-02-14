package _6_two_pointers;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length. Do not allocate extra
 * space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 * 
 * Example 1: Given nums = [1,1,2], Your function should return length = 2, with
 * the first two elements of nums being 1 and 2 respectively. It doesn't matter
 * what you leave beyond the returned length.
 * 
 * Given nums = [0,0,1,1,1,2,2,3,3,4], Your function should return length = 5,
 * with the first five elements of nums being modified to 0, 1, 2, 3, and 4
 * respectively. It doesn't matter what values are set beyond the returned
 * length.
 */

public class _2_remove_duplicate_numbers_in_array {
	// 1. Method 1: two pointer
	// Know how to move fast pointer while duplicate
	public int removeDuplicates(int[] nums) {
		int result = 0;
		if (nums == null || nums.length == 0) {
			return result;
		}
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			nums[slow++] = nums[fast++];
			while (fast < nums.length && nums[fast] == nums[fast - 1])
				fast++;
		}
		return slow;
	}

	// 2. Method 2: hash set
	// Use hash set to remove duplicate
	public int removeDuplicates2(int[] nums) {
		int result = 0;
		if (nums == null || nums.length == 0) {
			return result;
		}
		int slow = 0, fast = 0;
		Set<Integer> set = new HashSet<Integer>();
		while (fast < nums.length) {
			if (!set.contains(nums[fast])) {
				nums[slow++] = nums[fast];
				set.add(nums[fast]);
			}
			fast++;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
