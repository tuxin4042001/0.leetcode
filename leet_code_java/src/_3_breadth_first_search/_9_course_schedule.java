package _3_breadth_first_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _9_course_schedule {
	/*
	 * @param numCourses: a total of n courses
	 * 
	 * @param prerequisites: a list of prerequisite pairs
	 * 
	 * @return: true if can finish all courses or false
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] degree = new int[numCourses];
		int count = 0;
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new ArrayList<Integer>());
		}
		for (int[] prerequisite : prerequisites) {
			degree[prerequisite[1]]++;
			map.get(prerequisite[0]).add(prerequisite[1]);
		}
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
				count++;
			}
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			for (int i = 0; i < map.get(course).size(); i++) {
				int pointer = map.get(course).get(i);
				degree[pointer]--;
				if (degree[pointer] == 0) {
					queue.offer(pointer);
					count++;
				}
			}
		}
		return count == numCourses;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
