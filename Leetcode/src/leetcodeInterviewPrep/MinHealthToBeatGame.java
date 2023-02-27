package leetcodeInterviewPrep;

//You are playing a game that has n levels numbered from 0 to n - 1. You are given a 0-indexed integer array damage where damage[i] is the amount of health you will lose to complete the ith level.
//
//You are also given an integer armor. You may use your armor ability at most once during the game on any level which will protect you from at most armor damage.
//
//You must complete the levels in order and your health must be greater than 0 at all times to beat the game.
//
//Return the minimum health you need to start with to beat the game.
public class MinHealthToBeatGame {

	public long minimumHealth(int[] damage, int armor) {

		long sum = 0;
		long max = 0;
		// calculate sum of the damage
		for (int i = 0; i < damage.length; i++) {
			if (damage[i] > max) {
				max = damage[i];
			}
			sum += damage[i];
		}

		// subtract armor from sum, if armor <largest level, else subtract the largest
		// level as we will use armor at the level that causes highest damage
		sum = (max > armor) ? sum - armor : sum - max;

		return sum + 1;
	}
}
