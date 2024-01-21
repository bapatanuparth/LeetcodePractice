package leetcodeGreedy;

import java.util.Arrays;

//You are given a 0-indexed integer array coins, representing the values of the coins available, and an integer target.
//
//An integer x is obtainable if there exists a subsequence of coins that sums to x.
//
//Return the minimum number of coins of any value that need to be added to the array so that every integer in the range [1, target] is obtainable.
//
//A subsequence of an array is a new non-empty array that is formed from the original array by deleting some (possibly none) of the elements without disturbing the relative positions of the remaining elements.

public class MinNumberOfCoinsToBeAdded {

	public int minimumAddedCoins(int[] coins, int target) {
		// sort array
		Arrays.sort(coins);

		int curr_max = 0, additions = 0;
		int i = 0;
		// keep track of which value we have got till now
		while (curr_max < target) {
			// if new coin <= curr_max +1, it means this coin will add to the curr_max and
			// extend our reach further.
			// curr_max we are considering all the unique values that we have covered so
			// far, so we can directly say that we exted our reach by the new value
			if (i < coins.length && coins[i] <= curr_max + 1) {
				curr_max += coins[i];
				i++;
			} else {
				// we assume we added the coin in order to extend current max
				curr_max += curr_max + 1;
				additions++;
			}
		}

		return additions;
	}
}
