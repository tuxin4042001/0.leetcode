package _3_breadth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
 * Input：start = "a"，end = "c"，dict =["a","b","c"] Output：2 Explanation：
 * "a"->"c"
 * 
 * Example 2:
 * 
 * Input：start ="hit"，end = "cog"，dict =["hot","dot","dog","lot","log"] Output：5
 * Explanation： "hit"->"hot"->"dot"->"dog"->"cog"
 * 
 * Notice Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lowercase alphabetic characters. You
 * may assume no duplicates in the word list. You may assume beginWord and
 * endWord are non-empty and are not the same.
 * 
 * @author terry00
 *
 */
public class _17_word_ladder {
	/*
	 * @param start: a string
	 * 
	 * @param end: a string
	 * 
	 * @param dict: a set of string
	 * 
	 * @return: An integer
	 */
	public int ladderLength(String start, String end, Set<String> dict) {
		// write your code here
		if (start == null || end == null || start.length() == 0 || start.equals(end) || dict == null
				|| dict.size() == 0) {
			return 0;
		}
		Set<String> visited = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		int length = 1;
		queue.add(start);
		visited.add(start);
		dict.add(start);
		dict.add(end);
		while (!queue.isEmpty()) {
			length++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String head = queue.poll();
				for (String nextWord : getNextWord(head, dict)) {
					if (visited.contains(nextWord)) {
						continue;
					}
					if (nextWord.equals(end)) {
						return length;
					}
					queue.add(nextWord);
					visited.add(nextWord);
				}
			}
		}
		return 0;
	}

	private List<String> getNextWord(String head, Set<String> dict) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < head.length(); i++) {
			for (char c = 'a'; c < 'z'; c++) {
				StringBuilder sb = new StringBuilder(head);
				sb.setCharAt(i, c);
				if (dict.contains(sb.toString())) {
					list.add(sb.toString());
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "a";
		String end = "c";
		String[] d = { "a", "b", "c" };
		Set<String> dict = new HashSet<String>(Arrays.asList(d));
		_17_word_ladder rs = new _17_word_ladder();
		int result = rs.ladderLength(start, end, dict);
	}

}
