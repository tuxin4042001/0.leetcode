package _4_depth_first_search;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the shortest
 * transformation sequence from start to end, output the length of the sequence.
 * Transformation rule such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary. (Start and end words do not need to appear in the dictionary
 * )
 * 
 * Example 1:
 * 
 * Input：start = "a"，end = "c"，dict =["a","b","c"] Output：2
 * Explanation： "a"->"c"
 * 
 * Example 2:
 * 
 * Input：start ="hit"，end = "cog"，dict =["hot","dot","dog","lot","log"]
 * Output：5 Explanation： "hit"->"hot"->"dot"->"dog"->"cog"
 * 
 * @param args
 */
public class _10_word_ladder {
	/*
	 * @param start: a string
	 * 
	 * @param end: a string
	 * 
	 * @param dict: a set of string
	 * 
	 * @return: An integer
	 */
	private int minLength = 0;

	public int ladderLength(String start, String end, Set<String> dict) {
		// write your code here
		if (start == null || end == null || start.length() == 0 || start.equals(end) || dict == null
				|| dict.size() == 0) {
			return 0;
		}
		Set<String> visited = new HashSet<String>();
		backTrack(start, end, dict, 1, visited);
		return minLength;
	}

	private void backTrack(String start, String end, Set<String> dict, int length, Set<String> visited) {
		visited.add(start);
		for (int i = 0; i < start.length(); i++) {
			StringBuilder sb = new StringBuilder(start);
			for (char c = 'a'; c < 'z'; c++) {
				if (c == start.charAt(i)) {
					continue;
				}
				sb.setCharAt(i, c);
				String word = sb.toString();
				if (word.equals(end) && (minLength == 0 || length + 1 < minLength)) {
					minLength = length + 1;
				} else if (!visited.contains(word) && dict.contains(word)) {
					backTrack(word, end, dict, length + 1, visited);
				}
			}
		}
		visited.remove(start);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
