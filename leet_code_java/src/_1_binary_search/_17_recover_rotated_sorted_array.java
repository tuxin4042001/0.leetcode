package _1_binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _17_recover_rotated_sorted_array {
	/**
	 * @param nums: An integer array
	 * @return: nothing
	 */
	public void recoverRotatedSortedArray(List<Integer> nums) {
		// write your code here
		if (nums == null || nums.size() == 0) {
			return;
		}
		int index = findPeek(nums);
		if (index != -1) {
			reverseList(nums, 0, index);
			reverseList(nums, index + 1, nums.size() - 1);
			reverseList(nums, 0, nums.size() - 1);
		}
	}

	private int findPeek(List<Integer> nums) {
		for (int i = 0; i <= nums.size() - 2; i++) {
			if (nums.get(i) > nums.get(i + 1)) {
				return i;
			}
		}
		return -1;
	}

	private void reverseList(List<Integer> nums, int start, int end) {
		int temp = 0;
		while (start < end) {
			temp = nums.get(start);
			nums.set(start, nums.get(end));
			nums.set(end, temp);
			start++;
			end--;
		}
	}

	public static void main(String args[]) {
		Integer[] array = { 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		List<Integer> nums = Arrays.asList(array);
		_17_recover_rotated_sorted_array obj = new _17_recover_rotated_sorted_array();
		obj.recoverRotatedSortedArray(nums);
		System.out.print(nums);
	}

}
