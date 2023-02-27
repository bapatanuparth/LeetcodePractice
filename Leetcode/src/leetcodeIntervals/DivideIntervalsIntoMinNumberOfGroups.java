package leetcodeIntervals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].
//
//You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two intervals that are in the same group intersect each other.
//
//Return the minimum number of groups you need to make.
//
//Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.
//Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
//Output: 3

//can also be phrased as find Maximum Overlapping Intervals at any point
//same as meeting rooms II
public class DivideIntervalsIntoMinNumberOfGroups {

	public int minGroups(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);

		Queue<Integer> q = new PriorityQueue<>();
		q.add(intervals[0][1]);

		int count = 1;
		for (int i = 1; i < intervals.length; i++) {

			if (intervals[i][0] <= q.peek()) {
				count++;
			} else {
				q.poll();
			}
			q.offer(intervals[i][1]);
		}

		return count;
	}
}
