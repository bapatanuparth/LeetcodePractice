package leetcode150daysGreedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

public class MergeIntervals {

	class Solution {
		public int[][] merge(int[][] arr) {
			List<int[]> res = new ArrayList<>();
			Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

			int start = arr[0][0];
			int end = arr[0][1];

			for (int i = 1; i < arr.length; i++) {
				if (arr[i][0] > end) {
					res.add(new int[] { start, end });
					start = arr[i][0];
					end = arr[i][1];
				} else {
					end = Math.max(end, arr[i][1]);
				}
			}
			res.add(new int[] { start, end });

			return res.toArray(new int[res.size()][]);

		}
	}

}
