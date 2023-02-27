package leetcodeDynamicProgramming;

//You are given an array of integers stones where stones[i] is the weight of the ith stone.
//
//We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights x and y with x <= y. The result of this smash is:
//
//If x == y, both stones are destroyed, and
//If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
//At the end of the game, there is at most one stone left.
//
//Return the smallest possible weight of the left stone. If there are no stones left, return 0.

public class LastStoneWeightII {

	// removal of stones can be thought of as making 2 groups and minimizing the
	// difference in their sums in the array

	// let say array be [a,b,c,d]
	// answer = (a+b)-(c+d) OR
	// answer = a-(b+c+d) Or
	// answer = (d+b)-(a+c) and so on.. any combination could be possible
	// notice that in general I can say that
	// answer = S1-S2
	// where S1 is sum of some of the numbers and S2 is sum of rest of numbers
	// also note that S1+S2 = SUM (sum of all numbers)
	// S1 >= S2 beacuse negative answer is not possible
	// now we have to minimise answer
	// answer = SUM - 2*S2 (Just substituting S1 by SUM-S2)
	// To minimise answer S2 has to be maximum
	// Now, max value of S2 is SUM/2 (bigger than this and answer would be negative
	// which is not possible)
	// so the question reduces to find closest sum (sum of numbers) to (SUM/2)
	// now this could be understood as subset sum problem or 0/1 knapsack problem
	public int lastStoneWeightII(int[] stones) {
		int sum = 0;
		int s2 = 0;
		for (int i : stones)
			sum += i;
		boolean[][] dp = new boolean[stones.length + 1][sum / 2 + 1];

		for (int i = 0; i <= stones.length; i++) {
			dp[i][0] = true; // sum 0 is possible with any number of elements
		}

		for (int i = 1; i <= stones.length; i++) {
			for (int s = 1; s <= sum / 2; s++) {
				if (s < stones[i - 1]) {
					dp[i][s] = dp[i - 1][s];
				} else {
					dp[i][s] = dp[i - 1][s] || dp[i - 1][s - stones[i - 1]];
				}
				if (dp[i][s] == true) {
					s2 = Math.max(s2, s);
				}
			}
		}

		return sum - 2 * s2;

	}

}
