package _1_binary_search;

public class _4_last_position_of_target {
	public int lastPosition(int[] nums, int target) {
		// write your code here
		if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] <= target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (nums[end] == target) {
			return end;
		}
		if (nums[start] == target) {
			return start;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
