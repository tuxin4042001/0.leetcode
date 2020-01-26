package _3_breadth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, output sequence in dictionary
 * order.
 * 
 * Transformation rule such that: Only one letter can be changed at a time Each
 * intermediate word must exist in the dictionary
 * 
 * Example 1:
 * 
 * Input：start = "a"，end = "c"，dict =["a","b","c"] Output：[["a","c"]]
 * Explanation： "a"->"c"
 * 
 * Example 2:
 * 
 * Input：start ="hit"，end = "cog"，dict =["hot","dot","dog","lot","log"]
 * Output：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * 
 * Explanation： 1."hit"->"hot"->"dot"->"dog"->"cog"
 * 2."hit"->"hot"->"lot"->"log"->"cog" The dictionary order of the first
 * sequence is less than that of the second.
 * 
 * @author terry00
 *
 */
public class _17_word_ladder_II {
	/*
	 * @param start: a string
	 * 
	 * @param end: a string
	 * 
	 * @param dict: a set of string
	 * 
	 * @return: a list of lists of string
	 */
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> ladders = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Map<String, Integer> distance = new HashMap<String, Integer>();

		dict.add(start);
		dict.add(end);

		bfs(map, distance, end, start, dict);

		List<String> path = new ArrayList<String>();

		dfs(ladders, path, start, end, distance, map);

		return ladders;
	}

	void dfs(List<List<String>> ladders, List<String> path, String crt, String end, Map<String, Integer> distance,
			Map<String, List<String>> map) {
		path.add(crt);
		if (crt.equals(end)) {
			ladders.add(new ArrayList<String>(path));
		} else {
			for (String next : map.get(crt)) {
				if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
					dfs(ladders, path, next, end, distance, map);
				}
			}
		}
		path.remove(path.size() - 1);
	}

	void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict) {
		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		distance.put(start, 0);
		for (String s : dict) {
			map.put(s, new ArrayList<String>());
		}

		while (!q.isEmpty()) {
			String crt = q.poll();

			List<String> nextList = expand(crt, dict);
			for (String next : nextList) {
				map.get(next).add(crt);
				if (!distance.containsKey(next)) {
					distance.put(next, distance.get(crt) + 1);
					q.offer(next);
				}
			}
		}
	}

	List<String> expand(String crt, Set<String> dict) {
		List<String> expansion = new ArrayList<String>();

		for (int i = 0; i < crt.length(); i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (ch != crt.charAt(i)) {
					String expanded = crt.substring(0, i) + ch + crt.substring(i + 1);
					if (dict.contains(expanded)) {
						expansion.add(expanded);
					}
				}
			}
		}

		return expansion;
	}

	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		String[] d = { "hot", "dot", "dog", "lot", "log" };
		Set<String> dict = new HashSet<String>(Arrays.asList(d));
		_17_word_ladder_II rs = new _17_word_ladder_II();
		List<List<String>> result = rs.findLadders(start, end, dict);
	}

}
