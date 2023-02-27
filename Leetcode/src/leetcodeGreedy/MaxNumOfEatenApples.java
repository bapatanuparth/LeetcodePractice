package leetcodeGreedy;

import java.util.PriorityQueue;
import java.util.Queue;

//There is a special kind of apple tree that grows apples every day for n days. On the ith day, the tree grows apples[i] apples that will rot after days[i] days, that is on day i + days[i] the apples will be rotten and cannot be eaten. On some days, the apple tree does not grow any apples, which are denoted by apples[i] == 0 and days[i] == 0.
//
//You decided to eat at most one apple a day (to keep the doctors away). Note that you can keep eating after the first n days.
//
//Given two integer arrays days and apples of length n, return the maximum number of apples you can eat.

public class MaxNumOfEatenApples {

//	Greedy idea is to eat apples with the earliest expiration date.
//	We need to keep track of 2 things:
//
//	batch expiration date
//	apple count in a batch
//	Every day we remove rotten batches and batches that do not contain any more apples. MinHeap is sorted by expiration date.
	public int eatenApples(int[] apples, int[] days) {
		Queue<int[]> appleStorage = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		int appleCount = 0;

		for (int i = 0; i < apples.length || !appleStorage.isEmpty(); i++) {
			if (i < apples.length) {
				appleStorage.add(new int[] { i + days[i], apples[i] }); // add expiry of apples, and total number of
																		// apples
			}

			while (!appleStorage.isEmpty() && (appleStorage.peek()[0] <= i || appleStorage.peek()[1] <= 0))
				appleStorage.poll(); // remove either expired apple or the apple which are finished

			if (!appleStorage.isEmpty()) {
				appleCount++;
				appleStorage.peek()[1]--;
			}
		}

		return appleCount;

	}
}
