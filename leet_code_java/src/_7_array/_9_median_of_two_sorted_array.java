package _7_array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays.
 * 
 * Example 1
 * 
 * Input: A = [1,2,3,4,5,6] B = [2,3,4,5] Output: 3.5
 * 
 * Example 2
 * 
 * Input: A = [1,2,3] B = [4,5] Output: 3 Challenge The overall run time
 * complexity should be O(log (m+n)).
 * 
 * @author terry00
 *
 */

public class _9_median_of_two_sorted_array {
	/*
	 * @param A: An integer array
	 * 
	 * @param B: An integer array
	 * 
	 * @return: a double whose format is *.5 or *.0
	 */
	// 1. Method 1: merge two array and then find median
	public double findMedianSortedArrays(int[] A, int[] B) {
		// write your code here
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		int indexA = 0, indexB = 0;
		while (indexA < A.length && indexB < B.length) {
			if (A[indexA] < B[indexB]) {
				set.add(A[indexA]);
				indexA++;
			} else if (A[indexA] == B[indexB]) {
				set.add(A[indexA]);
				indexA++;
				indexB++;
			} else {
				set.add(B[indexB]);
				indexB++;
			}
		}
		while (indexA < A.length) {
			set.add(A[indexA]);
			indexA++;
		}
		while (indexB < B.length) {
			set.add(B[indexB]);
			indexB++;
		}
		list.addAll(set);
		int size = list.size();
		if (size % 2 == 0) {
			return ((double) (list.get((size - 1) / 2) + (double) list.get((size - 1) / 2 + 1))) / 2;
		} else {
			return (double) list.get((size - 1) / 2);
		}
	}

	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		if (m < n) {
			int[] temp = nums1;
			int tempLen = m;
			nums1 = nums2;
			nums2 = temp;
			m = n;
			n = tempLen;
		}
		int start = 0, end = m;
		while (start + 1 < end) {
			int i = start + (end - start) / 2;
			int j = (m + n) / 2 - i;
			if (nums1[i] < nums2[j + 1] && nums2[j] < nums1[i + 1]) {
				int leftMax = Math.max(nums1[i], nums2[j]);
				int rightMin = Math.min(nums1[i + 1], nums2[j + 1]);
				return (leftMax + rightMin) / 2;
			} else if (nums1[i] < nums2[j + 1] && nums2[j] >= nums1[i + 1]) {
				start = i;
			} else if (nums1[i] >= nums2[j + 1] && nums2[j] < nums1[i + 1]) {
				end = i;
			} else {
				start = i;
			}
		}
		int j = (m + n) / 2 - start;
		if (nums1[start] < nums2[j + 1] && nums2[j] < nums1[start + 1]) {
			int leftMax = Math.max(nums1[start], nums2[j]);
			int rightMin = Math.min(nums1[start + 1], nums2[j + 1]);
			return (leftMax + rightMin) / 2;
		}
		j = (m + n) / 2 - end;
		if (nums1[end] < nums2[j + 1] && nums2[j] < nums1[end + 1]) {
			int leftMax = Math.max(nums1[end], nums2[j]);
			int rightMin = Math.min(nums1[end + 1], nums2[j + 1]);
			return (leftMax + rightMin) / 2;
		}
		return (double) 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 2, 3, 4, 5, 6 };
		int[] B = { 2, 3, 4, 5 };
		_9_median_of_two_sorted_array rs = new _9_median_of_two_sorted_array();
		double result = rs.findMedianSortedArrays(A, B);
		System.out.print(result);
	}

}
