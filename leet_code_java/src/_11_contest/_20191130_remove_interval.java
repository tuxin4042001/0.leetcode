package _11_contest;

import java.util.ArrayList;
import java.util.List;

public class _20191130_remove_interval {
	public List<List<Integer>> removeInterval(int[][] intervals, final int[] toBeRemoved) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (intervals == null || intervals.length == 0) {
			return list;
		}

		if (toBeRemoved == null || toBeRemoved.length == 0 || toBeRemoved[1] <= intervals[0][0]
				|| toBeRemoved[0] >= intervals[intervals.length - 1][1]) {
			list = ArrayToList(intervals);
			return list;
		}

		final int startIndex = findIndex(intervals, toBeRemoved[0]);
		final int endIndex = findIndex(intervals, toBeRemoved[1]);
		if (startIndex == endIndex) {
			final int[] temp = intervals[startIndex];
			intervals = removeElementInArray(intervals, startIndex, startIndex);
			intervals = insertElementInArray(intervals, startIndex, new int[] { temp[0], toBeRemoved[0] });
			intervals = insertElementInArray(intervals, startIndex + 1, new int[] { toBeRemoved[1], temp[1] });
		} else {
			final int[] startTemp = intervals[startIndex];
			final int[] endTemp = intervals[endIndex];
			intervals = removeElementInArray(intervals, startIndex, endIndex);
			intervals = insertElementInArray(intervals, startIndex, new int[] { startTemp[0], toBeRemoved[0] });
			intervals = insertElementInArray(intervals, startIndex + 1, new int[] { toBeRemoved[1], endTemp[1] });
		}
		return ArrayToList(intervals);
	}

	private int[][] removeElementInArray(final int[][] array, final int from, final int to) {
		if (array == null || from > to || from < 0 || from > array.length || to < 0 || to > array.length) {
			return array;
		}
		final int removeNum = to - from + 1;
		final int[][] result = new int[array.length][array[0].length - removeNum];
		for (int i = 0, k = 0; i < array[0].length; i++) {
			if (from <= i && i <= to) {
				continue;
			}
			result[k++] = array[i];
		}
		return result;
	}

	private int[][] insertElementInArray(final int[][] array, final int index, final int[] element) {
		if (array == null || index < 0 || index > array.length) {
			return array;
		}
		final int[][] anotherArray = new int[array.length][array[0].length + 1];
		for (int i = 0, k = 0, j = 0; i < array[0].length; i++) {
			if (i != index) {
				anotherArray[k++] = array[j++];
			} else {
				anotherArray[i] = element;
			}
		}
		return anotherArray;
	}

	private List<List<Integer>> ArrayToList(final int[][] _2DArray) {
		final List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (final int[] array : _2DArray) {
			final List<Integer> temp = new ArrayList<Integer>();
			for (final int number : array) {
				temp.add(number);
			}
			list.add(temp);
		}
		return list;
	}

	private int findIndex(final int[][] intervals, final int target) {
		int start = 0;
		int end = intervals.length - 1;
		while (start + 1 < end) {
			final int mid = start + (end - start) / 2;
			if (inBound(intervals[mid], target)) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (inBound(intervals[start], target)) {
			return start;
		} else {
			return end;
		}
	}

	private boolean inBound(final int[] array, final int target) {
		if (array[0] <= target && target <= array[1]) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		final int[][] intervals = { { 0, 2 }, { 3, 4 }, { 5, 7 } };
		final int[] toBeRemoved = { 1, 6 };
		final _20191130_remove_interval ri = new _20191130_remove_interval();
		final List<List<Integer>> list = ri.removeInterval(intervals, toBeRemoved);
		System.out.print(list);
	}

}
