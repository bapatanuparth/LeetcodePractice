package leetcodeInterviewPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

public class MinTimeDifference {

	public class Solution {

		// solution without sorting
		public int findMinDifference(List<String> timePoints) {
			boolean[] mark = new boolean[24 * 60];
			for (String time : timePoints) {
				String[] t = time.split(":");
				int h = Integer.parseInt(t[0]);
				int m = Integer.parseInt(t[1]);
				if (mark[h * 60 + m])
					return 0;
				mark[h * 60 + m] = true;
			}

			int prev = 0, min = Integer.MAX_VALUE;
			int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
			for (int i = 0; i < 24 * 60; i++) {
				if (mark[i]) {
					if (first != Integer.MAX_VALUE) {
						min = Math.min(min, i - prev);
					}
					first = Math.min(first, i);
					last = Math.max(last, i);
					prev = i;
				}
			}

			min = Math.min(min, (24 * 60 - last + first));

			return min;
		}
	}

	public int findMinDifference(List<String> timePoints) {

		List<Integer> arr = new ArrayList<>();
		int i = 0;
		// get all data in minutes
		for (String s : timePoints) {
			int hrs = Integer.parseInt(s.substring(0, 2));
			int min = Integer.parseInt(s.substring(3));

			min = hrs * 60 + min;
			arr.add(min);

		}
		// sort the data to easily fond the min distance by straight array traversal
		// once
		Collections.sort(arr);

		int min = Integer.MAX_VALUE;
		// find min time difference
		for (int j = 1; j < arr.size(); j++) {
			int diff = arr.get(j) - arr.get(j - 1);
			min = Math.min(min, diff);
		}
		// for the corner case for ex. 23:59 and 00:00, we have to consider if the 1st
		// and last elements are closer to each other
		// the minutes of 23:59 are 1439, the clock can be thought of as 1440 minutes ==
		// 00 minutes reset, so below equation can give us the minutes value from
		// opposite side of the clock
		int diff = Math.abs((arr.get(0) + (1440 - arr.get(arr.size() - 0 - 1))));
		min = Math.min(min, diff);
		return min;
	}

}
