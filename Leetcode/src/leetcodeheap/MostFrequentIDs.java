package leetcodeheap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//The problem involves tracking the frequency of IDs in a collection that changes over time. You have two integer arrays, nums and freq, of equal length n. Each element in nums represents an ID, and the corresponding element in freq indicates how many times that ID should be added to or removed from the collection at each step.
//
//Addition of IDs: If freq[i] is positive, it means freq[i] IDs with the value nums[i] are added to the collection at step i.
//Removal of IDs: If freq[i] is negative, it means -freq[i] IDs with the value nums[i] are removed from the collection at step i.
//Return an array ans of length n, where ans[i] represents the count of the most frequent ID in the collection after the ith step. If the collection is empty at any step, ans[i] should be 0 for that step.

public class MostFrequentIDs {

	public long[] mostFrequentIDs(int[] nums, int[] freq) {

		// nums[i] - [timestamp, freq]
		Map<Integer, long[]> map = new HashMap<>();

		// [nums[i], timestamp, freq]

		Queue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(b[2], a[2]));// maxheap on freq

		long ans[] = new long[nums.length];

		for (int i = 0; i < nums.length; i++) {

			if (map.containsKey(nums[i])) {
				long newfreq = map.get(nums[i])[1] + freq[i]; // calculate revised frequency
				map.put(nums[i], new long[] { i, newfreq }); // keep track of the new frequency with timestamp
			} else {
				map.put(nums[i], new long[] { i, freq[i] });
			}
			long currFreq = map.get(nums[i])[1];

			q.offer(new long[] { nums[i], i, currFreq }); // add new array in the heap

			// now we have to make sure that max frequency we pick through heap is accurate
			// i.e. if max frequency of element is reduced, we need to make sure that we
			// ignore it correctly and pick second max
			while (!q.isEmpty()) {
				// get top element of the heap and its timestamp from the heap
				long[] currTop = q.peek();
				int topEle = (int) currTop[0];
				long topTimeStamp = currTop[1];
				if (map.get(topEle)[0] > topTimeStamp)// this is an older record, poll it, this is stale record, not
														// current updated one
					q.poll();
				else
					break;
			}
			ans[i] = q.isEmpty() ? 0 : q.peek()[2];
		}

		return ans;
	}

}
