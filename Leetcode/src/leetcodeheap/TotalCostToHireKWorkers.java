package leetcodeheap;

import java.util.PriorityQueue;
import java.util.Queue;
//You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.
//
//You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:
//
//You will run k sessions and hire exactly one worker in each session.
//In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
//For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
//In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
//If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
//A worker can only be chosen once.
//Return the total cost to hire exactly k workers.

public class TotalCostToHireKWorkers {

	// use 2 min heaps, one maintains the left half and the other maintains the
	// right half
	public long totalCost(int[] costs, int k, int candidates) {

		int n = costs.length;
		Queue<Integer> first = new PriorityQueue<>();
		Queue<Integer> sec = new PriorityQueue<>();

		// keep left and right pointer so that u dont overlap 2 min heaps
		int left = 0, right = n - 1;

		long res = 0;
		while (k > 0) {

			// add candidates to 2 heaps while left<=right
			while (first.size() < candidates && left <= right) {
				first.add(costs[left++]);
			}
			while (sec.size() < candidates && left <= right) {
				sec.add(costs[right--]);
			}

			// fetch the top of 2 candidates
			int top1 = first.size() > 0 ? first.peek() : Integer.MAX_VALUE;
			int top2 = sec.size() > 0 ? sec.peek() : Integer.MAX_VALUE;

			// add the smallest one to result
			if (top1 <= top2) {
				res += first.poll();
			} else
				res += sec.poll();
			// repeat while k workers are not hired yet
			k--;
		}

		return res;

	}
}
