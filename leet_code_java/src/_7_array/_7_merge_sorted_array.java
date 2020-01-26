package _7_array;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Example 1:
 * 
 * Input：[1, 2, 3] 3 [4,5] 2 Output：[1,2,3,4,5] Explanation: After merge, A will
 * be filled as [1, 2, 3, 4, 5]
 * 
 * Example 2:
 * 
 * Input：[1,2,5] 3 [3,4] 2 Output：[1,2,3,4,5] Explanation: After merge, A will
 * be filled as [1, 2, 3, 4, 5]
 * 
 * @author terry00
 *
 */

public class _7_merge_sorted_array {
	/*
	 * @param A: sorted integer array A which has m elements, but size of A is m+n
	 * 
	 * @param m: An integer
	 * 
	 * @param B: sorted integer array B which has n elements
	 * 
	 * @param n: An integer
	 * 
	 * @return: nothing
	 */
	// 1. Method 1: two pointers, sort with less than or greater than ?
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		// write your code here
		int indexA = m - 1, indexB = n - 1, indexTotal = m + n - 1;
		while (indexA >= 0 && indexB >= 0) {
			if (A[indexA] >= B[indexB]) {
				A[indexTotal--] = A[indexA--];
			} else {
				A[indexTotal--] = B[indexB--];
			}
		}
		while (indexA >= 0) {
			A[indexTotal--] = A[indexA--];
		}
		while (indexB >= 0) {
			A[indexTotal--] = B[indexB--];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
