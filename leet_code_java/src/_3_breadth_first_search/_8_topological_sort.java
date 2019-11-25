package _3_breadth_first_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _8_topological_sort {

	/*
	 * @param graph: A list of Directed graph node
	 * 
	 * @return: Any topological order for the given graph.
	 */
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		// write your code here
		List<DirectedGraphNode> list = new ArrayList<DirectedGraphNode>();
		Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
		for (DirectedGraphNode node : graph) {
			for (DirectedGraphNode neighbor : node.neighbors) {
				if (map.containsKey(neighbor)) {
					map.put(neighbor, map.get(neighbor) + 1);
				} else {
					map.put(neighbor, 1);
				}
			}
		}
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for (DirectedGraphNode node : graph) {
			if (!map.containsKey(node)) {
				queue.offer(node);
				list.add(node);
			}
		}
		while (!queue.isEmpty()) {
			DirectedGraphNode head = queue.poll();
			for (DirectedGraphNode neighbor : head.neighbors) {
				map.put(neighbor, map.get(neighbor) - 1);
				if (map.get(neighbor) == 0) {
					queue.offer(neighbor);
					list.add(neighbor);
				}
			}
		}
		return new ArrayList<DirectedGraphNode>(list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
