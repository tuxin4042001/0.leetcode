package _11_contest;

public class _20191123_minimum_time_visit_all_points {

	public int minTimeToVisitAllPoints(int[][] points) {
		int minTime = 0;
		if (points == null || points.length < 2 || points[0].length < 2) {
			return minTime;
		}
		for (int i = 0; i < points.length - 1; i++) {
			minTime += findMinTimeBetweenTwoPoint(points[i], points[i + 1]);
		}
		return minTime;
	}

	private int findMinTimeBetweenTwoPoint(int[] point1, int[] point2) {
		int x1 = point1[0];
		int y1 = point1[1];
		int x2 = point2[0];
		int y2 = point2[1];
		return Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
	}

}
