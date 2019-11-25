package _1_binary_search;

public class _1_closest_number_in_sorted_array {
	public int closestNumber(int[] A, int target) {
		// write your code here
		if (A == null || A.length == 0) {
			return 0;
		}
		int start = 0;
		int end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] <= target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (Math.abs(A[start] - target) <= Math.abs(A[end] - target)) {
			return start;
		} else {
			return end;
		}
	}
}