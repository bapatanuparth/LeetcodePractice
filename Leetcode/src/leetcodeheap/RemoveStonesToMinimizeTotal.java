package leetcodeheap;

import java.util.PriorityQueue;
import java.util.Queue;

//You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k. You should apply the following operation exactly k times:
//
//Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
//Notice that you can apply the operation on the same pile more than once.
//
//Return the minimum possible total number of stones remaining after applying the k operations.
//
//floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).

public class RemoveStonesToMinimizeTotal {

	// without using pq
	class Solution {
		public int minStoneSum(int[] piles, int k) {
			int[] pq = new int[100001];
			for (int i = 0; i < piles.length; i++) {
				pq[piles[i]]++;
			}

			for (int i = 10000; i > 0 && k > 0; i--) {
				if (pq[i] > 0) {
					while (pq[i] > 0 && k > 0) {
						int next = i / 2;
						pq[i - next]++;
						pq[i]--;
						k--;
					}
				}
			}

			int ans = 0;
			for (int i = 0; i < 100001; i++) {
				if (pq[i] > 0) {
					ans += pq[i] * i;
				}
			}

			return ans;
		}
	}

	// using priority queue
	public int minStoneSum(int[] piles, int k) {

		Queue<Integer> q = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

		for (int i : piles)
			q.add(i);

		while (k > 0) {
			int a = q.poll();
			if (a == 1) {
				q.add(a);
				break;
			}
			int val = 0;
			if (a % 2 == 1) {
				val = a / 2 + 1;
			} else
				val = a / 2;
			q.add(val);
			k--;
		}

		int sum = 0;
		while (!q.isEmpty()) {
			sum += q.poll();
		}

		return sum;
	}

}
