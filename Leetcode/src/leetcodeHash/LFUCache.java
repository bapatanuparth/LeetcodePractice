package leetcodeHash;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {

	int cap;
	int time = 0;
	// key : [value, freq]
	Map<Integer, int[]> map;
	// [key, freq, time]
	PriorityQueue<int[]> q;

	public LFUCache(int capacity) {
		cap = capacity;
		map = new HashMap<>();
		q = new PriorityQueue<>((a, b) -> {
			if (a[1] == b[1]) {
				return a[2] - b[2]; // in case of tie, return the least recently used key
			} else
				return a[1] - b[1];
		});

	}

	public int get(int key) {
		if (cap == 0 || !map.containsKey(key))
			return -1;
		int[] arr = map.get(key); // fetch value, update frequency, add to map and queue
		int value = arr[0];
		int freq = arr[1] + 1;
		map.put(key, new int[] { value, freq });
		q.offer(new int[] { key, freq, time++ }); // this can cause a case where we have multiple values for same key in
													// priority queue
		// to tackle this, we save the correct frequency value in the map as well.
		// while removing, we match the key and frequency from map and queue.
		// queue will ensure the correct minimum freq value and map will ensure the
		// correct key mapped to the min frequency polled
		return value;
	}

	public void put(int key, int value) {
		if (cap == 0)
			return;
		if (map.containsKey(key)) {
			int arr[] = map.get(key);
			int freq = arr[1] + 1;
			map.put(key, new int[] { value, freq });
			q.offer(new int[] { key, freq, time++ });
		} else {
			if (map.size() >= cap) {
				while (!q.isEmpty()) { // fetch values from queue until we get to the key and frequency value matching
										// in map and pqueue
					int[] arr = q.poll();
					if (map.containsKey(arr[0]) && map.get(arr[0])[1] == arr[1]) { // these values match means we have
																					// found the right element
						map.remove(arr[0]);
						break;
					}
				}
			}

			map.put(key, new int[] { value, 1 });
			q.offer(new int[] { key, 1, time++ });

		}

	}
}
