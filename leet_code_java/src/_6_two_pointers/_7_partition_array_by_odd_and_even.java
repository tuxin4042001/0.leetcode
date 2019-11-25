package _6_two_pointers;

public class _7_partition_array_by_odd_and_even {

	/*
	 * Method 1: use one index iterate array, and move the odd number to the begin
	 * and even number to the end; 
	 * a. when swap start and index, start and index can increase at the same time 
	 * b. when swap index and end, only decrease end. index cannot increase because the swap result can be also a even number.
	 */
	public void partitionArray(int[] nums) {
		// write your code here
		if (nums.length < 2) {
			return;
		}
		int start = 0, end = nums.length - 1;
		int index = 0;
		while (index < end) {
			if (nums[index] % 2 == 1) {
				swap(nums, start, index);
				start++;
				index++;
			} else if (nums[index] % 2 == 0) {
				swap(nums, index, end);
				end--;
			}
		}
		return;
	}

	/*
	 * Method 2: use while loop iterate from the beginning and from the end 
	 * a. use while loop always need to confirm start < end 
	 * b. when swap start and end, need to confirm start < end
	 */
	public void partitionArray2(int[] nums) {
		// write your code here
		if (nums.length < 2) {
			return;
		}
		int start = 0, end = nums.length - 1;
		while (start < end) {
			while (start < end && nums[start] % 2 == 1)
				start++;
			while (start < end && nums[end] % 2 == 0)
				end--;
			if (start < end) {
				swap(nums, start, end);
			}
		}
		return;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
