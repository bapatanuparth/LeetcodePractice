package leetcode150daysBacktrack;

import java.util.Arrays;

//You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
//
//Return true if you can make this square and false otherwise.

public class MatchsticksToSquare {

	boolean visited[];

	public boolean makesquare(int[] matchsticks) {
		int total = 0;
		visited = new boolean[matchsticks.length];

		for (int i : matchsticks)
			total += i;
		if (total % 4 != 0)
			return false;
		Arrays.sort(matchsticks);
		return dfs(matchsticks, 4, matchsticks.length - 1, 0, total / 4);
	}

	boolean dfs(int[] nums, int k, int i, int sum, int target) {
		if (k == 0)
			return true;

		if (sum == target) {
			if (dfs(nums, k - 1, nums.length - 1, 0, target))
				return true;
			;
		}

		for (int index = i; index >= 0; index--) {
			if (nums[index] + sum <= target && visited[index] == false) {
				visited[index] = true;
				if (dfs(nums, k, index - 1, sum + nums[index], target))
					return true;
				visited[index] = false;
			}
		}

		return false;
	}

}
