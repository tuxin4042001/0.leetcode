package _7_array;

/**
 * Merge two given sorted ascending integer array A and B into a new sorted
 * integer array.
 * 
 * Example 1:
 * 
 * Input: A=[1], B=[1] Output: [1,1] Explanation: return array merged.
 * 
 * Example 2:
 * 
 * Input: A=[1,2,3,4], B=[2,4,5,6] Output: [1,2,2,3,4,4,5,6] Explanation: return
 * array merged.
 * 
 * @author terry00
 *
 */

public class _6_merge_two_sorted_arrays {
	/**
	 * @param A: sorted integer array A
	 * @param B: sorted integer array B
	 * @return: A new sorted integer array
	 */
	// 1. Method 1: two pointers
	public int[] mergeSortedArray(int[] A, int[] B) {
		// write your code here
		if (A == null || A.length == 0) {
			return B;
		}

		if (B == null || B.length == 0) {
			return A;
		}

		int[] C = new int[A.length + B.length];
		int indexA = 0;
		int indexB = 0;
		int indexC = 0;
		while (indexA < A.length && indexB < B.length) {
			if (A[indexA] <= B[indexB]) {
				C[indexC++] = A[indexA++];
			} else {
				C[indexC++] = B[indexB++];
			}
		}

		while (indexA < A.length) {
			C[indexC++] = A[indexA++];
		}

		while (indexB < B.length) {
			C[indexC++] = B[indexB++];
		}

		return C;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
