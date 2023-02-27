package leetcodeIntervals;

import java.util.LinkedList;

public class InsertInterval {

	public int[][] insert(int[][] arr, int[] newInterval) {
		LinkedList<int[]> res = new LinkedList<>();
		int i = 0;

		// add all in the result who have finish time < start time of new interval
		while (i < arr.length && arr[i][1] < newInterval[0]) {
			res.add(arr[i]);
			i++;
		}

		// check how many middle intervals are overlapped by newinterval
		// if newinterval's end time> interval's start time, then that interval should
		// be merged in newInterval
		while (i < arr.length && arr[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(arr[i][0], newInterval[0]);
			newInterval[1] = Math.max(arr[i][1], newInterval[1]);
			i++;
		}

		// add the merged interval
		res.add(newInterval);

		// add remaining intervals
		while (i < arr.length) {
			res.add(arr[i]);
			i++;
		}

		// return
		return res.toArray(new int[res.size()][]);
	}
}
