package _4_depth_first_search;

import java.util.ArrayList;
import java.util.List;

public class _5_palindrome_partitioning {

	public List<List<String>> partition(String s) {
		// write your code here
		List<List<String>> result = new ArrayList<List<String>>();
		if (s == null || s.length() == 0) {
			return result;
		}
		List<String> list = new ArrayList<String>();
		backTrack(s, 0, list, result);
		return result;
	}

	private void backTrack(String s, int start, List<String> list, List<List<String>> result) {
		if (start == s.length()) {
			result.add(new ArrayList<String>(list));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			String str = s.substring(start, i + 1);
			if (isPalindrome(str)) {
				list.add(str);
				backTrack(s, i + 1, list, result);
				list.remove(list.size() - 1);
			}
		}
		return;
	}

	private boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (!Character.isLetterOrDigit(s.charAt(i))) {
				return false;
			}
			if (!Character.isLetterOrDigit(s.charAt(j))) {
				return false;
			}
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
