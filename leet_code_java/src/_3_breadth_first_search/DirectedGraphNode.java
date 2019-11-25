package _3_breadth_first_search;

import java.util.ArrayList;

public class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}

}
