package _4_depth_first_search;

import java.util.ArrayList;
import java.util.List;

public class _9_N_Queens_II {
	public int totalNQueens(int n) {
		List<List<String>> list = new ArrayList<List<String>>();
		if (n <= 0) {
			return 0;
		}
		List<Integer> subset = new ArrayList<Integer>();
		backTrack(n, 0, list, subset);
		return list.size();
	}

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
