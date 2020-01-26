package _3_breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class _14_knight_shortest_path {
	/**
	 * @param grid    a chessboard included 0 (false) and 1 (true)
	 * @param source, destination a point
	 * @return the shortest path
	 */
	int[] directX = { 1, 1, -1, -1, 2, 2, -2, -2 };
	int[] directY = { 2, -2, 2, -2, 1, -1, 1, -1 };

	public int shortestPath(boolean[][] grid, coordinate source, coordinate destination) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		Queue<coordinate> queue = new LinkedList<coordinate>();
		int steps = 0;
		queue.offer(source);
		while (!queue.isEmpty()) {
			coordinate head = queue.poll();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				if (head.x == destination.x && head.y == destination.y) {
					return steps;
				}
				for (int j = 0; j < 8; j++) {
					coordinate adj = new coordinate(head.x + directX[j], head.y + directY[j]);
					if (inBound(grid, adj) && !grid[adj.x][adj.y]) {
						queue.offer(adj);
						grid[adj.x][adj.y] = true;
					}
				}
			}
			steps++;
		}
		return -1;
	}

	private boolean inBound(boolean[][] grid, coordinate adj) {
		return adj.x >= 0 && adj.x < grid.length && adj.y >= 0 && adj.y < grid[0].length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
