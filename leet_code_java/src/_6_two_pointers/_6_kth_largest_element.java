package _6_two_pointers;

/**
 * Find K-th largest element in an array.
 * 
 * Example 1:
 * 
 * Input: n = 1, nums = [1,3,4,2] Output: 4
 * 
 * Example 2:
 * 
 * Input: n = 3, nums = [9,3,2,4,8] Output: 4
 * 
 * @author terry00
 *
 */

public class _6_kth_largest_element {
	/**
	 * @param n:    An integer
	 * @param nums: An array
	 * @return: the Kth largest element
	 */
	public int kthLargestElement(int n, int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return -1;
		}

		return quickSelect(nums, 0, nums.length - 1, n - 1);
	}

	private int quickSelect(int[] nums, int start, int end, int k) {
		if (start == end) {
			return -1;
		}

		int left = start, right = end, pivot = nums[(start + end) / 2];

		while (left <= right) {
			while (left <= right && nums[left] > pivot) {
				left++;
			}

			while (left <= right && nums[right] < pivot) {
				right--;
			}

			if (left <= right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
				right--;
			}
		}

		if (start <= right && k <= right) {
			return quickSelect(nums, start, right, k);
		}

		if (left <= end && k >= left) {
			return quickSelect(nums, left, end, k);
		}

		return nums[k];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 4, 2 };
		int n = 1;
		_6_kth_largest_element rs = new _6_kth_largest_element();
		int result = rs.kthLargestElement(n, nums);
		System.out.print(result);
	}

}
