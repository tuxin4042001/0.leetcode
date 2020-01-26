package _6_two_pointers;

public class _5_quick_select {

	public int kthSmallest(int k, int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return -1;
		}
		return quickSelect(nums, 0, nums.length - 1, k - 1);
	}

	public int quickSelect(int[] nums, int start, int end, int k) {
		if (start == end) {
			return nums[start];
		}
		int i = start, j = end, pivot = nums[(i + j) / 2];
		while (i <= j) {
			while (i <= j && nums[i] < pivot) {
				i++;
			}
			while (i <= j && nums[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j--;
			}
		}
		if (start <= j && k <= j) {
			quickSelect(nums, start, j, k);
		}
		if (i <= end && i <= k) {
			quickSelect(nums, i, end, k);
		}
		return nums[k];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
