package leetcodeBinarySearch;

import java.util.Arrays;

//You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.
//
//Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.
//
//You are also given an integer totalTrips, which denotes the number of trips all buses should make in total. Return the minimum time required for all buses to complete at least totalTrips trips.

public class MinTimeToCompleteTrips {

	// binary search algorithm
	public long minimumTime(int[] time, int totalTrips) {
		Arrays.sort(time);
		long mintime = time[0]; // this will be the min time required to complete one trip
		long maxtime = totalTrips * mintime; // max time required to complete totalTrips would be if we chse only 1 bus
												// with minimum time and used only 1 bus
		long ans = Long.MAX_VALUE;

		// algorithm is given a time, find out the max number of total trips that are
		// done by all the buses in that time
		while (mintime <= maxtime) {

			long mid = mintime + (maxtime - mintime) / 2;

			if (calctrips(time, mid) < totalTrips) {
				mintime = mid + 1;
			} else {
				ans = Math.min(ans, mid);
				maxtime = mid - 1;
			}
		}
		return ans;
	}

	long calctrips(int[] time, long t) {
		long ans = 0;
		for (int i : time) {
			ans += (t / i);
		}
		return ans;
	}
}
