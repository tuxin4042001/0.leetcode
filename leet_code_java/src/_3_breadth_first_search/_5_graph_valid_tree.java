package _3_breadth_first_search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _5_graph_valid_tree {
	/**
	 * @param n:     An integer
	 * @param edges: a list of undirected edges
	 * @return: true if it's a valid tree, or false
	 */
	public boolean validTree(int n, int[][] edges) {
		// write your code here
		if (n == 0) {
			return false;
		}
		if (edges.length != n - 1) {
			return false;
		}
		Map<Integer, Set<Integer>> graph = initGraph(n, edges);
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		queue.add(0);
		set.add(0);
		while (!queue.isEmpty()) {
			int head = queue.poll();
			for (int element : graph.get(head)) {
				if (!set.contains(element)) {
					set.add(element);
				}
			}
		}
		return set.size() == n;
	}

	Map<Integer, Set<Integer>> initGraph(int n, int[][] edges) {
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < n; i++) {
			map.put(i, new HashSet<Integer>());
		}
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			map.get(u).add(v);
			map.get(v).add(u);
		}
		return map;
	}

	public static void main(String[] args) {

	}

}
