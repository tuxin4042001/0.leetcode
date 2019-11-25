package _3_breadth_first_search;

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
			for (int j = 0; i < m; j++) {
				while (grid[i][j]) {
					markByBFS(grid, i, j);
					island++;
				}
			}
		}
		return island;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
