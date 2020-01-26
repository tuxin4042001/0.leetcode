package _4_depth_first_search;

import java.util.ArrayList;
import java.util.List;

/**
 * Description Given a string s. Partition s such that every substring in the
 * partition is a palindrome. Return all possible palindrome partitioning of s
 * 
 * example: Input: "aab", Output: [["aa", "b"], ["a", "a", "b"]]
 */
public class _5_palindrome_partitioning {
	/*
	 * @param s: A string
	 * 
	 * @return: A list of lists of string
	 */
	public List<List<String>> partition(String s) {
		// write your code here
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> subset = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return list;
		}
		helper(s, 0, list, subset);
		return list;
	}

	private void helper(String s, int index, List<List<String>> list, List<String> subset) {
		if (index == s.length()) {
			list.add(new ArrayList(subset));
		}
		for (int i = index; i < s.length(); i++) {
			String str = s.substring(index, i + 1);
			if (isPalindrome(str)) {
				subset.add(str);
				helper(s, i + 1, list, subset);
				subset.remove(subset.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str) {
		if (str == null && str.length() == 0)
			return false;
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a";
		_5_palindrome_partitioning r = new _5_palindrome_partitioning();
		List<List<String>> result = r.partition(s);
	}

}
