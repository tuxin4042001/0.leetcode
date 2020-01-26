package _3_breadth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class coordinate_II {
	int x, y, dist;

	public coordinate_II(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

public class _16_build_post_office_II {
	int[] directX = { 0, 0, 1, -1 };
	int[] directY = { 1, -1, 0, 0 };

	/**
	 * @param grid: a 2D grid
	 * @return: An integer
	 */
	public int shortestDistance(int[][] grid) {
		// write your code here
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}
		int m = grid.length;
		int n = grid[0].length;
		List<coordinate_II> houses = new ArrayList<coordinate_II>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					houses.add(new coordinate_II(i, j, 0));
				}
			}
		}
		// 1. No empty house
		int k = houses.size();
		if (k == m * n || k == 0) {
			return -1;
		}
		// 2. Init distance matrix, distance[k][m][n], each matrix represents the
		// distance between houses.get(k) and node grid[i][j]
		// [
		// [[Integer.MAX_VALUE, Integer.MAX_VALUE,
		// Integer.MAX_VALUE],[Integer.MAX_VALUE, Integer.MAX_VALUE,
		// Integer.MAX_VALUE]],
		// [[Integer.MAX_VALUE, Integer.MAX_VALUE,
		// Integer.MAX_VALUE],[Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE]]
		// ]
		int[][][] distance = new int[k][m][n];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < m; j++) {
				Arrays.fill(distance[i][j], Integer.MAX_VALUE);
			}
		}
		// 3. Get distance matrix
		for (int i = 0; i < k; i++) {
			getDistance(houses.get(i), distance, i, grid);
		}
		// 4. Calculate sum of distance of each house
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					int sum = 0;
					for (int l = 0; l < k; l++) {
						if (distance[l][i][j] == Integer.MAX_VALUE) {
							sum = Integer.MAX_VALUE;
							break;
						}
						sum += distance[l][i][j];
					}
					min = Math.min(min, sum);
				}
			}
		}
		if (min == Integer.MAX_VALUE) {
			return -1;
		}
		return min;
	}

	private void getDistance(coordinate_II house, int[][][] distance, int index, int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		Queue<coordinate_II> queue = new LinkedList<coordinate_II>();
		boolean[][] visited = new boolean[m][n];
		queue.offer(house);
		visited[house.x][house.y] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				coordinate_II head = queue.poll();
				for (int j = 0; j < 4; j++) {
					coordinate_II adj = new coordinate_II(head.x + directX[j], head.y + directY[j], 0);
					if (inBound(adj, grid) && grid[adj.x][adj.y] == 0 && visited[adj.x][adj.y] == false) {
						distance[index][adj.x][adj.y] = head.dist + 1;
						queue.offer(new coordinate_II(adj.x, adj.y, head.dist + 1));
						visited[adj.x][adj.y] = true;
					}
				}
			}
		}
	}

	private boolean inBound(coordinate_II adj, int[][] grid) {
		if (adj.x < 0 || adj.x >= grid.length || adj.y < 0 || adj.y >= grid[0].length) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 1, 0, 0, 0 }, { 1, 0, 0, 2, 1 }, { 0, 1, 0, 0, 0 } };
		_16_build_post_office_II solution = new _16_build_post_office_II();
		int result = solution.shortestDistance(grid);
	}

}
