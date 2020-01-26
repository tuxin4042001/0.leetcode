package _6_two_pointers;

import java.util.Arrays;
import java.util.HashSet;

public class _2_remove_duplicate_numbers_in_array {

	// 1.使用hashset去重
	public int deduplication(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (!set.contains(nums[fast])) {
				nums[slow++] = nums[fast];
				set.add(nums[fast]);
			}
			fast++;
		}
		return slow;
	}

	// 2.使用Arrays.sort排序去重
	public int deduplication2(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int slow = 1, fast = 1;
		while (fast < nums.length) {
			if (nums[fast] != nums[fast - 1]) {
				nums[slow++] = nums[fast];
			}
			fast++;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
