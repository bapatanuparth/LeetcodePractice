package leetcode150daysGreedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//You are given an array of points in the X-Y plane points where points[i] = [xi, yi].
//
//Return the minimum area of a rectangle formed from these points, with sides parallel to the X and Y axes. If there is not any such rectangle, return 0.

public class MinimumAreaRectangle {

	public int minAreaRect(int[][] points) {
		Map<Integer, Set<Integer>> map = new HashMap<>();

		for (int[] p : points) {
			if (!map.containsKey(p[0])) {
				map.put(p[0], new HashSet<>());
			}
			map.get(p[0]).add(p[1]);
		}

		int min = Integer.MAX_VALUE;
		for (int[] p1 : points) {

			for (int[] p2 : points) {

				if (p1[0] == p2[0] || p1[1] == p2[1]) { // dont consider points that are already lying on the same
														// vertical or horizontal line
					continue;
				}
				// consider 2 points lying on diagonal of rectangle
				if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
					min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
				}
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}

}
