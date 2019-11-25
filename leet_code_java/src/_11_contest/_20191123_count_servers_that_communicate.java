package _11_contest;

import java.util.LinkedList;
import java.util.Queue;

public class _20191123_count_servers_that_communicate {
	public int countServers(int[][] grid) {
		int count = 0;
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return count;
		}
		// Find the first point and insert into queue
		Queue<int[]> queue = new LinkedList<int[]>();
		outloop: for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 && isCommunicate(i, j, grid)) {
					queue.offer(new int[] { i, j });
					break outloop;
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] head = queue.poll();
			int row = head[0];
			int col = head[1];
			grid[row][col] = 0;
			count++;
			for (int j = 0; j < grid[0].length; j++) {
				if (j != col && grid[row][j] == 1) {
					queue.offer(new int[] { row, j });
				}
			}
			for (int i = 0; i < grid.length; i++) {
				if (i != row && grid[i][col] == 1) {
					queue.offer(new int[] { i, col });
				}
			}
		}
		return count;
	}

	private boolean isCommunicate(int row, int col, int[][] grid) {
		boolean isServer = false;
		for (int j = 0; j < grid[0].length; j++) {
			if (j != col && grid[row][j] == 1) {
				isServer = true;
				break;
			}
		}
		for (int i = 0; i < grid.length; i++) {
			if (i != row && grid[i][col] == 1) {
				isServer = true;
				break;
			}
		}
		return isServer;
	}

	// Fully count and remove duplicate count
	public int countServers2(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int numRows = grid.length;
		int numCols = grid[0].length;
		int rowCount[] = new int[numRows];
		int colCount[] = new int[numCols];
		int totalServers = 0;
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (grid[row][col] == 1) {
					rowCount[row]++;
					colCount[col]++;
					totalServers++;
				}
			}
		}
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (grid[row][col] == 1) {
					if (rowCount[row] == 1 && colCount[col] == 1) {
						totalServers--;
					}
				}
			}
		}
		return totalServers;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
		_20191123_count_servers_that_communicate s = new _20191123_count_servers_that_communicate();
		int count = s.countServers(grid);
		System.out.print(count);
	}

}
