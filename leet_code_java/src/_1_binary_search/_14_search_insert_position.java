package _1_binary_search;

public class _14_search_insert_position {
	/**
	 * @param A:      an integer sorted array
	 * @param target: an integer to be inserted
	 * @return: An integer
	 */
	public int searchInsert(int[] A, int target) {
		// write your code here
		if (A == null || A.length == 0) {
			return 0;
		}
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (target <= A[start]) {
			return start;
		} else if (A[start] < target && target <= A[end]) {
			return end;
		} else {
			return end + 1;
		}
	}

}
