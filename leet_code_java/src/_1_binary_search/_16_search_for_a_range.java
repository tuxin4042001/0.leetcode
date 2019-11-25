package _1_binary_search;

public class _16_search_for_a_range {
	/**
	 * @param A:      an integer sorted array
	 * @param target: an integer to be inserted
	 * @return: a list of length 2, [index1, index2]
	 */
	public int[] searchRange(int[] A, int target) {
		// write your code here
		int[] result = { -1, -1 };
		if (A == null || A.length == 0) {
			return result;
		}
		result[0] = findLeftRange(A, target);
		if (result[0] != -1)
			result[1] = findRightRange(A, target);
		return result;
	}

	private int findLeftRange(int[] A, int target) {
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (A[start] == target) {
			return start;
		} else if (A[end] == target) {
			return end;
		} else {
			return -1;
		}
	}

	private int findRightRange(int[] A, int target) {
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] <= target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (A[end] == target) {
			return end;
		} else if (A[start] == target) {
			return start;
		} else {
			return -1;
		}
	}

}
