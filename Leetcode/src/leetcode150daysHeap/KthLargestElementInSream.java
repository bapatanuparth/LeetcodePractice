package leetcode150daysHeap;

import java.util.PriorityQueue;
import java.util.Queue;

//Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//Implement KthLargest class:
//
//KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
//int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

public class KthLargestElementInSream {

	int k;
	int[] nums;
	Queue<Integer> q;

	public void KthLargest(int k, int[] nums) {
		this.k = k;
		this.nums = nums;
		q = new PriorityQueue<>((a, b) -> a - b);

		for (int i : nums) {
			q.add(i);
			if (q.size() > k)
				q.poll();
		}
	}

	public int add(int val) {
		q.add(val);
		if (q.size() > k)
			q.poll();
		return q.peek();
	}
}
