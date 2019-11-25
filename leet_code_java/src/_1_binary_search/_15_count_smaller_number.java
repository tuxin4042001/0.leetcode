package _1_binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_count_smaller_number {
	/**
	 * @param A:       An integer array
	 * @param queries: The query list
	 * @return: The number of element in the array that are smaller that the given
	 *          integer
	 */
	public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
		// write your code here
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(A);
		for (int i = 0; i <= queries.length - 1; i++) {
			list.add(getSearchResult(A, queries[i]));
		}
		return list;
	}

	private int getSearchResult(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] < target) {
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
			return 0;
		}
	}

	public static void main(String args[]) {
		int[] A = { 39, 49, 13, 22, 25, 57, 92, 92, 94, 56, 54, 70, 9, 52, 63, 75, 55, 33, 79, 13, 52, 35, 11, 17, 99,
				65, 86, 22, 31, 53, 91, 51, 18, 71, 70, 23, 73, 50, 35, 51, 38, 13, 80, 81, 54, 58, 40, 1, 80, 70, 1,
				53, 63, 74, 48, 18, 52, 80, 6, 42 };
		int[] queries = { 3, 83, 39, 95, 28, 59, 6, 74, 29, 61, 48, 52 };
		_15_count_smaller_number obj = new _15_count_smaller_number();
		List<Integer> list = obj.countOfSmallerNumber(A, queries);
		System.out.print(list);
	}

}
