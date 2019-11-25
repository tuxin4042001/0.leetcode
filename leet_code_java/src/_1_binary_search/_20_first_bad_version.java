package _1_binary_search;

class SVNRepo {
	public static boolean isBadVersion(int k) {
		return true;
	}
}

public class _20_first_bad_version {
	/**
	 * @param n: An integer
	 * @return: An integer which is the first bad version.
	 */
	public int findFirstBadVersion(int n) {
		// write your code here
		if (n == 0) {
			return -1;
		}
		int start = 1;
		int end = n;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (SVNRepo.isBadVersion(mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (SVNRepo.isBadVersion(start)) {
			return start;
		} 
		return end;
	}

	public static void main(String args[]) {
		_20_first_bad_version obj = new _20_first_bad_version();
		int result = obj.findFirstBadVersion(3);
		System.out.print(result);
	}

}
