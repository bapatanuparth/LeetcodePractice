package leetcodeHash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//You are given a stream of points on the X-Y plane. Design an algorithm that:
//
//Adds new points from the stream into a data structure. Duplicate points are allowed and should be treated as different points.
//Given a query point, counts the number of ways to choose three points from the data structure such that the three points and the query point form an axis-aligned square with positive area.
//An axis-aligned square is a square whose edges are all the same length and are either parallel or perpendicular to the x-axis and y-axis.
//
//Implement the DetectSquares class:
//
//DetectSquares() Initializes the object with an empty data structure.
//void add(int[] point) Adds a new point point = [x, y] to the data structure.
//int count(int[] point) Counts the number of ways to form axis-aligned squares with point point = [x, y] as described above.

public class DetectSquares {
	int[][] count;
	Set<List<Integer>> points;

	public DetectSquares() {
		points = new HashSet<>();
		count = new int[1001][1001];
	}

	public void add(int[] point) {
		count[point[0]][point[1]]++;
		List<Integer> ls = Arrays.asList(point[0], point[1]);
		points.add(ls);
	}

	// amongst all the points, find a diagonal point
	// and then add to answer by multiplying all 3 remaining poiunts' counts
	public int count(int[] point) {
		int x1 = point[0], y1 = point[1];
		int ans = 0;
		for (List<Integer> p : points) {
			int x2 = p.get(0), y2 = p.get(1);
			// ensures that the x2, y2 and x1,y1 are diagonals of square
			if (Math.abs(x2 - x1) == 0 || Math.abs(y2 - y1) == 0 || Math.abs(x2 - x1) != Math.abs(y2 - y1))
				continue;
			ans += count[x1][y2] * count[x2][y2] * count[x2][y1];
		}
		return ans;
	}

}
