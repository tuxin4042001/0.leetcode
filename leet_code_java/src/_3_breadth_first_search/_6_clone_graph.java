package _3_breadth_first_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class _6_clone_graph {
	// Key point is how to get ArrayList<UndirectedGraphNode> nodes
	// 1. How to design getNodes function to get ArrayList<UndirectedGraphNode>
	// nodes
	// 2. How to construct Map<UndirectedGraphNode, UndirectedGraphNode> map = new
	// HashMap<UndirectedGraphNode, UndirectedGraphNode>()
	// to realize the UndirectedGraphNode copy
	// 3. map can be used to record the newNode and newNeighbor info
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		// write your code here
		if (node == null) {
			return node;
		}
		List<UndirectedGraphNode> nodes = getNodes(node);
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		for (UndirectedGraphNode n : nodes) {
			map.put(n, new UndirectedGraphNode(n.label));
		}
		for (UndirectedGraphNode n : nodes) {
			UndirectedGraphNode newNode = map.get(n);
			for (UndirectedGraphNode neighbor : n.neighbors) {
				UndirectedGraphNode newNeighbor = map.get(neighbor);
				newNode.neighbors.add(newNeighbor);
			}
		}
		return map.get(node);
	}

	private List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
		queue.offer(node);
		set.add(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode head = queue.poll();
			for (UndirectedGraphNode neighbor : head.neighbors) {
				if (!set.contains(neighbor)) {
					set.add(neighbor);
					queue.offer(neighbor);
				}
			}
		}
		return new ArrayList(set);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
