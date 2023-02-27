package leetcodeInterviewPrep;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {

	// sort array based on start time as we will schedule meets from start of the
	// day
	// use a priority queue to store the end times in sorted way
	// so for each new meeting, check q.peek() if its less than that, we need to
	// utilize new room , else we can use previously occupied room
	public int minMeetingRooms(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		Queue<Integer> q = new PriorityQueue<>();
		q.add(intervals[0][1]);

		int count = 1;
		for (int i = 1; i < intervals.length; i++) {

			int arr[] = intervals[i];

			if (arr[0] < q.peek()) {
				count++;
				q.add(arr[1]);
			} else {
				q.poll();
				q.add(arr[1]);
			}
		}

		return count;
	}
}
