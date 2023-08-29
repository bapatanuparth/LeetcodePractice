package leetcode150daysGreedy;

import java.util.LinkedList;

//You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
//Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//Return intervals after the insertion.

public class InsertInterval {

	public int[][] insert(int[][] arr, int[] newInterval) {
		int i = 0;
		LinkedList<int[]> res = new LinkedList<>();
		while (i < arr.length && arr[i][1] < newInterval[0]) {
			res.add(arr[i]);
			i++;
		}

		while (i < arr.length && arr[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(arr[i][0], newInterval[0]);
			newInterval[1] = Math.max(arr[i][1], newInterval[1]);

			i++;
		}
		res.add(newInterval);

		while (i < arr.length) {
			res.add(arr[i]);
			i++;
		}

		return res.toArray(new int[res.size()][2]);
	}

}
