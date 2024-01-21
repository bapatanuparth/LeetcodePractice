package leetcode150daysHeap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Design and implement a data structure for a Least Frequently Used (LFU) cache.
//
//Implement the LFUCache class:
//
//LFUCache(int capacity) Initializes the object with the capacity of the data structure.
//int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
//void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
//To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.
//
//When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.
//
//The functions get and put must each run in O(1) average time complexity.

public class LFUCache {

	int cap;
	int time = 0;
	// key : value, freq
	Map<Integer, int[]> map;
	// key, freq, time
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
		int[] arr = map.get(key);
		int value = arr[0];
		int freq = arr[1] + 1;
		map.put(key, new int[] { value, freq });
		q.offer(new int[] { key, freq, time++ });
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
				while (!q.isEmpty()) {
					int[] arr = q.poll();
					if (map.containsKey(arr[0]) && map.get(arr[0])[1] == arr[1]) {
						map.remove(arr[0]);
						break;
					}
				}
			}

			map.put(key, new int[] { value, 1 });
			q.offer(new int[] { key, 1, time++ });

		}

	}

	/**
	 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
	 * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
	 */

}
