package _6_two_pointers;

public class _4_partition_array {

	public int partitionArray(int[] nums, int k) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			while (start <= end && nums[start] < k) {
				start++;
			}
			while (start <= end && nums[end] >= k) {
				end--;
			}
			if (start <= end) {
				swap(nums, start++, end--);
			}
		}
		return start;
	}

	public int partitionArray2(int[] nums, int k) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			if (nums[start] < k) {
				start++;
			} else {
				swap(nums, start, end--);
			}
		}
		return start;
	}

	public void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
