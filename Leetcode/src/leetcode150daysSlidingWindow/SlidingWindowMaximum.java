package leetcode150daysSlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

//You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
//Return the max sliding window.

public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {

		int n = nums.length;
		Deque<Integer> deq = new ArrayDeque<>();
		int res[] = new int[n - k + 1];

		for (int i = 0; i < n; i++) {

			// keep track of window, if we move out of the window, then remove first element
			// this will remove the max fof the previous window
			if (deq.size() > 0 && deq.peekFirst() <= i - k)
				deq.pollFirst();

			// while putting the new number maintain order such that the first element of
			// the deque will be the current window max
			// so while putting new element, remove all the previous elements from last that
			// are smaller than the current element
			while (deq.size() > 0 && nums[deq.peekLast()] < nums[i])
				deq.pollLast();

			deq.offerLast(i);
			if (i - k + 1 >= 0) {
				res[i - k + 1] = nums[deq.peekFirst()];
			}
		}

		return res;
	}

}
