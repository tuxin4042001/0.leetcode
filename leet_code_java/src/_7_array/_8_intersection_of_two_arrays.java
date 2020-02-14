package _7_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * Input: nums1 = [1, 2, 2, 1], nums2 = [2, 2], Output: [2].
 * 
 * Example 2:
 * 
 * Input: nums1 = [1, 2], nums2 = [2], Output: [2].
 * 
 * @author terry00
 *
 */

public class _8_intersection_of_two_arrays {
	/**
	 * @param nums1: an integer array
	 * @param nums2: an integer array
	 * @return: an integer array
	 */
	// 1. Method 1: two pointers without set
	public int[] intersection(int[] nums1, int[] nums2) {
		// write your code here
		int index1 = 0, index2 = 0;
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		while (index1 < nums1.length && index2 < nums2.length) {
			if (nums1[index1] < nums2[index2]) {
				index1++;
			} else if (nums1[index1] == nums2[index2]) {
				list.add(nums1[index1]);
				while (index1 + 1 < nums1.length && nums1[index1] == nums1[index1 + 1])
					index1++;
				while (index2 + 1 < nums2.length && nums2[index2] == nums2[index2 + 1])
					index2++;
				index1++;
				index2++;
			} else {
				index2++;
			}
		}
		int[] nums = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			nums[i] = list.get(i).intValue();
		}
		return nums;
	}

	// 2. Method 2: two pointers with set
	public int[] intersection2(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();
		int indexA = 0, indexB = 0;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		while (indexA < nums1.length && indexB < nums2.length) {
			if (nums1[indexA] < nums2[indexB]) {
				indexA++;
			} else if (nums1[indexA] == nums2[indexB]) {
				set.add(nums1[indexA]);
				indexA++;
				indexB++;
			} else {
				indexB++;
			}
		}
		int[] nums = new int[set.size()];
		int i = 0;
		for (Integer elem : set) {
			nums[i++] = elem.intValue();
		}
		return nums;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
