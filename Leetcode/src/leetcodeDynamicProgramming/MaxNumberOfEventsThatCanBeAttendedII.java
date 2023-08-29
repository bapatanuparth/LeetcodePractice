package leetcodeDynamicProgramming;

import java.util.Arrays;

//You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also given an integer k which represents the maximum number of events you can attend.
//
//You can only attend one event at a time. If you choose to attend an event, you must attend the entire event. Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other ends on the same day.
//
//Return the maximum sum of values that you can receive by attending events.

public class MaxNumberOfEventsThatCanBeAttendedII {

	int[][] dp;

	public int maxValue(int[][] events, int k) {
		Arrays.sort(events, (a, b) -> a[0] - b[0]);
		int n = events.length;
		dp = new int[n][k + 1];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return dfs(events, 0, 0, -1, k);

	}

	int dfs(int[][] events, int index, int count, int prev_end, int k) {
		if (count == k || index == events.length) {
			return 0;
		}
		// if curr start > prev end, skip the even
		if (events[index][0] <= prev_end) {
			return dfs(events, index + 1, count, prev_end, k);
		}

		if (dp[index][count] != -1)
			return dp[index][count];

		int ans = Math.max(dfs(events, index + 1, count, prev_end, k),
				dfs(events, index + 1, count + 1, events[index][1], k) + events[index][2]);
		dp[index][count] = ans;
		return ans;
	}

}
