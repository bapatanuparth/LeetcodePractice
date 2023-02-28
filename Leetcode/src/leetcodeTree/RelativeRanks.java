package leetcodeTree;

import java.util.PriorityQueue;
import java.util.Queue;

//You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.
//
//The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
//
//The 1st place athlete's rank is "Gold Medal".
//The 2nd place athlete's rank is "Silver Medal".
//The 3rd place athlete's rank is "Bronze Medal".
//For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
//Return an array answer of size n where answer[i] is the rank of the ith athlete.

public class RelativeRanks {

	public String[] findRelativeRanks(int[] score) {
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

		for (int i = 0; i < score.length; i++) {
			pq.add(new int[] { score[i], i });
		}

		String[] res = new String[score.length];
		int count = 0;
		while (!pq.isEmpty()) {
			int[] val = pq.poll();
			count++;
			if (count == 1) {
				res[val[1]] = "Gold Medal";
			} else if (count == 2) {
				res[val[1]] = "Silver Medal";
			} else if (count == 3) {
				res[val[1]] = "Bronze Medal";
			} else {
				res[val[1]] = "" + count;
			}
		}

		return res;
	}

}
