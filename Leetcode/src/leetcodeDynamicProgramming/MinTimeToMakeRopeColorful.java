package leetcodeDynamicProgramming;

import java.util.Arrays;

//Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.
//
//Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.
//
//Return the minimum time Bob needs to make the rope colorful.

public class MinTimeToMakeRopeColorful {

	// VERY EASY ANSWER WITHOUT USING DP
	public int minCostEff(String colors, int[] neededTime) {

		int time = 0;

		for (int i = 0; i < colors.length() - 1; i++) {

			if (colors.charAt(i) == colors.charAt(i + 1)) {

				if (neededTime[i] < neededTime[i + 1]) {
					time += neededTime[i];
				} else {
					time += neededTime[i + 1];
					// in case if we remove next baloon, we need to make sure that we
					// compare current balloon to the balloon at curr+2 in the next iteration
					// so update the next time value with the curr value
					neededTime[i + 1] = neededTime[i];
				}
			}

		}
		return time;
	}

	// SOLUTION NEEDS TO BE MEMOIZED, GIVES TLE
	public int minCost(String colors, int[] neededTime) {
		int len = colors.length();
		if (len == 1)
			return 1;
		else if (len == 2)
			return Math.min(neededTime[0], neededTime[1]);

		int memo[] = new int[neededTime.length];
		Arrays.fill(memo, -1);

		return memoize(colors, neededTime, len - 2, len - 1, memo);
	}

	int memoize(String colors, int[] neededTime, int n, int prev, int[] memo) {

		if (n < 0)
			return 0;

		// if(memo[prev]!=-1)return memo[n];

		int min;
		if (colors.charAt(n) == colors.charAt(prev)) {

			int val1 = neededTime[prev] + memoize(colors, neededTime, n - 1, n, memo);
			int val2 = neededTime[n] + memoize(colors, neededTime, n - 1, prev, memo);
			min = Math.min(val1, val2);
		} else {
			min = memoize(colors, neededTime, n - 1, n, memo);
		}

		return memo[n] = min;
	}
}
