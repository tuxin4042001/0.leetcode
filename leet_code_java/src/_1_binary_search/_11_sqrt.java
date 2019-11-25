package _1_binary_search;

public class _11_sqrt {
	/**
	 * @param x: An integer
	 * @return: The sqrt of x
	 */
	public int sqrt(int x) {
		// write your code here
		if (x < 0) {
			return -1;
		}
		long start = 0, end = x;
		while (start + 1 < end) {
			long mid = start + (end - start) / 2;
			if (mid * mid == x) {
				return (int) mid;
			} else if (mid * mid < x) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (end * end <= x) {
			return (int) end;
		}
		return (int) start;
	}

	public static void main(String args[]) {
		int x = 935513699;
		_11_sqrt obj = new _11_sqrt();
		int result = obj.sqrt(x);
		System.out.print(result);
	}
}
