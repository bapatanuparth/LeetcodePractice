package leetcodeGreedy;

import java.util.Arrays;
import java.util.PriorityQueue;

//You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
//
//You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.
//
//Return the maximum number of events you can attend.

public class MaxNumberOfEventsThatCanBeAttended {

	public int maxEvents(int[][] events) {
		// get both types of sorting
		// sport by starting point
		Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		// store by min heap of endpoints
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int i = 0, res = 0, n = events.length;

		// on each day
		for (int d = 1; d <= 100000; d++) {
			// bring out all events that have ended
			while (!pq.isEmpty() && pq.peek() < d)
				pq.poll();
			// add all events that are beginning now, based on the end time,
			// so we add all events beginning today in order of their ending times
			while (i < n && events[i][0] == d) {
				pq.offer(events[i++][1]);
			}
			// if there exists anything in the pq, poll it one by one and ++ result
			if (!pq.isEmpty()) {
				res++;
				pq.poll();
			}
		}

		return res;
	}

}
