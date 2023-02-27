package leetcodeIntervals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII {

	public int minMeetingRooms(int[][] intervals) {
		// sort by starting time
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		Queue<Integer> q = new PriorityQueue<>();
		q.offer(intervals[0][1]); // store end time in queue

		int count = 1;
		for (int i = 1; i < intervals.length; i++) {

			if (intervals[i][0] >= q.peek()) { // if new has start < least end time till now, then we will need another
												// room
				q.poll(); // otherwise, we just remove least ending meeting and start new meeting in same
							// room
				q.offer(intervals[i][1]);
			} else {
				count++;
				q.offer(intervals[i][1]);
			}
		}
		return count;
	}
}
