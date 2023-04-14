package leetcodeGreedy;

import java.util.Arrays;

//You are given a 0-indexed integer array buses of length n, where buses[i] represents the departure time of the ith bus. You are also given a 0-indexed integer array passengers of length m, where passengers[j] represents the arrival time of the jth passenger. All bus departure times are unique. All passenger arrival times are unique.
//
//You are given an integer capacity, which represents the maximum number of passengers that can get on each bus.
//
//When a passenger arrives, they will wait in line for the next available bus. You can get on a bus that departs at x minutes if you arrive at y minutes where y <= x, and the bus is not full. Passengers with the earliest arrival times get on the bus first.
//
//More formally when a bus arrives, either:
//
//If capacity or fewer passengers are waiting for a bus, they will all get on the bus, or
//The capacity passengers with the earliest arrival times will get on the bus.
//Return the latest time you may arrive at the bus station to catch a bus. You cannot arrive at the same time as another passenger.
//
//Note: The arrays buses and passengers are not necessarily sorted.

public class TheLatestTimeToCatchBus {

	public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
		Arrays.sort(buses);
		Arrays.sort(passengers);

		int n = passengers.length;
		int m = buses.length;

		int j = 0;
		int count = 0;
		for (int i = 0; i < buses.length; i++) {
			count = 0;
			while (j < passengers.length && passengers[j] <= buses[i] && count < capacity) {
				j++;
				count++;
			}

			if (i == m - 1) { // take the last bus
				if (count < capacity) {
					// last bus not full
					// we can take the latest time to be bus departure time and work backwords till
					// we find empty slot
					int time = buses[i];
					int k = j - 1;
					while (k >= 0 && passengers[k] == time) {
						time--;
						k--;
					}
					return time;
				} else {
					// the last bus is filled to capacity
					// we need to find the first empty slot before the last man in the bus
					int time = passengers[j - 1] - 1;
					int k = j - 2;
					while (k >= 0 && passengers[k] == time) {
						time--;
						k--;
					}
					return time;
				}
			}
		}

		return -1;

	}

}
