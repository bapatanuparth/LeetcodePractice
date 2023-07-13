package leetcodeDynamicProgramming;

public class TossStrangeCoins {
	public double probabilityOfHeads(double[] prob, int target) {
		double dp[][] = new double[target + 1][prob.length + 1];
		dp[0][0] = 1;

		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = (dp[0][i - 1]) * (1 - prob[i - 1]);
		}
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i > j)
					continue;
				else if (j == i)
					dp[i][j] = prob[j - 1] * dp[i - 1][j - 1];
				else
					dp[i][j] = dp[i][j - 1] * (1 - prob[j - 1]) + dp[i - 1][j - 1] * prob[j - 1];

			}

		}
		return dp[target][dp[0].length - 1];
	}

}
