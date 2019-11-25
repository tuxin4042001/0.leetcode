package _3_breadth_first_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _7_clone_graph_2 {

	public Node cloneGraph(Node node) {
		if (node == null) {
			return node;
		}
		Set<Node> nodes = getNodes(node);
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		for (Node n : nodes) {
			map.put(n.val, new Node(n.val, new ArrayList<Node>()));
		}
		for (Node n : nodes) {
			Node newNode = map.get(n.val);
			for (Node neighbor : n.neighbors) {
				Node newNeighbor = map.get(neighbor.val);
				newNode.neighbors.add(newNeighbor);
			}
		}
		return map.get(node.val);
	}

	private Set<Node> getNodes(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		Set<Node> set = new HashSet<Node>();
		queue.offer(node);
		set.add(node);
		while (!queue.isEmpty()) {
			Node head = queue.poll();
			for (Node neighbor : head.neighbors) {
				if (!set.contains(neighbor)) {
					set.add(neighbor);
					queue.offer(neighbor);
				}
			}
		}
		return set;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
