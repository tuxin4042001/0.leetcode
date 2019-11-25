package _3_breadth_first_search;

import java.util.List;

public class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
	}

	public Node(int _val, List<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
};