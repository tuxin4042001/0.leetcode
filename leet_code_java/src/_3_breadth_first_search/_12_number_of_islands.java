package _3_breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

class coordinate {
	int x, y;

	public coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class _12_number_of_islands {
	/**
	 * @param grid: a boolean 2D matrix
	 * @return: an integer
	 */
	public int numIslands(boolean[][] grid) {
		// write your code here
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int n = grid.length;
		int m = grid[0].length;
		int island = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				while (grid[i][j]) {
					markByBFS(grid, i, j);
					island++;
				}
			}
		}
		return island;
	}

	private void markByBFS(boolean[][] grid, int x, int y) {
		int[] directX = { 1, 0, -1, 0 };
		int[] directY = { 0, 1, 0, -1 };

		Queue<coordinate> queue = new LinkedList<coordinate>();
		coordinate coor = new coordinate(x, y);
		queue.offer(coor);
		grid[x][y] = false;

		while (!queue.isEmpty()) {
			coordinate head = queue.poll();
			for (int i = 0; i < 4; i++) {
				int adjx = head.x + directX[i];
				int adjy = head.y + directY[i];
				coordinate adj = new coordinate(adjx, adjy);
				if (inBound(grid, adj) && grid[adjx][adjy]) {
					grid[adjx][adjy] = false;
					queue.offer(adj);
				}
			}
		}
	}

	private boolean inBound(boolean[][] grid, coordinate adj) {
		int n = grid.length;
		int m = grid[0].length;
		return adj.x >= 0 && adj.x < n && adj.y >= 0 && adj.y < m;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] grid = { { true, true, false, false, false }, { false, true, false, false, true },
				{ false, false, false, true, true }, { false, false, false, false, false },
				{ false, false, false, false, true } };
		_12_number_of_islands s = new _12_number_of_islands();
		int result = s.numIslands(grid);
		System.out.print(result);
	}

}
