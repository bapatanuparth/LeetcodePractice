package leetcodeDynamicProgramming;

public class StoneGameIII {

	public String stoneGameIII(int[] stoneValue) {
		int n = stoneValue.length;
		int dp[] = new int[n + 1]; // difference between the scores of the players

		for (int i = n - 1; i >= 0; i--) {
			dp[i] = stoneValue[i] - dp[i + 1]; // take only current score. we subtract dp[i+1] because it represents
												// score of the other player before the current i
			if (i + 2 <= n) { // here we consider 2 stones to be taken at a time
				dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] - dp[i + 2]); // we take max because each
																						// player is trying to maximize
																						// their score
			}
			if (i + 3 <= n) { // here we consider 3 stones at a time
				dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3]);
			}
		}

		if (dp[0] > 0) {
			return "Alice";
		}
		if (dp[0] < 0) {
			return "Bob";
		}
		return "Tie";

	}

}
