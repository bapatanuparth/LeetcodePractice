package leetcodeIntervals;

import java.util.Arrays;

//Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
public class NonOverlappingIntervals {

	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort by starting

		int prevEnd = intervals[0][1];
		int count = 0;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= prevEnd)
				prevEnd = intervals[i][1];
			else {
				count++;
				prevEnd = Math.min(prevEnd, intervals[i][1]); // greedily choose the one that has minimum end, to make
																// sure we are removing min number of overlapping
																// elementsa
				// one that has longer end in overlap has high chances of more intersections and
				// hence should be removed
				// choosing the one with min end gives high probability of doing that
			}
		}

		return count;

	}

	// Approach 2,
	public int eraseOverlapIntervalsII(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> {
			return a[1] - b[1];
		});

		// we are essentially doing the same thing we did previously
		int end = intervals[0][1];
		int count = 1;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= end) {
				count++; // count good intervals
				end = intervals[i][1];
			}
		}

		return intervals.length - count;
	}

}
