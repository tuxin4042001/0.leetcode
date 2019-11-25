package _1_binary_search;

public class _9_find_peak_element {

	/**
	 * @param A: An integers array.
	 * @return: return any of peek positions.
	 */
	public int findPeak(int[] A) {
		// write your code here
		if (A == null || A.length == 0) {
			return -1;
		}
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid - 1] <= A[mid]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (A[start] >= A[end]) {
			return start;
		}
		return end;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
