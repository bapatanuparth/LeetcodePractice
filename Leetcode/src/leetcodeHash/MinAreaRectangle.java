package leetcodeHash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//You are given an array of points in the X-Y plane points where points[i] = [xi, yi].
//
//Return the minimum area of a rectangle formed from these points, with sides parallel to the X and Y axes. If there is not any such rectangle, return 0.

public class MinAreaRectangle {

	// create a map

	public int minAreaRect(int[][] points) {
		Map<Integer, Set<Integer>> map = new HashMap<>();

		// store all the y co-ordinates as a set for their respective x co-ordinates
		for (int[] p : points) {
			if (!map.containsKey(p[0])) {
				map.put(p[0], new HashSet<>());
			}
			map.get(p[0]).add(p[1]);
		}

		int min = Integer.MAX_VALUE;

		// now for each points, consider any 2 possible elements that are not in same
		// line

		for (int[] p1 : points) {

			for (int[] p2 : points) {

				if (p1[0] == p2[0] || p1[1] == p2[1]) { // don't consider points that are already lying on the same
														// vertical or horizontal line
					continue;
				}
				// consider 2 points lying on diagonal of rectangle
				// if this condition satisfies, it means that there is a point lying on same
				// vertical axis with same y coordinate which forms a rectangle from both sides
				if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
					min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
				}
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
