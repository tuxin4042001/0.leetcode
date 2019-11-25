package _1_binary_search;

public class _3_find_minimum_in_rotated_sorted_array {
	public int findMin(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] <= nums[end]) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (nums[start] <= nums[end]) {
			return nums[start];
		} else {
			return nums[end];
		}
	}

	public static void main(String args[]) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		_3_find_minimum_in_rotated_sorted_array obj = new _3_find_minimum_in_rotated_sorted_array();
		int result = obj.findMin(nums);
		System.out.print(result);
	}
}
