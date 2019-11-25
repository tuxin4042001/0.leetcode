package _1_binary_search;

public class _6_search_2D_matrix {
	/**
	 * @param matrix: matrix, a list of lists of integers
	 * @param target: An integer
	 * @return: a boolean, indicate whether matrix contains target
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		// write your code here
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int m = matrix.length, n = matrix[0].length;
		int start = 0, end = n * m - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (matrix[mid / n][mid % n] == target) {
				return true;
			} else if (matrix[mid / n][mid % n] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (matrix[start / n][start % n] == target) {
			return true;
		} else if (matrix[end / n][end % n] == target) {
			return true;
		}
		return false;
	}
}
