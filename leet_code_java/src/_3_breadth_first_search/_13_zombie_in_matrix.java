package _3_breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class _13_zombie_in_matrix {
	public int PEOPLE = 0;
	public int ZOMBIE = 1;
	public int[] directX = { 1, 0, -1, 0 };
	public int[] directY = { 0, 1, 0, -1 };

	public int zombie(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		// init people number and queue
		int people = 0;
		Queue<coordinate> queue = new LinkedList<coordinate>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == PEOPLE) {
					people++;
				} else if (grid[i][j] == ZOMBIE) {
					queue.offer(new coordinate(i, j));
				}
			}
		}

		if (people == 0) {
			return 0;
		}

		int days = 0;
		while (!queue.isEmpty()) {
			days++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				coordinate head = queue.poll();
				for (int j = 0; j < 4; j++) {
					coordinate adj = new coordinate(head.x + directX[j], head.y + directY[j]);
					if (inBound(grid, adj) && grid[adj.x][adj.y] == PEOPLE) {
						people--;
						grid[adj.x][adj.y] = ZOMBIE;
						if (people == 0) {
							return days;
						} else {
							queue.offer(adj);
						}
					}
				}
			}

		}
		return -1;
	}

	private boolean inBound(int[][] grid, coordinate adj) {
		return adj.x >= 0 && adj.x < grid.length && adj.y >= 0 && adj.y < grid[0].length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
