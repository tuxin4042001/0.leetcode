package _3_breadth_first_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a 2D grid, each cell is either an house 1 or empty 0 (the number zero,
 * one), find the place to build a post office, the distance that post office to
 * all the house sum is smallest. Return the smallest distance. Return -1 if it
 * is not possible.
 */

public class _15_build_post_office {
	int[] directX = { 0, 0, -1, 1, -1, 1, -1, 1 };
	int[] directY = { -1, 1, -1, -1, 0, 0, 1, 1 };

	public int shortestDistance(int[][] grid) {
		// 1. invalid grid
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}
		int n = grid.length;
		int m = grid[0].length;
		boolean[][] visited = new boolean[n][m];
		List<coordinate> house = new ArrayList<coordinate>();
		List<Integer> xarray = new ArrayList<Integer>();
		List<Integer> yarray = new ArrayList<Integer>();

		// 2. find house position
		// no empty house, return -1
		// no house, return -1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 0) {
					house.add(new coordinate(i, j));
					xarray.add(i);
					yarray.add(j);
				}
			}
		}
		if (house.size() == n * m) {
			return -1;
		}
		if (house.size() == 0) {
			return -1;
		}

		// 3. find median of house positions
		// median position is the best position to begin
		int xmedian = getMedian(xarray);
		int ymedian = getMedian(yarray);

		// 4. iterate the queue and find best position
		Queue<coordinate> queue = new LinkedList<coordinate>();
		queue.offer(new coordinate(xmedian, ymedian));
		visited[xmedian][ymedian] = true;
		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				coordinate head = queue.poll();
				if (grid[head.x][head.y] == 0) {
					min = Math.min(min, getDistance(house, head));
				}
				for (int j = 0; j < 8; j++) {
					coordinate adj = new coordinate(head.x + directX[j], head.y + directY[j]);
					if (inBound(grid, adj) && !visited[adj.x][adj.y]) {
						visited[adj.x][adj.y] = true;
						queue.add(adj);
					}
				}
			}
			if (min != Integer.MAX_VALUE) {
				return min;
			}
		}
		return -1;
	}

	private int getMedian(List<Integer> list) {
		int median = 0;
		Collections.sort(list);
		median = list.get(list.size() / 2);
		if (list.size() % 2 == 0) {
			median = (median + list.get(list.size() / 2 - 1)) / 2;
		}
		return median;
	}

	private int getDistance(List<coordinate> houses, coordinate node) {
		int distance = 0;
		for (coordinate house : houses) {
			distance = distance + Math.abs(node.x - house.x) + Math.abs(node.y - house.y);
		}
		return distance;
	}

	private boolean inBound(int[][] grid, coordinate adj) {
		boolean result = true;
		if (adj.x < 0 || adj.x >= grid.length || adj.y < 0 || adj.y >= grid[0].length) {
			return false;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
