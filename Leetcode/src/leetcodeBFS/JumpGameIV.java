package leetcodeBFS;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//Given an array of integers arr, you are initially positioned at the first index of the array.
//
//In one step you can jump from index i to index:
//
//i + 1 where: i + 1 < arr.length.
//i - 1 where: i - 1 >= 0.
//j where: arr[i] == arr[j] and i != j.
//Return the minimum number of steps to reach the last index of the array.
//
//Notice that you can not jump outside of the array at any time.

public class JumpGameIV {

	// Basic BFS algorithm easy
	public int minJumps(int[] arr) {

		// keep a track of all indexes at which the current element is present
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], new HashSet<>());
			}
			map.get(arr[i]).add(i);
		}

		// create a queue for BFS
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[arr.length];
		q.add(0);
		visited[0] = true;

		int steps = 0;

		// at each step in BFS, append the next all possible indices in the queue
		// take the indices out of queue one by one till we reach the last index of the
		// array
		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {
				// take out the current index
				int ind = q.poll();

				// return if we reach the last index
				if (ind == arr.length - 1)
					return steps;
				if (map.containsKey(arr[ind])) { // this means we havent added all the possible next jumps for current
													// element
					for (int s : map.get(arr[ind])) { // iterate over all indices where arr[i] == arr[j]
						if (visited[s] == false)
							q.add(s); // add all those indices as the next possible jumps
						visited[s] = true;
					}
					map.remove(arr[ind]); // rempve arr[ind] so that if next time we come across same element, we do not
											// iterate over the same indices again. this will reduce the time complexity
				}

				// check if we can go one step ahead
				if (visited[ind + 1] == false) {
					q.add(ind + 1);
					visited[ind + 1] = true;
				}
				// check if we can go one step before
				if (ind > 0 && visited[ind - 1] == false) {
					q.add(ind - 1);
					visited[ind - 1] = true;
				}

			}

			steps++;
		}

		return -1;
	}
}
