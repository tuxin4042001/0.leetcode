package _3_breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _10_course_schedule_II {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] degree = new int[numCourses];
		List<List<Integer>> graph = new ArrayList<>(numCourses);
		initialiseGraph(degree, graph, prerequisites);
		// return solveByBFS(incLinkCounts, adjs);
		return solveByBFS(degree, graph);
	}

	private void initialiseGraph(int[] degree, List<List<Integer>> graph, int[][] prerequisites) {
		for (int i = 0; i < degree.length; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int[] prerequisite : prerequisites) {
			int course = prerequisite[0];
			int dependentCourse = prerequisite[1];
			degree[course]++;
			graph.get(dependentCourse).add(course);
		}
	}

	private int[] solveByBFS(int[] degree, List<List<Integer>> graph) {
		int[] order = new int[degree.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0)
				queue.offer(i);
		}
		int visited = 0;
		while (!queue.isEmpty()) {
			int from = queue.poll();
			order[visited++] = from;
			for (int to : graph.get(from)) {
				degree[to]--;
				if (degree[to] == 0)
					queue.offer(to);
			}
		}
		return visited == degree.length ? order : new int[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
