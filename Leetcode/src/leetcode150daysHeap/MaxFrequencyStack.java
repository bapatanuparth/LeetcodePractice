package leetcode150daysHeap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
//
//Implement the FreqStack class:
//
//FreqStack() constructs an empty frequency stack.
//void push(int val) pushes an integer val onto the top of the stack.
//int pop() removes and returns the most frequent element in the stack.
//If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.

public class MaxFrequencyStack {

	class FreqStack {
		Queue<int[]> pq;
		Map<Integer, Integer> map;
		int time;

		// int[] == [num, freq, time]
		// map > num-freq
		public FreqStack() {
			// arrange the priority queue such that
			// firstly, check if the frequencies are not same, if not then order based on
			// their frequencies
			// otherwise, keep track of time, and if freq are same, then order based on time
			// of appearence
			pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[2] - a[2] : b[1] - a[1]);

			// keep a hashmap for constant lookup of frequency
			map = new HashMap<>();
			this.time = 0;
		}

		public void push(int val) {
			map.put(val, map.getOrDefault(val, 0) + 1);
			int[] arr = new int[] { val, map.get(val), ++time };
			pq.add(arr);

		}

		public int pop() {
			int arr[] = pq.poll();
			map.put(arr[0], map.get(arr[0]) - 1);
			return arr[0];
		}
	}
}