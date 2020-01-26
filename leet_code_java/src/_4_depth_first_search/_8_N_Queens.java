package _4_depth_first_search;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other(Any two queens can't be in the same
 * row, column, diagonal line).
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' each indicate a queen and an empty space
 * respectively.
 * 
 * Input: 1 Output: [["Q"]]
 * 
 * Input: 4 Output: [ // Solution 1 [".Q..", "...Q", "Q...", "..Q." ], //
 * Solution 2 ["..Q.", "Q...", "...Q", ".Q.." ] ]
 * 
 * @param args
 */
public class _8_N_Queens {
	/*
	 * @param n: The number of queens
	 * 
	 * @return: All distinct solutions
	 */
	public List<List<String>> solveNQueens(int n) {
		// write your code here
		List<List<String>> list = new ArrayList<List<String>>();
		if (n <= 0) {
			return list;
		}
		List<Integer> subset = new ArrayList<Integer>();
		backTrack(n, 0, list, subset);
		return list;
	}

	// 1. only valid subset then backTrack
	// 2. isValid is the key point of N-Queens
	// a. if row 0 is valid, then backTrack row 1, and then row 2
	// like place a 'Q' in row 0, and find the correct place in row 1 and then row 2
	// 3. in isValid function, how to use 'diff' to judge row, column, and diag
	// valid
	private void backTrack(int n, int row, List<List<String>> list, List<Integer> subset) {
		if (subset.size() == n) {
			list.add(new ArrayList(drawChessBoard(subset)));
		}
		for (int i = 0; i < n; i++) {
			subset.add(i);
			if (isValid(subset)) {
				backTrack(n, row + 1, list, subset);
			}
			subset.remove(subset.size() - 1);
		}
	}

	private boolean isValid(List<Integer> subset) {
		int rowId = subset.size() - 1;
		for (int i = 0; i < rowId; i++) {
			int diff = Math.abs(subset.get(i) - subset.get(rowId));
			if (diff == 0 || diff == (rowId - i)) {
				return false;
			}
		}
		return true;
	}

	private List<String> drawChessBoard(List<Integer> subset) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < subset.size(); i++) {
			StringBuilder str = new StringBuilder("");
			int num = subset.get(i);
			for (int j = 0; j < subset.size(); j++) {
				if (j == num) {
					str.append('Q');
				} else {
					str.append('.');
				}
			}
			res.add(str.toString());
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
