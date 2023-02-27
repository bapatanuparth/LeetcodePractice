package leetcodeDynamicProgramming;

import java.util.Arrays;

public class MaxLengthChain {

	class Pair {
		int x; // key of the pair
		int y; // value of the pair of input
	}

	int maxChainLength(Pair arr[], int n) {
		// your code here

		// sort the pairs based on their key
		Arrays.sort(arr, (a, b) -> a.x - b.x);

		int dp[] = new int[arr.length];
		// we need to find the longest possible chain such that prev pair's value<= curr
		// pair's key

		dp[0] = 1;
		// in dp tabulation, for each index we will store the longest possible chain
		// till that index
		for (int i = 1; i < dp.length; i++) {

			// for each index, go back till prev elements value > curr element's key
			int left = i - 1;
			while (left >= 0 && arr[left].y >= arr[i].x)
				left--;
			// then add 1 to the previous valid value / choose the max till that element
			if (left >= 0)
				dp[i] = Math.max(dp[i - 1], dp[left] + 1);
			else
				// if no such element present before, it means the current element cannot be
				// placed after any other pair as chain

				// hence just copy whatever the max is till previous element
				dp[i] = dp[i - 1];

		}

		return dp[dp.length - 1];

	}
}
