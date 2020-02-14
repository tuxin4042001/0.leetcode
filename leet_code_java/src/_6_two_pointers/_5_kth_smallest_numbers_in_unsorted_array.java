package _6_two_pointers;

/**
 * Find the kth smallest numbers in an unsorted integer array.
 * 
 * Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers are [1, 2, 3].
 * 
 * @author terry00
 *
 */

public class _5_kth_smallest_numbers_in_unsorted_array {
	/*
	 * @param k an integer
	 * 
	 * @param nums an integer array
	 * 
	 * @return kth smallest element
	 */
	public int kthSmallest(int k, int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return -1;
		}
		return quickSelect(nums, 0, nums.length - 1, k - 1);
	}

	private int quickSelect(int[] nums, int start, int end, int k) {
		if (start == end) {
			return nums[start];
		}

		int left = start, right = end, pivot = nums[(start + end) / 2];

		while (left <= right) {
			while (left <= right && nums[left] < pivot) {
				left++;
			}

			while (left <= right && nums[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = nums[right];
				nums[right] = nums[left];
				nums[left] = temp;
				left++;
				right--;
			}
		}

		if (left <= right && k < right) {
			return quickSelect(nums, start, right, k);
		}

		if (left <= right && left < k) {
			return quickSelect(nums, left, end, k);
		}

		return nums[k];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
