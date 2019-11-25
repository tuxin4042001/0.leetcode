package _1_binary_search;

public class _13_copy_books {
	/**
	 * @param pages: an array of integers
	 * @param k:     An integer
	 * @return: an integer
	 */
	public int copyBooks(int[] pages, int k) {
		// write your code here
		if (pages == null || pages.length == 0) {
			return 0;
		}
		if (k <= 0) {
			return -1;
		}
		int start = findMinTime(pages), end = findMaxTime(pages);
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (canFinishCopy(pages, k, mid) == true) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (canFinishCopy(pages, k, start) == true) {
			return start;
		} else if (canFinishCopy(pages, k, end) == true) {
			return end;
		} else {
			return 0;
		}
	}

	public int findMinTime(int[] pages) {
		int time = pages[0];
		for (int i = 0; i <= pages.length - 1; i++) {
			time = Math.max(time, pages[i]);
		}
		return time;
	}

	public int findMaxTime(int[] pages) {
		int time = 0;
		for (int i = 0; i <= pages.length - 1; i++) {
			time += pages[i];
		}
		return time;
	}

	public boolean canFinishCopy(int[] pages, int allowPeopleNum, int limitedTime) {
		int numOfPeople = 0;
		int leftCapacity = 0;
		for (int item : pages) {
			if (item > limitedTime) {
				return false;
			}
			if (item > leftCapacity) {
				numOfPeople++;
				leftCapacity = limitedTime;
			}
			leftCapacity -= item;
		}
		return numOfPeople <= allowPeopleNum;
	}

	public static void main(String args[]) {
		_13_copy_books obj = new _13_copy_books();
		int[] pages = { 1, 2 };
		int k = 5;
		int result = obj.copyBooks(pages, k);
		System.out.print(result);
	}
}
