package leetcodeheap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every two consecutive elements is the same. More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.
//
//For example, these are arithmetic sequences:
//
//1, 3, 5, 7, 9
//7, 7, 7, 7
//3, -1, -5, -9
//The following sequence is not arithmetic:
//
//1, 1, 2, 5, 7
//You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries, where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.
//
//Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.

public class ArithmeticSubarrays {

	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> res = new ArrayList<>();

		for (int i = 0; i < l.length; i++) {
			int left = l[i];
			int right = r[i];
			Queue<Integer> pq = new PriorityQueue<>();
			for (; left <= right; left++) {
				pq.add(nums[left]);
			}
			if (checkAP(pq)) {
				res.add(true);
			} else
				res.add(false);
		}

		return res;
	}

	boolean checkAP(Queue<Integer> pq) {
		int diff = Integer.MIN_VALUE;
		int prev = pq.poll();

		while (!pq.isEmpty()) {
			int curr = pq.poll();
			if (diff == Integer.MIN_VALUE)
				diff = curr - prev;
			else if (curr - prev != diff)
				return false;
			prev = curr;
		}

		return true;
	}

}
