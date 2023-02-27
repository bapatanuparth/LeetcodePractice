package leetcodeIntervals;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class CarPooling {

	// best TreeMap implementation, can be used anywhere
	public boolean carPoolingTreeMap(int[][] trips, int capacity) {
		Map<Integer, Integer> m = new TreeMap<>();

		for (int[] t : trips) {
			m.put(t[1], m.getOrDefault(t[1], 0) + t[0]); // add the point of trip start
			m.put(t[2], m.getOrDefault(t[2], 0) - t[0]); // add the point of trip end
		}

		// treemap will be traversed in order, so we can check whether the capacity
		// always remains >0
		for (int v : m.values()) {
			capacity -= v; // if trip was ended, it will automatically refill the capacity as it was
							// subtracted while filling map
			if (capacity < 0) {
				return false;
			}
		}
		return true;
	}

	// easier solution
	// we know we have 1000 stops, count #of ppl getting onboard at 1 stop, and
	// number of ppl leaving on a stop
	public boolean carPoolingEfficient(int[][] trips, int capacity) {
		int stops[] = new int[1001];
		for (int t[] : trips) {
			stops[t[1]] += t[0];
			stops[t[2]] -= t[0];
		}
		for (int i = 0; capacity >= 0 && i < 1001; ++i)
			capacity -= stops[i];
		return capacity >= 0;
	}

	public boolean carPooling(int[][] trips, int capacity) {

		Arrays.sort(trips, (a, b) -> a[1] - b[1]); // sort based on starting point of the trip
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]); // this is used to check the drop locations
																				// of trips

		q.add(trips[0]);// add the trip so we can maintain if passengers get off the trip midway

		int cap = trips[0][0];

		if (cap > capacity) // if current capacity exceeds, we cannot go
			return false;

		for (int i = 1; i < trips.length; i++) {

			int[] trip = trips[i];
			if (trip[1] < q.peek()[2]) { // if the boarding location is less than the least of previous all trip's
											// ending time, it means there is an overlap of trips
				// there is overlap
				cap += trip[0]; // increase the capacity and add this trip in queue
				q.add(trip);

			} else { // if the current starting is greater than the least ending time of any of the
						// previous trip, we need to make sure that we subtract those passengers from
						// the present passengers in car
				while (q.size() > 0 && trip[1] >= q.peek()[2]) { // check how many trips have ended before starting
																	// current trip
					cap -= q.peek()[0]; // reduce as many members from car
					q.poll();
				}
				cap += trip[0]; // add current people on car
				q.add(trip);
			}

			if (cap > capacity)
				return false;
		}

		return true;

	}
}
