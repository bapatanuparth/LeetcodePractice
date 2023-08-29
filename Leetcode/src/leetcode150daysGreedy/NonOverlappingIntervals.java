package leetcode150daysGreedy;

//Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

public class NonOverlappingIntervals {

	public int eraseOverlapIntervals(int[][] intervals) {
		// Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		int prevend = intervals[0][1];
		int i = 1;
		int count = 0;
		while (i < intervals.length) {
			if (intervals[i][0] >= prevend) {
				prevend = intervals[i][1];
			} else {
				prevend = Math.min(prevend, intervals[i][1]);
				count++;
			}
			i++;
		}

		return count;
	}

}
