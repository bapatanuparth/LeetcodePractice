package leetcodeGraphs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
//
//For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
//You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.
//
//Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible

public class BusRoutes {
	// Basic BFS solution
	public int numBusesToDestination(int[][] routes, int source, int target) {
		Map<Integer, Set<Integer>> map = new HashMap<>(); // map to store stop number - bus pair
		int res = 0;

		if (source == target)
			return res;

		for (int i = 0; i < routes.length; i++) {

			for (int j : routes[i]) {
				if (!map.containsKey(j))
					map.put(j, new HashSet<>());
				map.get(j).add(i); // map each stop to all the buses that cover that stop
				// bus 0, bus 1 etc.
			}

		}
		// in map we have a pair of = stop number - set{all buses that go to that stop}

		Set<Integer> seen = new HashSet<>();
		Queue<Integer> q = new ArrayDeque<>();
		q.add(source);
		while (!q.isEmpty()) {
			int size = q.size();
			res++;

			for (int i = 0; i < size; i++) {
				int cur = q.poll(); // stop number
				Set<Integer> buses = map.get(cur); // get all the buses at that stop

				for (int bus : buses) { // iterate over the buses
					if (seen.contains(bus)) // if the bus is not covered yet
						continue;
					seen.add(bus);
					for (int k = 0; k < routes[bus].length; k++) { // check if target stop is covered by that route of
																	// the bus.
						if (routes[bus][k] == target)
							return res; // if yes return,
						q.offer(routes[bus][k]); // else, add all the intermidiate stops covered by the bus and for each
													// stop, repeat the process of checking this next bus
					}
				}

			}

		}

		return -1;
	}

}
