package _1_binary_search;

public class _19_find_first_last_position_of_element {
	public int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
			return result;
		}
		result[0] = findFirstPosition(nums, target);
		result[1] = findLastPosition(nums, target);
		return result;
	}

	private int findFirstPosition(int[] nums, int target) {
		if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (nums[start] == target) {
			return start;
		}
		if (nums[end] == target) {
			return end;
		}
		return -1;
	}

	private int findLastPosition(int[] nums, int target) {
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
