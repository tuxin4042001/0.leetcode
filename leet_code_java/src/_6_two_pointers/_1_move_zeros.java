package _6_two_pointers;

public class _1_move_zeros {
	public void moveZeroes(int[] nums) {
		// write your code here
		if (nums == null || nums.length <= 1) {
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] != 0) {
						swap(nums, i, j);
						break;
					}
				}
			}
		}
	}

	public void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}

	// Ë«Ö¸Õë:¿ìÂýÖ¸Õë
	public void moveZeroes2(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return;
		}
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != 0) {
				nums[slow++] = nums[fast];
			}
			fast++;
		}
		while (slow < nums.length) {
			nums[slow++] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_1_move_zeros mz = new _1_move_zeros();
		int[] nums = { 0, 1, 0, 3, 12 };
		mz.moveZeroes(nums);
	}
}
