package _6_two_pointers;

public class _8_interleaving_positive_and_negative_numbers {

	/*
	 * Method 1: a. determine if the positive number more than negative number or negative
	 *              number more than positive number
	 *           b. determine the first element is positive number or negative number:
	 *              -if posNum > negNum, the first element is positive number.
	 *              -if negNum > posNum, the first element is negative number.
	 *           c. use while loop and two pointer interleaving positive number and negative number
	 */
	public void rerange(int[] A) {
		// write your code here
		if (A.length < 2) {
			return;
		}
		int posNum = 0, negNum = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				posNum++;
			}
			if (A[i] < 0) {
				negNum++;
			}
		}
		int posIdx, negIdx;
		if (posNum >= negNum) {
			posIdx = 0;
			negIdx = 1;
		} else {
			posIdx = 1;
			negIdx = 0;
		}
		while (posIdx < A.length && negIdx < A.length) {
			while (posIdx < A.length && A[posIdx] > 0)
				posIdx += 2;
			while (negIdx < A.length && A[negIdx] < 0)
				negIdx += 2;
			if (posIdx < A.length && negIdx < A.length) {
				swap(A, posIdx, negIdx);
			}
		}
	}

	public void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
