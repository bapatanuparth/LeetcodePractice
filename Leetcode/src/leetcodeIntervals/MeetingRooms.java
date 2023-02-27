package leetcodeIntervals;

import java.util.Arrays;

public class MeetingRooms {

	public boolean canAttendMeetings(int[][] intervals) {
		if (intervals.length == 0)
			return true;

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int a = intervals[0][0];
		int b = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < b)
				return false;
			else {
				a = intervals[i][0];
				b = intervals[i][1];
			}
		}

		return true;
	}
}
