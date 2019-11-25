package _1_binary_search;

public class _7_search_for_a_range {
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
		result[0] = findLeft(A, target);
		result[1] = findRight(A, target);
		return result;
	}

	private int findLeft(int[] A, int target) {
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

	private int findRight(int[] A, int target) {
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

	public static void main(String args[]) {
		int[] A = { -1, 0, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 90, 92, 93, 101 };
		int target = 2;
		_7_search_for_a_range obj = new _7_search_for_a_range();
		int[] result = obj.searchRange(A, target);
		System.out.print(result);
	}
}
