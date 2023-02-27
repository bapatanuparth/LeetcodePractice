package leetcodeDynamicProgramming;

import java.util.Arrays;

public class BestTeamWithNoConflict {

	int bestTeam(int[] scores, int[] ages) {
		int n = scores.length;
		int[][] ageScores = new int[n][n];

		for (int i = 0; i < n; i++) {
			ageScores[i][0] = ages[i];
			ageScores[i][1] = scores[i];
		}

		Arrays.sort(ageScores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		return findMax(ageScores, n);
	}

	// we create a dp array.
	// in this array we store the max possible team value that we can get at any ith
	// position
	int findMax(int[][] ageScores, int n) {
		int dp[] = new int[n];
		int answer = 0;

		for (int i = 0; i < n; i++) {
			dp[i] = ageScores[i][1]; // beginning all dp values will have the max team score == score of single pair
		}

		for (int i = 0; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				// if j can be included in i's team
				if (ageScores[i][1] >= ageScores[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + ageScores[i][1]);
				}
			}

			answer = Math.max(answer, dp[i]);
		}

		return answer;

	}

}
