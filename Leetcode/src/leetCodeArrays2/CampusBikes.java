package leetCodeArrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//On a campus represented on the X-Y plane, there are n workers and m bikes, with n <= m.
//
//You are given an array workers of length n where workers[i] = [xi, yi] is the position of the ith worker. You are also given an array bikes of length m where bikes[j] = [xj, yj] is the position of the jth bike. All the given positions are unique.
//
//Assign a bike to each worker. Among the available bikes and workers, we choose the (workeri, bikej) pair with the shortest Manhattan distance between each other and assign the bike to that worker.
//
//If there are multiple (workeri, bikej) pairs with the same shortest Manhattan distance, we choose the pair with the smallest worker index. If there are multiple ways to do that, we choose the pair with the smallest bike index. Repeat this process until there are no available workers.
//
//Return an array answer of length n, where answer[i] is the index (0-indexed) of the bike that the ith worker is assigned to.
//
//The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.

public class CampusBikes {

	class Solution {
		// Class to store (worker, bike, distance)
		class WorkerBikePair {
			int workerIndex;
			int bikeIndex;
			int distance;

			// Constructor to initialize the member variables
			WorkerBikePair(int workerIndex, int bikeIndex, int distance) {
				this.workerIndex = workerIndex;
				this.bikeIndex = bikeIndex;
				this.distance = distance;
			}
		}

		// Custom comparator for sorting
		Comparator<WorkerBikePair> WorkerBikePairComparator = new Comparator<WorkerBikePair>() {
			@Override
			public int compare(WorkerBikePair a, WorkerBikePair b) {
				if (a.distance != b.distance) {
					// Prioritize the one having smaller distance
					return a.distance - b.distance;
				} else if (a.workerIndex != b.workerIndex) {
					// Prioritize according to the worker index
					return a.workerIndex - b.workerIndex;
				} else {
					// Prioritize according to the bike index
					return a.bikeIndex - b.bikeIndex;
				}
			}
		};

		// Function to return the Manhattan distance
		int findDistance(int[] worker, int[] bike) {
			return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
		}

		public int[] assignBikes(int[][] workers, int[][] bikes) {
			// List of WorkerBikePair's to store all the possible pairs
			List<WorkerBikePair> allTriplets = new ArrayList<>();

			// Generate all the possible pairs
			for (int worker = 0; worker < workers.length; worker++) {
				for (int bike = 0; bike < bikes.length; bike++) {
					int distance = findDistance(workers[worker], bikes[bike]);
					WorkerBikePair workerBikePair = new WorkerBikePair(worker, bike, distance);
					allTriplets.add(workerBikePair);
				}
			}

			// Sort the triplets as per the custom comparator 'WorkerBikePairComparator'
			Collections.sort(allTriplets, WorkerBikePairComparator);

			// Initialize all values to false, to signify no bikes have been taken
			boolean bikeStatus[] = new boolean[bikes.length];
			// Initialize all index to -1, to mark all the workers available
			int workerStatus[] = new int[workers.length];
			Arrays.fill(workerStatus, -1);
			// Keep track of how many worker-bike pairs have been made
			int pairCount = 0;

			for (WorkerBikePair triplet : allTriplets) {
				int worker = triplet.workerIndex;
				int bike = triplet.bikeIndex;

				// If both worker and bike are free, assign them to each other
				if (workerStatus[worker] == -1 && !bikeStatus[bike]) {
					bikeStatus[bike] = true;
					workerStatus[worker] = bike;
					pairCount++;

					// If all the workers have the bike assigned, we can stop
					if (pairCount == workers.length) {
						return workerStatus;
					}
				}
			}

			return workerStatus;
		}
	}
}
