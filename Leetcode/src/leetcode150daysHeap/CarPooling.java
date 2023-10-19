package leetcode150daysHeap;

import java.util.Arrays;
import java.util.PriorityQueue;

//There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
//
//You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.
//
//Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

public class CarPooling {

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
